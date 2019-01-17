package lk.ijse.dep.fx.view.util;

public class User_DB {
   private String User_Name;
   private String User_Password;

    public String getUser_Name() {
        return User_Name;
    }

    public User_DB(String user_Name, String user_Password) {
        User_Name = user_Name;
        User_Password = user_Password;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }
}
