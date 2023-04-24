/**
 * File: PAssign08.java
 * Class: CSCI 1302
 * Author: Lavardo Miller
 * Created on: April 24, 2023
 * Last Modified: April 24, 2023
 * Description: Updating a GUI application using a real world object with KeyPadPane class from GitHub
 * GitHub Link: 
 */
package ch14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PAssign08 extends Application {
    // private Label
    protected Label lblPhoneNumber;

    @Override
    public void start(Stage primaryStage) {
        // a keyPad using KeyPadCustomPane with a Label
       // KeyPadPane keyPad = new KeyPadPane(true);
    	KeyPadCustomPane keyPad = new KeyPadCustomPane(true);
        lblPhoneNumber = new Label();
        
        
        // An HBox area for the numbers to display when clicked
        HBox numberDisplay = new HBox(lblPhoneNumber);
        numberDisplay.setAlignment(Pos.CENTER_LEFT);
        numberDisplay.setPadding(new Insets(10));

        // a VBox for the scene of keyPad and numberDisplay
        VBox VPane = new VBox(numberDisplay, keyPad);
        VPane.setPadding(new Insets(50));
        keyPad.setHgap(10); // horizontal gap between buttons
        keyPad.setVgap(10); // vertical gap between buttons

        // event handler for * button from KeyPadCustomPane
        keyPad.btnAsterisk.setOnAction(e -> {
            lblPhoneNumber.setText(lblPhoneNumber.getText() + "*");
            System.out.println("Button * was clicked.");
        });

        // event handler for # button from KeyPadCustomPane
        keyPad.btnPound.setOnAction(e -> {
            lblPhoneNumber.setText(lblPhoneNumber.getText() + "#");
            System.out.println("Button # was clicked.");
        });

        // Add Dialing button
        Button btnDial = new Button("Dial");
        btnDial.setOnAction(e -> {
            String phoneNumber = lblPhoneNumber.getText();
            System.out.println("Dialing " + phoneNumber);
            // Printing phone call
        });
        
        // Add Clear button
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(e -> {
            lblPhoneNumber.setText("");
            System.out.println("Phone number cleared.");
            // Printing phone number cleared
        });
        // HBoc for dial and clear
        HBox hboxDialClear = new HBox(btnDial, btnClear);
        hboxDialClear.setAlignment(Pos.CENTER_RIGHT);
        hboxDialClear.setSpacing(10);

        VPane.getChildren().add(hboxDialClear);
        VPane.setAlignment(Pos.CENTER);
        VPane.setSpacing(10);

        // Setting the stage
        Scene scene = new Scene(VPane);
        primaryStage.setTitle("Telephone KeyPad");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // Launch
    public static void main(String[] args) {
        launch(args);
    }
}
