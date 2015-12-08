import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by Talal on 12/3/2015.
 */
public class Controller {
    private FileChooser fileChooser = new FileChooser();
    @FXML GridPane gridPane;

    @FXML protected void close(ActionEvent e){
        System.out.println("Closing GUI");
        System.exit(0);
    }

    @FXML protected void openTorrent(ActionEvent e){
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("torrent Files", "*.torrent"),
                new FileChooser.ExtensionFilter("All Files", "*")
        );
        fileChooser.setTitle("Open .torrent File");
        File torrentFile = fileChooser.showOpenDialog(gridPane.getScene().getWindow());
        ThreadManager tm = new ThreadManager(torrentFile);
        new Thread(tm).start();

    }

    private class ThreadManager implements Runnable {
        File torrentFile;

        ThreadManager(File torrentFile){
            this.torrentFile = torrentFile;
        }

        public void run() {
            try {
                Client client = new Client(InetAddress.getLocalHost(), SharedTorrent.fromFile(torrentFile, new File("C:\\Users\\Talal\\Desktop")));
                client.download();
                client.setMaxDownloadRate(50.0);
                client.setMaxUploadRate(50.0);
                client.waitForCompletion();
                System.out.print("Waiting for completion");
            } catch (UnknownHostException uhE) {
                System.err.println("Cannot find host.");
                //uhE.printStackTrace();
            } catch (IOException ioE) {
                System.err.println("Cannot find file.");
            }
        }
    }
}
