package lk.ijse.dep.fx.view.util;

public class System_DB {
    private String Sys_Name;
    private String Sys_Password;

    public System_DB(String sys_Name, String sys_Password) {
        Sys_Name = sys_Name;
        Sys_Password = sys_Password;
    }

    public String getSys_Name() {
        return Sys_Name;
    }

    public void setSys_Name(String sys_Name) {
        Sys_Name = sys_Name;
    }

    public String getSys_Password() {
        return Sys_Password;
    }

    public void setSys_Password(String sys_Password) {
        Sys_Password = sys_Password;
    }
}
