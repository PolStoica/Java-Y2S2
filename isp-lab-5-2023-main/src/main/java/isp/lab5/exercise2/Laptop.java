package isp.lab5.exercise2;

public class Laptop {
    private int BatteryLevel=0;
    public int getBatteryCharge(){
        return BatteryLevel;
    }

    public void charge(int durationinMinutes) {
        if (durationinMinutes < 0) {
            throw new IllegalArgumentException("You must insert a positive number of minutes");
        }
        if (BatteryLevel < 100) {
            int newBatteryLevel = BatteryLevel + (durationinMinutes/2);
            if (newBatteryLevel >= 100) {
                int charged = 100 - BatteryLevel;
                BatteryLevel = 100;
                System.out.println("Battery charged in " + (charged/4) + " minutes to " + BatteryLevel+" %");
            }
            else
            {
                BatteryLevel = newBatteryLevel;
                System.out.println("Battery charged to " + newBatteryLevel+ " %");
            }
        } else {
            System.out.println("Battery is fully charged");
        }
    }

}