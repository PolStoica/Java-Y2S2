package isp.lab10.racedemo;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;

    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
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

        carPanel.carFinished(name);
    }
}

class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;
    private List<String> finishOrder = new ArrayList<>();

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
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

    public void carFinished(String carName) {
        finishOrder.add(carName);

        System.out.println(carName + " finished race.");

        if (finishOrder.size() == 4) {
            System.out.println("The finish order is " + finishOrder);
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
