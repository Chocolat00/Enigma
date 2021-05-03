package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    RadioButton firstRotor1;
    RadioButton firstRotor2;
    RadioButton firstRotor3;
    RadioButton firstRotor4;
    RadioButton firstRotor5;
    
    RadioButton secondRotor1;
    RadioButton secondRotor2;
    RadioButton secondRotor3;
    RadioButton secondRotor4;
    RadioButton secondRotor5;
    
    RadioButton thirdRotor1;
    RadioButton thirdRotor2;
    RadioButton thirdRotor3;
    RadioButton thirdRotor4;
    RadioButton thirdRotor5;
    
    RadioButton reflector1;
    RadioButton reflector2;
    
    int first=0, second=0, third=0;
    int pos1=0, pos2=0, pos3=0;
    int ref=0;
    
    Rotor rotor1;
    Rotor rotor2;
    Rotor rotor3;
    
    Reflector reflector;
    
    Label l1;
    TextArea input;

    @Override
    public void start(Stage stage) {
        stage1 = stage;
        scene = new Scene(new Group(), 920, 600);
        //scene.getStylesheets().add("./test.css");

        ObservableList<String> options = 
        FXCollections.observableArrayList();
        for(int i=0; i<26; i++){
            int num =65+i;
            String str=Character.toString((char)num);
            options.add(str);
        }
        comboBox1 = new ComboBox<String>(options);
        comboBox1.getSelectionModel().selectFirst();
        comboBox1.setOnAction(e->{
        	pos1 = comboBox1.getSelectionModel().getSelectedIndex();
        });
        comboBox2 = new ComboBox<String>(options);
        comboBox2.getSelectionModel().selectFirst();
        comboBox2.setOnAction(e->{
        	pos2 = comboBox2.getSelectionModel().getSelectedIndex();
        });
        comboBox3 = new ComboBox<String>(options);
        comboBox3.getSelectionModel().selectFirst();
        comboBox3.setOnAction(e->{
        	pos3 = comboBox3.getSelectionModel().getSelectedIndex();
        });

        l1 =new Label("Wybierz i zatwierdź ustawienia Enigmy aby rozpocząć.");
        l1.setPrefWidth(400);
        //lista etykiet
        lista = FXCollections.observableArrayList();
        for(int i=0; i<26; i++){
            lista.add(new Label (options.get(i)));
        }

        //Tworzenie menu
        Menu menu = new Menu("Menu");
        //Dodanie pozycji menu
        MenuItem menuItem1 = new MenuItem("Wczytaj z pliku");
        MenuItem menuItem2 = new MenuItem("Zapisz");
        MenuItem menuItem3 = new MenuItem("Reset");
        menuItem3.setOnAction(e->{
        	firstRotor1.setSelected(true);
        	secondRotor1.setSelected(true);
        	thirdRotor1.setSelected(true);
        	reflector1.setSelected(true);
        	comboBox1.getSelectionModel().selectFirst();
        	comboBox2.getSelectionModel().selectFirst();
        	comboBox3.getSelectionModel().selectFirst();
        	input.setText("");
        	input.setPromptText("Tu wpisz tekst");
        	l1.setText("Wybierz i zatwierdź ustawienia Enigmy aby rozpocząć.");
        });
        MenuItem menuItem4 = new MenuItem("English");
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menuItem4);
        //Dodanie do paska
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        final ToggleGroup group = new ToggleGroup();
        firstRotor1 = new RadioButton("I");
        firstRotor1.setOnAction(e->first=0);
        firstRotor1.setToggleGroup(group);
        firstRotor1.setSelected(true);
        firstRotor2 = new RadioButton("II");
        firstRotor2.setOnAction(e->first=1);
        firstRotor2.setToggleGroup(group);
        firstRotor3 = new RadioButton("III");
        firstRotor3.setOnAction(e->first=2);
        firstRotor3.setToggleGroup(group);
        firstRotor4 = new RadioButton("IV");
        firstRotor4.setOnAction(e->first=3);
        firstRotor4.setToggleGroup(group);
        firstRotor5 = new RadioButton("V");
        firstRotor5.setOnAction(e->first=4);
        firstRotor5.setToggleGroup(group);
   	 
        final ToggleGroup group2 = new ToggleGroup();
        secondRotor1 = new RadioButton("I");
        secondRotor1.setOnAction(e->second=0);
        secondRotor1.setToggleGroup(group2);
        secondRotor1.setSelected(true);
        secondRotor2 = new RadioButton("II");
        secondRotor2.setOnAction(e->second=1);
        secondRotor2.setToggleGroup(group2);
        secondRotor3 = new RadioButton("III");
        secondRotor3.setOnAction(e->second=2);
        secondRotor3.setToggleGroup(group2);
        secondRotor4 = new RadioButton("IV");
        secondRotor4.setOnAction(e->second=3);
        secondRotor4.setToggleGroup(group2);
        secondRotor5 = new RadioButton("V");
        secondRotor5.setOnAction(e->second=4);
        secondRotor5.setToggleGroup(group2);
   	 
        final ToggleGroup group3 = new ToggleGroup();
        thirdRotor1 = new RadioButton("I");
        thirdRotor1.setOnAction(e->third=0);
        thirdRotor1.setToggleGroup(group3);
        thirdRotor1.setSelected(true);
        thirdRotor2 = new RadioButton("II");
        thirdRotor2.setOnAction(e->third=1);
        thirdRotor2.setToggleGroup(group3);
        thirdRotor3 = new RadioButton("III");
        thirdRotor3.setOnAction(e->third=2);
        thirdRotor3.setToggleGroup(group3);
        thirdRotor4 = new RadioButton("IV");
        thirdRotor4.setOnAction(e->third=3);
        thirdRotor4.setToggleGroup(group3);
        thirdRotor5 = new RadioButton("V");
        thirdRotor5.setOnAction(e->third=4);
        thirdRotor5.setToggleGroup(group3);
        
        final ToggleGroup group4 = new ToggleGroup();
        reflector1 = new RadioButton("B");
        reflector1.setOnAction(e->ref=0);
        reflector1.setToggleGroup(group4);
        reflector1.setSelected(true);
        reflector2 = new RadioButton("C");
        reflector2.setOnAction(e->ref=1);
        reflector2.setToggleGroup(group4);

    	Button button = new Button("Łącznica kablowa");
    	button.setOnAction(e->stage.setScene(scene2));
    	CablePane layout = new CablePane(100, 100);

        layout.back.setOnAction(e->stage.setScene(scene));
        scene2=new Scene(layout, 200, 200);
    	
    	Button button2 = new Button("Zatwierdź wirniki");
    	button2.setOnAction(e->validateRotors());

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
    	GridPane gridReflector = new GridPane();
    	gridReflector.setPadding(new Insets(10,10,10,10));
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

        input =new TextArea();
        input.setPromptText("Tu wpisz tekst");
        input.setOnKeyTyped(e->{
        	int letter = letterToNumber(e.getCharacter());
        	runEnigma(letter);
        });
        input.setPrefWidth(400);
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
    	
    	gridReflector.add(reflector1, 0, 0);
    	gridReflector.add(reflector2, 1, 0);
   	 
    	gridRotors.add(new Label("Wirnik 1"), 0, 0);
        gridRotors.add(gridFirstRotor, 0, 1);
        gridRotors.add(new Label("Wirnik 2"), 0, 2);
        gridRotors.add(gridSecondRotor, 0, 3);
        gridRotors.add(new Label("Wirnik 3"), 0, 4);
        gridRotors.add(gridThirdRotor, 0, 5);
        gridRotors.add(new Label("Reflektor"), 1, 0);
        gridRotors.add(gridReflector, 1, 1);
        gridRotors.add(button, 1, 2);
        gridRotors.add(button2, 2, 2);

        gridAnimation.add(new Label("Tu będą animacje"), 0, 0);

        stage.setOnCloseRequest(e->{
   		 e.consume();
   		 closeProgram();
    	});
       
        Group root = (Group)scene.getRoot();
        root.getChildren().add(masterGrid);
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

   void chooseRotors() {
	   if (first!=second && second!=third && third!=first) {
		   rotor1 = new Rotor(first);
		   rotor2 = new Rotor(second);
		   rotor3 = new Rotor(third);
		   reflector = new Reflector(ref);
		   l1.setText("Ustawienie wirników przebielgo prawidłowo.\n");
	   }
	   else {
		   l1.setText("Conajmniej dwa wybrane wirniki są takie same. Nie można rozpocząć.");
	   }
   }
   void setRotorPositions () {
	   if (rotor1!=null && rotor2!=null && rotor3!=null) {
		   rotor1.setRotorPosition(pos1);
		   rotor2.setRotorPosition(pos2);
		   rotor3.setRotorPosition(pos3);
		   l1.setText(l1.getText()+"\nPozycja startowa wirników: "+pos1+" "+pos2+" "+pos3);
	   }
	   else {
		   l1.setText(l1.getText()+"\nNie ustawiono pozycji wirników. Nie można rozpocząć.");
	   }
   }
   
   public int letterToNumber (String s){
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
   
   public String numberToLetter (int n) {
	n=n+65;
	String s = Character.toString((char) n);
        return s;
   }
   
   void validateRotors () {
	   chooseRotors();
	   setRotorPositions();
   }
   
   void rotateRotors() {
	   int position3 = rotor3.getRotorPosition();
	   int position2 = rotor2.getRotorPosition();
	   int position1 = rotor1.getRotorPosition();

	   if (position3<25) {
		   rotor3.setRotorPosition(position3+1);
		   comboBox3.getSelectionModel().select(rotor3.getRotorPosition());
	   }
	   else {
		   rotor3.setRotorPosition(0);
		   comboBox3.getSelectionModel().select(rotor3.getRotorPosition());
		   if (position2<25) {
			   rotor2.setRotorPosition(position2+1);
			   comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
		   }
		   else {
			   rotor2.setRotorPosition(0);
			   comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
			   if (position1<25) {
				   rotor1.setRotorPosition(position1+1);
				   comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
			   }
			   else {
				   rotor1.setRotorPosition(0);
				   comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
			   }
		   }
		   
	   }  
   }
   void runEnigma (int input) {
	   if (rotor1!=null && rotor2!=null && rotor3!=null) {
		   int value = input;
		   value = rotor3.returnValueForward(value);
		   value = rotor2.returnValueForward(value);
		   value = rotor1.returnValueForward(value);
		   value = reflector.returnValue(value);
		   value = rotor1.returnValueBackward(value);
		   value = rotor2.returnValueBackward(value);
		   value = rotor3.returnValueBackward(value);
		   String code = numberToLetter(value);
		   System.out.print(code);
		   rotateRotors();
	   }
   }

    public static void main(String[] args) {
        launch();
    }

}
