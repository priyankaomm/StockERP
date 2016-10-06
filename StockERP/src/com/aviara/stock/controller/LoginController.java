/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;


import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author comp2
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane main;
    @FXML
    private Pane title_pane;
    
    @FXML
    private StackPane mainPane;
    Modal modal=new Modal();
    boolean flag=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
    
}
