package matchapxstore.controllers;

import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import matchapxstore.*;
import matchapxstore.Item;
import matchapxstore.Store;


public class ViewToysController implements Initializable
{
    @FXML
    private GridPane GridItems;

    public ArrayList<Item> StoreItems;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        StoreItems = Store.getStoreItems();
        int row = 1;
        int column = 1;
        try
        {
            for(int i =0; i < StoreItems.size(); i++ )
            {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("viewers/Item.fxml"));
                AnchorPane AnchorPaneItem = fxmlloader.load();

                ItemController itemcontroller = fxmlloader.getController();
                
                if(StoreItems.get(i).getDepartment().equals("toys"))
                {    
                    itemcontroller.SetData(StoreItems.get(i));
                        
                    GridItems.add(AnchorPaneItem, column++, row) ;
                
                    GridItems.setMargin(AnchorPaneItem, new Insets(12.2));  
                }
            }   
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        } 
    }
    
}
