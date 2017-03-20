package WebApp;

public class user{



    private String userName;
    private String userRole;
    private String userUsername;
    private String userPassword;

    public user(String userName, String userRole, String userUsername, String userPassword){
       this.userName = userName;
       this.userRole = userRole;
       this.userUsername = userUsername;
       this.userPassword = userPassword;

    }

    public user() {

    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole){
        this.userRole = userRole;
    }

    public String getUserUsername(){
        return userUsername;
    }
    public void setUserUsername(String userUsername){
        this.userUsername = userUsername;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}