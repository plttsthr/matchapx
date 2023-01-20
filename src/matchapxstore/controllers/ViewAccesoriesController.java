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
import matchapxstore.Item;
import matchapxstore.Store;


public class ViewAccesoriesController implements Initializable
{
    @FXML
    private GridPane GridItems;

    private ArrayList<Item> ItemsList;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ItemsList = Store.getStoreItems();
        int row = 1;
        int column = 0;
        try
        {
            for(int i =0; i < ItemsList.size(); i++ )
            {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("viewers/Item.fxml"));
                AnchorPane AnchorPaneItem = fxmlloader.load();

                ItemController itemcontroller = fxmlloader.getController();
                if(ItemsList.get(i).getDepartment().equals("accesories"))
                {
                    itemcontroller.SetData(ItemsList.get(i));

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
