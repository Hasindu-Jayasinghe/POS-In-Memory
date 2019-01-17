package lk.ijse.dep.fx.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.Order2_TM;
import lk.ijse.dep.fx.view.util.ViewOrdersTM;

import java.io.IOException;

public class ViewOrder2 {
    public  static TextField txtOder_ID;
    public TextField txtOrder_Date;
    public TextField txtCus_ID;
    public TextField txtCus_Name;
    public TableView <Order2_TM> tblView_Order2;
    public Label lblTotal;
    public Button btnBack;



    public void initialize(){
        tblView_Order2.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblView_Order2.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("desc"));
        tblView_Order2.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblView_Order2.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblView_Order2.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

//        txtCus_ID.setText(PlaceOrder.ordsesave.get().getCustomerid());


    }

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/ViewOrders.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);

    }
}
