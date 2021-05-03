
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class CablePane extends Pane {
    ComboBox<String> comboBox1;
    ComboBox<String> comboBox2;
    ComboBox<String> comboBox3;
    ComboBox<String> comboBox4;
    ComboBox<String> comboBox5;
    ComboBox<String> comboBox6;
    Button back = new Button("Powrót");
    ObservableList<String> options =
            FXCollections.observableArrayList();


    public CablePane(double width, double height) {
       this.setPrefHeight(height);
       this.setPrefWidth(width);



        for(int i=0; i<26; i++){
            int num =65+i;
            String str=Character.toString((char)num);
            options.add(str);
        }
        Label label1 = new Label("Połączenie 1");
        comboBox1 = new ComboBox<String>(options);
        comboBox2 = new ComboBox<String>(options);
        Label label2 = new Label("Połączenie 2");
        comboBox3 = new ComboBox<String>(options);
        comboBox4 = new ComboBox<String>(options);
        Label label3 = new Label("Połączenie 3");
        comboBox5 = new ComboBox<String>(options);
        comboBox6 = new ComboBox<String>(options);

        Button check = new Button("Sprawdź połączenie");
        check.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                if (correctConnection()){
                    Alert alert1= new Alert(Alert.AlertType.INFORMATION,
                            "Połączenie w łącznicy kablowej jest poprawne");
                    alert1.show();
                }
                else{
                    Alert alert2 = new Alert(Alert.AlertType.WARNING,
                            "Połączenie w łącznicy kablowej jest niepoprawne, kodowanie nie odbędzie się");
                    alert2.show();
                }

            }
        });
        GridPane mastergrid =new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        GridPane buttonPane = new GridPane();
        
        grid1.add(comboBox1, 0, 0);
        grid1.add(comboBox2, 1, 0);

        grid2.add(comboBox3, 0, 0);
        grid2.add(comboBox4, 1, 0);

        grid3.add(comboBox5, 0, 0);
        grid3.add(comboBox6, 1, 0);
        
        buttonPane.add(check, 0, 0);
        buttonPane.add(back, 1, 0);

        mastergrid.add(label1, 0, 0);
        mastergrid.add(grid1, 0, 1);
        mastergrid.add(label2, 0, 2);
        mastergrid.add(grid2, 0, 3);
        mastergrid.add(label3, 0, 4);
        mastergrid.add(grid3, 0, 5);
        mastergrid.add(buttonPane, 0, 6);
        this.getChildren().add(mastergrid);




    }
    boolean correctConnection(){
        ObservableList <String> lista= FXCollections.observableArrayList();

        lista.add(comboBox1.getValue());
        lista.add(comboBox2.getValue());
        lista.add(comboBox3.getValue());
        lista.add(comboBox4.getValue());
        lista.add(comboBox5.getValue());
        lista.add(comboBox6.getValue());

        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                System.out.println(lista.get(i));
                System.out.println(lista.get(j));
                if(lista.get(i).equals(lista.get(j))){

                    lista.clear();
                    return false;
                }
            }
        }
        lista.clear();
        return true;

    }
}
