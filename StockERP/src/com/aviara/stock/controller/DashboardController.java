/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author comp2
 */
    
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane side_menu;
    @FXML
    private Pane menu_bar;
    @FXML
    private Pane side_icon;
    @FXML
    private ScrollPane scroll;
    boolean flag=false;
    Modal modal= new Modal();
    TranslateTransition tr = null;
    double x=0.00,y=0.00,width=0.00;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       width=menu_bar.getPrefWidth();
       menu_bar.setPrefWidth(side_icon.getPrefWidth());
    }    
    @FXML
    private void handle(ActionEvent evt)
    {
        
        if(!flag)
        {
            side_menu.setTranslateX(x);
            side_menu.setTranslateY(y);
            menu_bar.setPrefWidth(width);
            tr=modal.translateTransition(side_menu, 0.00, -160);
            flag=true;
            tr.play();
            System.out.println("show");
            
        }
        else
        {
           //side_menu.setTranslateX(x);
           //side_menu.setTranslateY(y);
           menu_bar.setPrefWidth(side_icon.getPrefWidth());
           tr = modal.translateTransition(side_menu, 0.00, 160);
           flag=false;
           tr.play();
           //System.out.println("hide x="+side_menu.getTranslateX()+" y="+side_menu.getTranslateY());
           
        }
    }
    @FXML
    private void openPO(MouseEvent evt)
    {
        try
        {
         
        String path="/com/aviara/stock/view/PO_form.fxml";
        AnchorPane root=modal.open(path);
        scroll.setContent(root);
        }catch(Exception e)
        {
          e.printStackTrace();
        }
    }
}

