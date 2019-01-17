package lk.ijse.dep.fx.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep.fx.view.util.User_DB;

public class Admin_User {
    public PasswordField txtU_pswrd;
    public TextField txtU_Name;
    public TextField txtA_Name;
    public PasswordField txtA_psrwd;
    public TableView<User_DB> tbluserview;

    public static ObservableList<User_DB> user2;

    public void initialize(){

        txtA_Name.setText(Login.name);
        txtA_Name.setDisable(true);
        txtU_Name.setDisable(true);
        txtU_pswrd.setDisable(true);

        tbluserview.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("User_Username"));
        tbluserview.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("User_Userpassword"));
        if (!(Sys_Admin.user==null)){
            tbluserview.setItems(Sys_Admin.user);
        }


    }

    public void A_Update_Action(ActionEvent actionEvent) {
    }

    public void btn_Home(ActionEvent actionEvent) {
    }

    public void U_New_Action(ActionEvent actionEvent) {
        txtU_Name.setDisable(false);
        txtU_pswrd.setDisable(false);
    }

    public void U_Create_Action(ActionEvent actionEvent) {

        Sys_Admin.user=tbluserview.getItems();
        if (txtU_Name.getText().trim().isEmpty() || txtU_pswrd.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty Fields").show();
            return;
        }

        Sys_Admin.user.add(new User_DB(txtU_Name.getText(),txtU_pswrd.getText()));
        tbluserview.refresh();
        return;
    }
}
