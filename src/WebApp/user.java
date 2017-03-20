package WebApp;

public class user
{

    private String userName;
    private String userSurname;
    private String userRole;
    private String userUsername;
    private String userPassword;

    public user()
    {

    }

    public String getUserUsername()
    {
        return userUsername;
    }

    public void setUserUsername(String userUsername)
    {
      this.userUsername= userUsername;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName= userName;
    }

    public String getUserRole()
    {
        return userRole;
    }

    public void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }

    public String getUserSurname()
    {
        return userSurname;
    }

    public void setUserSurname(String userUsername)
    {
        this.userSurname= userSurname;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userUsername)
    {
        this.userPassword = userPassword;
    }

}
