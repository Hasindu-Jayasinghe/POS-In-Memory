package lk.ijse.dep.fx.view.util;

public class Admin_DB {
    private String Admin_User_Name;
    private String Admin_User_Password;

    public Admin_DB(String admin_User_Name, String admin_User_Password) {
        setAdmin_User_Name(admin_User_Name);
        setAdmin_User_Password(admin_User_Password);
    }

    public String getAdmin_User_Name() {
        return Admin_User_Name;
    }

    public void setAdmin_User_Name(String admin_User_Name) {
        Admin_User_Name = admin_User_Name;
    }

    public String getAdmin_User_Password() {
        return Admin_User_Password;
    }

    public void setAdmin_User_Password(String admin_User_Password) {
        Admin_User_Password = admin_User_Password;
    }

}
