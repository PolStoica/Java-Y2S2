package utcluj.aut;

import java.util.Scanner;

public class ClasaNoua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                ClasaNoua.different(a, b);
                //different(a, b);
    }
    public static void different(int a, int b){
        if (a != b)  {
            System.out.println("the numbers are different");
        }else {
            System.out.println("the numbers are equal");
        }
    }
}