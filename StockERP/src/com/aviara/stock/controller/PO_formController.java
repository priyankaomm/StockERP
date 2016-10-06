/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author comp2
 */
public class PO_formController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView autofill;
    @FXML
    private TextField supplier_name;
    @FXML
    private AnchorPane PO_form;
    
    ObservableList<String> data = FXCollections.observableArrayList();
    String[] s=new String[200];
    Modal modal=new Modal();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        autofill.setVisible(false);
        //ObservableList<String> data = FXCollections.observableArrayList();

	        s = new String[]{"apple","ball","cat","doll","elephant",

	            "fight","georgeous","height","ice","jug",

	             "aplogize","bank","call","done","ego",

	             "finger","giant","hollow","internet","jumbo",

	             "kilo","lion","for","length","primary","stage",

	             "scene","zoo","jumble","auto","text",

	            "root","box","items","hip-hop","himalaya","nepal",

	            "kathmandu","kirtipur","everest","buddha","epic","hotel"};

	 

	            /*for(int j=0; j<s.length; j++){

	                data.add(s[j]);

	            }
                    autofill.setItems(data);*/
    }   
    @FXML
    private void handleAutofill(KeyEvent evt)
    {
        autofill.getItems().clear();
         for(int j=0; j<s.length; j++)
         {
             
             if(s[j].startsWith(supplier_name.getText()))
             {
                 data.add(s[j]);
                 autofill.setVisible(true);
                 
             }
             else
             {
                //autofill.setVisible(false);
             }
            
         }
         autofill.setItems(data);
         
    }
    @FXML
    private void handleClick(MouseEvent evt)
    {
        String selected=autofill.getSelectionModel().getSelectedItem().toString();
        supplier_name.setText(selected);
        autofill.setVisible(false);
    }
    @FXML
    private void handleFocusLost(MouseEvent evt)
    {
       autofill.setVisible(false); 
       PO_form.setDisable(false);
    }
    @FXML
    private void openSupplier(ActionEvent evt) 
    {
        String path="/com/aviara/stock/view/Supplier.fxml";
        open(path);
    }
    @FXML
    private void openInventoryItem(ActionEvent evt) 
    {
        String path="/com/aviara/stock/view/AddProduct.fxml";
        open(path);
    }
    @FXML
    private void openItem(ActionEvent evt) 
    {
        String path="/com/aviara/stock/view/Item.fxml";
        open(path);
    }
    private void open(String path)
    {
        try{
           PO_form.setDisable(true);
           Stage stage=modal.openForm(path);
           stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           public void handle(WindowEvent we) {
              PO_form.setDisable(false);
              System.out.println("Stage is closing");
            }
         });   
            stage.focusedProperty().addListener(new ChangeListener<Boolean>()
           {
           @Override
             public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1)
             {
                PO_form.setDisable(false);
                stage.close();
             }
           });
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
