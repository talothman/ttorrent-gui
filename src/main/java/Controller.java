import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import javax.swing.*;


/**
 * Created by Talal on 12/3/2015.
 */
public class Controller {

    @FXML protected void close(ActionEvent e){
        System.out.println("Closing GUI");
        System.exit(0);
    }
}
