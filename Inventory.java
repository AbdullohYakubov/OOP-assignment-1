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

    public String displayInventory(){
        String itemsAsString = "You have: ";

        for(int i = 0; i < itemsStored; i++){
            if(items[i] != null){
                itemsAsString += items[i] + " ";
            }
        }

        if(itemsStored == 0)
            itemsAsString = ">> Your inventory is empty.";
        
        return itemsAsString;
    }

    // public String displayInventory() {
    //     StringBuilder itemsAsString = new StringBuilder("You have:");

    //     for (int i = 0; i < itemsStored; i++) {
    //         if (items[i] != null) {
    //             itemsAsString.append(" ").append(items[i]);
    //         }
    //     }

    //     return itemsAsString.toString();
    // }
}