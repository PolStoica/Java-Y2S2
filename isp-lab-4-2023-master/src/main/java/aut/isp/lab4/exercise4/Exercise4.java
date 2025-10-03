package aut.isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        AquariumController controller = new AquariumController();
        String lSwitch;
        if(controller.light.getIsOn()){
            lSwitch = "On";
        }else {
            lSwitch = "Off";
        }
        System.out.println("The light is "+lSwitch+" inside the Aquarium");

        controller.setCurrentTime(0);
        if(controller.light.getIsOn()){
            lSwitch = "On";
        }else {
            lSwitch = "Off";
        }
        System.out.println("The light is "+lSwitch+" inside the Aquarium");
    }
}