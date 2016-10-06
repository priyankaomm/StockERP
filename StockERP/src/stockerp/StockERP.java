/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockerp;

import com.aviara.stock.controller.Modal;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author comp2
 */
public class StockERP extends Application {
    
    @FXML
    private Pane main;
    @FXML
    private Pane title_pane;
    @FXML
    private Pane back;
    
    Modal modal=new Modal();
    boolean flag=false;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/aviara/stock/view/Login.fxml"));
        //AnchorPane ap=(AnchorPane)root;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Rectangle2D primScreenBounds=modal.setFullScreen(stage);
        ((Pane)root.lookup("#tp")).setLayoutX(primScreenBounds.getWidth() /3); 
        ((Pane)root.lookup("#lp")).setLayoutX(primScreenBounds.getWidth() /3); 
        stage.show();
       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @FXML
    private void showLogin(MouseEvent evt)
    {
        TranslateTransition tr=modal.translateTransition(main,-480.0,0.0);
        if(!flag)
        {
            tr.play();
            flag=true;
        }
        else
        {
            tr.stop();
        }
    }
    @FXML
    private void handleLogin(ActionEvent evt)
   {
       try{
           modal.close(evt);
           String path="/com/aviara/stock/view/Dashboard.fxml";
           modal.openInFullScreen(path);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
