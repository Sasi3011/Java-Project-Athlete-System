// InventoryManager.java
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        inventory.put(item.getName(), item);
        System.out.println("Item added: " + item.getName());
    }

    public void updateStock(String name, int change) {
        if (inventory.containsKey(name)) {
            Item item = inventory.get(name);
            item.setStock(item.getStock() + change);
            System.out.println("Stock updated for " + name);
        }
    }

    public Item getItem(String name) {
        return inventory.get(name);
    }
}