package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog {
    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus) {
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.tenantName = tenantName;
    }
    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.tenantName = tenantName;
        this.errorMessage=errorMessage;
    }

    @Override
    public String toString() {
        return "Tenant: " + tenantName + ", Date/Time: " + dateTime + ", Operation: " + operation + ", Door Status: " + doorStatus;
    }
}