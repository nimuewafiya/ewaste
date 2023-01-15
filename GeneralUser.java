public class GeneralUser extends User {

    protected String points;

    public GeneralUser (String n, String un, String p, String po){
        super(n,un,p);
        this.points = po;
    }

    protected String getPoints(){
        return points;
    }

    protected void setPoints(int p){

        points = String.valueOf(p);

    }
    
}
