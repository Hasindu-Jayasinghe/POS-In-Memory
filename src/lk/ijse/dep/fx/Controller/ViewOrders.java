package lk.ijse.dep.fx.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.Place_OrderTM;
import lk.ijse.dep.fx.view.util.ViewOrdersTM;

import java.io.IOException;
import java.util.ArrayList;



public class ViewOrders {

    public TableView <ViewOrdersTM> tbl_ViewOrders;
     public Button btnBack;
    public TextField txt_OrdersSearch;

    public static  ObservableList<ViewOrdersTM> item;

    public void initialize(){
        tbl_ViewOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tbl_ViewOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tbl_ViewOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerid"));
        tbl_ViewOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customername"));


       item =  FXCollections.observableArrayList(PlaceOrder.ordsesave);
        tbl_ViewOrders.setItems(item);



     tbl_ViewOrders.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ViewOrdersTM>() {
            @Override
            public void changed(ObservableValue<? extends ViewOrdersTM> observable, ViewOrdersTM oldValue, ViewOrdersTM b) {


                ViewOrder2.txtOder_ID.setText(b.getOrderId());


            }
        });

    }

    public void btn_Back(ActionEvent actionEvent) throws IOException {
        Parent roots= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/PlaceOrder.fxml"));
        Scene scene= new Scene(roots);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void btn_HomeAction(ActionEvent actionEvent) throws IOException {
        Parent r= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
        Scene scene= new Scene(r);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void search(KeyEvent keyEvent) {

        ObservableList temp = FXCollections.observableArrayList();
      for (int i = 0; i < item.size() ; i++) {

          if(item.get(i).getOrderId().startsWith(txt_OrdersSearch.getText())){

              String x= item.get(i).getOrderId();
              String y = item.get(i).getCustomerid();
              String z = item.get(i).getCustomername();
              String a = item.get(i).getDate();


              temp.add(new ViewOrdersTM(x,y,z,a));

              tbl_ViewOrders.setItems(temp);
          }

      }
    }


}
