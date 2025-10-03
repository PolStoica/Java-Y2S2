package isp.lab10.raceapp;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

class TimerThread extends Thread {
    private long startTime;
    private long endTime;
    private boolean running = true;

    public long getTimer() {
        return endTime - startTime;
    }

    public void setEndTime(long time) {
        endTime = time;
    }

    public void stopTimer() {
        running = false;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (running) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private double startTime ;
    private double endTime ;
    private TimerThread timer;

    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        carPanel.playSound();
        timer = new TimerThread();
        timer.start();

        startTime = System.currentTimeMillis();
        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;
            carPanel.updateCarPosition(name, distance);
            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();
        timer.setEndTime((long) endTime);
        carPanel.carFinished(name,startTime,endTime,timer);
    }

    public void startAllCars(Car car2, Car car3, Car car4, SemaphoreThread semaphoreThread) {
        try {
            semaphoreThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.start();
        car2.start();
        car3.start();
        car4.start();
    }

}

class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;
    Map<String,Double> podium= new LinkedHashMap<>();
    private Clip clip;

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    void playSound() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("/Users/pol/Documents/AIA_Current/ISP/isp-2025-hm-PolStoica-main/isp-lab-10-2023-main/shanghai-formula-1-grand-prix.wav")));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public synchronized void  carFinished(String carName, double startTime, double endTime, TimerThread timer) {

        double duration = (endTime - startTime)/1000.0;

        podium.put(carName,duration);

        //System.out.println(carName+": "+duration);

        if (podium.size() == 4) {

            clip.stop();
            clip.close();
            System.out.println("The Race Ended and the order is complete. " );
            System.out.print("The winner is :");
            display(podium);

            timer.stopTimer();
            System.out.printf("Total race time: %.3f seconds%n", timer.getTimer() / 1000.0);
        }
    }

    public void display(Map<String,Double> podium) {
        for(String value:podium.keySet()) {
            System.out.println(value);
        }
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }

}