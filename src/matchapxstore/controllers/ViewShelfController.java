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


public class ViewShelfController implements Initializable
{
    @FXML
    private GridPane GridItems;

    public ArrayList<Item> RecordsList; // añadir timestamp !! //

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        RecordsList = Store.getUserOrders();
        
        int row = 1;
        int column = 0;
        try
        {
            for(int i =0; i < RecordsList.size(); i++ )
            {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("viewers/RecordItem.fxml"));
                AnchorPane AnchorPaneItem = fxmlloader.load();

                ShelfController shelfcontroller = fxmlloader.getController();
                shelfcontroller.SetData(RecordsList.get(i));

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
 
    
