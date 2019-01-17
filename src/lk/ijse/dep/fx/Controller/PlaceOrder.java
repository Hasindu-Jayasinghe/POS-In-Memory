package lk.ijse.dep.fx.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.ItemTM;
import lk.ijse.dep.fx.view.util.Order2_TM;
import lk.ijse.dep.fx.view.util.Place_OrderTM;
import lk.ijse.dep.fx.view.util.ViewOrdersTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PlaceOrder {
    @FXML
    public TextField txtQty_Hand;
    @FXML
    public TextField txtUnit_Price;
    @FXML
    public TextField txtQty;
    @FXML
    public TextField txtDescription;
    @FXML
    public TextField txtCustomer_Name;
    @FXML
    public TextField txtDate;
    @FXML
    public TextField txtItem_Code;
    @FXML
    public TextField txtCustomer_Id;
    @FXML
    public TextField txtOder_Id;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnRemove;
    @FXML
    public TableView <Place_OrderTM> tblPlace_Order;
    @FXML
    public TextField txtTotal;
    @FXML
    public Button btnBack;
    public static int count=1;
  //  public TableView<Place_OrderTM> tbl_place;

    public static ArrayList<Place_OrderTM> place_orderTMS= new ArrayList<>();
    public static ArrayList<ViewOrdersTM> ordsesave= new ArrayList<>();
    public void initialize(){



        tblPlace_Order.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblPlace_Order.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblPlace_Order.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblPlace_Order.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblPlace_Order.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        txtDate.setText(LocalDate.now().toString());

        txtDate.setEditable(false);
        txtCustomer_Name.setEditable(false);
        txtDescription.setEditable(false);
        txtOder_Id.setEditable(false);
        txtQty_Hand.setEditable(false);
        txtUnit_Price.setEditable(false);

        //count= place_orderTMS.size()+1;
        txtOder_Id.setText(Integer.toString(count));


        ObservableList<Place_OrderTM> item= FXCollections.observableArrayList(place_orderTMS);
        tblPlace_Order.setItems(item);

        tblPlace_Order.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Place_OrderTM>() {
            @Override
            public void changed(ObservableValue<? extends Place_OrderTM> observable, Place_OrderTM oldValue, Place_OrderTM A) {
                 txtUnit_Price.setText(A.getUnitPrice());
                 txtQty.setText(A.getQty());
                 txtDescription.setText(A.getDescription());
                 txtItem_Code.setText(A.getCode());
               //  txtQty_Hand.setText(A.getQty_Hand());

            }
        });




    }

    Date date= new Date();


    @FXML
    public void btnAdd_Action(ActionEvent actionEvent) {
        String qtyHand = txtQty_Hand.getText();
        String unitPrice = txtUnit_Price.getText();
        String qty = txtQty.getText();
        String description = txtDescription.getText();
        String cusId =  txtCustomer_Name.getText();
        String cusName = txtCustomer_Id.getText();
        String date= txtDate.getText();
        String itemCode= txtItem_Code.getText();
        String oderId= txtOder_Id.getText();
       // String total= txtTotal.getText();

      if (Integer.parseInt(txtQty_Hand.getText()) < Integer.parseInt(txtQty.getText())){
          new Alert(Alert.AlertType.ERROR,"Over Qty",ButtonType.OK).showAndWait();
          return;
        }

      if(qty.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"qty field can't empty",ButtonType.OK).showAndWait();
            return;
        }

      /* for (int i=0; i<ItemTM.size();i++) {
            if (code.equals(itemTMS.get(i).getCode())){
                new Alert(Alert.AlertType.ERROR, "Same ID", ButtonType.OK).showAndWait();
                return;
            } */









        double x,y, total;

        x= Double.parseDouble(txtQty.getText());
        y= Double.parseDouble((txtUnit_Price.getText()));

        total= x*y;



       for (int i = 0; i <  place_orderTMS.size(); i++) {


            if (txtItem_Code.getText().equals(place_orderTMS.get(i).getCode())) {
                double a, b, c, d, e;
                a = Double.parseDouble(txtUnit_Price.getText());
                b = Double.parseDouble(txtQty.getText());
                c = Double.parseDouble(place_orderTMS.get(i).getQty());

                d = b + c;
                e = d * a;
                place_orderTMS.get(i).setQty(Double.toString(d));
                place_orderTMS.get(i).setTotal(Double.toString(e));
                tblPlace_Order.refresh();

                findtotal();
                Stockupdate();
                return;
            }
        }

        place_orderTMS.add(new Place_OrderTM(itemCode,description,unitPrice,qty,Double.toString(total)));
        ObservableList<Place_OrderTM> item = FXCollections.observableArrayList(place_orderTMS);
        tblPlace_Order.setItems(item);
//
//        txtItem_Code.setText("");
//        txtQty.setText("");
//        txtUnit_Price.setText("");
//        txtDescription.setText("");
//        txtQty_Hand.setText("");

        findtotal();
        Stockupdate();



        return;

    }

    public void findtotal(){
        double Total=0;
        for (int i = 0; i < place_orderTMS.size() ; i++) {
            double x=Double.parseDouble(place_orderTMS.get(i).getTotal());
           Total+=x;

        }
        txtTotal.setText(Double.toString(Total));
    }


    @FXML
    public void btnRemove_Action(ActionEvent actionEvent) {
        Place_OrderTM SelectedItem = tblPlace_Order.getSelectionModel().getSelectedItem();
       place_orderTMS.remove(SelectedItem);

        new Alert(Alert.AlertType.INFORMATION,"Item Deleted", ButtonType.OK).showAndWait();
        ObservableList<Place_OrderTM> order = FXCollections.observableArrayList(place_orderTMS);
        tblPlace_Order.setItems(order);

        txtCustomer_Id.setText("");
        txtItem_Code.setText("");
        txtQty_Hand.setText("");
        txtUnit_Price.setText("");
        txtQty.setText("");
        txtDescription.setText("");
        txtCustomer_Name.setText("");


    }
    @FXML
    public void btnPlace_Order(ActionEvent actionEvent) throws IOException {
        ordsesave.add(new ViewOrdersTM(txtOder_Id.getText(),txtCustomer_Id.getText(),txtDate.getText(),txtCustomer_Name.getText(),place_orderTMS));
        count = count +1;
        place_orderTMS.clear();
        this.tblPlace_Order.getItems().clear();
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);








    }
    @FXML
    public void btnBack_Action(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void searchID(KeyEvent keyEvent) {
        for (int i = 0; i < MangeCustomer.customerTMS.size() ; i++) {
           if(txtCustomer_Id.getText().equals(MangeCustomer.customerTMS.get(i).getId() )){

               txtCustomer_Name.setText( MangeCustomer.customerTMS.get(i).getName());
           }
        }

    }

    public void search_Item(KeyEvent keyEvent) {
        for (int i = 0; i <MangeItems.itemTMS.size() ; i++) {
            if(txtItem_Code.getText().equals(MangeItems.itemTMS.get(i).getCode())){
            txtDescription.setText(MangeItems.itemTMS.get(i).getDescription());
                txtQty_Hand.setText(MangeItems.itemTMS.get(i).getQty());
                txtUnit_Price.setText(MangeItems.itemTMS.get(i).getUnitPrice());

        }
    }
    }
    public void Stockupdate(){
        for (int i = 0; i <MangeItems.itemTMS.size() ; i++) {
            if(txtItem_Code.getText().equals(MangeItems.itemTMS.get(i).getCode())){
                int x,y,z;
                x=Integer.parseInt(MangeItems.itemTMS.get(i).getQty());
                y= Integer.parseInt(txtQty.getText());
                z= x-y;
                MangeItems.itemTMS.get(i).setQty(Integer.toString(z));
                txtQty_Hand.setText(Integer.toString(z));

                return;
            }
        }
    }


}
