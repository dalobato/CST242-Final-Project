package person;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BottomButtonsPane {

    HBox buttonsPane = new HBox(20);
    Button insertBtn;
    Button removeBtn;
    Button updateBtn;
    Button searchBtn;


    public BottomButtonsPane() {

        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setPadding(new Insets(20, 20, 20, 20));

        insertBtn = new Button("Insert");
        insertBtn.setPrefWidth(100);
        removeBtn = new Button("Remove");
        removeBtn.setPrefWidth(100);
        updateBtn = new Button("Update");
        updateBtn.setPrefWidth(100);
        searchBtn = new Button("Search");
        searchBtn.setPrefWidth(100);


        buttonsPane.getChildren().addAll(insertBtn, removeBtn, updateBtn, searchBtn);
    }

    public HBox returnBtnPane() {
        return buttonsPane;
    }

}