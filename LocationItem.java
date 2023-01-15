import java.util.*;

public class LocationItem extends Item{

    protected ArrayList<String> specificLocations;

    public LocationItem(String lid, String ln, ArrayList<String> sl){
        super(lid,ln);
        this.specificLocations = sl;
    }

    protected ArrayList<String> getSpecificLocations(){
        return specificLocations;
    }
    
}
