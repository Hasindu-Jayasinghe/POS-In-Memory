package lk.ijse.dep.fx.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.Admin_DB;
import lk.ijse.dep.fx.view.util.User_DB;

import java.io.IOException;

public class Sys_Admin {
    public PasswordField U_Psrwd;
    public TextField txtU_Name;
    public PasswordField txS_New_psrwd;
    public PasswordField txtS_C_Psrwd;
    public PasswordField txtA_pswrd;
    public TextField txtS_Name;
    public TextField txtA_Name;



    public static ObservableList<Admin_DB> Admin;
    public static ObservableList <User_DB>user;
    static String Syspword="123";
 //   public TableColumn tbl_Admin;
    public Button BtnS_Change;
    public Button btnCreate;
    public Button btn_New;
    public Button btn_U_New;
    public Button btnU_Create;
    public TableView <Admin_DB>tbl_Admin;
    public TableView <User_DB>tbl_User;
  //  public TableColumn tbl_user;
    public Button btnHome;
    public TextField txt_Old_Pswrd;



    public void initialize(){

        txtA_Name.setDisable(true);
        txtA_pswrd.setDisable(true);
        U_Psrwd.setDisable(true);
        txtU_Name.setDisable(true);

        if (!(user==null)){
            this.tbl_User.setItems(user);
        }
         tbl_User.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("User_Name"));
        tbl_User.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("User_Password"));


        if (!(Admin==null)){
            this.tbl_Admin.setItems(Admin);
            tbl_Admin.refresh();
        }
        tbl_Admin.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Admin_User_Name"));
        tbl_Admin.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Admin_User_Password"));
    }


    public void S_Change_Action(ActionEvent actionEvent) {
        if (txt_Old_Pswrd.getText().trim().isEmpty() || txS_New_psrwd.getText().trim().isEmpty() || txtS_C_Psrwd.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields").show();
            return;
        }
        if (txt_Old_Pswrd.getText().equals(Syspword)) {
            if (txS_New_psrwd.getText().equals(txtS_C_Psrwd.getText())) {
                this.Syspword = txS_New_psrwd.getText();
                new Alert(Alert.AlertType.INFORMATION,"Pasword has change").show();
                return;
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Password dosent match").show();
                return;
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Old Password dosent match").show();
            return;
        }

    }

    public void A_Create_Action(ActionEvent actionEvent) {
        if (txtA_pswrd.getText().trim().isEmpty() || txtA_Name.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields").show();
            return;
        }

        if (tbl_Admin.getItems().size()==2){
            new Alert(Alert.AlertType.ERROR,"Mxiumum Admin are sets").show();
            return;
        }
        Admin=tbl_Admin.getItems();
        Admin.add(new Admin_DB(txtU_Name.getText(),txtA_pswrd.getText()));
        new Alert(Alert.AlertType.INFORMATION,"Admin has Created").show();
        tbl_Admin.refresh();
        return;
    }

    public void A_New_Action(ActionEvent actionEvent) {
        txtA_Name.setDisable(false);
        txtA_pswrd.setDisable(false);
    }

    public void U_New_Action(ActionEvent actionEvent) {
        txtU_Name.setDisable(false);
        U_Psrwd.setDisable(false);
    }

    public void U_Create(ActionEvent actionEvent) {
        user=tbl_User.getItems();
        if(txtU_Name.getText().trim().isEmpty() || U_Psrwd.getText().trim().isEmpty())
        {
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields").show();
            return;
        }

        user.add(new User_DB(txtU_Name.getText(),U_Psrwd.getText()) );
        new Alert(Alert.AlertType.INFORMATION,"New User Created");
        tbl_User.refresh();
        return;
    }



    public void logout(MouseEvent mouseEvent) throws IOException {
        Parent path = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/View/Login.fxml"));
        Scene sc = new Scene(path);
        Stage asd = (Stage) tbl_Admin.getScene().getWindow();
        asd.setScene(sc);
    }

    public void gohome(MouseEvent mouseEvent) throws IOException {
        Parent path = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/View/MainForm.fxml"));
        Scene sc = new Scene(path);
        Stage pmstage = (Stage) tbl_Admin.getScene().getWindow();
        pmstage.setScene(sc);
    }
}
