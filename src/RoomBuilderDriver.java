import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.scene.control.ToggleButton;

public class RoomBuilderDriver extends Application {
    public static void main(String[] args) throws Exception {
        launch();
    }

    ToggleButton beigeTileButton;
    ToggleButton brownTileButton;
    ToggleButton whiteTileButton;
    Scene scene;
    Scene tutorialScene;
    BorderPane root;
    BorderPane root2;

    public void start(Stage stage) throws Exception {
        stage.setWidth(700);
        stage.setHeight(700);
        stage.setTitle("Room Builder");
        
        BorderPane introRoot = new BorderPane();
        Scene introScene = new Scene(introRoot);
        Rectangle r = new Rectangle(25, 25, 1000, 500);
        r.setFill(new LinearGradient(0, 0, introScene.getWidth(), introScene.getHeight(), true, // sizing
                CycleMethod.NO_CYCLE, // cycling
                new Stop(0, Color.web("#81c483")), // colors
                new Stop(1, Color.web("#fcc200"))));
        introRoot.setCenter(r);
        // gradient background
        /*
         * introRoot.setFill(new LinearGradient(0, 0, introScene.getWidth(),
         * introScene.getHeight(), true, // sizing
         * CycleMethod.NO_CYCLE, // cycling
         * new Stop(0, Color.web("#81c483")), // colors
         * new Stop(1, Color.web("#fcc200"))));
         */

        root2 = new BorderPane();
        root2.setPadding(new Insets(20));
        // Creating a header for the welcome scene
        Label header = new Label("Welcome to RoomBuilder");
        header.setStyle("-fx-font-size: 36pt; -fx-font-weight: bold; -fx-text-fill: #8B4513");
        introRoot.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);
        // Creating tutorial for nincompoops
        Label descriptionTut = new Label(
                "Hello! This is a quick tutorial on how to use RoomBuilder. First, \nyou can click furniture and place it anywhere on the map. \nYou can also drag the furniture around the grid by \nholding down the Left Mouse Button. Pressing R while \ndoing so will rotate the selected furniture. ");
        descriptionTut.setStyle("-fx-font-size: 20pt; -fx-text-fill: #8B4513;");
        StackPane s = new StackPane();
        s.getChildren().addAll(r, descriptionTut);
        s.setAlignment(Pos.CENTER);
        root2.setCenter(s);

        StackPane sd = new StackPane();
        Rectangle rt = new Rectangle(25, 25, 1000, 500);
        rt.setFill(new LinearGradient(0, 0, introScene.getWidth(), introScene.getHeight(), true, // sizing
                CycleMethod.NO_CYCLE, // cycling
                new Stop(0, Color.web("#81c483")), // colors
                new Stop(1, Color.web("#fcc200"))));
        sd.setAlignment(Pos.CENTER);
        //sd.setBackground(new Background(new BackgroundFill(lg, CornerRadii.EMPTY, Insets.EMPTY)));
        sd.getChildren().addAll(rt, descriptionTut);
        sd.setAlignment(Pos.CENTER);
        root2.setCenter(sd);

        
        
        Button backButton = new Button("Back");
        backButton.setStyle(
                "-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 20pt; -fx-font-weight: bold;");
        backButton.setOnAction(event -> stage.setScene(introScene));
        backButton.setPrefWidth(200);
        backButton.setPrefHeight(60);
        root2.setBottom(backButton);
        



        // Creating a brief description of the RoomBuilder application
        Label description = new Label("Roombuilder is a software for designing rooms. Users can choose \nfrom pre-built templates or create a new room from scratch.\nThe application offers many customization options, including furniture,\ndecor, and room dimensions. Users can view their room in 3D and \nmake changes in real-time before committing.");
        description.setStyle("-fx-font-size: 20pt; -fx-text-fill: #8B4513;");
        StackPane x = new StackPane();
        x.getChildren().addAll(r, description);
        description.setAlignment(Pos.CENTER);
        x.setAlignment(Pos.CENTER);
        introRoot.setCenter(x);

        BorderPane.setAlignment(description, Pos.CENTER);

        Button startButton = new Button("Start");
        startButton.setStyle(
                "-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 20pt; -fx-font-weight: bold;");
        startButton.setOnAction(event -> {
            stage.setScene(scene);
            stage.setFullScreen(true);
        });
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(60);
        introRoot.setBottom(startButton);
        BorderPane.setAlignment(startButton, Pos.CENTER);

        Button tutorialButton = new Button("Tutorial");
        tutorialButton.setStyle(
                "-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 20pt; -fx-font-weight: bold;");
        tutorialButton.setOnAction(event -> {
            stage.setScene(tutorialScene);
            stage.setFullScreen(true);
        });
        tutorialButton.setPrefWidth(200);
        tutorialButton.setPrefHeight(60);
        introRoot.setBottom(tutorialButton);
        BorderPane.setAlignment(tutorialButton, Pos.BOTTOM_RIGHT);
        introRoot.setPadding(new Insets(20));

        Button backbutton = new Button("Back");
        backbutton.setStyle(
                "-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 20pt; -fx-font-weight: bold;");
        backbutton.setOnAction(event -> {
            stage.setScene(introScene);
            stage.setFullScreen(true);
        });
        backbutton.setPrefWidth(200);
        backbutton.setPrefHeight(60);
        root2.setBottom(backbutton);


        HBox startHBox = new HBox();
        startHBox.getChildren().addAll(startButton, tutorialButton);
        startHBox.setSpacing(500);
        startHBox.setAlignment(Pos.CENTER);
        introRoot.setBottom(startHBox);

        root = new BorderPane();
        root.setPadding(new Insets(20));

        scene = new Scene(root);
        tutorialScene = new Scene(root2);

        RoomLayout rL = new RoomLayout(stage, "beige-tile.png");
        rL.maxWidth(16 * rL.getTileSize());
        rL.maxHeight(16 * rL.getTileSize());
        // rL.getChildren().addListener(c -> {

        // });
        Graphics g = new Graphics(rL);
        VBox imagesBox = new VBox();

        ImageView beigeTileView = new ImageView("beige-tile.png");
        ImageView brownTileView = new ImageView("brown-tile.png");
        ImageView whiteTileView = new ImageView("white-tile.png");
        beigeTileView.setFitWidth(60);
        brownTileView.setFitWidth(60);
        beigeTileView.setFitHeight(60);
        brownTileView.setFitHeight(60);
        whiteTileView.setFitHeight(60);
        whiteTileView.setFitWidth(60);
        beigeTileButton = new ToggleButton("Beige Tile");
        beigeTileButton.setOnAction(event -> {
            brownTileButton.setSelected(false);
            whiteTileButton.setSelected(false);
            RoomLayout original = g.getRoomLayout();
            RoomLayout rLTemp = new RoomLayout(stage, "beige-tile.png");
            rL.makeTiles("beige-tile.png");
            rLTemp.maxWidth(16 * rL.getTileSize());
            rLTemp.maxHeight(16 * rL.getTileSize());

            // Update the furniture list with the new furniture
            // rL.furniture.addAll(original.furniture);
            for (ImageView d : rL.furniture) {
                rL.getChildren().remove(d);
                rL.getChildren().add(d);
            }
        });
        brownTileButton = new ToggleButton("Brown Tile");
        VBox tilesBox = new VBox();
        brownTileButton.setOnAction(event -> {
            beigeTileButton.setSelected(false);
            whiteTileButton.setSelected(false);
            RoomLayout original = g.getRoomLayout();
            RoomLayout rLTemp = new RoomLayout(stage, "brown-tile.png");
            rL.makeTiles("brown-tile.png");
            rLTemp.maxWidth(16 * rL.getTileSize());
            rLTemp.maxHeight(16 * rL.getTileSize());
            // g.setRoomLayout(rLTemp);
            for (ImageView d : rL.furniture) {
                rL.getChildren().remove(d);
                rL.getChildren().add(d);
                // rLTemp.addFurniture(d);

            }
            System.out.println(rL.furniture.size());
            // root.setCenter(rLTemp);
        });
        whiteTileButton = new ToggleButton("White button");
        whiteTileButton.setOnAction(event -> {
            brownTileButton.setSelected(false);
            beigeTileButton.setSelected(false);
            // RoomLayout original = g.getRoomLayout();
            // RoomLayout rLTemp = new RoomLayout(stage, "white-tile.png");
            rL.makeTiles("white-tile.png");
            // rLTemp.maxWidth(16 * rL.getTileSize());
            // rLTemp.maxHeight(16 * rL.getTileSize());
            // g.setRoomLayout(rLTemp);
            for (ImageView d : rL.furniture) {
                rL.getChildren().remove(d);
                rL.getChildren().add(d);
                // rLTemp.addFurniture(d);
            }
            // root.setCenter(rLTemp);
        });

        tilesBox.getChildren().addAll(beigeTileView, beigeTileButton, brownTileView, brownTileButton, whiteTileView,
                whiteTileButton);
        tilesBox.setSpacing(10);
        tilesBox.setAlignment(Pos.CENTER_LEFT);
        imagesBox.getChildren().addAll(tilesBox);
        imagesBox.setSpacing(10);
        imagesBox.setAlignment(Pos.CENTER);
        root.setLeft(imagesBox);
        root.setTop(g);
        root.setCenter(rL);

        HBox botHbox = new HBox();
        Button save = new Button("Save");
        Button load = new Button("Load");
        Button back = new Button("Back");
        botHbox.getChildren().addAll(save, load, back);
        botHbox.setSpacing(stage.getWidth()/4);
        botHbox.setAlignment(Pos.CENTER);
        back.setOnAction(event -> {
            stage.setScene(introScene);
            stage.setFullScreen(true);
        });
        root.setBottom(botHbox);
        save.setOnAction(event -> {
            FileChooser f = new FileChooser();
            File file = f.showSaveDialog(null);
            PrintWriter p;
            try {
                p = new PrintWriter(file);
                p.write(rL.getTileColor() + "\n");
                for (int i = 0; i < rL.furniture.size(); i++) {
                    
                    p.write(rL.getFileName(i) + " " + rL.furniture.get(i).getX() + " "
                            + rL.furniture.get(i).getY() + " " + rL.furniture.get(i).getRotate() + " \n");
                }
                p.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        load.setOnAction(eve -> {
            FileChooser f = new FileChooser();
            File file = f.showOpenDialog(null);

            try {
                Scanner scan = new Scanner(file);
                rL.makeTiles(scan.next());
                
                while (scan.hasNext()) {
                    Image i = new Image(scan.next());
                    ImageView v = new ImageView(i);
                    v.setX(scan.nextDouble());
                    v.setY(scan.nextDouble());
                    v.setRotate(scan.nextDouble());
                    rL.furniture.remove(v);
                    rL.furniture.add(v);
                    rL.getChildren().remove(v);
                    rL.getChildren().add(v);
                    
                }
                for (ImageView v:rL.furniture) {
                    v.setOnMousePressed(event -> {
                        if (event.isSecondaryButtonDown()) {
                            rL.furniture.remove(event.getSource());
                            rL.getChildren().remove(event.getSource());
                        }
                    });
                    System.out.println("hello3");
                    v.setOnMouseDragged(event -> {
                        double x1 = event.getX();
                        double y = event.getY();
                        if (v.getRotate() == 0) {
                            v.setX(x1 - v.getImage().getWidth() / 2);
                            v.setY(y - v.getImage().getHeight() / 2);
                        } else if (v.getRotate() == 90 || v.getRotate() == 270|| v.getRotate() == 180) {
                        double rot = v.getRotate();
                            v.setRotate(0);
                            v.setX(x1);
                            v.setY(y);
                            //curr.setRotate(rot);
                        }
                    });
                }
                //System.out.println(rL.furniture.size());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.R) {
                System.out.println("k");
                ImageView curr = rL.furniture.get(rL.furniture.size() - 1);
                curr.setRotate(curr.getRotate() + 90);
                // curr.getTransforms().add(new Rotate(90, curr.getBoundsInLocal().getWidth() /
                // 2, curr.getBoundsInLocal().getHeight() / 2));
            }
        });
        stage.setScene(introScene);
        stage.setFullScreen(true);
        stage.show();
    }
}
