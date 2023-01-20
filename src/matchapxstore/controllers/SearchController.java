package matchapxstore.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import matchapxstore.Item;
import matchapxstore.Store;


public class SearchController implements Initializable{
    
    @FXML
    private GridPane GridItems;

    public ArrayList<Item> FoundList; // añadir timestamp !! //

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        FoundList = Store.getFoundItems();
        int row = 1;
        int column = 0;
        try
        {
            for(int i = 0; i < FoundList.size(); i++ )
            {
                    FXMLLoader fxmlloader = new FXMLLoader();
                    fxmlloader.setLocation(getClass().getResource("viewers/Item.fxml"));
                    AnchorPane AnchorPaneItem = fxmlloader.load();

                    ItemController itemcontroller = fxmlloader.getController();
                    itemcontroller.SetData(FoundList.get(i));

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
    
}