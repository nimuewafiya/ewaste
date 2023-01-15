import java.util.*;

import javax.imageio.IIOException;

import java.io.*;

public class Database {

    protected ArrayList<AdminUser> getAdminInfo () throws FileNotFoundException{
        ArrayList<AdminUser> adminUsers = new ArrayList<AdminUser>();
        File adminUserFiles = new File("AdminUserInfo.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(adminUserFiles);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            AdminUser a = new AdminUser(line[0],line[1],line[2]);
            adminUsers.add(a);
        }

        return adminUsers;
    }

    protected ArrayList<GeneralUser> getUserInfo () throws FileNotFoundException{
        ArrayList<GeneralUser> generalUsers = new ArrayList<GeneralUser>();
        File generalUserFiles = new File("GeneralUserInfo.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(generalUserFiles);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            GeneralUser gu = new GeneralUser(line[0],line[1],line[2],line[3]);
            generalUsers.add(gu);
        }

        return generalUsers;
    }

    protected ArrayList<EWasteItem> getWasteItems () throws FileNotFoundException{
        ArrayList<EWasteItem> eWasteItems = new ArrayList<EWasteItem>();
        File eWasteItemFile = new File("WasteItems.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(eWasteItemFile);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            EWasteItem e = new EWasteItem(line[0],line[1],line[2]);
            eWasteItems.add(e);
        }

        return eWasteItems;

    }

    protected ArrayList<EWasteItem> getRedemptionItems () throws FileNotFoundException{
        ArrayList<EWasteItem> redemptionItems = new ArrayList<EWasteItem>();
        File redemptionItemFile = new File("RedemptionItems.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(redemptionItemFile);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            EWasteItem r = new EWasteItem(line[0],line[1],line[2]);
            redemptionItems.add(r);
        }

        return redemptionItems;

    }

    protected ArrayList<LocationItem> getLocationItems () throws FileNotFoundException{
        ArrayList<LocationItem> locationItems = new ArrayList<LocationItem>();
        File locationItemFile = new File("LocationItems.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(locationItemFile);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            ArrayList<String> specificLocations = new ArrayList<String>();
            for (int i = 2; i < line.length; i++){
                specificLocations.add(line[i]);
            }
            LocationItem l = new LocationItem(line[0],line[1],specificLocations);
            locationItems.add(l);
        }

        return locationItems;

    }
    
    protected void setNewUser(GeneralUser gu) throws FileNotFoundException, IOException{

        String newUser = ("\n" + gu.getName() + "," + gu.getUsername() + "," + gu.getPassword() + "," + gu.getPoints());

        try {
            FileWriter fw = new FileWriter("GeneralUserInfo.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(newUser);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printUserMainMenu(){

        String horizontalBorder = "* ===================================================== *\n";
        System.out.println(horizontalBorder);
        System.out.println("                      MAIN MENU\n");
        System.out.println(horizontalBorder);
        System.out.println("1. List of waste items we accept\n");
        System.out.println("2. Recycle!\n");
        System.out.println("3. Redemptions\n");
        System.out.println("4. Locations\n");
        System.out.println("5. Logout\n");
        System.out.println(horizontalBorder);
        System.out.print("Enter your option: ");

    }

    public void printAdminMainMenu(){

        String horizontalBorder = "* ===================================================== *\n";
        System.out.println(horizontalBorder);
        System.out.println("                E-WASTE MANAGEMENT (ADMIN)\n");
        System.out.println(horizontalBorder);
        System.out.println("Welcome admin! Please select the action you would like to perform: \n");
        System.out.println("1. Add waste item \n");
        System.out.println("2. Delete waste item \n");
        System.out.println("3. Add redemption item \n");
        System.out.println("4. Delete redemption item \n");
        System.out.println("5. Logout\n");
        System.out.print("Please type in the corresponding number for your choice: ");

    }

    public void printWasteItemMenu() throws FileNotFoundException{

        String horizontalBorder = "* ===================================================== *\n";
        System.out.println(horizontalBorder);
        System.out.println("                      WASTE ITEMS\n");
        System.out.println(horizontalBorder);
        System.out.println(" ITEM ID               WASTE ITEM(POINTS)                ");
        System.out.println("---------------------------------------------------------");

        ArrayList<EWasteItem> eWasteItems = new ArrayList<EWasteItem>();

        File eWasteItemFile = new File("WasteItems.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(eWasteItemFile);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            EWasteItem e = new EWasteItem(line[0],line[1],line[2]);
            eWasteItems.add(e);
        }

        for (EWasteItem w: eWasteItems){
            System.out.println("  " + w.getItemId() + "                      " + w.getItemName() + "(" + w.getItemPoints() + ")" + "\n");
        }

    }

    public void printRedemptionItemMenu() throws FileNotFoundException{

        String horizontalBorder = "* ===================================================== *\n";
        System.out.println(horizontalBorder);
        System.out.println("                       REDEMPTION ITEMS\n");
        System.out.println(horizontalBorder);
        System.out.println(" ITEM ID               REDEMPTION ITEM(POINTS)                ");
        System.out.println("---------------------------------------------------------");

        ArrayList<EWasteItem> redemptionItems = new ArrayList<EWasteItem>();

        File redemptionItemFile = new File("RedemptionItems.txt");
        String str;
        String[] line;
        Scanner fileReader = new Scanner(redemptionItemFile);

        while(fileReader.hasNextLine()){
            str = fileReader.nextLine();
            line = str.split(",");
            EWasteItem r = new EWasteItem(line[0],line[1],line[2]);
            redemptionItems.add(r);
        }

        for (EWasteItem ri: redemptionItems){
            System.out.println("  " + ri.getItemId() + "                      " + ri.getItemName() + "(" + ri.getItemPoints() + ")" + "\n");
        }

    }

    public void printMainLocationMenu(ArrayList<LocationItem> li){

        String horizontalBorder = "* ===================================================== *\n";
        System.out.println(horizontalBorder);
        System.out.println("                        LOCATIONS\n");
        System.out.println(horizontalBorder);

        for (LocationItem a: li){
            System.out.println("\n" + a.getItemId() + " " + a.getItemName());
        }

    }

    public void printSpecificLocations(LocationItem l){

        String horizontalBorder = "* ===================================================== *\n";
        int counter = 1;
        System.out.println(horizontalBorder);
        System.out.println("               LOCATIONS IN " + l.getItemName());
        System.out.println(horizontalBorder);

        for (String x: l.getSpecificLocations()){
            System.out.println(" " + counter + "." + " " + x);
            counter = counter + 1;
        }

    }

    public String userRecycles (GeneralUser u, String id, String q) throws FileNotFoundException, IOException{

        ArrayList<EWasteItem> eWasteItems = new ArrayList<EWasteItem>();
        ArrayList<GeneralUser> generalUsers = new ArrayList<GeneralUser>();
        String points = null;
        String pointsEarned;

        eWasteItems = getWasteItems();

        for (EWasteItem w: eWasteItems){
            if (id.equals(w.getItemId())){
                points = w.getItemPoints();
                break;
            }
        }
        
        int multiply = (Integer.parseInt(points))*(Integer.parseInt(q));
        pointsEarned = String.valueOf(multiply);

        generalUsers = getUserInfo();

        for (GeneralUser g: generalUsers){
            if (u.getUsername().equals(g.getUsername())){
                int total = multiply + Integer.valueOf(g.getPoints());
                g.setPoints(total);
                break;
            }
        }

        new FileWriter("GeneralUserInfo.txt", false).close();

        try {
            FileWriter fw = new FileWriter("GeneralUserInfo.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            for (GeneralUser gu: generalUsers){
                pw.println(gu.getName() + "," + gu.getUsername() + "," + gu.getPassword() + "," + gu.getPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pointsEarned;

    }

    public String userRedeems (GeneralUser u, String id) throws FileNotFoundException, IOException{

        ArrayList<EWasteItem> redemptionItems = new ArrayList<EWasteItem>();
        ArrayList<GeneralUser> generalUsers = new ArrayList<GeneralUser>();
        String pointsDeducted = null; //to return to main program

        redemptionItems = getRedemptionItems();

        for (EWasteItem ri: redemptionItems){
            if (id.equals(ri.getItemId())){
                pointsDeducted = ri.getItemPoints();
                break;
            }
        }

        File generalUserFile = new File("GeneralUserInfo.txt");
        String str2;
        String[] line2;
        Scanner fileReader2 = new Scanner(generalUserFile);

        while(fileReader2.hasNextLine()){
            str2 = fileReader2.nextLine();
            line2 = str2.split(",");
            GeneralUser gu = new GeneralUser(line2[0],line2[1],line2[2],line2[3]);
            generalUsers.add(gu);
        }

        for (GeneralUser g: generalUsers){
            if (u.getUsername().equals(g.getUsername())){
                int pointsBalance = Integer.valueOf(g.getPoints()) - Integer.valueOf(pointsDeducted);
                g.setPoints(pointsBalance);
                break;
            }
        }

        new FileWriter("GeneralUserInfo.txt", false).close();

        try {
            FileWriter fw = new FileWriter("GeneralUserInfo.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            for (GeneralUser gu: generalUsers){
                pw.println(gu.getName() + "," + gu.getUsername() + "," + gu.getPassword() + "," + gu.getPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pointsDeducted;

    }

    protected void addWasteItem (String n, String p, AdminUser a) throws IOException, FileNotFoundException{
        
        ArrayList<EWasteItem> eWasteItems = getWasteItems();
        String newItemId = String.valueOf(eWasteItems.size() + 1);
        EWasteItem newEwasteItem = new EWasteItem(newItemId, n, p);
        eWasteItems.add(newEwasteItem);

        new FileWriter("WasteItems.txt",false).close();

        try {
            FileWriter fw = new FileWriter("WasteItems.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for (EWasteItem wi: eWasteItems){
                pw.println(wi.getItemId() + "," + wi.getItemName() + "," + wi.getItemPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void deleteWasteItem (String i, AdminUser a) throws IOException, FileNotFoundException{

        ArrayList<EWasteItem> eWasteItems = getWasteItems();
        eWasteItems.remove(Integer.valueOf(i) - 1);

        int counter = 1;

        for (EWasteItem e: eWasteItems){
            e.setItemId(String.valueOf(counter));
            counter = counter + 1;
        }

        new FileWriter("WasteItems.txt",false).close();

        try {
            FileWriter fw = new FileWriter("WasteItems.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for (EWasteItem wi: eWasteItems){
                pw.println(wi.getItemId() + "," + wi.getItemName() + "," + wi.getItemPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void addRedemptionItem (String n, String p, AdminUser a) throws IOException, FileNotFoundException{
        
        ArrayList<EWasteItem> redemptionItems = getRedemptionItems();
        String newItemId = String.valueOf(redemptionItems.size() + 1);
        EWasteItem newEwasteItem = new EWasteItem(newItemId, n, p);
        redemptionItems.add(newEwasteItem);

        new FileWriter("RedemptionItems.txt",false).close();

        try {
            FileWriter fw = new FileWriter("RedemptionItems.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for (EWasteItem ri: redemptionItems){
                pw.println(ri.getItemId() + "," + ri.getItemName() + "," + ri.getItemPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void deleteRedemptionItem (String i, AdminUser a) throws IOException, FileNotFoundException{

        ArrayList<EWasteItem> redemptionItems = getRedemptionItems();
        redemptionItems.remove(Integer.valueOf(i) - 1);

        int counter = 1;

        for (EWasteItem r: redemptionItems){
            r.setItemId(String.valueOf(counter));
            counter = counter + 1;
        }

        new FileWriter("RedemptionItems.txt",false).close();

        try {
            FileWriter fw = new FileWriter("RedemptionItems.txt",true);
            PrintWriter pw = new PrintWriter(fw);

            for (EWasteItem ri: redemptionItems){
                pw.println(ri.getItemId() + "," + ri.getItemName() + "," + ri.getItemPoints());
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
