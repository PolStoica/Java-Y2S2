package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        AquariumController controller= new AquariumController("Bosch","Model1", 12 );
        System.out.println(controller.toString());
        controller.setCurrentTime(1100);
        System.out.println(controller.toString());
    }
}