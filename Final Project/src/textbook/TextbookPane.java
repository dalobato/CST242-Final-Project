package textbook;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


/**
 * Created by dalob on 4/5/2017.
 */
public class TextbookPane {
    private VBox textbookPane;
    private GridPane authorFieldsPane;
    private TextField textbookTitleField;
    private TextField textbookISBNField;
    private TextField textbookPriceField;
    private TextField authorFirstNameField;
    private TextField authorLastNameField;

    private Label textbookTitleLbl;
    private Label textbookISBNLbl;
    private Label textbookPriceLbl;
    private Label authorFirstNameLbl;
    private Label authorLastNameLbl;

    private Button insertBtn;
    private Button searchBtn;
    private Button removeBtn;
    private Button updateBtn;

    public TextbookPane() {

        textbookPane = new VBox(20);
        textbookPane.setAlignment(Pos.CENTER);
        textbookPane.setPadding(new Insets(20));

        GridPane bookFieldsName = new GridPane();
        bookFieldsName.setAlignment(Pos.CENTER);
        bookFieldsName.setHgap(20);

        authorFieldsPane = new GridPane();
        authorFieldsPane.setAlignment(Pos.CENTER);
        authorFieldsPane.setHgap(20);


        textbookTitleLbl = new Label("Textbook Title");
        textbookISBNLbl = new Label("Textbook ISBN");
        textbookPriceLbl = new Label("Textbook Price");
        textbookTitleField = new TextField();
        textbookISBNField = new TextField();
        textbookPriceField = new TextField();

        authorFirstNameLbl = new Label("Author First Name");
        authorLastNameLbl = new Label("Author Last Name");
        authorFirstNameField = new TextField();
        authorLastNameField = new TextField();

        insertBtn = new Button("Insert");
        searchBtn = new Button("Search");
        removeBtn = new Button("Remove");
        updateBtn = new Button("Update");

        bookFieldsName.add(textbookTitleLbl, 0, 0);
        bookFieldsName.add(textbookTitleField, 0, 1);
        bookFieldsName.add(textbookISBNLbl, 1, 0);
        bookFieldsName.add(textbookISBNField, 1, 1);
        bookFieldsName.add(textbookPriceLbl, 2, 0);
        bookFieldsName.add(textbookPriceField, 2, 1);

        authorFieldsPane.add(authorFirstNameLbl, 0, 0);
        authorFieldsPane.add(authorFirstNameField, 0, 1);
        authorFieldsPane.add(authorLastNameLbl, 1, 0);
        authorFieldsPane.add(authorLastNameField, 1, 1);

        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(20);
        buttonsBox.getChildren().addAll(insertBtn, searchBtn, removeBtn, updateBtn);

        textbookPane.getChildren().addAll(bookFieldsName, authorFieldsPane, buttonsBox);
    }

    public VBox getTextbookPane() {
        return textbookPane;
    }

    public void setTextbookPane(VBox textbookPane) {
        this.textbookPane = textbookPane;
    }

    public TextField getTextbookTitleField() {
        return textbookTitleField;
    }

    public void setTextbookTitleField(TextField textbookTitleField) {
        this.textbookTitleField = textbookTitleField;
    }

    public TextField getTextbookISBNField() {
        return textbookISBNField;
    }

    public void setTextbookISBNField(TextField textbookISBNField) {
        this.textbookISBNField = textbookISBNField;
    }

    public TextField getTextbookPriceField() {
        return textbookPriceField;
    }

    public void setTextbookPriceField(TextField textbookPriceField) {
        this.textbookPriceField = textbookPriceField;
    }

    public TextField getAuthorFirstNameField() {
        return authorFirstNameField;
    }

    public void setAuthorFirstNameField(TextField authorFirstNameField) {
        this.authorFirstNameField = authorFirstNameField;
    }

    public TextField getAuthorLastNameField() {
        return authorLastNameField;
    }

    public void setAuthorLastNameField(TextField authorLastNameField) {
        this.authorLastNameField = authorLastNameField;
    }

    public Button getInsertBtn() {
        return insertBtn;
    }

    public void setInsertBtn(Button insertBtn) {
        this.insertBtn = insertBtn;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
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

    public void clearFields(){
        authorFirstNameField.clear();
        authorLastNameField.clear();
        textbookTitleField.clear();
        textbookISBNField.clear();
        textbookPriceField.clear();
    }

    public void setFields(Textbook t){

//    	authorFieldsPane.add(authorFirstNameLbl, 0, 0);
//        authorFieldsPane.add(authorFirstNameField, 0, 1);
//        authorFieldsPane.add(authorLastNameLbl, 1, 0);
//        authorFieldsPane.add(authorLastNameField, 1, 1);
//

    	int firstNameCounter = 1;
    	// Authors FN
    	for (Author a : t.getBookAuthors()){
    		//authorFirstNameField.appendText(a.getAuthorFirstName() + ", ");
    		TextField newFNAuthorField = new TextField();
    		newFNAuthorField.setText(a.getAuthorFirstName());
    		authorFieldsPane.add(newFNAuthorField, 0, firstNameCounter);
    		firstNameCounter++;
    	}

    	int lastNameCounter = 1;
    	for (Author a : t.getBookAuthors()){
    		TextField newLNAuthorField = new TextField();
    		newLNAuthorField.setText(a.getAuthorLastName());
    		authorFieldsPane.add(newLNAuthorField, 1, lastNameCounter);
    		lastNameCounter++;
    	}
    	textbookTitleField.setText(t.getBookTitle());
    	textbookISBNField.setText(t.getBookISBN());
    	textbookPriceField.setText(String.valueOf(t.getBookPrice()));
    }
}
