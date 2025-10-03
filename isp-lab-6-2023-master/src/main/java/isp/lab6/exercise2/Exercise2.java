package isp.lab6.exercise2;

import java.util.ArrayList;


public class Exercise2 {
    public static void main(String[] args) {
        ArrayList<Vechicle> list = new ArrayList<>();
        Vechicle v1 =new Vechicle("MS01BOS",1,3,1970,1010);
        Vechicle v2 =new Vechicle("Ms01BIS",2,3,1972,1011);

        v1.addVechile(list,v1);
        v2.addVechile(list,v2);
        v2.displayList(list);

        boolean flag= v2.isInList(list,v2);
        System.out.println("The statement: \"v2 is in the list\" is: "+flag);
        v2.removeVechile(list,v2);
        v1.displayList(list);
    }
}
