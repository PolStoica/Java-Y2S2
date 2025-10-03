package utcluj.aut.lab2.demo;

public class InstanceAttributeDemo {
    private String[] items; // Instance attribute (fixed-size array)
    private int count; // Tracks the number of added items

    // Constructor to initialize the array with a fixed size
    public InstanceAttributeDemo(int size) {
        this.items = new String[size];
        this.count = 0;
    }

    // Method to add an item to the array
    public void addItem(String item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        } else {
            System.out.println("Array is full! Cannot add: " + item);
        }
    }

    // Method to print all items
    public void printItems() {
        System.out.println("Stored items:");
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        // Create an instance with a fixed array size of 3
        InstanceAttributeDemo example = new InstanceAttributeDemo(3);

        // Add items using the instance method
        example.addItem("Apple");
        example.addItem("Banana");
        example.addItem("Cherry");
        example.addItem("Date"); // This should trigger an "array is full" message

        // Print all stored items
        example.printItems();
    }
}

