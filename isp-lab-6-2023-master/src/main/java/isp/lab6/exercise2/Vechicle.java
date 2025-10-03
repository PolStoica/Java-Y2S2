package isp.lab6.exercise2;
import java.util.ArrayList;
import java.util.HashMap;

public class Vechicle {
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    private         int VIN;
    private static  int itemNumber=0;
    private         String licensePlate;
    private         int make;
    private         int model;
    private         int year;

    public Vechicle(String licensePlate, int make, int model, int year,int VIN) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.hashMap.put(itemNumber,VIN);
        itemNumber++;
    }
    public Vechicle() {
        this.licensePlate = null;
        this.make  = 0 ;
        this.model = 0;
        this.year  = 0;
        this.VIN=0;
    }
    public int getVIN() {
        return VIN;
    }

    public void addVechile(ArrayList<Vechicle> list,Vechicle vechicle){
        boolean flag=false;
        if(!list.isEmpty()) {
            for (Vechicle v : list) {
                if (vechicle.VIN == v.VIN) {
                    flag = true;
                    System.out.println("The vechicle has the same VIN");
                    break;
                }
            }
        }
        if(!flag){
            list.add(vechicle);
        }
    }

    public void removeVechile(ArrayList<Vechicle> list,Vechicle vechicle){
        list.remove(vechicle);
    }

    public boolean isInList(ArrayList<Vechicle> list,Vechicle vechicle){
        for(Vechicle v:list){
            if(vechicle.equals(v)) {
                return true;
            }
        }
        return false;
    }


    public void displayList(ArrayList<Vechicle> list){
        System.out.println("The vechicle in the list have:");
        for(Vechicle v:list){
            System.out.println("VIN:"+VIN+" the make:"+make+" the model:"+model+" the year:"+year);
        }
    }
}