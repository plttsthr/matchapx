/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchapxstore.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import matchapxstore.Store;


/**
 *
 * @author paulette.
 */

public class SettingsController 
{
    private Store store_instance;
  
    @FXML
    private Label LabelMyBalance;
    @FXML
    private PasswordField ChangeCurrentPassword;
    @FXML
    private PasswordField NewPassword;
    @FXML
    private PasswordField ConfirmNewPassword;
    @FXML
    private Button ButtonChangePassword;

    
    @FXML
    private void GetBalance(ActionEvent event) throws IOException     
    {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        store_instance = (Store) stage.getUserData();
        LabelMyBalance.setText("" + store_instance.getUserMoney());
    }
    
    @FXML
    private void AddCredit(ActionEvent event) throws IOException
    {
        RadioButton trigger = (RadioButton) event.getSource();
        int id = Integer.parseInt(trigger.getId().substring(2));
        trigger.setSelected(false);
        trigger.setSelected(true);
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        
        store_instance = (Store) stage.getUserData();
        store_instance.AddCredit(id);
        
        GetBalance(event); 
    }
    
    @FXML
    private void ChangePassword(ActionEvent event) throws IOException
    {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        store_instance = (Store) stage.getUserData();
        
        stage = new Stage();
        Parent root_1 = FXMLLoader.load(getClass().getResource("viewers/AlertPasswordUpdated.fxml")); ;
        
        if(!ConfirmNewPassword.getText().equals(NewPassword.getText()) || 
                ConfirmNewPassword.getText().trim().length() <= 0 || 
                NewPassword.getText().trim().length() <= 0 ||
                ChangeCurrentPassword.getText().trim().length() <= 0)
        {
            root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertChangePassword.fxml"));   
        }
        
        else if(!(store_instance.UpdatePassword(ChangeCurrentPassword.getText(), NewPassword.getText())))
        { 
            root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertChangePassword.fxml"));      
        }
        
        stage.setScene(new Scene(root_1));
        stage.initModality(Modality.APPLICATION_MODAL) ;
        stage.initOwner(ButtonChangePassword.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
        
        ChangeCurrentPassword.setText("");
        ConfirmNewPassword.setText("");
        NewPassword.setText("");
    } 
}
