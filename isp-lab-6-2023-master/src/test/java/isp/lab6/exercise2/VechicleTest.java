package isp.lab6.exercise2;

import junit.framework.TestCase;

import java.util.ArrayList;

public class VechicleTest extends TestCase {

    public void testAddVechile() {
        ArrayList<Vechicle> list = new ArrayList<>();
        Vechicle v1 = new Vechicle("MS01BOS",1,3,1970,1010);
        v1.addVechile(list,v1);

        Vechicle v2 = new Vechicle("Ms01BIS",2,3,1972,1010);
        assertEquals(1, list.size());
        assertEquals(1010, list.get(0).getVIN());
    }

    public void testRemoveVechile() {
        ArrayList<Vechicle> list = new ArrayList<Vechicle>();
        Vechicle v1 = new Vechicle("MS01BOS",1,3,1970,1010);
        v1.addVechile(list,v1);
        v1.removeVechile(list,v1);
        assertEquals(0, list.size());
    }

    public void testIsInList() {
        ArrayList<Vechicle> list = new ArrayList<Vechicle>();
        Vechicle v1 = new Vechicle("MS01BOS",1,3,1970,1010);
        v1.addVechile(list,v1);
        assertTrue(v1.isInList(list,v1));
    }
}