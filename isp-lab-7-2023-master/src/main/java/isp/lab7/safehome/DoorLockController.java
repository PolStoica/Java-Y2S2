package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {
    Map<Tenant, AccessKey> tenantsAccesKeyMap=new Hashtable<>();
    Door door;
    private int tries=0;
    List<AccessLog> accessLog;
    private boolean permanentlyLocked = false;

    public DoorLockController(Map<Tenant, AccessKey> map) {
        this.tenantsAccesKeyMap=map;
        this.door=new Door();
        this.accessLog=new ArrayList<>();
    }

    public void increaseTries(){
        tries++;
    }


    public int getTries(){
        return tries;
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        AccessKey accessKey=new AccessKey(pin);
        String name="UNKNOWN";

        if (permanentlyLocked && !MASTER_KEY.equals(pin)) {
            accessLog.add(new AccessLog("UNKNOWN", LocalDateTime.now(), "tried while locked", door.getStatus(), "Too many attempts"));
            throw new TooManyAttemptsException();
        }

        if (MASTER_KEY.equals(pin)) {
            tries=0;
            permanentlyLocked=false;
            System.out.println("Logged in as admin");
            door.unlockDoor();
            tries=0;
            accessLog.add(new AccessLog("MASTER",LocalDateTime.now(), "opened", DoorStatus.OPEN));
            return DoorStatus.OPEN;
        }

        if (tries<2) {
                if (tenantsAccesKeyMap.containsValue(accessKey)) {
                    for (Map.Entry<Tenant, AccessKey> entry : tenantsAccesKeyMap.entrySet()) {
                        if (entry.getValue().equals(accessKey)) {
                           name= entry.getKey().getName();
                           break;
                        }
                    }
                    tries=0;
                    if(door.getStatus() == DoorStatus.OPEN) {
                        accessLog.add(new AccessLog(name ,LocalDateTime.now(), "closed", DoorStatus.OPEN));
                        door.lockDoor();
                        return DoorStatus.CLOSE;
                    }else
                    {
                        accessLog.add(new AccessLog(name ,LocalDateTime.now(), "opened", DoorStatus.OPEN));
                        door.unlockDoor();
                        return DoorStatus.OPEN;
                    }
                }
                tries++;
                accessLog.add(new AccessLog(name ,LocalDateTime.now(), "tried to open/close", door.getStatus(),"invalid Pin"));
                throw new InvalidPinException();
        }else{
            tries++;
            accessLog.add(new AccessLog(name ,LocalDateTime.now(), "tried to open/close", door.getStatus(),"Too many attempts"));
            permanentlyLocked = true;
            throw new TooManyAttemptsException();
        }
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
            Tenant tenant = new Tenant(name);
            AccessKey accessKey=new AccessKey(pin);
            if (!tenantsAccesKeyMap.containsValue(accessKey)) {
                tenantsAccesKeyMap.put(tenant, accessKey);
            }else {
                throw new TenantAlreadyExistsException(name);
            }
    }

    @Override
    public void removeTenant(String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if(!tenantsAccesKeyMap.containsKey(tenant)){
            throw new TenantNotFoundException(name);
        }else {
            tenantsAccesKeyMap.remove(tenant);
        }
    }

    public List<AccessLog> getAccesLog(){
        return accessLog;
    }

    public String accesLogToString(){
        StringBuilder logOutput = new StringBuilder();
        for (AccessLog log : accessLog) {
            logOutput.append(log.toString()).append("\n");
        }
        return logOutput.toString();
    }

    public void accesLogPrint(){
        for (AccessLog log : accessLog) {
            System.out.print(log.toString() +"; ");
        }

    }

}