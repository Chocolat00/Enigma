import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.geometry.Pos;


public class Main extends Application {

    Scene scene, scene2;
    Stage stage1;

    ComboBox<String> comboBox1;
    ComboBox<String> comboBox2;
    ComboBox<String> comboBox3;
    ObservableList <Node> lista;

public int code(String s){
        char c= s.charAt(0);
        int num = c;

        if(num>64 && num<91){
            num = num-65;
            
        }
        if(num>96 && num<123){
            num= num-97;
            
        }
        return num;
    }
    

    


    @Override
    public void start(Stage stage) {
        stage1 = stage;
        Scene scene = new Scene(new Group(), 1000, 600);
        scene.getStylesheets().add("./test.css");

        ObservableList<String> options = 
        FXCollections.observableArrayList();
        for(int i=0; i<26; i++){
            int num =65+i;
            String str=Character.toString((char)num);
            options.add(str);
        }
        comboBox1 = new ComboBox<String>(options);

        comboBox2 = new ComboBox<String>(options);
         
        comboBox3 = new ComboBox<String>(options);

        Label l1 =new Label(" Coś");
//lista etykiet
lista = FXCollections.observableArrayList();
        for(int i=0; i<26; i++){
            lista.add(new Label (options.get(i)));
        }


//Tworzenie menu
    Menu menu = new Menu("Menu");
    //Dodanie pozycji menu
    menu.getItems().add(new MenuItem("Wczytaj z pliku"));
    menu.getItems().add(new MenuItem("Zapisz"));
    menu.getItems().add(new MenuItem("Reset"));
    menu.getItems().add(new MenuItem("English"));
    //Dodanie do paska
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().add(menu);

    final ToggleGroup group = new ToggleGroup();
    RadioButton firstRotor1 = new RadioButton("I");
    firstRotor1.setToggleGroup(group);
    firstRotor1.setSelected(true);
    RadioButton firstRotor2 = new RadioButton("II");
    firstRotor2.setToggleGroup(group);
    RadioButton firstRotor3 = new RadioButton("III");
    firstRotor3.setToggleGroup(group);
    RadioButton firstRotor4 = new RadioButton("IV");
    firstRotor4.setToggleGroup(group);
    RadioButton firstRotor5 = new RadioButton("V");
    firstRotor5.setToggleGroup(group);
   	 
    final ToggleGroup group2 = new ToggleGroup();
    RadioButton secondRotor1 = new RadioButton("I");
    secondRotor1.setToggleGroup(group2);
    secondRotor1.setSelected(true);
    RadioButton secondRotor2 = new RadioButton("II");
    secondRotor2.setToggleGroup(group2);
    RadioButton secondRotor3 = new RadioButton("III");
    secondRotor3.setToggleGroup(group2);
    RadioButton secondRotor4 = new RadioButton("IV");
    secondRotor4.setToggleGroup(group2);
    RadioButton secondRotor5 = new RadioButton("V");
    secondRotor5.setToggleGroup(group2);
   	 
    final ToggleGroup group3 = new ToggleGroup();
    RadioButton thirdRotor1 = new RadioButton("I");
    thirdRotor1.setToggleGroup(group3);
    thirdRotor1.setSelected(true);
    RadioButton thirdRotor2 = new RadioButton("II");
    thirdRotor2.setToggleGroup(group3);
    RadioButton thirdRotor3 = new RadioButton("III");
    thirdRotor3.setToggleGroup(group3);
    RadioButton thirdRotor4 = new RadioButton("IV");
    thirdRotor4.setToggleGroup(group3);
    RadioButton thirdRotor5 = new RadioButton("V");
    thirdRotor5.setToggleGroup(group3);

    Button button = new Button("Łącznica kablowa");
button.setOnAction(e->stage.setScene(scene2));
    	StackPane layout = new StackPane();
    	Button button2 = new Button("Powrót");
    	button2.setOnAction(e->stage.setScene(scene));
    	layout.getChildren().add(button2);
    	scene2=new Scene(layout, 200, 200);

      GridPane masterGrid =new GridPane();
        GridPane grid =new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        GridPane grid1 =new GridPane();
        GridPane grid2=new GridPane();
        FlowPane flowComboBox = new FlowPane();
        GridPane gridAnimation =new GridPane();
        GridPane gridKey = new GridPane();
        GridPane gridRotors = new GridPane();
        GridPane gridFirstRotor = new GridPane();
    gridFirstRotor.setPadding(new Insets(10,10,10,10));
    GridPane gridSecondRotor = new GridPane();
    gridSecondRotor.setPadding(new Insets(10,10,10,10));
    GridPane gridThirdRotor = new GridPane();
    gridThirdRotor.setPadding(new Insets(10,10,10,10));
        FlowPane keyTop =new FlowPane();
        FlowPane keyMiddle = new FlowPane();
        FlowPane keyBottom =new FlowPane();
   
masterGrid.add(menuBar, 0, 0);
    	masterGrid.add(grid, 0, 1);
        grid.add(grid1, 0, 0);
        grid.add(grid2, 1, 0);
        grid1.add(flowComboBox, 0, 0);
        grid1.add(gridAnimation, 0, 1);
        grid1.add(gridKey, 0, 2);
        grid1.add(gridRotors, 0, 3);
        gridKey.setPrefSize(450, 180);

        TextArea input =new TextArea();
        input.setPromptText("Tu wpisz tekst");
        input.setPrefWidth(200);
        input.setPrefHeight(300);
        input.getStyleClass().add("text-input");
        grid2.add(input, 0, 0);
        grid2.add(l1, 0, 1);
        flowComboBox.setHgap(50);
        flowComboBox.setAlignment(Pos.CENTER);

        flowComboBox.getChildren().add(comboBox1);
        flowComboBox.getChildren().add(comboBox2);
        flowComboBox.getChildren().add(comboBox3);

        gridKey.add(keyTop, 0, 0);
        gridKey.add(keyMiddle, 0, 1);
        gridKey.add(keyBottom, 0, 2);
        keyTop.setHgap(30);
        keyTop.setAlignment(Pos.CENTER);
        keyTop.setPrefHeight(60);
        keyMiddle.setHgap(30);
        keyMiddle.setAlignment(Pos.CENTER);
        keyMiddle.setPrefHeight(60);
        keyBottom.setHgap(30);
        keyBottom.setAlignment(Pos.CENTER);
        keyBottom.setPrefHeight(60);

        keyTop.getChildren().add(lista.get(16));
        keyTop.getChildren().add(lista.get(22));
        keyTop.getChildren().add(lista.get(4));
        keyTop.getChildren().add(lista.get(17));
        keyTop.getChildren().add(lista.get(19));
        keyTop.getChildren().add(lista.get(24));
        keyTop.getChildren().add(lista.get(20));
        keyTop.getChildren().add(lista.get(8));
        keyTop.getChildren().add(lista.get(14));
        keyTop.getChildren().add(lista.get(15));

        keyMiddle.getChildren().add(lista.get(0));
        keyMiddle.getChildren().add(lista.get(18));
        keyMiddle.getChildren().add(lista.get(3));
        keyMiddle.getChildren().add(lista.get(5));
        keyMiddle.getChildren().add(lista.get(6));
        keyMiddle.getChildren().add(lista.get(7));
        keyMiddle.getChildren().add(lista.get(9));
        keyMiddle.getChildren().add(lista.get(10));
        keyMiddle.getChildren().add(lista.get(11));

        keyBottom.getChildren().add(lista.get(25));
        keyBottom.getChildren().add(lista.get(23));
        keyBottom.getChildren().add(lista.get(2));
        keyBottom.getChildren().add(lista.get(21));
        keyBottom.getChildren().add(lista.get(1));
        keyBottom.getChildren().add(lista.get(13));
        keyBottom.getChildren().add(lista.get(12));


        gridFirstRotor.add(firstRotor1, 0, 0);
    	gridFirstRotor.add(firstRotor2, 1, 0);
    	gridFirstRotor.add(firstRotor3, 2, 0);
    	gridFirstRotor.add(firstRotor4, 3, 0);
    	gridFirstRotor.add(firstRotor5, 4, 0);
   	 
    	gridSecondRotor.add(secondRotor1, 0, 0);
    	gridSecondRotor.add(secondRotor2, 1, 0);
    	gridSecondRotor.add(secondRotor3, 2, 0);
    	gridSecondRotor.add(secondRotor4, 3, 0);
    	gridSecondRotor.add(secondRotor5, 4, 0);
   	 
    	gridThirdRotor.add(thirdRotor1, 0, 0);
    	gridThirdRotor.add(thirdRotor2, 1, 0);
    	gridThirdRotor.add(thirdRotor3, 2, 0);
    	gridThirdRotor.add(thirdRotor4, 3, 0);
    	gridThirdRotor.add(thirdRotor5, 4, 0);
   	 
    	gridRotors.add(new Label("Wirnik 1"), 0, 0);
    	gridRotors.add(gridFirstRotor, 0, 1);
    	gridRotors.add(new Label("Wirnik 2"), 1, 0);
    	gridRotors.add(gridSecondRotor, 1, 1);
    	gridRotors.add(new Label("Wirnik 3"), 2, 0);
    	gridRotors.add(gridThirdRotor, 2, 1);
	gridRotors.add(button, 0, 2);

        gridAnimation.add(new Label("Tu będą animacje"), 0, 0);

stage.setOnCloseRequest(e->{
   		 e.consume();
   		 closeProgram();
    	});
       
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.setTitle("Enigma");
        stage.show();
    }
   private void closeProgram() {
   	 Alert alert = new Alert(AlertType.CONFIRMATION, "Czy na pewno chcesz zamknąć okno?", ButtonType.YES, ButtonType.NO);
   	 alert.showAndWait();

   	 if (alert.getResult() == ButtonType.YES) {
   	 	stage1.close();
   	 }
    }


    public static void main(String[] args) {
        launch();
    }

}

