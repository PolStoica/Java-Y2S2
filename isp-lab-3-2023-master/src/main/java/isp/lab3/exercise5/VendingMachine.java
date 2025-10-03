package isp.lab3.exercise5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private int credit;
    private List<Product> products;

    public VendingMachine() {
        this.credit = 0;
        products =new ArrayList<>();
        Product a=new Product("Kiwi",81,5,0);
        products.add(0,a) ;
        Product b=new Product("Banana",12,2,10);
        products.add(1,b) ;
        Product c=new Product("Apple",32,1,10);
        products.add(2,c) ;
    }

    public void displayProducts(){
        for (Product product : products) {
            if (product.quantity > 0) {
                System.out.println("The product: " + product.name + " has the id: " + String.valueOf(product.id));
            }
        }
    }

    public void insertCoin(int value){
        if (value > 0){
            credit+=value;
        }else{
            throw new IllegalArgumentException("value must be greater than zero");
        }
    }

    public int getCredit(){
        return credit;
    }

    public String selectProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                if (p.getQuantity() == 0) {
                    return "Sorry, " + p.getName() + " is out of stock.";
                }
                if (credit >= p.getPrice()) {
                    credit -= p.getPrice();
                    p.sold();
                    return "Dispensing " + p.getName() + ". Remaining money: " + credit;
                } else {
                    return "Insufficient money.";
                }
            }
        }
        return "Id is wrong.";
    }

    public void displayCredit(){
        System.out.println("The vending machine has :"+ credit +" credit." );
    }

    public void userMenu(){
        System.out.println("Welcome to the vending machine !");
        System.out.println("Insert some coins to buy something!");
        Scanner scanner= new Scanner(System.in);
        int credit = scanner.nextInt();
        boolean stop =false;
        while (credit > 0 && !stop) {
            System.out.println("You have " + credit + " coins !");
            System.out.println("Here are the products and their price");
            displayProducts();
            System.out.println("Select a product from the list using their id");
            int ID= scanner.nextInt();
            System.out.println(selectProduct(ID));
            System.out.println("Do you want to buy something? If you want to stop enter 'true', else 'false'.");
            stop = scanner.nextBoolean();
        }
    }
}
