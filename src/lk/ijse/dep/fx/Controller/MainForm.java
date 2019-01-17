package lk.ijse.dep.fx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainForm {
    @FXML
    public Button btnMCust;
    @FXML
    public Button btnMItems;
    @FXML
    public Button btnPOrders;
    @FXML
    public Button btnVoreders;
    @FXML
    private AnchorPane rootmain;

    @FXML
    public void Customer_Action (ActionEvent actionEvent) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MangeCustomer.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnMCust.getScene().getWindow();
        primaryStage.setScene(scene);
    }
    @FXML
    public void Items_Action(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MangeItems.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnMItems.getScene().getWindow();
        primaryStage.setScene(scene);
    }
    @FXML
    public void P_Orders_Action(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/PlaceOrder.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnMItems.getScene().getWindow();
        primaryStage.setScene(scene);
    }
    @FXML
    public void V_Oreders_Action(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/ViewOrders.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnMItems.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void btn_Setings_Action(ActionEvent actionEvent) {
    }

    public void gotosetting(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/System_Admin.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnMItems.getScene().getWindow();
        primaryStage.setScene(scene);

    }
}
