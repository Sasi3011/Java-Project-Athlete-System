// Item.java
public class Item {
    private String name;
    private int stock;

    public Item(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}