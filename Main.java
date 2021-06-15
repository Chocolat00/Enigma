package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
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
    TextArea l2;

    CablePane layout;
    int value;
    ObservableList<Integer> comboBoxes =
            FXCollections.observableArrayList();

    Image image = new Image(Main.class.getResourceAsStream("rotor.jpg"));
    Image image2 = new Image(Main.class.getResourceAsStream("rotor.gif"));
    ImageView iv = new ImageView();
    ImageView iv2 = new ImageView();
    ImageView iv3 = new ImageView();

    Locale currentLocale;
    ResourceBundle labelsBundle;
    String language="", country="";
    boolean animacje =true;

    @Override
    public void start(Stage stage) {
        currentLocale = new Locale(language,country);
        labelsBundle = ResourceBundle.getBundle("LabelsBundle", currentLocale);

        stage1 = stage;
        scene = new Scene(new Group(), 880, 700);
        //scene.getStylesheets().add("./test.css");

        ObservableList<String> options =
                FXCollections.observableArrayList();
        for(int ii=0; ii<26; ii++){
            int num =65+ii;
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

        l1 =new Label(labelsBundle.getString("generalPromptMessage"));
        l1.setPrefWidth(400);
        l2=new TextArea("");
        l2.setEditable(false);
        l2.setPrefWidth(400);
        l2.setWrapText(true);
        //lista etykiet
        lista = FXCollections.observableArrayList();
        for(int i=0; i<26; i++){
            lista.add(new Label (options.get(i)));
        }


        //Tworzenie menu
        Menu menu = new Menu(labelsBundle.getString("menuLabel"));
        //Dodanie pozycji menu
        MenuItem menuItem1 = new MenuItem(labelsBundle.getString("menuFileLabel"));
        menuItem1.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(labelsBundle.getString("fileChooserOpenLabel"));

            //extension filter
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extensionFilter);

            File file = fileChooser.showOpenDialog(stage1);

            if(file != null){
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    //tu
                    animacje=false;
                    while ((line = reader.readLine()) != null) {
                        input.setText(input.getText()+" "+line);
                        char[] charArray = (line+" ").toCharArray();
                        for (char c:charArray) {
                            String change = Character.toString(c);
                            int letter = letterToNumber(change);
                            int s = switchLetters(letter);
                            runEnigma(s);
                        }
                    }
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            animacje=true;
        });
        MenuItem menuItem2 = new MenuItem(labelsBundle.getString("menuSaveLabel"));
        menuItem2.setOnAction(e->{
            FileChooser fileChooser2 = new FileChooser();
            fileChooser2.setTitle(labelsBundle.getString("fileChooserSaveLabel"));

            //extension filter
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser2.getExtensionFilters().add(extensionFilter);

            File file = fileChooser2.showSaveDialog(stage1);

            if(file != null){
                try {
                    FileWriter fileWriter;
                    String content=l2.getText();

                    fileWriter = new FileWriter(file);
                    fileWriter.write(content);
                    fileWriter.close();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem menuItem3 = new MenuItem(labelsBundle.getString("menuResetLabel"));
        menuItem3.setOnAction(e->{
            firstRotor1.setSelected(true);
            secondRotor1.setSelected(true);
            thirdRotor1.setSelected(true);
            reflector1.setSelected(true);
            comboBox1.getSelectionModel().selectFirst();
            comboBox2.getSelectionModel().selectFirst();
            comboBox3.getSelectionModel().selectFirst();
            input.setText("");
            input.setPromptText(labelsBundle.getString("inputPromptMessage"));
            l1.setText(labelsBundle.getString("generalPromptMessage"));
            l2.setText("");

            for(int i=0; i<20; i++){
                layout.options1.get(i).getSelectionModel().selectFirst();
            }
            comboBoxes.clear();
        });
        MenuItem menuItem4 = new MenuItem(labelsBundle.getString("menuLanguageLabel"));
        menuItem4.setOnAction(e->{
            if (language.equals("") || language.equals("pl")) {
                language = "en";
                country = "US";
            }
            else {
                language = "pl";
                country = "PL";
            }
            start(stage1);
        });
        MenuItem menuItem5 = new MenuItem("Autorzy");
        menuItem5.setOnAction(e->{
            Alert alert= new Alert(AlertType.INFORMATION,
                    "Katarzyna Domańska \n Katarzyna Stojek");
            alert.setTitle("Autorzy");
            alert.show();
        });
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menuItem5);
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

        Button button = new Button(labelsBundle.getString("cablePaneButtonLabel"));
        button.setOnAction(e->stage.setScene(scene2));
        layout = new CablePane(300, 300, language, country);

        layout.back.setOnAction(e->stage.setScene(scene));
        layout.check.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                if (layout.correctConnection()){
                    Alert alert1= new Alert(Alert.AlertType.INFORMATION,
                            labelsBundle.getString("cablePaneConfirmedMessage"));
                    alert1.show();
                    for(int i=0; i<20; i++){

                        if(!"".equals(String.valueOf(layout.options1.get(i).getValue()))){
                            comboBoxes.add(letterToNumber(String.valueOf(layout.options1.get(i).getValue())));
                        }
                    }
                    }
                    else{
                        Alert alert2 = new Alert(Alert.AlertType.WARNING,
                                labelsBundle.getString("wrongCablePaneSettingsMessage"));
                        alert2.show();
                    }

                }
            });
            scene2=new Scene(layout, 300, 300);

            Button button2 = new Button(labelsBundle.getString("confirmRotorsLabel"));
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
        input.setPromptText(labelsBundle.getString("inputPromptMessage"));
        input.setOnKeyTyped(e->{
                if(input.isEditable()) {
                    int letter = letterToNumber(e.getCharacter());
                    int s = switchLetters(letter);
                    runEnigma(s);
                }
            });
        input.setPrefWidth(400);
        input.setPrefHeight(300);
        input.getStyleClass().add("text-input");
        input.setWrapText(true);
        grid2.add(input, 0, 0);
        grid2.add(l1, 0, 1);
        grid2.add(l2, 0, 2);
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

        gridRotors.add(new Label(labelsBundle.getString("rotorLabel1")), 0, 0);
        gridRotors.add(gridFirstRotor, 0, 1);
        gridRotors.add(new Label(labelsBundle.getString("rotorLabel2")), 0, 2);
        gridRotors.add(gridSecondRotor, 0, 3);
        gridRotors.add(new Label(labelsBundle.getString("rotorLabel3")), 0, 4);
        gridRotors.add(gridThirdRotor, 0, 5);
        gridRotors.add(new Label(labelsBundle.getString("reflectorLabel")), 1, 0);
        gridRotors.add(gridReflector, 1, 1);
        gridRotors.add(button, 1, 2);
        gridRotors.add(button2, 2, 2);

            HBox pictureRegion = new HBox();
        pictureRegion.setMaxWidth(300);


        iv.setImage(image);
        iv.setFitWidth(150);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        pictureRegion.getChildren().add(iv);

        HBox pictureRegion2 = new HBox();
        pictureRegion2.setMaxWidth(300);

        iv2.setImage(image);
        iv2.setFitWidth(150);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        pictureRegion2.getChildren().add(iv2);

            HBox pictureRegion3 = new HBox();
        pictureRegion3.setMaxWidth(300);

        iv3.setImage(image);
        iv3.setFitWidth(150);
        iv3.setPreserveRatio(true);
        iv3.setSmooth(true);
        iv3.setCache(true);
        pictureRegion3.getChildren().add(iv3);

        gridAnimation.add(pictureRegion, 0,0);
        gridAnimation.add(pictureRegion2, 1,0);
        gridAnimation.add(pictureRegion3, 2,0);

        stage.setOnCloseRequest(e->{
                e.consume();
                closeProgram();
            });

            Group root = (Group)scene.getRoot();
        root.getChildren().add(masterGrid);
        stage.setScene(scene);
        stage.setTitle(labelsBundle.getString("windowTitle"));
        stage.show();
        }
        public void changePic(ImageView imv, Image im){
            imv.setImage(im);
        }

        private void closeProgram() {
            Alert alert = new Alert(AlertType.CONFIRMATION, labelsBundle.getString("closeWindowMessage") , ButtonType.YES, ButtonType.NO);
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
                l1.setText(labelsBundle.getString("rotorsConfirmedMessage"));
            }
            else {
                l1.setText(labelsBundle.getString("wrongRotorsMessage"));
            }
        }
        void setRotorPositions () {
            if (rotor1!=null && rotor2!=null && rotor3!=null) {
                rotor1.setRotorPosition(pos1);
                rotor2.setRotorPosition(pos2);
                rotor3.setRotorPosition(pos3);
                l1.setText(l1.getText()+labelsBundle.getString("rotorsSettingsMessage")+pos1+" "+pos2+" "+pos3 +"\n \n");
            }
            else {
                l1.setText(l1.getText()+labelsBundle.getString("rotorPositionNotSetMessage"));
            }
        }

        public int letterToNumber (String s){
            char c= s.charAt(0);
            int num = c;
            if(num>64 && num<91){
                num = num-65;
            }
            else if (s.equals("ą") || s.equals("Ą")) {
                num = 0;
            }
            else if (s.equals("ć") || s.equals("Ć")) {
                num = 2;
            }
            else if (s.equals("ę") || s.equals("Ę")) {
                num = 4;
            }
            else if (s.equals("ł") || s.equals("Ł")) {
                num = 11;
            }
            else if (s.equals("ń") || s.equals("Ń")) {
                num = 13;
            }
            else if (s.equals("Ó") || s.equals("ó")) {
                num = 14;
            }
            else if (s.equals("ś") || s.equals("Ś")) {
                num = 18;
            }
            else if (s.equals("Ź") || s.equals("ź")) {
                num = 25;
            }
            else if (s.equals("Ż") || s.equals("ż")) {
                num = 25;
            }
            else{
                num= num-97;
            }
            return num;
        }

        public String numberToLetter (int n) {
            n=n+97;

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
            if(animacje) {
                Task<Void> sleeper1 = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        return null;
                    }
                };
                Task<Void> sleeper2 = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        return null;
                    }
                };
                Task<Void> sleeper3 = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(530);
                        } catch (InterruptedException e) {
                        }
                        return null;
                    }
                };

                sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        changePic(iv, image);
                    }
                });
                sleeper2.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        changePic(iv2, image);
                    }
                });
                sleeper3.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        changePic(iv3, image);
                    }
                });


                if (position3 < 25) {
                    rotor3.setRotorPosition(position3 + 1);
                    iv3.setImage(image2);
                    new Thread(sleeper3).start();
                    comboBox3.getSelectionModel().select(rotor3.getRotorPosition());

                } else {
                    rotor3.setRotorPosition(0);
                    iv3.setImage(image2);
                    new Thread(sleeper3).start();
                    comboBox3.getSelectionModel().select(rotor3.getRotorPosition());
                    if (position2 < 25) {
                        rotor2.setRotorPosition(position2 + 1);
                        iv2.setImage(image2);
                        new Thread(sleeper2).start();
                        comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
                    } else {
                        rotor2.setRotorPosition(0);
                        iv2.setImage(image2);
                        new Thread(sleeper2).start();
                        comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
                        if (position1 < 25) {
                            rotor1.setRotorPosition(position1 + 1);
                            iv.setImage(image2);
                            new Thread(sleeper1).start();
                            comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
                        } else {
                            rotor1.setRotorPosition(0);
                            iv.setImage(image2);
                            new Thread(sleeper1).start();
                            comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
                        }
                    }

                }
            }
            else{
                if (position3 < 25) {
                    rotor3.setRotorPosition(position3 + 1);
                    comboBox3.getSelectionModel().select(rotor3.getRotorPosition());

                } else {
                    rotor3.setRotorPosition(0);
                    comboBox3.getSelectionModel().select(rotor3.getRotorPosition());
                    if (position2 < 25) {
                        rotor2.setRotorPosition(position2 + 1);
                        comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
                    } else {
                        rotor2.setRotorPosition(0);
                        comboBox2.getSelectionModel().select(rotor2.getRotorPosition());
                        if (position1 < 25) {
                            rotor1.setRotorPosition(position1 + 1);
                            comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
                        } else {
                            rotor1.setRotorPosition(0);
                            comboBox1.getSelectionModel().select(rotor1.getRotorPosition());
                        }
                    }
                }
            }
        }
        void runEnigma (int input) {
            if (rotor1!=null && rotor2!=null && rotor3!=null) {
                if(input>=0&&input<26){
                    value = input;
                    value = rotor3.returnValueForward(value);
                    value = rotor2.returnValueForward(value);
                    value = rotor1.returnValueForward(value);
                    value = reflector.returnValue(value);
                    value = rotor1.returnValueBackward(value);
                    value = rotor2.returnValueBackward(value);
                    value = rotor3.returnValueBackward(value);
                    value=switchLetters(value);
                    String code = numberToLetter(value);

                    rotateRotors();
                    if(animacje) {
                        light(value);
                        Task<Void> sleeper = new Task<Void>() {
                            @Override
                            protected Void call() throws Exception {
                                try {
                                    Thread.sleep(600);
                                } catch (InterruptedException e) {
                                }
                                return null;
                            }
                        };
                        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent event) {
                                dim(value);
                            }
                        });

                        new Thread(sleeper).start();
                    }
                    l2.setText(l2.getText()+code);

                }
                else{
                    String c = numberToLetter(input);
                    l2.setText(l2.getText()+c);
                }


            }
        }

        void light(int a){
            lista.get(a).setStyle("-fx-text-fill: #FFFF00;");
            input.setEditable(false);
        }
        void dim(int a){

            lista.get(a).setStyle("-fx-text-fill: #000000;");
            input.setEditable(true);
        }

        int switchLetters(int s){
            int j=1;
            for(int i=0; i<comboBoxes.size()-1; i+=2){
                if(s==comboBoxes.get(i)){
                    int n=comboBoxes.get(j);
                    return n;
                }
                else if(s==comboBoxes.get(j)){
                    int n=comboBoxes.get(i);
                    return n;
                }
                j+=2;
            }
            return s;
        }
        public static void main(String[] args) {
            launch();
        }


    }
