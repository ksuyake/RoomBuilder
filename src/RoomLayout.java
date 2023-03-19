import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RoomLayout extends Group {
    int tileSize = 30;
    ArrayList<ImageView> furniture = new ArrayList<ImageView>();
    Stage stage;
    String color;

    public RoomLayout(Stage s, String tilePng) {
        color = tilePng;
        stage = s;
        Image t = new Image(tilePng);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                ImageView v = new ImageView(t);
                v.setFitWidth(tileSize);
                v.setFitHeight(tileSize);
                v.setX(350 - 8 * tileSize + i * tileSize);
                v.setY(350 - 8 * tileSize + j * tileSize);
                this.getChildren().add(v);
            }
        }

    }
    public String getFileName(int i) {
        Image t = this.furniture.get(i).getImage();
        Image darkBed = new Image("dark-bed.png");
        Image coffeeTable = new Image("coffee-table.png");
        Image singleDarkBed = new Image("dark-bed-single.png");
        Image desktopTable = new Image("desktop-table.png");
        Image diningTable = new Image("dining-table.png");
        Image drawer = new Image("drawer.png");
        Image greenPlant = new Image("green-plant.png");
        Image roundTable = new Image("round-table.png");
        Image singeChair = new Image("single-chair.png");
        Image sofa = new Image("sofa.png");
        Image tableBrown = new Image("table-brown.png");
        Image tableLamp = new Image("table-lamp.png");
        Image tv = new Image("tv.png");
        Image benchTable = new Image("bench-table.png");
        Image bathTub = new Image("bath-tub.png");
        System.out.println("Hellow World: THe answer is rigtt here: " + t.getWidth());
        if (t.getWidth() == darkBed.getWidth() && t.getHeight() == darkBed.getHeight()) {
            return "dark-bed.png";
        } else if (t.getWidth() == coffeeTable.getWidth() && t.getHeight() == coffeeTable.getHeight()) {
            return "coffee-table.png";
        } else if (t.getWidth() == singleDarkBed.getWidth() && t.getHeight() == singleDarkBed.getHeight()) {
            return "dark-bed-single.png";
        } else if (t.getWidth() == desktopTable.getWidth() && t.getHeight() == desktopTable.getHeight()) {
            return "desktop-table.png";
        } else if (t.getWidth() == diningTable.getWidth() && t.getHeight() == diningTable.getHeight()) {
            return "dining-table.png";
        } else if (t.getWidth() == drawer.getWidth() && t.getHeight() == drawer.getHeight()) {
            return "drawer.png";
        } else if (t.getWidth() == greenPlant.getWidth() && t.getHeight() == greenPlant.getHeight()) {
            return "green-plant.png";
        } else if (t.getWidth() == roundTable.getWidth() && t.getHeight() == roundTable.getHeight()) {
            return "round-table.png";
        } else if (t.getWidth() == singeChair.getWidth() && t.getHeight() == singeChair.getHeight()) {
            return "single-chair.png";
        } else if (t.getWidth() == sofa.getWidth() && t.getHeight() == sofa.getHeight()) {
            return "sofa.png";
        }  else if (t.getWidth() == tableBrown.getWidth() && t.getHeight() == tableBrown.getHeight()) {
            return "table-brown.png";
        }  else if (t.getWidth() == tableLamp.getWidth() && t.getHeight() == tableLamp.getHeight()) {
            return "table-lamp.png";
        }  else if (t.getWidth() == tv.getWidth() && t.getHeight() == tv.getHeight()) {
            return "tv.png";
        }  else if (t.getWidth() == benchTable.getWidth() && t.getHeight() == benchTable.getHeight()) {
            return "bench-table.png";
        } else if (t.getWidth() == bathTub.getWidth() && t.getHeight() == bathTub.getHeight()) {
            return "bath-tub.png";
        }
        return "failure";
    }
    public String getTileColor() {
        return color;
    }

    public void makeTiles(String tilePng) {
        color = tilePng;
        Image t = new Image(tilePng);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                ImageView v = new ImageView(t);
                v.setFitWidth(tileSize);
                v.setFitHeight(tileSize);
                v.setX(350 - 8 * tileSize + i * tileSize);
                v.setY(350 - 8 * tileSize + j * tileSize);
                this.getChildren().add(v);
            }
        }
    }

    public double roomLayoutTop() {
        return -1;
    }

    public double getBottomY() {
        // return stage.getHeight() / 2 - 8 * tileSize +
        return -2;
    }

    public ArrayList<ImageView> getFurniture() {
        return furniture;
    }

    public void addFurniture(ImageView v) {
        furniture.add(v);
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getLeftX() {
        return -1;
    }
}
