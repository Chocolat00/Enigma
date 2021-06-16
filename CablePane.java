package pl.edu.pw.fizyka.pojava.enigma;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

//Autorka: Katarzyna Domañska
public class CablePane extends Pane {

    ComboBox<String> comboBox1;
    ComboBox<String> comboBox2;
    ComboBox<String> comboBox3;
    ComboBox<String> comboBox4;
    ComboBox<String> comboBox5;
    ComboBox<String> comboBox6;
    ComboBox<String> comboBox7;
    ComboBox<String> comboBox8;
    ComboBox<String> comboBox9;
    ComboBox<String> comboBox10;
    ComboBox<String> comboBox11;
    ComboBox<String> comboBox12;
    ComboBox<String> comboBox13;
    ComboBox<String> comboBox14;
    ComboBox<String> comboBox15;
    ComboBox<String> comboBox16;
    ComboBox<String> comboBox17;
    ComboBox<String> comboBox18;
    ComboBox<String> comboBox19;
    ComboBox<String> comboBox20;
    Button back;
    Button check;

    ObservableList<String> options =
            FXCollections.observableArrayList();

    ObservableList<ComboBox> options1 =
            FXCollections.observableArrayList();

    public CablePane(double width, double height, String language, String country) {
        Locale currentLocale = new Locale(language,country);
        ResourceBundle cablePaneBundle = ResourceBundle.getBundle("LabelsBundle", currentLocale);

        this.setPrefHeight(height);
        this.setPrefWidth(width);

        back = new Button(cablePaneBundle.getString("returnButtonLabel"));
        check = new Button(cablePaneBundle.getString("confirmCablePaneSettingsMessage"));

        options.add("");
        for(int i=0; i<26; i++){
            int num =65+i;
            String str=Character.toString((char)num);
            options.add(str);
        }
        Label label1 = new Label(cablePaneBundle.getString("connectionLabel1"));
        comboBox1 = new ComboBox<String>(options);
        comboBox2 = new ComboBox<String>(options);
        Label label2 = new Label(cablePaneBundle.getString("connectionLabel2"));
        comboBox3 = new ComboBox<String>(options);
        comboBox4 = new ComboBox<String>(options);
        Label label3 = new Label(cablePaneBundle.getString("connectionLabel3"));
        comboBox5 = new ComboBox<String>(options);
        comboBox6 = new ComboBox<String>(options);
        Label label4 = new Label(cablePaneBundle.getString("connectionLabel4"));
        comboBox7 = new ComboBox<String>(options);
        comboBox8 = new ComboBox<String>(options);
        Label label5 = new Label(cablePaneBundle.getString("connectionLabel5"));
        comboBox9 = new ComboBox<String>(options);
        comboBox10 = new ComboBox<String>(options);
        Label label6 = new Label(cablePaneBundle.getString("connectionLabel6"));
        comboBox11 = new ComboBox<String>(options);
        comboBox12 = new ComboBox<String>(options);
        Label label7 = new Label(cablePaneBundle.getString("connectionLabel7"));
        comboBox13 = new ComboBox<String>(options);
        comboBox14 = new ComboBox<String>(options);
        Label label8 = new Label(cablePaneBundle.getString("connectionLabel8"));
        comboBox15 = new ComboBox<String>(options);
        comboBox16 = new ComboBox<String>(options);
        Label label9 = new Label(cablePaneBundle.getString("connectionLabel9"));
        comboBox17 = new ComboBox<String>(options);
        comboBox18 = new ComboBox<String>(options);
        Label label10 = new Label(cablePaneBundle.getString("connectionLabel10"));
        comboBox19 = new ComboBox<String>(options);
        comboBox20 = new ComboBox<String>(options);

        comboBox1.getSelectionModel().selectFirst();
        comboBox2.getSelectionModel().selectFirst();
        comboBox3.getSelectionModel().selectFirst();
        comboBox4.getSelectionModel().selectFirst();
        comboBox5.getSelectionModel().selectFirst();
        comboBox6.getSelectionModel().selectFirst();
        comboBox7.getSelectionModel().selectFirst();
        comboBox8.getSelectionModel().selectFirst();
        comboBox9.getSelectionModel().selectFirst();
        comboBox10.getSelectionModel().selectFirst();
        comboBox11.getSelectionModel().selectFirst();
        comboBox12.getSelectionModel().selectFirst();
        comboBox13.getSelectionModel().selectFirst();
        comboBox14.getSelectionModel().selectFirst();
        comboBox15.getSelectionModel().selectFirst();
        comboBox16.getSelectionModel().selectFirst();
        comboBox17.getSelectionModel().selectFirst();
        comboBox18.getSelectionModel().selectFirst();
        comboBox19.getSelectionModel().selectFirst();
        comboBox20.getSelectionModel().selectFirst();

        options1.add(comboBox1);
        options1.add(comboBox2);
        options1.add(comboBox3);
        options1.add(comboBox4);
        options1.add(comboBox5);
        options1.add(comboBox6);
        options1.add(comboBox7);
        options1.add(comboBox8);
        options1.add(comboBox9);
        options1.add(comboBox10);
        options1.add(comboBox11);
        options1.add(comboBox12);
        options1.add(comboBox13);
        options1.add(comboBox14);
        options1.add(comboBox15);
        options1.add(comboBox16);
        options1.add(comboBox17);
        options1.add(comboBox18);
        options1.add(comboBox19);
        options1.add(comboBox20);


        GridPane cablegrid =new GridPane();
        GridPane mastergrid=new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        GridPane grid4 = new GridPane();
        GridPane grid5 = new GridPane();
        GridPane grid6 = new GridPane();
        GridPane grid7 = new GridPane();
        GridPane grid8 = new GridPane();
        GridPane grid9 = new GridPane();
        GridPane grid10 = new GridPane();
        GridPane buttonPane = new GridPane();

        cablegrid.setHgap(20);
        mastergrid.setVgap(10);


        grid1.add(comboBox1, 0, 0);
        grid1.add(comboBox2, 1, 0);

        grid2.add(comboBox3, 0, 0);
        grid2.add(comboBox4, 1, 0);

        grid3.add(comboBox5, 0, 0);
        grid3.add(comboBox6, 1, 0);

        grid4.add(comboBox7, 0, 0);
        grid4.add(comboBox8, 1, 0);

        grid5.add(comboBox9, 0, 0);
        grid5.add(comboBox10, 1, 0);

        grid6.add(comboBox11, 0, 0);
        grid6.add(comboBox12, 1, 0);

        grid7.add(comboBox13, 0, 0);
        grid7.add(comboBox14, 1, 0);

        grid8.add(comboBox15, 0, 0);
        grid8.add(comboBox16, 1, 0);

        grid9.add(comboBox17, 0, 0);
        grid9.add(comboBox18, 1, 0);

        grid10.add(comboBox19, 0, 0);
        grid10.add(comboBox20, 1, 0);

        buttonPane.add(check, 0, 0);
        buttonPane.add(back, 1, 0);

        cablegrid.add(label1, 0, 0);
        cablegrid.add(grid1, 0, 1);
        cablegrid.add(label2, 0, 2);
        cablegrid.add(grid2, 0, 3);
        cablegrid.add(label3, 0, 4);
        cablegrid.add(grid3, 0, 5);
        cablegrid.add(label4, 0, 6);
        cablegrid.add(grid4, 0, 7);
        cablegrid.add(label5, 0, 8);
        cablegrid.add(grid5, 0, 9);

        cablegrid.add(label6, 1, 0);
        cablegrid.add(grid6, 1, 1);
        cablegrid.add(label7, 1, 2);
        cablegrid.add(grid7, 1, 3);
        cablegrid.add(label8, 1, 4);
        cablegrid.add(grid8, 1, 5);
        cablegrid.add(label9, 1, 6);
        cablegrid.add(grid9, 1, 7);
        cablegrid.add(label10, 1, 8);
        cablegrid.add(grid10, 1, 9);

        mastergrid.add(cablegrid, 0, 0);
        mastergrid.add(buttonPane, 0, 1);
        this.getChildren().add(mastergrid);




    }
    boolean correctConnection(){
        ObservableList <String> lista= FXCollections.observableArrayList();
        for(int i=0; i< options1.size();i++){
            lista.add(String.valueOf(options1.get(i).getValue()));
        }


        for(int i=0; i<20; i++){

            if("".equals(lista.get(i))){

                int n =(i+1)%2;
                if(n==0 && "".equals(lista.get(i-1))){

                }
                else if(n==1 && "".equals(lista.get(i+1))){

                }
                else{
                    for(int j=i+1; j<20; j++){

                        if(lista.get(i).equals(lista.get(j))){
                            lista.clear();
                            return false;
                        }
                    }
                }
            }
            else{
                for(int j=i+1; j<20; j++){

                    if(lista.get(i).equals(lista.get(j))){
                        lista.clear();
                        return false;
                    }
                }
            }
        }
        lista.clear();
        return true;

    }
}
