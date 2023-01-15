public class User{
    
protected String name;
protected String username;
protected String password;

public User(String n, String un, String p){
    this.name = n;
    this.username = un;
    this.password = p;
}

protected String getName(){
    return name;
}

protected String getUsername(){
    return username;
}

protected String getPassword(){
    return password;
}

}