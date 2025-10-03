package aut.isp.lab4.exercise5;

public class Exercise5 {
    public static void main(String[] args) {
        AquariumController controller = new AquariumController();

        Actuator heater =controller.getHeater();
        System.out.println(heater.toString());
        controller.checkTemperature();
        System.out.println(heater.toString());

        Actuator alarm=controller.getAlarm();
        System.out.println(alarm.toString());
        controller.checkWaterLevel();
        System.out.println(alarm.toString());
    }
}
