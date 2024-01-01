package models;

public class FormData {
    private String username;
    private String password;

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString(){
        return "User {name = "+username+", pwd = "+password+"}";
    }
}
