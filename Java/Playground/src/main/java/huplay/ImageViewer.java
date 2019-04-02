package huplay;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ImageViewer
{
   private String filename;
   
   public ImageViewer(String filename)
   {
       this.filename = filename;
   }
   
   public Scene getScene() 
   {
       StackPane pane = new StackPane();
       Image image = new Image(filename);
       
       ImageView imageView = new ImageView(image);
      
       
       imageView.fitWidthProperty().bind(pane.widthProperty());
       imageView.fitHeightProperty().bind(pane.heightProperty());
       pane.getChildren().add(imageView);
       Scene scene = new Scene(pane);
       
       return scene;
       
   }
}
