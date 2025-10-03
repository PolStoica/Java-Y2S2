package isp.lab3.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        Tree tree=new Tree();
        System.out.println("The default height is:"+ tree.height);
        tree.grow(5);
        System.out.println("The height after it grew is now:" + tree.toString());
    }
}
