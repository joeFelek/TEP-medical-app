package HY360;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogController extends Application {

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField databaseField;

    @FXML
    private JFXButton createTableBtn;

    @FXML
    private JFXButton InsertValuesBtn;

    @FXML
    private JFXButton logInBtn;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        stage.setTitle("Τμήμα Επειγόντων Περιστατικών");
        stage.setScene(new Scene(root, 1280, 800));
        stage.show();
    }

    public void Create() throws FileNotFoundException {

        if(databaseField.getText().isEmpty()) {
            databaseField.setText("Needs to be specified!");
            return;
        }
        DBUtil.setDatabaseName(databaseField.getText());
        //create tables
        File tables = new File("Table Entries/Tables.txt");
        Scanner s = new Scanner(tables);
        while(s.hasNextLine()) {
            String create = s.nextLine();
            try {
                DBUtil.dbExecuteUpdate(create);
            } catch (SQLException | ClassNotFoundException ignored) {

            }
        }
        s.close();
    }

    public void Insert() {
        try {
            //fill table with default values
            File file = new File("Table Entries/GeneratedInfo.txt");
            Scanner scan = new Scanner(file);
            int flag=0;
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.equals("---")){
                    flag++;
                    continue;
                }
                String[] info = line.split("\\|");

                if(flag==0) { //employee
                    try {
                        if(databaseField.getText().isEmpty()) {
                            databaseField.setText("Needs to be specified!");
                            scan.close();
                            return;
                        }
                        DBUtil.setDatabaseName(databaseField.getText());
                        int id = findAutoIncrementID();
                        DBUtil.dbExecuteUpdate("Insert Into Employee(Name, Phone, Address, Position, PositionTitle) VALUES('"+
                                info[0]+"','"+info[1]+"','"+info[2]+"','"+info[3]+"','"+info[4]+"')");
                        if(info[3].equals("D"))
                            DBUtil.dbExecuteUpdate("Insert INTO Doctor Values("+id+",'"+info[4]+"')");
                        else if(info[3].equals("N"))
                            DBUtil.dbExecuteUpdate("Insert INTO Nurse Values("+id+")");

                    } catch (SQLException | ClassNotFoundException throwable) {
                        throwable.printStackTrace();
                        break;
                    }
                }else if(flag==1) { //patient
                    try {
                        info[3] = "STR_TO_DATE('"+info[3]+"', '%m-%d-%Y')";
                        DBUtil.dbExecuteUpdate("Insert Into Patient VALUES("+info[0]+",'"+info[1]+"','"+info[2]+"',"+info[3]+","+info[4]+",'"+info[5]+"','"+info[6]+"')");
                    } catch (SQLException | ClassNotFoundException throwable) {
                        throwable.printStackTrace();
                        break;
                    }
                }else if(flag==2) {  //disease
                    try {
                        DBUtil.dbExecuteUpdate("Insert into Disease(Name, Speciality, Symptoms) Values('"+info[0]+"','"+info[1]+"','"+info[2]+"')");
                    } catch (SQLException | ClassNotFoundException throwable) {
                        throwable.printStackTrace();
                        break;
                    }
                }else if(flag==3) { //exam
                    try {
                        DBUtil.dbExecuteUpdate("Insert into Exam(Name) Values('"+info[0]+"')");
                    } catch (SQLException | ClassNotFoundException throwable) {
                        throwable.printStackTrace();
                        break;
                    }
                }else if(flag==4) { //medicine
                    try {
                        DBUtil.dbExecuteUpdate("Insert Into Medicine(idDisease, Name, Type, Dose) VALUES("+info[0]+",'"+info[1]+"','"+info[2]+"',"+info[3]+")");
                    } catch (SQLException | ClassNotFoundException throwable) {
                        throwable.printStackTrace();
                        break;
                    }
                }
            }
            try {
                DBUtil.dbExecuteUpdate("Insert Into Disease Values(-1,'NULL','NULL',NULL)");
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void logIn(ActionEvent event) throws IOException {

        if(databaseField.getText().isEmpty()) {
            databaseField.setText("Needs to be specified!");
            return;
        }
        DBUtil.setDatabaseName(databaseField.getText());

        DBUtil.setUsername(usernameField.getText());
        DBUtil.setPassword(passwordField.getText());

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        stage.setScene(new Scene(root, 1280, 800));
        stage.show();
    }

    private int findAutoIncrementID() {
        String findPNEid = "SELECT `AUTO_INCREMENT` " +
                "FROM INFORMATION_SCHEMA.TABLES " +
                "WHERE TABLE_SCHEMA = '"+DBUtil.getDatabaseName()+"' " +
                "AND TABLE_NAME = 'Employee'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(findPNEid);
            if(set.next())
                return set.getInt(1);

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

}