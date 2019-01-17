package lk.ijse.dep.fx.Controller;

import com.sun.xml.internal.bind.v2.model.core.ID;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.CustomerTM;

import javax.lang.model.element.Name;
import java.io.IOException;
import java.util.ArrayList;

public class MangeCustomer {
    @FXML
    public Button btnCustomer;
    @FXML
    public Button btnBack;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnDelete;
    public TextField txtId;
    @FXML

    public TextField txtName;
    @FXML

    public TextField txtAddress;
    @FXML
    public AnchorPane tbl;
    @FXML
    public TableColumn c_Id;
    public TableColumn C_name;
    public TableColumn C_Address;
    @FXML
    public TableView<CustomerTM> tbl_Customer;

    public static ArrayList<CustomerTM> customerTMS = new ArrayList<>();
    public Button btnUpdate;

    static {
        customerTMS.add(new CustomerTM("1","Nuwan","Panadura"));
        customerTMS.add(new CustomerTM("2","Kasun","Homagam"));
        customerTMS.add(new CustomerTM("3","Ishan","matara"));
    }

    @FXML
    public void NewCustomer_Action(ActionEvent actionEvent) throws IOException {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);

    }

    @FXML

    public void Back_Action(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
    }


    public void initialize() {

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);

        tbl_Customer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl_Customer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_Customer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        ObservableList<CustomerTM> cus = FXCollections.observableArrayList(customerTMS);
        tbl_Customer.setItems(cus);

        tbl_Customer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM Value) {
                txtId.setText(Value.getId());
                txtName.setText(Value.getName());
                txtAddress.setText(Value.getAddress());
            }
        });

    }

    @FXML
    public void Save_Action(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        if (id.trim().isEmpty() || name.trim().isEmpty() || address.trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "field can't empty", ButtonType.OK).showAndWait();
            return;
        }
            for (int i=0; i<customerTMS.size();i++) {
                if (id.equals(customerTMS.get(i).getId())){
                    new Alert(Alert.AlertType.ERROR, "Same ID", ButtonType.OK).showAndWait();
                    return;
                }



            }


        customerTMS.add(new CustomerTM(id, name, address));
        new Alert(Alert.AlertType.CONFIRMATION, "Succesfully Entered", ButtonType.OK).showAndWait();

        ObservableList<CustomerTM> cus = FXCollections.observableArrayList(customerTMS);
        tbl_Customer.setItems(cus);

        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");

    }

    @FXML

    public void Delet_Action(ActionEvent actionEvent) {
        CustomerTM SelectedCustomer = tbl_Customer.getSelectionModel().getSelectedItem();
        customerTMS.remove(SelectedCustomer);

        new Alert(Alert.AlertType.INFORMATION, "Customer Deleted", ButtonType.OK).showAndWait();
        ObservableList<CustomerTM> cus = FXCollections.observableArrayList(customerTMS);
        tbl_Customer.setItems(cus);

        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
    }

    public void btnUpdate_Action(ActionEvent actionEvent) {
/*
    if (customerTMS == null){
            return;
        }
        ArrayList<CustomerTM> cus = new ArrayList<>();

        for (CustomerTM customerTM : customerTMS) {
            if(customerTM.getId().equals(txtId)) {
                cus.add(new CustomerTM(customerTM.getId(),));
                else{
                    cus.add(new CustomerTM(customerTM.getId(), customerTM.getName(), customerTM.getAddress()));
                }
            }
        }
        customerTMS=cus;
         */

    }
}
