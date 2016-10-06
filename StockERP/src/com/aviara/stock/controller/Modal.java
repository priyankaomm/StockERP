/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;

import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author comp2
 */
public class Modal {
    public TranslateTransition translateTransition(Pane node,double valueY,double valueX)
    {
        TranslateTransition slideOut = new TranslateTransition(Duration.seconds(0.5), node);
        slideOut.setByY(valueY);
        slideOut.setByX(valueX);
        return slideOut;
    }
    public Rectangle2D setFullScreen(Stage stage)
    {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setMinHeight(primScreenBounds.getHeight());
        stage.setMinWidth(primScreenBounds.getWidth());
        return primScreenBounds;
    }
    public void close(Event evt)
    {
        final Node source = (Node) evt.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public Stage openInFullScreen(String path) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        //AnchorPane ap=(AnchorPane)root;
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        setFullScreen(stage);
        stage.show();
        return stage;
    }
    public AnchorPane open(String path) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.show();
        return (AnchorPane)root;
    }
    public Stage openForm(String path) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.toFront();
        stage.show();
        return stage;
    }
    public void showMessage(String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
