package person;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BottomButtonsPane {

    private HBox controlButtonsPane;
    private VBox buttonsPane;
    private Button insertBtn;
    private Button removeBtn;
    private Button updateBtn;
    private Button searchBtn;
    private Button saveBtn;


    public BottomButtonsPane() {

        insertBtn = new Button("Insert");
        insertBtn.setPrefWidth(100);
        removeBtn = new Button("Remove");
        removeBtn.setPrefWidth(100);
        updateBtn = new Button("Update");
        updateBtn.setPrefWidth(100);
        searchBtn = new Button("Search");
        searchBtn.setPrefWidth(100);
        saveBtn = new Button("SAVE");


        controlButtonsPane = new HBox(20);
        controlButtonsPane.setAlignment(Pos.CENTER);
        controlButtonsPane.setPadding(new Insets(20));

        buttonsPane = new VBox(10);
        buttonsPane.setAlignment(Pos.CENTER);

        controlButtonsPane.getChildren().addAll(insertBtn, removeBtn, updateBtn, searchBtn);
        buttonsPane.getChildren().addAll(controlButtonsPane, saveBtn);
    }

    public VBox returnButtonsPane() {
        return buttonsPane;
    }

    public void setButtonsPane(VBox buttonsPane) {
        this.buttonsPane = buttonsPane;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(Button saveBtn) {
        this.saveBtn = saveBtn;
    }

    public Button getInsertBtn() {
        return insertBtn;
    }

    public void setInsertBtn(Button insertBtn) {
        this.insertBtn = insertBtn;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(Button removeBtn) {
        this.removeBtn = removeBtn;
    }

    public Button getUpdateBtn() {
        return updateBtn;
    }

    public void setUpdateBtn(Button updateBtn) {
        this.updateBtn = updateBtn;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
    }
}