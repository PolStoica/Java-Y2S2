package aut.isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        AquariumController a= new AquariumController("Bosch","finalModel", 21.3F);
        a.feeder.feed();
        a.feeder.fillUp();
        a.setFeedingTime(30.1F);
        a.setCurrentTime(30.1F);
    }
}