package isp.lab3.exercise5;

import org.junit.jupiter.api.Test;

import javax.sql.rowset.BaseRowSet;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    @Test
    void displayProducts() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.displayProducts();
        assertEquals("The product: Kiwi has the id: 81\n" + "The product: Banana has the id: 12\n" + "The product: Apple has the id: 32\n",String.valueOf(outputStream),"The vending machine does not display well");
    }

    @Test
    void insertCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThrows(IllegalArgumentException.class, () -> vendingMachine.insertCoin(-1),"Value is not >0");
        vendingMachine.insertCoin(7);
        assertEquals(7,vendingMachine.getCredit(),"Coin inserted well");
    }

    @Test
    void selectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(2);
        assertEquals("Sorry, Kiwi is out of stock.",vendingMachine.selectProduct(81),"Item out of stock");
        assertEquals("Dispensing Apple. Remaining money: 1",vendingMachine.selectProduct(32),"Apple dispensed");
        assertEquals("Insufficient money.",vendingMachine.selectProduct(12),"Insufficient money");
        assertEquals("Id is wrong.",vendingMachine.selectProduct(100),"Id is not wrong.");
    }
}