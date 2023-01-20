package matchapxstore.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import matchapxstore.Item;
import matchapxstore.Store;


public class ItemController 
{
    
    @FXML
    private Text TextNameItem;
    @FXML
    private Button ButtonBuy;
    @FXML
    private Text TextPriceItem;
    @FXML
    private ImageView ItemImage;
    @FXML
    private Stage stage;
    @FXML
    private Text itemDescription;
    @FXML
    private Text TextDescription;
   
    public void SetData(Item item)
    {

        Image image = new Image(getClass().getResourceAsStream(item.getImage()));
        ItemImage.setImage(image);
        TextNameItem.setText(item.getName());
        TextPriceItem.setText("$" + item.getPrice());
        ButtonBuy.setId(item.getName());
  
        TextDescription.setText("Stock: "+ Store.getStoreItems().get(item.getId() - 1).getStock());
        itemDescription.setText(item.getDescription());
                  
        System.out.println(ButtonBuy.getId());
    }
    
    @FXML
    private void Buy(ActionEvent event) throws IOException      
    {
        Button trigger = (Button) event.getSource();
        String itemName = trigger.getId();
        int status = Store.Buy(itemName);
        stage = new Stage();
        Parent root_1 = FXMLLoader.load(getClass().getResource("viewers/AlertTransactionFailed.fxml"));;
                
        switch (status) 
        {
            case 1:
            {
                root_1 = FXMLLoader.load(getClass().getResource("viewers/AlertSuccess.fxml"));
                System.out.println(itemName + " bought!");
                break;
            }
        // out of stock //
            case -2:
            {
                root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNoStock.fxml"));
                System.out.println(itemName + " no stock :( ");
                break;
            }
        // no money //
            case -1:
            {
                root_1 =  FXMLLoader.load(getClass().getResource("viewers/AlertNoMoney.fxml"));
                System.out.println(itemName + " no money :( ");
                break;
            }
        }
        stage.setScene(new Scene(root_1));
        stage.initModality(Modality.APPLICATION_MODAL) ;
        stage.initOwner(trigger.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
    }
}
