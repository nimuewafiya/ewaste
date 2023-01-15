public class EWasteItem extends Item {

    protected String itemPoints;

    public EWasteItem(String iid, String in, String ip){
        super(iid,in);
        this.itemPoints = ip;
    }

    protected String getItemPoints () {
        return itemPoints;
    }
    
}
