public class Item {
    
    protected String itemId;
    protected String itemName;

    public Item(String iid, String in){
        this.itemId = iid;
        this.itemName = in;
    }
    
    protected String getItemId(){
        return itemId;
    }
    
    protected String getItemName(){
        return itemName;
    }

    protected void setItemId(String i){
        itemId = i;
    }

}
