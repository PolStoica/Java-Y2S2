package isp.lab7.safehome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {
        Map<Tenant, AccessKey> map = new HashMap<>();

        Tenant t1 = new Tenant("pol");
        AccessKey key1 = new AccessKey("111");
        map.put(t1, key1);

        Tenant t2 = new Tenant("lol");
        AccessKey key2 = new AccessKey("222");
        map.put(t2, key2);

        Tenant t3 = new Tenant("bol");
        AccessKey key3 = new AccessKey("333");
        map.put(t3, key3);

        Tenant t4 = new Tenant("rol");
        AccessKey key4 = new AccessKey("444");
        map.put(t4, key4);

        DoorLockController doorLockController = new DoorLockController(map);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Menu --");
        System.out.println("1. Admin");
        System.out.println("2. Tenant");
        System.out.print("Choose option: ");
        String choice = scanner.nextLine();

        boolean flag = false;

        if (String.valueOf(choice).equals("1")) {  //admin methods

            System.out.println("If at any moment you want to exit just type: \"EXIT\", if you don't just press ENTER.");
            String userInput = scanner.nextLine();
            System.out.println("Enter the MasterKey");
            String pin = " ";

            while (!userInput.equals("EXIT")) {
                if (!flag && doorLockController.getTries()<3) {
                    pin = scanner.nextLine();
                    try {
                        doorLockController.enterPin(pin);
                        System.out.println("--- Welcome Admin ---");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                if (flag) {
                    System.out.println("\n-- Admin Menu --");
                    System.out.println("1. ADD tenant");
                    System.out.println("2. REMOVE tenant");
                    System.out.println("3. View AccessLog");
                    System.out.print("or type \"EXIT\" to exit ");
                    choice = scanner.nextLine();
                    // add tenant
                    switch (String.valueOf(choice)) {
                        case "1": {
                            System.out.println("Enter tenant name: ");
                            String tenantName = scanner.nextLine();
                            System.out.println("Enter tenant pin: ");
                            String tenantPin = scanner.nextLine();
                            boolean flag2 = false;
                            try {
                                doorLockController.addTenant(tenantPin, tenantName);
                                flag2 = true;
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            if (flag2) {
                                System.out.println("tennant added successfully");
                            }
                            //remove tenant
                            break;
                        }
                        case "2": {
                            System.out.println("Enter tenant name: ");
                            String tenantName = scanner.nextLine();
                            boolean flag2 = false;
                            try {
                                doorLockController.removeTenant(tenantName);
                                flag2 = true;
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            if (flag2) {
                                System.out.println("tennant removed successfully");
                            }
                            break;
                        }
                        case "3": {
                            System.out.println("Here is the AccesLog:");
                            doorLockController.accesLogPrint();
                            break;
                        }
                        case "EXIT":
                            return;
                    }
                }

            }

        } else  /* tenant methods */ {
            while (!flag && doorLockController.getTries()<3) {
                System.out.print("Enter your PIN: ");
                String pin = scanner.nextLine();
                try {
                    //search for the name
                    String name = "UNKNOWN";
                    AccessKey accessKey = new AccessKey(pin);
                    for (Map.Entry<Tenant, AccessKey> entry : doorLockController.tenantsAccesKeyMap.entrySet()) {
                        if (entry.getValue().equals(accessKey)) {
                            name = entry.getKey().getName();
                            break;
                        }
                    }
                    //got name

                    DoorStatus status = doorLockController.enterPin(pin);
                    System.out.println("--- Welcome " + name + " ---");
                    System.out.println("Door is now: " + status);
                    flag = true;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}