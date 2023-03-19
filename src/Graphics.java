import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.input.KeyCode;

public class Graphics extends ScrollPane {
    Boolean isSelected = false;
    ImageView curr;
    RoomLayout rL;

    public Graphics(RoomLayout temp) {
        rL = temp;
        HBox box = new HBox();

        // coffee table
        Image cTable = new Image("coffee-table.png");
        ImageView cT = new ImageView(cTable);
        // dark-bed-single
        Image dBedSingle = new Image("dark-bed-single.png");
        ImageView dB1 = new ImageView(dBedSingle);
        // dark-bed
        Image dBed = new Image("dark-bed.png");
        ImageView dB = new ImageView(dBed);
        // desktop-table
        Image dTable = new Image("desktop-table.png");
        ImageView dT = new ImageView(dTable);
        // dining-table
        Image dinTable = new Image("dining-table.png");
        ImageView dinT = new ImageView(dinTable);
        // drawer
        Image drawer = new Image("drawer.png");
        ImageView d = new ImageView(drawer);
        // round-table
        Image rTable = new Image("round-table.png");
        ImageView rT = new ImageView(rTable);
        // single-chair
        Image sChair = new Image("single-chair.png");
        ImageView sC = new ImageView(sChair);
        // sofa
        Image sofa = new Image("sofa.png");
        ImageView s = new ImageView(sofa);
        // table-lamp
        Image tLamp = new Image("table-lamp.png");
        ImageView tL = new ImageView(tLamp);
        // tv
        Image tele = new Image("tv.png");
        ImageView tv = new ImageView(tele);
        // brown table
        Image bTable = new Image("table-brown.png");
        ImageView bT = new ImageView(bTable);
        //
        Image gPlant = new Image("green-plant.png");
        ImageView gP = new ImageView(gPlant);

        Image benchTable = new Image("bench-table.png");
        ImageView benchT = new ImageView(benchTable);

        Image bathTub = new Image("bath-tub.png");
        ImageView bathT = new ImageView(bathTub);

        MyClickHandler h = new MyClickHandler();
        cT.setOnMouseClicked(h);
        dB1.setOnMouseClicked(h);
        dB.setOnMouseClicked(h);
        dT.setOnMouseClicked(h);
        dinT.setOnMouseClicked(h);
        d.setOnMouseClicked(h);
        rT.setOnMouseClicked(h);
        sC.setOnMouseClicked(h);
        s.setOnMouseClicked(h);
        tL.setOnMouseClicked(h);
        tv.setOnMouseClicked(h);
        rL.setOnMouseClicked(h);
        bT.setOnMouseClicked(h);
        gP.setOnMouseClicked(h);
        benchT.setOnMouseClicked(h);
        bathT.setOnMouseClicked(h);

        box.setSpacing(30);
        box.setAlignment(Pos.CENTER);
        // this.setAlignment(Pos.CENTER);
        box.getChildren().addAll(cT, dB1, dB, dT, dinT, d, rT, sC, s, tL, tv, bT, gP, benchT, bathT);
        this.setContent(box);

    }

    public void setRoomLayout(RoomLayout r) {
        rL = r;
        MyClickHandler h = new MyClickHandler();
        rL.setOnMouseClicked(h);
    }

    public RoomLayout getRoomLayout() {
        return rL;
    }
    /*
     * private class MyActionHandler extends AnimationTimer {
     * public void handle(long now) {
     * rL.getChildren().remove(curr);
     * 
     * curr.setX(getCurrX());
     * curr.setY(getCurrY());
     * System.out.println("hello");
     * rL.getChildren().add(curr);
     * }
     * }
     */

    private class MyClickHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent e) {
            System.out.println(isSelected);
            if (!isSelected) {
                System.out.println("hello1");
                ImageView t = (ImageView) e.getSource();
                curr = new ImageView(t.getImage());
                // rL.getChildren().add(curr);
                isSelected = true;
                System.out.println(isSelected);

            } else {
                if (e.getY() > 100) {
                System.out.println("hello2");
                curr.setX(e.getX() - curr.getImage().getWidth() / 2);
                curr.setY(e.getY() - curr.getImage().getHeight() / 2);
                rL.getChildren().add(curr);
                rL.addFurniture(curr);
                isSelected = false;
                curr.setOnMousePressed(event -> {
                    if (event.isSecondaryButtonDown()) {
                        rL.furniture.remove(event.getSource());
                        rL.getChildren().remove(event.getSource());
                    }
                });
                System.out.println("hello3");
                curr.setOnMouseDragged(event -> {
                    double x = event.getX();
                    double y = event.getY();
                    if (curr.getRotate() == 0) {
                        curr.setX(x - curr.getImage().getWidth() / 2);
                        curr.setY(y - curr.getImage().getHeight() / 2);
                    } else if (curr.getRotate() == 90 || curr.getRotate() == 270|| curr.getRotate() == 180) {
                        double rot = curr.getRotate();
                        curr.setRotate(0);
                        curr.setX(x);
                        curr.setY(y);
                        //curr.setRotate(rot);
                    }
                    rL.setOnKeyPressed(eve -> {
                        System.out.println("hello5");
                        if (eve.getCode() == KeyCode.R) {
                            System.out.println("hello5");
                            curr.getTransforms().add(new Rotate(90, curr.getBoundsInLocal().getWidth() / 2,
                                    curr.getBoundsInLocal().getHeight() / 2));
                        }
                    });
                });
                }

            }
        }
    }
}

/*
 * public double getCurrX() {
 * MouseEvent e = MouseType.ANY;
 * return curr.getX();
 * }
 * 
 * public double getCurrY() {
 * return curr.getY();
 * }
 */
