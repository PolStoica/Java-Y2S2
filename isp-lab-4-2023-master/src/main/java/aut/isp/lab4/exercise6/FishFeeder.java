package aut.isp.lab4.exercise6;

public class FishFeeder {

    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public FishFeeder(){
        this.manufacturer = "None";
        this.model = "None";
        this.meals = 0;
    }

    public int getMeals() {
        return meals;
    }

    public void feed() {
        if (meals !=0) {
            meals--;
            System.out.println("A meal has been disbursed, there are " + meals + " meals left in the tank.");
        }else {
            System.out.println("The feeder is empty, you have to fillUp");
        }
    }

    public void fillUp(){
        meals = 14;
        System.out.println("Fish Feeder is filled up");
    }

    public String toString() {
        return "The manufacturere of the FishFeeder is: "+ manufacturer + ". The model is: " + model + " . And it has : " + meals+ " meals left to disburst.";
    }
}
