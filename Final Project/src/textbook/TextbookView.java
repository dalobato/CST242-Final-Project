package textbook;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TextbookView extends Application {

	Bookbag bookbag;
	int updateFLAG;
	String bookISBNtoUpdate;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextbookPane root = new TextbookPane();


		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saveBooks.dat"))) {
			bookbag = (Bookbag) ois.readObject();
			ois.close();
		} catch (Exception e) {
			bookbag = new Bookbag(100);
		}

		Scene scene = new Scene(root.getTextbookPane(), 500, 200);
		primaryStage.setTitle("Textbooks");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

		root.getInsertBtn().setOnAction(e -> {

			// Get first author first to add to list at first index
			ArrayList<Author> authorList = new ArrayList<>();
			Author firstAuthor = new Author(root.getAuthorFirstNameField().getText(),
					root.getAuthorLastNameField().getText());
			authorList.add(firstAuthor);

			Stage multipleAuthorsStage = new Stage();
			VBox selectionBox = new VBox();
			selectionBox.setAlignment(Pos.CENTER);
			selectionBox.setSpacing(20);
			selectionBox.setPadding(new Insets(20));
			HBox buttonsBox = new HBox();
			buttonsBox.setAlignment(Pos.CENTER);
			buttonsBox.setSpacing(20);

			Label messageLbl = new Label("Are there more authors to this book?");
			Button yesBtn = new Button("YES");
			Button noBtn = new Button("NO");
			buttonsBox.getChildren().addAll(yesBtn, noBtn);
			selectionBox.getChildren().addAll(messageLbl, buttonsBox);

			Scene selectionScene = new Scene(selectionBox);
			multipleAuthorsStage.setScene(selectionScene);
			multipleAuthorsStage.show();

			yesBtn.setOnAction(e1 -> {
				Stage addStage = new Stage();
				GridPane addPane = new GridPane();
				addPane.setAlignment(Pos.CENTER);
				addPane.setHgap(10);
				addPane.setVgap(10);
				addPane.setPadding(new Insets(20));
				Label firstName = new Label("Author First Name:");
				Label lastName = new Label("Author Last Name");
				TextField firstNameFld = new TextField();
				TextField lastNameFld = new TextField();

				Button finishBtn = new Button("Add author");

				addPane.add(firstName, 0, 0);
				addPane.add(firstNameFld, 0, 1);
				addPane.add(lastName, 1, 0);
				addPane.add(lastNameFld, 1, 1);
				addPane.add(finishBtn, 1, 3);

				Scene addScene = new Scene(addPane);
				addStage.setScene(addScene);
				addStage.show();

				finishBtn.setOnAction(e2 -> {
					try {
						Author tempA = new Author(firstNameFld.getText(), lastNameFld.getText());
						authorList.add(tempA);
						addStage.close();
					} catch (Exception error) {
						Stage errorStage = new Stage();
						VBox errorBox = new VBox();
						errorBox.setAlignment(Pos.CENTER);
						errorBox.setPadding(new Insets(20));
						Label errorLbl = new Label("Error. Please fill in all fields correctly.");
						Button errorBtn = new Button("OK");
						errorBox.getChildren().addAll(errorLbl, errorBtn);
						Scene errorScene = new Scene(errorBox);
						errorStage.setScene(errorScene);
						errorStage.show();

						errorBtn.setOnAction(e3 -> {
							errorStage.close();
							multipleAuthorsStage.close();
						});
					}
				});
			});

			noBtn.setOnAction(e1 -> {
				try {
					Textbook newBook = new Textbook(root.getTextbookISBNField().getText(),
							root.getTextbookTitleField().getText(), authorList,
							Double.parseDouble(root.getTextbookPriceField().getText()));
					bookbag.add(newBook);

					Stage confirmStage = new Stage();
					VBox confirmBox = new VBox();
					confirmBox.setSpacing(20);
					confirmBox.setPadding(new Insets(20));
					confirmBox.setAlignment(Pos.CENTER);

					Label confirmLbl = new Label("Book added:");
					TextArea output = new TextArea();
					output.appendText(newBook.toString());
					output.setEditable(false);
					Button confirmBtn = new Button("OK");

					confirmBox.getChildren().addAll(confirmLbl, output, confirmBtn);
					Scene confirmScene = new Scene(confirmBox);
					confirmStage.setScene(confirmScene);
					confirmStage.show();

					confirmBtn.setOnAction(e2 -> {
						root.clearFields();
						confirmStage.close();
						multipleAuthorsStage.close();
					});
				} catch (Exception error) {
					Stage errorStage = new Stage();
					VBox errorBox = new VBox();
					errorBox.setAlignment(Pos.CENTER);
					errorBox.setPadding(new Insets(20));
					Label errorLbl = new Label("Error. Please fill in all fields correctly.");
					Button errorBtn = new Button("OK");
					errorBox.getChildren().addAll(errorLbl, errorBtn);
					Scene errorScene = new Scene(errorBox);
					errorStage.setScene(errorScene);
					errorStage.show();

					errorBtn.setOnAction(e2 -> {
						errorStage.close();
						multipleAuthorsStage.close();
					});
				}
			});

		});

		root.getSearchBtn().setOnAction(e -> {

			Stage searchStage = new Stage();
			VBox searchBox = new VBox();
			searchBox.setAlignment(Pos.CENTER);
			searchBox.setPadding(new Insets(20));
			searchBox.setSpacing(20);
			Label searchLbl = new Label("Enter book ISBN to search for");
			TextField searchField = new TextField();
			Button searchBtn = new Button("Search");

			searchBox.getChildren().addAll(searchLbl, searchField, searchBtn);
			Scene searchScene = new Scene(searchBox);
			searchStage.setScene(searchScene);
			searchStage.show();

			searchBtn.setOnAction(e1 -> {
				try {
					Stage foundStage = new Stage();
					foundStage.setTitle("Found");
					VBox foundVBox = new VBox(20);
					foundVBox.setPadding(new Insets(20, 20, 20, 20));
					foundVBox.setAlignment(Pos.CENTER);
					Label message = new Label("Found:");
					TextArea output = new TextArea();
					output.setEditable(false);
					output.setText(bookbag.searchByISBN(searchField.getText()).toString());
					Button closeBtn = new Button("OK");
					foundVBox.getChildren().addAll(message, output, closeBtn);
					Scene fScene = new Scene(foundVBox);
					foundStage.setScene(fScene);
					foundStage.show();
					closeBtn.setOnAction(e2 -> {
						foundStage.close();
					});
				} catch (Exception error) {
					Stage errorStage = new Stage();
					VBox errorBox = new VBox();
					errorBox.setAlignment(Pos.CENTER);
					errorBox.setPadding(new Insets(20));
					Label errorLbl = new Label("ISBN Not found.");
					Button errorBtn = new Button("OK");
					errorBox.getChildren().addAll(errorLbl, errorBtn);
					Scene errorScene = new Scene(errorBox, 200, 200);
					errorStage.setScene(errorScene);
					errorStage.show();

					errorBtn.setOnAction(e2 -> {
						errorStage.close();
					});
				}
			});

		});

		root.getRemoveBtn().setOnAction(e -> {
			Stage removeStage = new Stage();
			VBox removeBox = new VBox();
			removeBox.setAlignment(Pos.CENTER);
			removeBox.setPadding(new Insets(20));
			removeBox.setSpacing(20);
			Label removeLbl = new Label("Enter book ISBN to search for");
			TextField removeField = new TextField();
			Button removeBtn = new Button("Search");

			removeBox.getChildren().addAll(removeLbl, removeField, removeBtn);
			Scene removeScene = new Scene(removeBox);
			removeStage.setScene(removeScene);
			removeStage.show();

			removeBtn.setOnAction(e1 -> {
				try {
					Stage foundStage = new Stage();
					VBox foundVBox = new VBox(20);
					foundVBox.setPadding(new Insets(20, 20, 20, 20));
					foundVBox.setAlignment(Pos.CENTER);
					Label message = new Label("Removed:");
					TextArea output = new TextArea();
					output.setEditable(false);
					output.setText(bookbag.searchByISBN(removeField.getText()).toString());
					bookbag.removeByBookISBN(removeField.getText());
					Button closeBtn = new Button("OK");
					foundVBox.getChildren().addAll(message, output, closeBtn);
					Scene fScene = new Scene(foundVBox);
					foundStage.setScene(fScene);
					foundStage.show();
					closeBtn.setOnAction(e2 -> {
						foundStage.close();
					});
				} catch (Exception error) {
					Stage errorStage = new Stage();
					VBox errorBox = new VBox();
					errorBox.setAlignment(Pos.CENTER);
					errorBox.setPadding(new Insets(20));
					Label errorLbl = new Label("ISBN Not found.");
					Button errorBtn = new Button("OK");
					errorBox.getChildren().addAll(errorLbl, errorBtn);
					Scene errorScene = new Scene(errorBox, 200, 200);
					errorStage.setScene(errorScene);
					errorStage.show();

					errorBtn.setOnAction(e2 -> {
						errorStage.close();
					});
				}
			});

		});

		root.getUpdateBtn().setOnAction(e -> {

			if (updateFLAG == 0) {
				Stage updateStage = new Stage();
				VBox updateBox = new VBox();
				updateBox.setAlignment(Pos.CENTER);
				updateBox.setPadding(new Insets(20));
				updateBox.setSpacing(10);

				Label updateMessage = new Label("Enter ISBN of Textbook you want to update");
				TextField updateField = new TextField();
				Button updateBtn = new Button("Search");

				updateBox.getChildren().addAll(updateMessage, updateField, updateBtn);
				Scene updateScene = new Scene(updateBox);
				updateStage.setScene(updateScene);
				updateStage.show();

				updateBtn.setOnAction(e1 -> {
					try {
						bookISBNtoUpdate = updateField.getText();
						root.setFields(bookbag.searchByISBN(bookISBNtoUpdate));
						updateStage.close();


					} catch (Exception error) {
						Stage errorStage = new Stage();
						VBox errorBox = new VBox();
						errorBox.setAlignment(Pos.CENTER);
						errorBox.setPadding(new Insets(20));
						Label errorLbl = new Label("ISBN Not found.");
						Button errorBtn = new Button("OK");
						errorBox.getChildren().addAll(errorLbl, errorBtn);
						Scene errorScene = new Scene(errorBox, 200, 200);
						errorStage.setScene(errorScene);
						errorStage.show();

						errorBtn.setOnAction(e2 -> {
							errorStage.close();
						});
					}
				});
			} else if (updateFLAG == 1){
				try{


				}catch(Exception error){
					Stage errorStage = new Stage();
					VBox errorBox = new VBox();
					errorBox.setAlignment(Pos.CENTER);
					errorBox.setPadding(new Insets(20));
					Label errorLbl = new Label("Error. Please fill out all fields correctly.");
					Button errorBtn = new Button("OK");
					errorBox.getChildren().addAll(errorLbl, errorBtn);
					Scene errorScene = new Scene(errorBox, 200, 200);
					errorStage.setScene(errorScene);
					errorStage.show();

					errorBtn.setOnAction(e2 -> {
						errorStage.close();
					});
				}
			}

		});



		primaryStage.setOnCloseRequest(e -> {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saveBooks.dat"))) {
				oos.writeObject(bookbag);
				oos.close();
			} catch (Exception error) {
				error.printStackTrace();
			}
		});
	}
}
