package lk.ijse.dep.fx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    public TextField txt_User_Name;
    public TextField txt_Pswrd;
public static String name="";
public static int a=0;


    public void Login_Action(ActionEvent actionEvent) throws IOException {

//        String username = txt_User_Name.getText();
//        String password = txt_Pswrd.getText();
        if(txt_User_Name.getText().trim().isEmpty() || txt_Pswrd.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have Empty Fields",ButtonType.OK).show();
            return;
        }

        if (txt_User_Name.getText().equals("system") && txt_Pswrd.getText().equals(Sys_Admin.Syspword)) {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
            Scene scene = new Scene(root);

            Stage primaryStage = (Stage) txt_User_Name.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
            this.name=txt_User_Name.getText();
            this.a=1;
            return;


        } else if (!(txt_User_Name.getText().isEmpty())){
            for (int i = 0; i < Sys_Admin.Admin.size(); i++) {
                if (txt_User_Name.getText().equals(Sys_Admin.Admin.get(i).getAdmin_User_Name()) && txt_Pswrd.getText().equals(Sys_Admin.Admin.get(i).getAdmin_User_Password())) {
                    Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/View/MainView.fxml"));
                    Scene sc = new Scene(root);
                    Stage pmstage = (Stage) txt_Pswrd.getScene().getWindow();
                    pmstage.setScene(sc);
                    this.name=txt_User_Name.getText();
                    this.a = 2;
                    return;
        }
            }
       }

       else if (!(txt_User_Name.getText().isEmpty())){
            for (int i = 0; i < Sys_Admin.user.size(); i++) {
                if (txt_User_Name.getText().equals(Sys_Admin.user.get(i).getUser_Name()) && txt_Pswrd.getText().equals(Sys_Admin.user.get(i).getUser_Password())) {
                    Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/View/MainView.fxml"));
                    Scene sc = new Scene(root);
                    Stage pmstage = (Stage) txt_Pswrd.getScene().getWindow();
                    pmstage.setScene(sc);
                    this.name=txt_User_Name.getText();
                    this.a =3;
                    return;
                }
            }

        }
    }
}
