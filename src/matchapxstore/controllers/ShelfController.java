
package matchapxstore.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import matchapxstore.Item;


public class ShelfController 
{
    @FXML
    private Text TextNameItem;
    @FXML
    private Text TextPriceItem;
    @FXML
    private ImageView ItemImage;
    @FXML
    private Text DateText;

    
    public void SetData(Item item)
    {
        Image image = new Image(getClass().getResourceAsStream(item.getImage()));
        ItemImage.setImage(image);
        TextNameItem.setText(item.getName());
        TextPriceItem.setText("$" + item.getPrice());
        DateText.setText(item.getDateOfPurchase().toString());
    }
}
