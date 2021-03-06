package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultDesktopManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Category;
import model.Organizer;

public class mainScreenGUI {
	
	@FXML
    private Button categoryManagerButton;
	
    @FXML
    private Button AddCategoryButton;

    @FXML
    private GridPane gridOptions;
    
    @FXML
    private TextField categoryNameTxt;

    @FXML
    private Button addedButton;

    @FXML
    private Button cancelledButton;
    
    @FXML
    private Label categoryTitul;
    
    @FXML
    private AnchorPane managerPane;
    
    @FXML
    private GridPane managerGridCategories;

    @FXML
    private Button managerAddButton;

    @FXML
    private Button managerImportButton;

    @FXML
    private Button managerExportButton;

    @FXML
    private Button managerDeleteButton;
    
    @FXML
    private GridPane readingGrid;
    
    @FXML
    private TextField txtFilePath;

    @FXML
    private TextField txtFileName;

    @FXML
    private DatePicker dateSelect;

    @FXML
    private ComboBox<Category> comboCategories;
    
    private ArrayList<Button> categories;
    
    private ArrayList<CheckBox> managerCategories;
    
    private Organizer organizer;
    
    private int categoriesNum;
    
    public mainScreenGUI() {
    	organizer = new Organizer();
    	categories = new ArrayList<Button>();
    	managerCategories = new ArrayList<CheckBox>();
    	categoriesNum = 0;
    }
    
    public void initialize() throws MalformedURLException {
    	putImgMainButtons();
    }
    
    private void putImgMainButtons() throws MalformedURLException {
    	Path op = Paths.get("img/options.png");
    	Path a = Paths.get("img/agregar.png");
    	Image option = new Image(op.toUri().toString(),45, 45, false, true);
    	categoryManagerButton.setGraphic(new ImageView(option));
    	categoryManagerButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
    	
	    	if(newValue) {
	    		categoryManagerButton.setStyle("-fx-background-radius: 50; -fx-background-color: F3DFAD"); 
	    	} else {
	    		categoryManagerButton.setStyle("-fx-background-color: transparent");
	    	}
    	
    	});
    	
    	
    	Image add = new Image(a.toUri().toString(),45, 45, false, true);
    	AddCategoryButton.setGraphic(new ImageView(add));
    	AddCategoryButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
        	
	    	if(newValue) {
	    		AddCategoryButton.setStyle("-fx-background-radius: 50; -fx-background-color: F3DFAD"); 
	    	} else {
	    		AddCategoryButton.setStyle("-fx-background-color: transparent");
	    	}
    	});
    }
    
    private void putImgCategoryButtons() {
    	Path s = Paths.get("img/correct.png");
    	Path p = Paths.get("img/incorrect.png");
    	
    	Image correct = new Image(s.toUri().toString(), 45, 45, false, true);
    	Image cancelled = new Image(p.toUri().toString(), 45, 45, false, true);
    	
    	addedButton.setGraphic(new ImageView(correct));
    	addedButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
    		
    		if(newValue) {
    			addedButton.setStyle("-fx-background-radius: 50; -fx-background-color: F3DFAD");
    		} else {
    			addedButton.setStyle("-fx-background-color: transparent");
    		}
    	});
    	
    	cancelledButton.setGraphic(new ImageView(cancelled));
    	cancelledButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
    		
    		if(newValue) {
    			cancelledButton.setStyle("-fx-background-radius: 50; -fx-background-color: F3DFAD");
    		} else {
    			cancelledButton.setStyle("-fx-background-color: transparent");
    		}
    	});
    }
    
    @FXML
    public void addCategory(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/AddCategory.fxml"));
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		
		putImgCategoryButtons();
		
		stage.showAndWait();
    }
    
    @FXML
    public void addCancel(ActionEvent event) {
    	Stage stage = (Stage)cancelledButton.getScene().getWindow();
    	stage.close();
    }

    @FXML
    public void addCorrect(ActionEvent event) {
    	
    	String name = categoryNameTxt.getText();
    	
    	if (!name.equals("")) {
			if (organizer.addCategory(name)) {
				categoryNameTxt.setText("");
				categoryNameTxt.requestFocus();
				
				Button category = new Button(name);
				category.setPrefHeight(50);
				category.setPrefWidth(100);
				category.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						categoryTitul.setText(name);
					}
				});
				categories.add(category);
				
				CheckBox managerCategory = new CheckBox(name);
				managerCategory.setStyle("-fx-font-size: 20;");
				managerCategories.add(managerCategory);

				gridOptions.getRowConstraints().add(new RowConstraints(100));
				gridOptions.addRow(categoriesNum, category);
				GridPane.setHalignment(categories.get(categoriesNum), HPos.CENTER);
				categoriesNum++;
			} else {
				categoryNameTxt.setText("");
				categoryNameTxt.requestFocus();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("El nombre de la categor?a ya existe, por favor digite uno diferente.");
				alert.showAndWait();
			}
		}
    }
    
    @FXML
    public void openCategoryManager(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/CategoryManager.fxml"));
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		//stage.initStyle(StageStyle.UNDECORATED);
		loadCategories();
		stage.showAndWait();
    }
    
    public void loadCategories() {
    	
    	for (int i = 0; i < managerCategories.size(); i++) {
    		managerGridCategories.getRowConstraints().add(new RowConstraints(50));
    		managerGridCategories.addRow(i, managerCategories.get(i));
		}
    }
    
    @FXML
    public void removeCategory(ActionEvent event) {
    	
    }
    
    @FXML
    public void addReading(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/AddFilesScreen.fxml"));
		fxmlLoader.setController(this);
		
		Parent root = fxmlLoader.load();
		
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		
		putCateogories();
		
		stage.showAndWait();
    }
    
    private void putCateogories() {
    	ObservableList<Category> categories = FXCollections.observableArrayList(organizer.getCategoriesList());
		comboCategories.setItems(categories);
    }
    
    @FXML
    public void addFile(ActionEvent event) {
    	
			try {
				
				Stage stage = new Stage();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Select reading");
				File d = fileChooser.showOpenDialog(stage);
				txtFilePath.setText(d.getPath());
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Documento no encontrado.");
				alert.showAndWait();
			}
    }
    
    @FXML
    public void addCorrectReading(ActionEvent event) throws IOException {
    	
    	if (!txtFileName.getText().isEmpty() && !txtFilePath.getText().isEmpty() && comboCategories.getValue() != null) {
    		
    			Path p = Paths.get(txtFilePath.getText());
				byte[] b = Files.readAllBytes(p);
				
				LocalDate d = dateSelect.getValue();
				System.out.println(d.getDayOfMonth());
				System.out.println(d.getMonthValue());
				organizer.addReading(b, comboCategories.getValue(), txtFileName.getText(), d);
				
    	} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("Hay campos vac?os.");
			alert.showAndWait();
		}
    }
    
    @FXML
    public void closeAddFileScreen(ActionEvent event) {
    	Stage stage = (Stage)dateSelect.getScene().getWindow();
    	stage.close();
    }
}
