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
        for(int i = 0; i < items.length; i++){
            if(items[i] == item)
                return i;
        }

        return -1;
    }

    public void removeItem(String item){
        String[] leftItems = new String[items.length];
        int removedItemIndex = -1;

        if(items.length == 0){
            return;
        }

        for(int i = 0; i < items.length; i++){
            if(items[i] == item){
                removedItemIndex = i;
                break;
            }
        }

        if(removedItemIndex == -1){
            return;
        }

        for(int i = 0, j = 0; i < items.length; i++){
            if(i != removedItemIndex){
                leftItems[j++] = items[i];
            }
        }
        
        itemsStored--;
        items = leftItems;

        // int removedItemIndex = hasItem(item);

        // if(removedItemIndex == -1)
        //     return;
        
        
    }
    
    public String displayInventory(){
        String itemsAsString = "You have: ";

        for(int i = 0; i < items.length; i++){
            // if(items[i] == items[items.length - 1])
            //     items[i] = items[i] + " ";
            
            // if(items[i] == items[0])
            //     itemsAsString =  items[i];
            // else
            itemsAsString = itemsAsString + items[i];
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
        item_1.addItem("mainkey");
        System.out.println(item_1.displayInventory());
        item_1.addItem("lightbulb");
        System.out.println(item_1.displayInventory());
        item_1.addItem("saw");
        System.out.println(item_1.displayInventory());
        item_1.addItem("wood");
        System.out.println(item_1.displayInventory());
        item_1.addItem("padlock");
        System.out.println(item_1.displayInventory());
        item_1.addItem("carpet");
        System.out.println(item_1.displayInventory());
        item_1.removeItem("carkey");
        System.out.println(item_1.displayInventory());
        item_1.removeItem("carkey");
        System.out.println(item_1.displayInventory());  
        System.out.println(item_1.hasItem("carkey"));
        System.out.println(item_1.hasItem("carpet"));
        item_1.addItem("carkey");
        System.out.println(item_1.displayInventory());  
        item_1.addItem("battery");
        item_1.addItem("sword");
        System.out.println(item_1.displayInventory());  
        item_1.addItem("sword");
        System.out.println(item_1.displayInventory());  
    }
   
}