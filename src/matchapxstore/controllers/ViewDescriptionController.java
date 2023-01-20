
package matchapxstore.controllers;

import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import matchapxstore.*;
import matchapxstore.Item;
import matchapxstore.Store;


public class ViewDescriptionController implements Initializable
{
    @FXML
    private Text itemDescription;
    @FXML
    private Text TextDescription;
    public ArrayList<Item> StoreItems;

@Override
    public void initialize(URL location, ResourceBundle resources)
    {
        StoreItems = Store.getStoreItems();
    }
    
    public void SetData(Item item)
    {
        itemDescription.setText(item.getName() + "Description: ");
        TextDescription.setText(item.getDescription());
    }
   
}
