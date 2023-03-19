import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class IntroUI extends Application {
    public static void main(String[] args) throws Exception {
        launch();
    }

    Button enterButton;
    Scene roomBuilderScene;
    BorderPane root;

    public void start(Stage stage) throws Exception {
        stage.setWidth(700);
        stage.setHeight(700);
        MyEventHandler a = new MyEventHandler();
        BorderPane introRoot = new BorderPane();
        Scene intro = new Scene(introRoot);

        Label welcomeLabel = new Label("Welcome to RoomBuilder!");
        VBox welcomeBox = new VBox();
        welcomeBox.getChildren().add(welcomeLabel);
        welcomeBox.setAlignment(Pos.CENTER);
        introRoot.setCenter(welcomeBox);

        enterButton = new Button("Enter RoomBuilder");
        enterButton.setOnAction(event -> stage.setScene(roomBuilderScene));
        introRoot.setBottom(enterButton);

        root = new BorderPane();
        roomBuilderScene = new Scene(root);

        stage.setScene(intro);
        stage.show();

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {

        }
    }
}
