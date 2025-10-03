package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Race!");
        JFrame frame1 = new JFrame("Semaphore");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame1.getContentPane().add(semaphorePanel);
        frame1.pack();
        frame1.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        JFrame frame2 = new JFrame("Car Race");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        frame2.getContentPane().add(carPanel);
        frame2.pack();
        frame2.setSize(500, 300);
        frame2.setVisible(true);

            Car car1 = new Car("Red car", carPanel);
            Car car2 = new Car("Blue car", carPanel);
            Car car3 = new Car("Green car", carPanel);
            Car car4 = new Car("Yellow car", carPanel);

        car1.startAllCars(car2,car3,car4,semaphoreThread);

    }
}
