package matchapxstore.controllers;

import javafx.scene.control.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import matchapxstore.Store;

public class SessionController
{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button ButtonLogIn;
    @FXML
    private Button ButtonSignUp;
    @FXML
    private PasswordField CreatePassword;
    @FXML
    private TextField CreateUsername;
    @FXML
    private PasswordField ConfirmPassword;
    @FXML
    private TextField GetUsername;
    @FXML
    private PasswordField GetPassword;
    @FXML
    private Button ButtonSignUpInLogIn;
    
    private Store store_instance;
    
    @FXML
    private void SwitchtoLogIn(ActionEvent event) throws IOException 
    {
        Button login = (Button) event.getSource();
        login.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("viewers/Log-In.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();     
    }
    
    @FXML
    private void SwitchtoStore(ActionEvent event) throws IOException 
    {
        ButtonLogIn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("viewers/StoreView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void SwitchtoSignUp(ActionEvent event) throws IOException
    {
        ButtonSignUpInLogIn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("viewers/SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void SignUp(ActionEvent event) throws IOException // register //
    {
        store_instance = new Store();
        stage = new Stage();
        boolean registered = false;
        Parent root_1 = FXMLLoader.load(getClass().getResource("viewers/AlertExistingUsername.fxml")); ;
        
        if(CreateUsername.getText().trim().length()<= 0 || 
                CreateUsername.getText().trim().length() <= 0 || 
                CreateUsername.getText().trim().length() <= 0 || 
                !CreatePassword.getText().equals(ConfirmPassword.getText()))
        {
            root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNotSignUp.fxml")); 
            System.out.println("Couldn't register.");
        }
        
        // return false if username exists already //
        else if(store_instance.SignUp(CreateUsername.getText(),CreatePassword.getText()))
        {
            registered = true;
            root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertSuccess.fxml"));
        }
        
        stage.setScene(new Scene(root_1));
        stage.initModality(Modality.APPLICATION_MODAL) ;
        stage.initOwner(ButtonSignUp.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
        
        if(registered)
        {
            ButtonSignUp.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("viewers/Log-In.fxml"));
            Scene scene = new Scene(root); 
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        
        CreateUsername.setText("");
        CreatePassword.setText("");
        ConfirmPassword.setText("");
    }
    
    @FXML
    private void LogIn(ActionEvent event) throws IOException
    {
        store_instance = new Store();
        store_instance.LogIn(GetUsername.getText(), GetPassword.getText());
        Store.setInstance(store_instance);
        if(store_instance.hasAccess())  
        {
            System.out.println("Logged in!");
            ButtonLogIn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("viewers/StoreView.fxml"));
           
            Scene scene = new Scene(root); 
            Stage stage = new Stage();
            stage.setUserData(store_instance);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        
        else
        { 
            stage = new Stage();
            Parent root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNotLogIn.fxml")); 
            
            stage.setScene(new Scene(root_1));
            stage.initModality(Modality.APPLICATION_MODAL) ;
            stage.initOwner(ButtonLogIn.getScene().getWindow());
            stage.setResizable(false);
            stage.showAndWait();
           
            GetUsername.setText("");
            GetPassword.setText("");   
        }
    }
}