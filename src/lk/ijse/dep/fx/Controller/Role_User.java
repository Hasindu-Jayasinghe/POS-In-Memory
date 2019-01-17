package lk.ijse.dep.fx.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Role_User {
    public PasswordField txtPsrwd;
    public PasswordField txtNewPsrwd;
    public PasswordField txtCnfrmPsrwd;
    public TextField txtUserName;

    public void initialize(){
        txtUserName.setDisable(true);
        txtUserName.setText(Login.name);
    }

    public void Change_Action(ActionEvent actionEvent) {

        if (txtNewPsrwd.getText().trim().isEmpty() || txtCnfrmPsrwd.getText().trim().isEmpty() || txtPsrwd.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields").show();
        }

        for (int i = 0; i <Sys_Admin.user.size() ; i++) {
            if (txtUserName.getText().equals(Sys_Admin.user.get(i).getUser_Name())){
                if (txtPsrwd.getText().equals(Sys_Admin.user.get(i).getUser_Password())){
                    if(txtNewPsrwd.getText().equals(txtCnfrmPsrwd.getText())){
                        Sys_Admin.user.get(i).setUser_Password(txtNewPsrwd.getText());
                        new Alert(Alert.AlertType.INFORMATION,"Password Updated").show();
                        return;
                    }
                    else {
                        new Alert(Alert.AlertType.ERROR,"Password Dosen't Match").show();
                        return;
                    }
                }
                else {
                    new Alert(Alert.AlertType.ERROR,"Old Password Dosen't Match").show();
                    return;
                }
            }
        }

    }
}
