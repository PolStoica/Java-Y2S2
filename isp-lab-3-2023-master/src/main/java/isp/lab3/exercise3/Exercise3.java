package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
            Vehicle vechicle1 = new Vehicle("Dacia","Logan",150, 'B');
            Vehicle vechicle2 = new Vehicle("Porsche","911",280, 'B');
        System.out.println("Fuel type of vehicle1 is:"+vechicle1.getFuelType());
        vechicle1.setFuelType('D');
        System.out.println("Fuel type of vehicle1 now is:"+vechicle1.getFuelType());
//        vechicle2.setFuelType('G');
//        System.out.println("Fuel type of vehicle2 now is:"+vechicle2.getFuelType());
        boolean equals = vechicle1.equals(vechicle2);
        System.out.println("the statement:'vehicle1 is the same as vehicle2' is "+equals);
        System.out.println("there are "+ vechicle1.getCounter()+ " vehicles");
        System.out.println(vechicle1.toString());
    }
}