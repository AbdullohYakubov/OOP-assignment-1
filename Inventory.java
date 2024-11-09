public class Inventory {
    final int MAX_ITEMS = 10; 
    private String[] items = new String[MAX_ITEMS];
    private int itemsStored = 0;  

    public Inventory(){}

    public void addItem(String item){
        if(itemsStored < MAX_ITEMS){
            items[itemsStored] = item;
            itemsStored++;
        }
    }

    public int hasItem(String item){
        for(int i = 0; i < itemsStored; i++){
            if(items[i].equals(item))
                return i;
        }
        return -1;
    }

    public void removeItem(String item){
        String[] leftItems = new String[MAX_ITEMS];
        int removedItemIndex = -1;

        if(items.length == 0)
            return;

        for(int i = 0; i < itemsStored; i++){
            if(items[i].equals(item)  ){
                removedItemIndex = i;
                break;
            }
        }

        if(removedItemIndex == -1)
            return;

        for(int i = 0, j = 0; i < itemsStored; i++){
            if(i != removedItemIndex)
                leftItems[j++] = items[i];
        }
        
        itemsStored--;
        items = leftItems;   
    }

    // public void removeItem(String item) {
    //     int removedItemIndex = -1;
    
    //     // Find the index of the item to remove within the actual stored items
    //     for (int i = 0; i < itemsStored; i++) {
    //         if (item.equals(items[i])) { // Use .equals() for content comparison
    //             removedItemIndex = i;
    //             break;
    //         }
    //     }
    
    //     if (removedItemIndex == -1)
    //         return; // Item not found, no removal needed
    
    //     // Shift elements left to fill the gap
    //     for (int i = removedItemIndex; i < itemsStored - 1; i++) {
    //         items[i] = items[i + 1];
    //     }
    
    //     // Set the last used slot to null and decrement itemsStored
    //     items[itemsStored - 1] = null;
    //     itemsStored--;
    // }
    
    // public String displayInventory() {
    //     StringBuilder itemsAsString = new StringBuilder("You have:");

    //     for (int i = 0; i < itemsStored; i++) {
    //         if (items[i] != null) {
    //             itemsAsString.append(" ").append(items[i]);
    //         }
    //     }

    //     return itemsAsString.toString();
    // }

    public String displayInventory(){
        String itemsAsString = "You have:";

        for(int i = 0; i < itemsStored; i++){
            if(items[i] != null){
                itemsAsString = itemsAsString + " " + items[i];
            }
        }
        
        return itemsAsString;
    }

    public static void main(String[] args){
        Inventory item_1 = new Inventory();

        System.out.println(item_1.displayInventory());
        item_1.addItem("key");
        System.out.println(item_1.displayInventory());
        System.out.println(item_1.hasItem("key"));
        item_1.removeItem("key");
        System.out.println(item_1.displayInventory());
        System.out.println(item_1.hasItem("key"));
        item_1.addItem("carkey");
        System.out.println(item_1.displayInventory());
        System.out.println(item_1.hasItem("carkey"));
        item_1.addItem("screwdriver");
        item_1.addItem("hammer");
        System.out.println(item_1.displayInventory());
        System.out.println(item_1.hasItem("hammer"));
        item_1.removeItem("screwdriver");
        System.out.println(item_1.displayInventory());
        System.out.println(item_1.hasItem("hammer"));
        System.out.println(item_1.hasItem("screwdriver"));
        item_1.addItem("mainkey");
        item_1.addItem("lightbulb");
        item_1.addItem("saw");
        item_1.addItem("wood");
        item_1.addItem("padlock");
        item_1.addItem("carpet");
        System.out.println(item_1.displayInventory());
        item_1.removeItem("carkey");
        System.out.println(item_1.displayInventory());
        item_1.removeItem("carkey");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.hasItem("carkey"));
        System.out.println(item_1.hasItem("carpet"));
        item_1.addItem("carkey");
        item_1.addItem("battery");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        item_1.addItem("sword");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]);  
        item_1.removeItem("sword");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]); 
        item_1.addItem("baraban");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]);
        item_1.removeItem("baraban");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]);
        item_1.addItem("last");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]);
        item_1.removeItem("last");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.itemsStored);  
        System.out.println(item_1.items[9]);
        item_1.removeItem("saw");
        item_1.removeItem("wood");
        item_1.removeItem("mainkey");
        item_1.removeItem("hammer");
        System.out.println(item_1.displayInventory());  
        item_1.removeItem("carkey");
        item_1.removeItem("battery");
        item_1.removeItem("padlock");
        item_1.removeItem("lightbulb");
        
        // item_1.removeItem("carpet");
        System.out.println(item_1.items[1]);  
        System.out.println(item_1.items[9]);  
        System.out.println(item_1.items[2]);  
        System.out.println(item_1.displayInventory());  

    }
}