/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;

import com.aviara.stock.bean.Supplier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author comp2
 */
public class SupplierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox state;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private TextField pincode;
    @FXML
    private TextField contact;
    Modal modal=new Modal();
    Supplier sbean=new Supplier();
    Query query=new Query();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String s[]=new String[]{"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana",
        "Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya"
        ,"Mizoram","Nagaland","Odisha (Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
        for(int j=0;j<s.length;j++)
        {
            state.getItems().add(s[j]);
        }
    }  
    @FXML
    private void saveSupplier(ActionEvent evt)
    {
        if(fname.getText().equals("")||
           lname.getText().equals("")||
           email.getText().equals("")||
           contact.getText().equals(""))
        {
            modal.showMessage("Please Fill all Mandatory Fields!!");
        }
        else
        {
            sbean.setFname(fname.getText());
            sbean.setLname(lname.getText());
            sbean.setEmail(email.getText());
            sbean.setCity(city.getText());
            sbean.setAddress(address.getText());
            sbean.setPincode(pincode.getText());
            sbean.setContact(contact.getText());
            sbean.setState(state.getSelectionModel().getSelectedItem().toString());
            query.save(sbean);
        }
    }
    
}
