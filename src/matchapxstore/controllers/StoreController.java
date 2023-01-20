/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchapxstore.controllers;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import matchapxstore.Item;
import matchapxstore.Store;

/**
 *
 * @author paulette.
 */
public class StoreController implements Initializable{
    
    @FXML
    private Stage stage;
    @FXML
    private Button ButtonLogOut;
    @FXML
    private AnchorPane AnchorPaneStore;
    @FXML
    private GridPane GridItems;
    @FXML
    private TextField SearchInput;
    @FXML
    private Button ButtonSearch;
    @FXML
    private Button ButtonShelf;
 
    private ArrayList<Item> StoreItems;
    private Store store_instance;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        StoreItems = Store.getStoreItems();
        int row = 1;
        int column = 0;
        try
        {
            for(int i =0; i < StoreItems.size(); i++ )
            {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("viewers/Item.fxml"));
                AnchorPane AnchorPaneItem = fxmlloader.load();

                ItemController itemcontroller = fxmlloader.getController();
                itemcontroller.SetData(StoreItems.get(i));

                if(column == 4)
                {
                    column = 0;
                    row ++;
                }

                GridItems.add(AnchorPaneItem, column++, row) ;
                
                GridItems.setMargin(AnchorPaneItem, new Insets(12.2));
            }   
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        } 
    }
    
    @FXML
    private void LogOut(ActionEvent event) throws IOException
    {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        store_instance = (Store) stage.getUserData();
        store_instance.LogOut();
        
        ButtonLogOut.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("viewers/SignUp.fxml"));
        Scene scene = new Scene(root); 
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void Settings(ActionEvent event) throws IOException
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Settings.fxml"));
        AnchorPaneStore.getChildren().setAll(view);
    }
    
    @FXML
    private void Catalog(ActionEvent event) throws IOException      
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Catalog.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void HomeAppliances(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/HomeAppliances.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Electronics(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Electronics.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Food(ActionEvent event) throws IOException        
    {
        
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/FoodCategory.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Accesories(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Accesories.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Toys(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/ToysCategory.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void HomeDecor(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/HomeDecor.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Others(ActionEvent event) throws IOException       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Others.fxml"));
        AnchorPaneStore.getChildren().setAll(view) ;
    }
    
    @FXML
    private void Shelf(ActionEvent event) throws IOException   
       
    {
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Shelf.fxml"));
        AnchorPaneStore.getChildren().setAll(view);
        
        if(Store.getUserOrders().isEmpty())
        {
            
            stage = new Stage();
            Parent root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNoRecords.fxml")); 
            
            stage.setScene(new Scene(root_1));
            stage.initModality(Modality.APPLICATION_MODAL) ;
            stage.initOwner(ButtonShelf.getScene().getWindow());
            stage.setResizable(false);
            stage.showAndWait();
        }
    }

    @FXML
    private void Search(ActionEvent event) throws IOException       
    {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        
        store_instance = (Store) stage.getUserData();
        store_instance.SearchItems(SearchInput.getText());
        AnchorPane view = FXMLLoader.load(getClass().getResource("viewers/Search.fxml"));
        AnchorPaneStore.getChildren().setAll(view);
        
        if(Store.getFoundItems().isEmpty())
        {
            stage = new Stage();
            Parent root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNoRecords.fxml")); 
            
            stage.setScene(new Scene(root_1));
            stage.initModality(Modality.APPLICATION_MODAL) ;
            stage.initOwner(ButtonSearch.getScene().getWindow());
            stage.setResizable(false);
            stage.showAndWait();
        }
    }
    
    @FXML
    void onEnter(ActionEvent event) throws IOException
    {
        Search(event);
    }
}
