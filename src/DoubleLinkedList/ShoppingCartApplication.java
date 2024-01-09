package DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingCartItem {
    String itemName;
    int quantity;
    double price;
    ShoppingCartItem prev;
    ShoppingCartItem next;

    public ShoppingCartItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.prev = null;
        this.next = null;
    }
    
    //Tổng giá mỗi sản phầm
    public double getTotalPrice() {
        return quantity * price;
    }
}

class ShoppingCart {
    private ShoppingCartItem head;
    private ShoppingCartItem tail;

    public ShoppingCart() {
        this.head = null;
        this.tail = null;
    }
    
    //Thêm 1 món hàng vào giỏ bao gồm tên và số lượng mua
    public void addItem(String itemName, int quantity, double price) {
        ShoppingCartItem newItem = new ShoppingCartItem(itemName, quantity, price);
        if (head == null) {
            head = newItem;
            tail = newItem;
        } else {
            newItem.next = head;
            head.prev = newItem;
            head = newItem;
        }
        System.out.println("Item added to the shopping cart: " + itemName);
    }
    
    //Xóa 1 món khỏi giỏ hàng
    public void removeItem(String itemName) {
        ShoppingCartItem current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Item removed from the shopping cart: " + itemName);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found in the shopping cart: " + itemName);
    }
    
    //Điều chỉnh số lượng món hàng trong giỏ
    public void adjustQuantity(String itemName, int newQuantity) {
        ShoppingCartItem current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                current.quantity = newQuantity;
                System.out.println("Quantity adjusted for " + itemName + ": " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found in the shopping cart: " + itemName);
    }

    //Thêm phương thức để tính tổng giá của giỏ hàng
    public double getTotalCartPrice() {
        double total = 0.0;
        ShoppingCartItem current = head;
        while (current != null) {
            total += current.getTotalPrice();
            current = current.next;
        }
        return total;
    }

    //In ra toàn bộ giỏ hàng
    public void displayCart() {
        if (head == null) {
            System.out.println("Shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            ShoppingCartItem current = head;
            while (current != null) {
                System.out.println(current.itemName + " - Quantity: " + current.quantity + " - Price: $" + current.price +
                        " - Total: $" + current.getTotalPrice());
                current = current.next;
            }
            System.out.println("Total Cart Price: $" + getTotalCartPrice());
        }
    }
}

public class ShoppingCartApplication {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> storeInventory = new HashMap<>();
        storeInventory.put("Vegetable", 8.0);
        storeInventory.put("Fish", 50.0);
        storeInventory.put("Pine", 10.0);
        storeInventory.put("Apples",5.0);
        storeInventory.put("Milks",10.0);
        storeInventory.put("Meats",15.0);
        storeInventory.put("Eggs",30.0);
                
        while (true) {
            System.out.println("\n--- Store Menu ---");
            System.out.println("1. View Store Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. Adjust Quantity in Cart");
            System.out.println("5. View Shopping Cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\n--- Store Inventory ---");
                    for (Map.Entry<String, Double> entry : storeInventory.entrySet()) {
                        System.out.println(entry.getKey() + " - Price: $" + entry.getValue());
                    }
                    break;

                case 2:
                    System.out.print("Enter item name to add: ");
                    String itemNameToAdd = scanner.nextLine();
                    if (storeInventory.containsKey(itemNameToAdd)) {
                        System.out.print("Enter quantity to add: ");
                        int quantityToAdd = scanner.nextInt();
                        shoppingCart.addItem(itemNameToAdd, quantityToAdd, storeInventory.get(itemNameToAdd));
                    } else {
                        System.out.println("Item not found in the store inventory.");
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to remove from cart: ");
                    String itemNameToRemove = scanner.nextLine();
                    shoppingCart.removeItem(itemNameToRemove);
                    break;

                case 4:
                    System.out.print("Enter item name to adjust quantity in cart: ");
                    String itemNameToAdjust = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    shoppingCart.adjustQuantity(itemNameToAdjust, newQuantity);
                    break;

                case 5:
                    shoppingCart.displayCart();
                    break;

                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
