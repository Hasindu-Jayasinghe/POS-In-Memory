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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.CustomerTM;
import lk.ijse.dep.fx.view.util.ItemTM;
import sun.awt.SunHints;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MangeItems {
    @FXML
    public Button btnItem;
    @FXML
    public Button btnBack;
    @FXML
    public TextField txtCode;
    @FXML

    public TextField txtDesc;
    @FXML

    public TextField txtUnit;
    @FXML

    public TextField txtQty;
    @FXML

    public Button btnSave;
    @FXML

    public Button btndelete;
    @FXML
    public Button btnUpdate;

    @FXML
    private AnchorPane root;
    @FXML
    public TableView<ItemTM> tbl_Items;

    public static ArrayList<ItemTM> itemTMS= new ArrayList<>();

    static {
        itemTMS.add(new ItemTM("1","lux" ,"200","20"));
        itemTMS.add(new ItemTM("2","kohoba" ,"50","20"));
        itemTMS.add(new ItemTM("3","life boy" ,"100","10"));

    }


    @FXML

    public void Item_Action(ActionEvent actionEvent) throws IOException {
         txtCode.setDisable(false);
         txtDesc.setDisable(false);
         txtQty.setDisable(false);
         txtUnit.setDisable(false);

    }
    @FXML

    public void Back_Action(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/dep/fx/view/MainForm.fxml"));
        Scene scene= new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void initialize() {

        txtCode.setDisable(true);
        txtDesc.setDisable(true);
        txtQty.setDisable(true);
        txtUnit.setDisable(true);

        tbl_Items.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tbl_Items.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tbl_Items.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tbl_Items.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        ObservableList<ItemTM> item= FXCollections.observableArrayList(itemTMS);
        tbl_Items.setItems(item);

        tbl_Items.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemTM>() {
            @Override
            public void changed(ObservableValue<? extends ItemTM> observable, ItemTM oldValue, ItemTM x) {
                txtCode.setText(x.getCode());
                txtDesc.setText(x.getDescription());
                txtQty.setText(x.getQty());
                txtUnit.setText(x.getUnitPrice());
            }
        });



    }
    @FXML

    public void Save_Action(ActionEvent actionEvent) {
        String code= txtCode.getText();
        String description= txtDesc.getText();
        String unitPrice = txtUnit.getText();
        String qty= txtQty.getText();

        if(code.trim().isEmpty()||description.trim().isEmpty()||unitPrice.trim().isEmpty()||qty.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"fields can't empty",ButtonType.OK).showAndWait();
            return;
        }

        for (int i=0; i<itemTMS.size();i++) {
            if (code.equals(itemTMS.get(i).getCode())){
                new Alert(Alert.AlertType.ERROR, "Same ID", ButtonType.OK).showAndWait();
                return;
            }


        }

            itemTMS.add(new ItemTM(code, description, unitPrice, qty));
            ObservableList<ItemTM> item = FXCollections.observableArrayList(itemTMS);
            tbl_Items.setItems(item);
            new Alert(Alert.AlertType.CONFIRMATION, "succesfully entered", ButtonType.OK).showAndWait();


        txtCode.setText("");
        txtDesc.setText("");
        txtQty.setText("");
        txtUnit.setText("");
    }
    @FXML

    public void Delete_Action(ActionEvent actionEvent) {

        ItemTM SelectedItem = tbl_Items.getSelectionModel().getSelectedItem();
        itemTMS.remove(SelectedItem);

        new Alert(Alert.AlertType.INFORMATION,"Item Deleted",ButtonType.OK).showAndWait();
        ObservableList<ItemTM>item = FXCollections.observableArrayList(itemTMS);
        tbl_Items.setItems(item);

        txtCode.setText("");
        txtDesc.setText("");
        txtQty.setText("");
        txtUnit.setText("");
    }

    public void btnUpdate_Action(ActionEvent actionEvent) {

    }
}
