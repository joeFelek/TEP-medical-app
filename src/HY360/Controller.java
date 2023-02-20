package HY360;

import HY360.TableEntities.*;
import com.jfoenix.controls.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.RotateTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Bloom;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller implements Initializable {

    public JFXButton schedInsertBtn;
    public TableColumn<Shift, String> schedEAvailCol;
    public TableColumn<Shift, String> schedEPosCol;
    public TableColumn<Shift, String> schedENameCol;
    public TableColumn<Shift, Integer> schedEIdCol;
    public TableView<Shift> schedETableView;
    public TableColumn<Shift, Button> schedSRemove;
    public JFXDatePicker schedEDatePicker;
    public JFXTextField schedHoursField;
    public JFXTextField schedStartTimeField;
    public JFXTextField schedIdField;
    public Label schedFlag;
    public JFXButton patientSearchBtn;
    public TextField patientSearchField;
    public AnchorPane patientCreatePane;
    public JFXTextField patientIdField;
    public JFXTextField patientNameField;
    public JFXComboBox<String> patientSexBox;
    public JFXTextField patientInsurField;
    public JFXTextField patientAddreField;
    public JFXTextField patientPhoneField;
    public JFXButton patientInsertBtn;
    public AnchorPane patientFoundPane;
    public Label patientNameLabel;
    public Label patientIdLabel;
    public Label patientSexLabel;
    public Label patientDateLabel;
    public Label patientInsurLabel;
    public Label patientAddreLabel;
    public Label patientPhoneLabel;
    public TableView<Patient> patientRecordView;
    public TableColumn<Patient, String> patientDateCol;
    public TableColumn<Patient, String> patientDiseaseCol;
    public TableColumn<Patient, String> patientExamCol;
    public TableColumn<Patient, String> patientByCol;
    public TableColumn<Patient, String> patientSpecialityCol;
    public TableColumn<Patient, Integer> patientHospitalisedCol;
    public TableView<Medicine> patientPrescripView;
    public TableColumn<Medicine, String> patientMedicineCol;
    public TableColumn<Medicine, Integer> patientQuantityCol;
    public TableColumn<Medicine, Integer> patientDoseCol;
    public TableColumn<Medicine, String> patientTypeCol;
    public Label patientErrorLabel;
    public JFXDatePicker patientDateField;
    public Label patientInsertErrorLabel;
    public JFXTextField patientUNameField;
    public JFXTextField patientUsexField;
    public JFXTextField patientUDateField;
    public JFXTextField patientUInsField;
    public JFXTextField patientUAddrField;
    public JFXTextField patientUPhoneField;
    public JFXButton patientUpdateBtn;
    public Label patientUErrorLabel;
    public JFXTextField patientSymptomsField;
    public JFXButton patientSearchBtn1;
    public Label patientDoctorSpecialityLabel;
    public Label patientSpecialityResultLabel;
    public JFXButton patientAddNewBtn;
    public Label patientDoctorSpecialityLabel1;
    public Label patientSpecialityResultLabel1;
    public AnchorPane staffInsertNewPane;
    public JFXTextField staffInNameField;
    public JFXTextField staffInPhoneField;
    public JFXTextField staffInAddrField;
    public JFXComboBox<String> staffInPosBox;
    public JFXTextField staffInTitleField;
    public JFXButton staffInsertBtn;
    public AnchorPane staffAllStaffPane;
    public TableView<Staff> staffAllView;
    public TableColumn<Staff, Integer> staffIdCol;
    public TableColumn<Staff, String> staffNameCol;
    public TableColumn<Staff, String> staffPhoneCol;
    public TableColumn<Staff, String> staffAddrCol;
    public TableColumn<Staff, String> staffPosCol;
    public TableColumn<Staff, String> staffTitleCol;
    public TableColumn<Staff, Button> staffDelCol;
    public AnchorPane staffSearchPane;
    public JFXTextField staffSearchField;
    public JFXButton staffSearchBtn;
    public AnchorPane staffInfoPane;
    public Label staffNameLabel;
    public Label staffPhoneLabel;
    public Label staffAddrLabel;
    public Label staffTitleLabel;
    public Label staffPosLabel;
    public Label staffIdLabel;
    public JFXButton staffUpdateBtn;
    public JFXTextField staffNameField;
    public JFXTextField staffPhoneField;
    public JFXTextField staffAddrField;
    public JFXTextField staffTitleField;
    public JFXTextField staffPosField;
    public AnchorPane staffHeaderPane;
    public JFXButton staffNewEmpBtn;
    public JFXButton staffShowAllBtn;
    public JFXButton staffSearchTabBtn;
    public Label staffInError;
    public Label staffUpdateError;
    public Label staffSearchError;
    public JFXTabPane examDoctorPane;
    public AnchorPane examNursePane;
    public AnchorPane examDiseasePane;
    public AnchorPane examMedicinePane;
    public AnchorPane examProcedurePane;
    public AnchorPane examHeaderPane;
    public JFXButton examMedBtn;
    public JFXButton examProcedureBtn;
    public JFXButton examDoctorBtn;
    public JFXButton examNurseBtn;
    public JFXButton examDiseaseBtn;
    public Label examHeaderName;
    public JFXButton examDiseaseCloseBtn;
    public JFXButton examMedicineCloseBtn;
    public JFXButton examNurseSearchBtn;
    public JFXButton examProcedureEditBtn;
    public JFXButton examProcedureAddBtn;
    public AnchorPane patientSearchPane;
    public TableView<Disease> examDiseaseTable;
    public TableColumn<Disease, Integer> examDiseaseIDCol;
    public TableColumn<Disease, String> examDiseaseNameCol;
    public TableColumn<Disease, String> examDiseaseSpecialityCol;
    public TableColumn<Disease, String> examDiseaseSymptomsCol;
    public TableColumn<Disease, Button> examDiseaseECol;
    public TableColumn<Disease, Button> examDiseaseDCol;
    public JFXButton examDiseaseAddBtn;
    public AnchorPane examDiseaseInPane;
    public JFXTextField examDiseaseNameField;
    public JFXTextField examDiseaseSpecialityField;
    public JFXButton examDiseaseEditBtn;
    public JFXTextArea examDiseaseSymptomsField;
    public Label examDiseaseIDLabel;
    public TableView<Medicine> examMedicineTable;
    public TableColumn<Medicine, Integer> examMedicineIDCol;
    public TableColumn<Medicine, String> examMedicineNameCol;
    public TableColumn<Medicine, String> examMedicineTypeCol;
    public TableColumn<Medicine, Integer> examMedicineDoseCol;
    public TableColumn<Medicine, String> examMedicineDiseaseCol;
    public TableColumn<Medicine, Integer> examMedicineQuantityCol;
    public TableColumn<Medicine, Button> examMedicineECol;
    public TableColumn<Medicine, Button> examMedicineDCol;
    public JFXButton examMedicineAddBtn;
    public AnchorPane examMedicineInPane;
    public JFXTextField examMedicineNameField;
    public JFXTextField examMedicineTypeField;
    public JFXTextField examMedicineDoseField;
    public JFXTextField examMedicineDiseaseField;
    public JFXButton examMedicineEditBtn;
    public Label examMedicineIDLabel;
    public TableView<Procedure> examProcedureTable;
    public TableColumn<Procedure, Integer> examProcedureIDCol;
    public TableColumn<Procedure, String> examProcedureNameCol;
    public TableColumn<Procedure, Button> examProcedureECol;
    public TableColumn<Procedure, Button> examProcedureDCol;
    public JFXTextField examProcedureAddField;
    public AnchorPane examProcedureEditPane;
    public JFXTextField examProcedureEditField;
    public Label examProcedureIDLabel;
    public Tab examDoctorNewExamTab;
    public AnchorPane examDoctorNewExamPane;
    public JFXTextField examDoctorNIDField;
    public JFXTextField examDoctorNAMKAField;
    public JFXDatePicker examDoctorNDatePicker;
    public JFXComboBox<String> examDoctorNExamField;
    public JFXComboBox<String> examDoctorNDiagnosisField;
    public JFXRadioButton examDoctorNReexamCheck;
    public AnchorPane examDoctorNReexamPane;
    public JFXTextField examDoctorNNurseField;
    public JFXComboBox<String> examDoctorNNurseExamField;
    public JFXRadioButton examDoctorNPrescriptionCheck;
    public AnchorPane examDoctorNPrescriptionPane;
    public JFXComboBox<String> examDoctorNPreNameField;
    public JFXTextField examDoctorNPreQuantityField;
    public JFXComboBox<String> examDoctorNPreTypeField;
    public JFXButton examDoctorNPreAddBtn;
    public TableView<Medicine> examDoctorNPreTable;
    public TableColumn<Medicine, String> examDoctorNPreNameCol;
    public TableColumn<Medicine, String> examDoctorNPreTypeCol;
    public TableColumn<Medicine, Integer> examDoctorNPreDoseCol;
    public TableColumn<Medicine, Integer> examDoctorNPreQuantityCol;
    public TableColumn<Medicine, Button> examDoctorNPreDCol;
    public JFXButton examDoctorNDoneBtn;
    public Label examDoctorNResultLabel;
    public Tab examDoctorReexamTab;
    public JFXButton examDoctorNClearBtn;
    public AnchorPane examDoctorReexamPane;
    public AnchorPane examDoctorReSearchPane;
    public JFXTextField examDoctorRePDEIDField;
    public JFXTextField examDoctorReDoctorIDField;
    public JFXTextField examDoctorRePatientIDField;
    public JFXTextField examDoctorReExamIDField;
    public JFXDatePicker examDoctorReOldDatePicker;
    public JFXButton examDoctorReSearchBtn;
    public AnchorPane examDoctorReMainPane;
    public Label examDoctorReDoctorIdLabel;
    public Label examDoctorRePatientIDLabel;
    public JFXDatePicker examDoctorReExamDate;
    public JFXComboBox<String> examDoctorReDiagnosisLabel;
    public JFXCheckBox examDoctorReHospitalisedCheck;
    public Label examDoctorRePrescriptionIDLabel;
    public JFXButton examDoctorReDoneBtn;
    public AnchorPane examDoctorRePrescriptionPane;
    public TableView<Medicine> examDoctorRePreTable;
    public TableColumn<Medicine, String> examDoctorReNameCol;
    public TableColumn<Medicine, String> examDoctorReTypeCol;
    public TableColumn<Medicine, Integer> examDoctorReDoseCol;
    public TableColumn<Medicine, Integer> examDoctorReQuantityCol;
    public TableColumn<Medicine, Button> examDoctorReDCol;
    public JFXRadioButton examDoctorRePreAddRadio;
    public AnchorPane examDoctorRePreAddPane;
    public JFXComboBox<String> examDoctorRePreNameField;
    public JFXComboBox<String> examDoctorRePreTypeField;
    public JFXTextField examDoctorRePreQuantityField;
    public JFXButton examDoctorRePreAddBtn;
    public AnchorPane patientPane;
    public AnchorPane staffPane;
    public AnchorPane examPane;
    public AnchorPane dbPane;
    public AnchorPane schedPane;
    public AnchorPane schedHeaderPane;
    public AnchorPane schedSearchPane;
    public JFXDatePicker schedSDatePicker;
    public TableView<Shift> schedStableView;
    public TableColumn<Shift, Integer> schedSid;
    public TableColumn<Shift, String> schedSName;
    public TableColumn<Shift, String> schedSpos;
    public TableColumn<Shift, Integer> schedSHours;
    public TableColumn<Shift, Integer> schedSTime;
    public AnchorPane tabPane;
    public JFXButton schedBtn;
    public JFXButton patientBtn;
    public JFXButton staffBtn;
    public JFXButton examBtn;
    public JFXButton dbBtn;
    public JFXButton examDoctorReCancelBtn;
    public JFXTextArea examDoctorReReport;
    public JFXComboBox<String> examDoctorReExamNameField;
    public Label examDoctorRePrevExamLabel;
    public Label examDoctorRePrevDateLabel;
    public Label examDoctorReNurseLabel;
    public Label examDoctorReNurseIDLabel;
    public Label examDoctorReIDPDELabel;
    public AnchorPane examNurseFoundPane;
    public JFXTextField examNurseIDField;
    public JFXTextArea examNurseReportField;
    public JFXButton examNurseDoneBtn;
    public JFXTextField examNurseExamNameField;
    public JFXDatePicker examNurseDateField;
    public JFXTextField examNurseIDPDEField;
    public LineChart<String, Integer> IncidentsChart;
    public JFXComboBox<Month> DB2MonthField;
    public JFXComboBox<Year> DB2YearField;
    public JFXButton DB2IncidentsBtn;
    public JFXButton DB2DiseasesBtn;
    public JFXButton DB2ExamBtn;
    public JFXButton DB2MedBtn;
    public NumberAxis ChartYAxis;
    public CategoryAxis ChartXAxis;
    public PieChart DiseasePieChart1;
    public PieChart DiseasePieChart2;
    public AnchorPane DiseasePieChartPane;
    public Label pieChartLabel;
    public JFXComboBox<Integer> DB2DayField;
    public Label pieChartLabel1;
    public AnchorPane IncidentsChartPane;
    public AnchorPane ExamPieChartPane;
    public PieChart ExamPieChart1;
    public PieChart ExamPieChart2;
    public AnchorPane MedPieChartPane;
    public PieChart MedPieChart1;
    public PieChart MedPieChart2;
    public AnchorPane DB1Pane;
    public Label DB1Date;
    public Label DB1Incidents;
    public Label DB1Doctors;
    public Label DB1Nurses;
    public Label DB1Workers;
    public Label DB1PDE;
    public Label DB1PNE;
    public Label DB1Diseases;
    public Label DB1Medicines;
    public AnchorPane DB2Pane;
    public AnchorPane DB3Pane;
    public Label DB3Cases;
    public JFXListView<String> DB3PatientList;
    public AnchorPane DB3InfoPane;
    public JFXListView<String> DB3DiseaseList;
    public Label DB3Name;
    public Label DB3Amka;
    public Label DB3Gender;
    public Label DB3Date;
    public Label DB3Address;
    public Label DB3Phone;
    public AnchorPane DB4Pane;
    public JFXDatePicker DB4DatePicker;
    public AnchorPane DB4MainPane;
    public Label DB4Date;
    public JFXListView<String> DB4StaffList;
    public AnchorPane DB4InfoPane;
    public BarChart<String,Integer> DB4Chart;
    public CategoryAxis DB4XAxis;
    public NumberAxis DB4YAxis;
    public Label DB4Hours;
    public Label DB4Shifts;
    public AnchorPane DB5Pane;
    public JFXTextArea DB5Query;
    public JFXButton DB5RunBtn;
    public AnchorPane DB5ResultPane;
    public TableView<List<String>> DB5ResultTable;
    public JFXTextArea DB5Message;
    public AnchorPane DBHeaderPane;
    public JFXButton DB1Btn;
    public JFXButton DB2Btn;
    public JFXButton DB3Btn;
    public JFXButton DB4Btn;
    public JFXButton DB5Btn;
    public FontAwesomeIconView Spinner;
    public JFXTextField staffPassword;
    public JFXTextField patientPassword;


    public void changeMainPain(ActionEvent actionEvent) {
        if(actionEvent.getSource() == schedBtn) {
            schedPane.toFront();
            populateSchedETableView(schedSDatePicker.getValue().toString());
            populateSchedSTableView(schedSDatePicker.getValue().toString());
        }
        else if(actionEvent.getSource() == patientBtn) {
            patientPane.toFront();
            patientHome();
        }
        else if(actionEvent.getSource() == staffBtn) {
            staffPane.toFront();
            staffSearchPane.toFront();
            staffHeaderPane.toFront();
        }
        else if(actionEvent.getSource() == examBtn) {
            examPane.toFront();
            examDoctorPane.toFront();
            examHeaderPane.toFront();
            examHeaderName.setText("Doctor Examination");
        }
        else if(actionEvent.getSource() == dbBtn) {
            dbPane.toFront();
            fillDB1();
            fillDB3();
            fillDB4();
        }
        tabPane.toFront();

        patientCancelUpdate();
        patientInsertErrorLabel.setVisible(false);
        patientDoctorSpecialityLabel.setVisible(false);
        patientSpecialityResultLabel.setVisible(false);
        patientSpecialityResultLabel1.setVisible(false);
        patientDoctorSpecialityLabel1.setVisible(false);

        staffNewEmployeeTabClose();
        staffCancelUpdate();
        staffInfoPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //schedule pane
        schedSDatePicker.setValue(LocalDate.now());
        schedEDatePicker.setValue(LocalDate.now());
        populateSchedSTableView(LocalDate.now().toString());
        populateSchedETableView(LocalDate.now().toString());
        //patient pane
        patientSearchBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SEARCH));
        patientSearchBtn1.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SEARCH));
        patientSexBox.getItems().addAll("Male", "Female");
        patientDateField.setValue(LocalDate.now());
        patientSexBox.setValue("Male");
        TextFields.bindAutoCompletion(patientSymptomsField, setPatientSymptomsAutoComplete());
        //staff pane
        staffSearchBtn.setGraphic( new FontAwesomeIconView(FontAwesomeIcon.SEARCH));
        staffInPosBox.getItems().addAll("Doctor", "Nurse", "Worker");
        staffInPosBox.setValue("Doctor");
        //exam pane
        //Disease
        examPopulateDiseaseTable();
        //Medicine
        examPopulateMedicineTable();
        //Procedure
        examPopulateProcedureTable();
        //Doctor
        examDoctorNDatePicker.setValue(LocalDate.now());
        TextFields.bindAutoCompletion(examDoctorNIDField, setDoctorIDAutoComplete());
        examDoctorNPrescriptionCheck.setOnAction(actionEvent -> examDoctorNPreOpenPane());
        examDoctorNReexamCheck.setOnAction(actionEvent -> examDoctorNNurseOpenPane());
        examDoctorNFillExam();
        examDoctorReOldDatePicker.setValue(LocalDate.now());
        //Statistics pane
        DB2MonthField.getItems().addAll(Month.values());
        for(int year = Year.now().getValue(); year >= 1979; year--)
            DB2YearField.getItems().add(Year.of(year));
        for(int day = 1; day<=31; day++) {
            DB2DayField.getItems().add(day);
        }
        DB2MonthField.setValue(LocalDate.now().getMonth());
        DB2DayField.setValue(LocalDate.now().getDayOfMonth());
        DB2YearField.setValue(Year.of(LocalDate.now().getYear()));
        pieChartLabel.setOnMouseClicked(mouseEvent->pieChartLabel.setVisible(false));
        pieChartLabel1.setOnMouseClicked(mouseEvent->pieChartLabel1.setVisible(false));
        DB3PatientList.setOnMouseClicked(mouseEvent -> {
            String item = DB3PatientList.getSelectionModel().getSelectedItem();
            if (item != null && !item.equals("ID\t\tDate Diagnosed"))
                DB3InfoInit(item.split("\\t")[0]);
            else DB3InfoPane.setVisible(false);
        });
        DB4DatePicker.setValue(LocalDate.now());
        DB4StaffList.setOnMouseClicked(mouseEvent -> {
            String item = DB4StaffList.getSelectionModel().getSelectedItem();
            if (item != null && !item.equals("ID\t\tName\t\tPosition Title"))
                DB4InfoInit(item.split("\\t")[0]);
            else DB4InfoPane.setVisible(false);
        });

    }




    /************ Schedule Methods ********************/

    private boolean shiftExist(String date, int id)  {
        String query = "SELECT COUNT(idEmp) FROM Shift WHERE shiftDate = '"+date+"' && idEmp = "+id;

        try {
           ResultSet set = DBUtil.dbExecuteQuery(query);
            return !set.next() || set.getInt(1) != 0;

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    public void populateSchedETableView(String Date) {

        ObservableList<Shift> shiftList = FXCollections.observableArrayList();

        String query = "Select idEmp, Name, PositionTitle from Employee";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Shift shift = new Shift();

                shift.setId(set.getInt("idEmp"));
                shift.setName(set.getString("Name"));
                shift.setPosition(set.getString("PositionTitle"));
                shift.setAvailable("Available");
                if(shiftExist(Date, shift.getId()))
                        shift.setAvailable("Unavailable");

                shiftList.add(shift);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        schedEIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        schedENameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        schedEPosCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        schedEAvailCol.setCellValueFactory(new PropertyValueFactory<>("available"));

        schedETableView.setItems(shiftList);


    }

    public void populateSchedSTableView(String Date) {

        ObservableList<Shift> shiftList = FXCollections.observableArrayList();

        String query = "Select Shift.idEmp, Name, PositionTitle, hoursOfWork, shiftStart" +
                        " from Employee, Shift" +
                        " where Shift.idEmp = Employee.idEmp && shiftDate = '" + Date +"'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Shift shift = new Shift();

                shift.setId(set.getInt("idEmp"));
                shift.setName(set.getString("Name"));
                shift.setPosition(set.getString("PositionTitle"));
                shift.setHoursOfWork(set.getInt("hoursOfWork"));
                shift.setShiftStart(set.getString("shiftStart"));

                shift.getButton().setOnAction(actionEvent -> RemoveRow(shift.getId(), Date));
                shift.getButton().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));

                shiftList.add(shift);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        schedSid.setCellValueFactory(new PropertyValueFactory<>("id"));
        schedSName.setCellValueFactory(new PropertyValueFactory<>("name"));
        schedSpos.setCellValueFactory(new PropertyValueFactory<>("position"));
        schedSHours.setCellValueFactory(new PropertyValueFactory<>("hoursOfWork"));
        schedSTime.setCellValueFactory(new PropertyValueFactory<>("shiftStart"));
        schedSRemove.setCellValueFactory(new PropertyValueFactory<>("button"));



        schedStableView.setItems(shiftList);

    }

    public void schedSDateChange() {
        schedStableView.getItems().clear();
        schedETableView.getItems().clear();
        schedEDatePicker.setValue(schedSDatePicker.getValue());
        populateSchedSTableView(schedSDatePicker.getValue().toString());
        populateSchedETableView(schedSDatePicker.getValue().toString());
    }

    public void schedEDateChange() {
        schedETableView.getItems().clear();
        schedStableView.getItems().clear();
        schedSDatePicker.setValue(schedEDatePicker.getValue());
        populateSchedETableView(schedEDatePicker.getValue().toString());
        populateSchedSTableView(schedSDatePicker.getValue().toString());
    }

    public void insertShift() {

        String idEmp = schedIdField.getText();
        String hours = schedHoursField.getText();
        String start = schedStartTimeField.getText();
        String date = schedEDatePicker.getValue().toString();


        String query = "INSERT INTO Shift(idEmp, shiftDate, shiftStart, hoursOfWork) " +
                        "VALUES("+idEmp+" ,'"+date+"','"+start+"', "+hours+")";

        try {
            DBUtil.dbExecuteUpdate(query);
            schedFlag.setText("Success");
            schedFlag.setTextFill(Color.GREEN);
        } catch (SQLException | ClassNotFoundException throwable) {
            schedFlag.setText("Error");
            schedFlag.setTextFill(Color.RED);
        }

        if(schedSDatePicker.getValue().toString().equals(date)) {
            populateSchedSTableView(schedSDatePicker.getValue().toString());
            populateSchedETableView(schedEDatePicker.getValue().toString());
        }
    }

    private void RemoveRow(int id, String date) {

        String query = "DELETE FROM Shift WHERE idEmp = "+id+" && shiftDate='"+date+"'";

        try {
            DBUtil.dbExecuteUpdate(query);
            populateSchedSTableView(date);
            if(schedEDatePicker.getValue().toString().equals(date))
                populateSchedETableView(date);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }




    /*********** Patient Methods *********************/

    public void patientHome() {
        patientSearchPane.toFront();
        tabPane.toFront();
        patientCancelUpdate();
        patientInsertErrorLabel.setVisible(false);
        patientSpecialityResultLabel.setVisible(false);
        patientDoctorSpecialityLabel.setVisible(false);
        patientDoctorSpecialityLabel1.setVisible(false);
        patientSpecialityResultLabel1.setVisible(false);
        patientSymptomsField.clear();
        patientSearchField.clear();
    }

    public void patientSearch() {

        patientCancelUpdate();

        if(patientSearchField.getText().isEmpty()) {
            patientErrorLabel.setVisible(true);
            return;
        }

        String exist = "SELECT COUNT(AMKA) FROM Patient WHERE AMKA = " + patientSearchField.getText();

        try {
            ResultSet set = DBUtil.dbExecuteQuery(exist);
            if(set.next() && set.getInt(1) == 0) {
                patientCreatePane.toFront();
                patientErrorLabel.setVisible(true);
            } else {
                patientFoundPane.toFront();
                patientErrorLabel.setVisible(false);
                patientFoundPaneInit(patientSearchField.getText());
            }
            tabPane.toFront();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void patientFoundPaneInit(String amka) {

        String query = "Select * from Patient where AMKA="+amka;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                patientIdLabel.setText(amka);
                patientNameLabel.setText(set.getString("Name"));
                if(set.getString("Sex").equals("M"))
                    patientSexLabel.setText("Male");
                else
                    patientSexLabel.setText("Female");
                patientDateLabel.setText(set.getString("DateOfBirth"));
                patientInsurLabel.setText(set.getString("Insurance"));
                patientAddreLabel.setText(set.getString("Address"));
                patientPhoneLabel.setText(set.getString("Phone"));
                patientPrescripView.getItems().clear();
                populatePatientRecordTable(amka);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }


    }

    public void patientInsert() {

        String AMKA = patientIdField.getText();
        String name = patientNameField.getText();
        String date = patientDateField.getValue().toString();
        String insurance = patientInsurField.getText();
        String address = patientAddreField.getText();
        String phone = patientPhoneField.getText();
        String sex;
        if(patientSexBox.getValue().equals("Male")) sex = "M";
        else sex = "F";

        String query = "INSERT INTO Patient VALUES("+AMKA+",'"+name+"','"+sex+"','"+date+"',"+insurance+",'"+address+"','"+phone+"')";

        try {
            DBUtil.dbExecuteUpdate(query);
            patientInsertErrorLabel.setVisible(false);
            patientFoundPane.toFront();
            patientErrorLabel.setVisible(false);
            patientFoundPaneInit(AMKA);
        } catch (SQLException | ClassNotFoundException throwable) {
            patientInsertErrorLabel.setVisible(true);
            patientInsertErrorLabel.setText("Error");
            patientInsertErrorLabel.setTextFill(Color.RED);
        }
    }

    public void patientUpdate() {
        //set labels invisible
        patientNameLabel.setVisible(false);
        patientSexLabel.setVisible(false);
        patientDateLabel.setVisible(false);
        patientInsurLabel.setVisible(false);
        patientAddreLabel.setVisible(false);
        patientPhoneLabel.setVisible(false);
        //set text fields visible
        patientUNameField.setVisible(true);
        patientUsexField.setVisible(true);
        patientUDateField.setVisible(true);
        patientUInsField.setVisible(true);
        patientUAddrField.setVisible(true);
        patientUPhoneField.setVisible(true);
        //set text fields values as the labels
        patientUNameField.setText(patientNameLabel.getText());
        patientUsexField.setText(patientSexLabel.getText());
        patientUDateField.setText(patientDateLabel.getText());
        patientUInsField.setText(patientInsurLabel.getText());
        patientUAddrField.setText(patientAddreLabel.getText());
        patientUPhoneField.setText(patientPhoneLabel.getText());
        //change button text to Done
        patientUpdateBtn.setText("Done");
        //set button action to reverseUpdate
        patientUpdateBtn.setOnAction(actionEvent -> patientReverseUpdate());
    }

    public void patientReverseUpdate() {
        //get info from text fields
        String amka = patientIdLabel.getText();
        String name = patientUNameField.getText();
        String sex  = patientUsexField.getText();
        String date = patientUDateField.getText();
        String insurance = patientUInsField.getText();
        String addr = patientUAddrField.getText();
        String phone = patientUPhoneField.getText();
        String s;
        if(sex.equals("Male")) s = "M";
        else s = "F";
        //execute query update
        String query = "Update Patient Set Name='"+name+"', Sex='"+s+"',DateOfBirth='"+date+"',Insurance="+insurance+
                        ",Address='"+addr+"',Phone='"+phone+"' Where AMKA="+amka;

        try {
            DBUtil.dbExecuteUpdate(query);
            patientUErrorLabel.setVisible(true);
            patientUErrorLabel.setText("Success");
            patientUErrorLabel.setTextFill(Color.GREEN);
            //reverse back to labels
            patientNameLabel.setText(name);
            patientSexLabel.setText(sex);
            patientDateLabel.setText(date);
            patientInsurLabel.setText(insurance);
            patientAddreLabel.setText(addr);
            patientPhoneLabel.setText(phone);
            //set label visible
            patientNameLabel.setVisible(true);
            patientSexLabel.setVisible(true);
            patientDateLabel.setVisible(true);
            patientInsurLabel.setVisible(true);
            patientAddreLabel.setVisible(true);
            patientPhoneLabel.setVisible(true);
            //set field invisible
            patientUNameField.setVisible(false);
            patientUsexField.setVisible(false);
            patientUDateField.setVisible(false);
            patientUInsField.setVisible(false);
            patientUAddrField.setVisible(false);
            patientUPhoneField.setVisible(false);
            //reverse update button
            patientUpdateBtn.setText("Update");
            patientUpdateBtn.setOnAction(actionEvent -> patientUpdate());

        } catch (SQLException | ClassNotFoundException throwable) {
            patientUErrorLabel.setVisible(true);
            patientUErrorLabel.setText("Error");
            patientUErrorLabel.setTextFill(Color.RED);
        }
    }

    public void patientCancelUpdate() {
        patientNameLabel.setVisible(true);
        patientSexLabel.setVisible(true);
        patientDateLabel.setVisible(true);
        patientInsurLabel.setVisible(true);
        patientAddreLabel.setVisible(true);
        patientPhoneLabel.setVisible(true);
        //set field invisible
        patientUNameField.setVisible(false);
        patientUsexField.setVisible(false);
        patientUDateField.setVisible(false);
        patientUInsField.setVisible(false);
        patientUAddrField.setVisible(false);
        patientUPhoneField.setVisible(false);
        //reverse update button
        patientUpdateBtn.setText("Update");
        patientUpdateBtn.setOnAction(actionEvent -> patientUpdate());
    }

    private void populatePatientRecordTable(String amka) {

        ObservableList<Patient> patientList = FXCollections.observableArrayList();

        String query = "Select r.DateDiagnosed, r.Diagnosis, e.Name, emp.Name, doc.Speciality, PDE.toHospitalise, PDE.idPrescription" +
                " From Doctor doc, Exam e, Record r, PDE, Employee emp" +
                " Where r.idPatient="+amka+" && PDE.idPatient=r.idPatient && PDE.Diagnosis=r.Diagnosis && emp.idEmp=doc.idDoctor" +
                " && doc.idDoctor=PDE.idDoctor && e.idExam=PDE.idExam && r.DateDiagnosed=PDE.OperationDate";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Patient patient = new Patient();

                patient.setDate(set.getString(1));
                patient.setDisease(set.getString(2));
                patient.setExam(set.getString(3));
                patient.setDiagnosedBy(set.getString(4));
                patient.setSpeciality(set.getString(5));
                patient.setHospitalised(set.getBoolean(6));
                patient.setPrescription(set.getInt(7));

                String perscription = "Select Name, Quantity, Dose, Type From Medicine m, Prescription p " +
                                        "Where p.idMedicine=m.idMedicine && p.idPrescription="+patient.getPrescription();
                ResultSet s = DBUtil.dbExecuteQuery(perscription);
                ArrayList<Medicine> med = new ArrayList<>();
                while(s.next()) {
                    Medicine m = new Medicine();
                    m.setName(s.getString(1));
                    m.setQuantity(s.getInt(2));
                    m.setDose(s.getInt(3));
                    m.setType(s.getString(4));
                    med.add(m);
                }
                patient.setMedicine(med);

                patientList.add(patient);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientDiseaseCol.setCellValueFactory(new PropertyValueFactory<>("disease"));
        patientExamCol.setCellValueFactory(new PropertyValueFactory<>("exam"));
        patientByCol.setCellValueFactory(new PropertyValueFactory<>("diagnosedBy"));
        patientSpecialityCol.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        patientHospitalisedCol.setCellValueFactory(new PropertyValueFactory<>("hospitalised"));

        patientRecordView.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty())
                    populatePatientPrescripTable(row.getItem().getMedicine());

            });
            return row;
        });

        patientRecordView.setItems(patientList);
    }

    public void populatePatientPrescripTable(ArrayList<Medicine> meds) {
        ObservableList<Medicine> medList = FXCollections.observableArrayList();
        medList.addAll(meds);

        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientDiseaseCol.setCellValueFactory(new PropertyValueFactory<>("disease"));
        patientExamCol.setCellValueFactory(new PropertyValueFactory<>("exam"));
        patientByCol.setCellValueFactory(new PropertyValueFactory<>("diagnosedBy"));

        patientMedicineCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        patientQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        patientDoseCol.setCellValueFactory(new PropertyValueFactory<>("dose"));
        patientTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        patientPrescripView.setItems(medList);
    }

    public ArrayList<String> setPatientSymptomsAutoComplete() {

        ArrayList<String> suggestions = new ArrayList<>();

        String query = "Select Symptoms From Disease";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            while (set.next()) {
                suggestions.add(set.getString("Symptoms"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return suggestions;
    }

    public void patientRecommend() {
        String symptoms = patientSymptomsField.getText();
        String query = "Select Doctor.Speciality, Employee.Name From Disease, Doctor, Employee Where Symptoms = '"+symptoms+
                        "' && Doctor.Speciality = Disease.Speciality && idDoctor=idEmp";

        try {
           ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                patientDoctorSpecialityLabel.setVisible(true);
                patientSpecialityResultLabel.setVisible(true);
                patientSpecialityResultLabel1.setVisible(true);
                patientDoctorSpecialityLabel1.setVisible(true);
                patientSpecialityResultLabel.setText(set.getString("Speciality"));
                patientSpecialityResultLabel1.setText(set.getString("Name"));
            }else {
                patientDoctorSpecialityLabel.setVisible(false);
                patientSpecialityResultLabel.setVisible(false);
                patientSpecialityResultLabel1.setVisible(false);
                patientDoctorSpecialityLabel1.setVisible(false);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            patientDoctorSpecialityLabel.setVisible(false);
            patientSpecialityResultLabel.setVisible(false);
            patientSpecialityResultLabel1.setVisible(false);
            patientDoctorSpecialityLabel1.setVisible(false);
        }
    }




    /*********** Staff Methods *********************/

    public void staffShowAllTab() {
        staffAllStaffPane.toFront();
        staffHeaderPane.toFront();
        tabPane.toFront();

        staffAllView.getItems().clear();
        populateStaffTable();
        staffNewEmployeeTabClose();
        staffCancelUpdate();
    }

    private void populateStaffTable() {

        ObservableList<Staff> staffList = FXCollections.observableArrayList();

        String query = "Select * From Employee";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Staff staff = new Staff();

                staff.setId(set.getInt("idEmp"));
                staff.setName(set.getString("Name"));
                staff.setPhone(set.getString("Phone"));
                staff.setAddr(set.getString("Address"));
                staff.setTitle(set.getString("PositionTitle"));
                switch (set.getString("Position")) {
                    case "D" -> staff.setPos("Doctor");
                    case "N" -> staff.setPos("Nurse");
                    case "W" -> staff.setPos("Worker");
                    default -> staff.setPos("Unknown");
                }

                staff.getButton().setOnAction(actionEvent -> staffRemoveRow(staff.getId(), staff.getPos()));
                staff.getButton().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));

                staffList.add(staff);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffPosCol.setCellValueFactory(new PropertyValueFactory<>("pos"));
        staffPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        staffAddrCol.setCellValueFactory(new PropertyValueFactory<>("addr"));
        staffTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        staffDelCol.setCellValueFactory(new PropertyValueFactory<>("button"));

        staffAllView.setItems(staffList);
    }

    private void staffRemoveRow(int id, String pos) {

        try {
            //remove from shift
            DBUtil.dbExecuteUpdate("Delete From Shift Where idEmp="+id);
            //remove from pde or pne
            if(pos.equals("Doctor")) {
                DBUtil.dbExecuteUpdate("Delete From PDE where idDoctor="+id);
            }else if(pos.equals("Nurse")) {
                DBUtil.dbExecuteUpdate("Delete From PNE Where idNurse="+id);
            }
            // remove from doctor or nurse
            if(!pos.equals("Worker"))
                DBUtil.dbExecuteUpdate( "Delete From "+pos+" Where id"+pos+"="+id);
            // remove from employee
            DBUtil.dbExecuteUpdate("Delete From Employee Where idEmp="+id);
            populateStaffTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    public void staffNewEmployeeTab() {
        if(staffInsertNewPane.isVisible())
            staffNewEmployeeTabClose();
        else {
            tabPane.toFront();
            staffInsertNewPane.setVisible(true);
            staffHeaderPane.toFront();
            staffNewEmpBtn.setText("Hide");
        }
    }

    public void staffSearchTab() {
        staffSearchPane.toFront();
        staffInfoPane.setVisible(false);
        staffHeaderPane.toFront();
        tabPane.toFront();

        staffNewEmployeeTabClose();
        staffCancelUpdate();
    }

    public void staffInsert() throws SQLException, ClassNotFoundException {

        String name = staffInNameField.getText();
        String phone = staffInPhoneField.getText();
        String addr = staffInAddrField.getText();
        String pos = staffInPosBox.getValue();
        String title = staffInTitleField.getText();

        switch (pos) {
            case "Doctor" -> pos = "D";
            case "Nurse" -> pos = "N";
            case "Worker" -> pos = "W";
        }

        String query = "Insert Into Employee(Name, Phone, Address, Position, PositionTitle) " +
                        "Values('"+name+"','"+phone+"','"+addr+"','"+pos+"','"+title+"')";

        try {
            DBUtil.dbExecuteUpdate(query);
            String query1 = null;
            switch (pos) {
                case "D" -> query1 = "Insert Into Doctor Values((Select idEmp From Employee Where Name='"+name+"' && Phone='"+phone+"'),'"+title+"')";
                case "N" -> query1 = "Insert Into Nurse Values((Select idEmp From Employee Where Name='"+name+"' && Phone='"+phone+"'))";
            }
            if(query1 != null)
                DBUtil.dbExecuteUpdate(query1);

            staffNewEmployeeTabClose();
            populateStaffTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            DBUtil.dbExecuteUpdate("Delete From Employee Where idEmp="+(findAutoIncrementID("Employee")-1));
            staffInError.setVisible(true);
        }
    }

    private void staffNewEmployeeTabClose() {
        staffNewEmpBtn.setText("New Employee");
        staffInsertNewPane.setVisible(false);
        staffInNameField.clear();
        staffInTitleField.clear();
        staffInAddrField.clear();
        staffInPhoneField.clear();
        staffInError.setVisible(false);
    }

    public void staffSearch() {

        staffCancelUpdate();
        if(staffSearchField.getText().isEmpty())
            return;

        String query = "Select * From Employee Where idEmp = " + staffSearchField.getText();

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                staffNameLabel.setText(set.getString("Name"));
                staffIdLabel.setText(set.getString("idEmp"));
                staffPhoneLabel.setText(set.getString("Phone"));
                staffAddrLabel.setText(set.getString("Address"));
                staffTitleLabel.setText(set.getString("PositionTitle"));
                switch (set.getString("Position")) {
                    case "D" -> staffPosLabel.setText("Doctor");
                    case "N" -> staffPosLabel.setText("Nurse");
                    case "W" -> staffPosLabel.setText("Worker");
                }
                staffInfoPane.setVisible(true);
                staffSearchError.setVisible(false);
            }else {
                staffInfoPane.setVisible(false);
                staffSearchError.setVisible(true);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    public void staffUpdate() {
        staffNameLabel.setVisible(false);
        staffPhoneLabel.setVisible(false);
        staffAddrLabel.setVisible(false);
        staffPosLabel.setVisible(false);
        staffTitleLabel.setVisible(false);

        staffNameField.setVisible(true);
        staffPhoneField.setVisible(true);
        staffAddrField.setVisible(true);
        staffPosField.setVisible(true);
        staffTitleField.setVisible(true);

        staffNameField.setText(staffNameLabel.getText());
        staffPhoneField.setText(staffPhoneLabel.getText());
        staffTitleField.setText(staffTitleLabel.getText());
        staffPosField.setText(staffPosLabel.getText());
        staffAddrField.setText(staffAddrLabel.getText());

        staffUpdateBtn.setText("Done");
        staffUpdateBtn.setOnAction(actionEvent -> staffReverseUpdate());
    }

    private void staffReverseUpdate() {
        String name = staffNameField.getText();
        String phone = staffPhoneField.getText();
        String addr = staffAddrField.getText();
        String pos = staffPosField.getText();
        String title = staffTitleField.getText();

        if(name.isEmpty() || pos.isEmpty() || title.isEmpty()) {
            staffUpdateError.setVisible(true);
            return;
        }

        switch (pos) {
            case "Doctor" -> pos = "D";
            case "Nurse" -> pos = "N";
            case "Worker" -> pos = "W";
        }
        String query = "Update Employee Set Name='"+name+"',Phone='"+phone+"',Address='"+addr+"',Position='"+pos+"',PositionTitle='"+title+"'"+
                        "Where idEmp = " + staffIdLabel.getText();

        try {
            DBUtil.dbExecuteUpdate(query);
            staffUpdateError.setVisible(false);

            staffNameLabel.setText(staffNameField.getText());
            staffPhoneLabel.setText(staffPhoneField.getText());
            staffTitleLabel.setText(staffTitleField.getText());
            staffPosLabel.setText(staffPosField.getText());
            staffAddrLabel.setText(staffAddrField.getText());

            staffNameField.setVisible(false);
            staffPhoneField.setVisible(false);
            staffAddrField.setVisible(false);
            staffPosField.setVisible(false);
            staffTitleField.setVisible(false);

            staffNameLabel.setVisible(true);
            staffPhoneLabel.setVisible(true);
            staffAddrLabel.setVisible(true);
            staffPosLabel.setVisible(true);
            staffTitleLabel.setVisible(true);

            staffUpdateBtn.setText("Update");
            staffUpdateBtn.setOnAction(actionEvent -> staffUpdate());

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            staffUpdateError.setVisible(true);
        }
    }

    private void staffCancelUpdate() {
        staffNameField.setVisible(false);
        staffPhoneField.setVisible(false);
        staffAddrField.setVisible(false);
        staffPosField.setVisible(false);
        staffTitleField.setVisible(false);

        staffNameLabel.setVisible(true);
        staffPhoneLabel.setVisible(true);
        staffAddrLabel.setVisible(true);
        staffPosLabel.setVisible(true);
        staffTitleLabel.setVisible(true);

        staffUpdateBtn.setText("Update");
        staffUpdateBtn.setOnAction(actionEvent -> staffUpdate());

        staffUpdateError.setVisible(false);
    }




    /*********** Examination Methods ****************/
    public void changeExamTabs(ActionEvent actionEvent) {

        if(actionEvent.getSource() == examDiseaseBtn) {
            examDiseasePane.toFront();
            examHeaderName.setText("Diseases");
            examPopulateDiseaseTable();
        }else if(actionEvent.getSource() == examMedBtn) {
            examMedicinePane.toFront();
            examHeaderName.setText("Medicines");
            examPopulateMedicineTable();
        }else if(actionEvent.getSource() == examProcedureBtn) {
            examProcedurePane.toFront();
            examHeaderName.setText("Procedures");
            examPopulateProcedureTable();
        }else if(actionEvent.getSource() == examDoctorBtn) {
            examDoctorPane.toFront();
            examHeaderName.setText("Doctor Examination");
        }else if(actionEvent.getSource() == examNurseBtn) {
            examNursePane.toFront();
            examHeaderName.setText("Nurse Examination");
        }
        examHeaderPane.toFront();
        tabPane.toFront();
    }

    public ArrayList<String> setDoctorIDAutoComplete() {
        ArrayList<String> suggestions = new ArrayList<>();

        String date = examDoctorNDatePicker.getValue().toString();
        String query = "Select e.idEmp From Employee e,Shift s,Doctor d Where e.idEmp=s.idEmp && d.idDoctor=e.idEmp && shiftDate='"+date+"'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            while (set.next()) {
                suggestions.add(set.getString("idEmp"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return suggestions;
    }

    /************* Disease ***********/
    public void examDiseaseAddNew() {
        examDiseaseInPane.setVisible(true);
        examDiseaseClearFields();
        examDiseaseEditBtn.setText("Add");
        examDiseaseIDLabel.setVisible(false);
    }

    public void examDiseaseClosePane() {
        examDiseaseInPane.setVisible(false);
        examDiseaseClearFields();
    }

    private void examDiseaseClearFields() {
        examDiseaseNameField.clear();
        examDiseaseSpecialityField.clear();
        examDiseaseSymptomsField.clear();
    }

    public void examDiseaseComplete() {

        String name = examDiseaseNameField.getText();
        String speciality = examDiseaseSpecialityField.getText();
        String symptoms = examDiseaseSymptomsField.getText();
        String[] id = examDiseaseIDLabel.getText().split("#");
        String query = "";
        if(id.length == 2)
            query = "Update Disease Set Name='"+name+"',Speciality='"+speciality+"',Symptoms='"+symptoms+"' Where idDisease="+id[1];
        String query1 = "Insert Into Disease(Name,Speciality,Symptoms) Values('"+name+"','"+speciality+"','"+symptoms+"')";

        try {
            if(examDiseaseEditBtn.getText().equals("Edit"))
                DBUtil.dbExecuteUpdate(query);
            else
                DBUtil.dbExecuteUpdate(query1);
            examDiseaseClosePane();
            examPopulateDiseaseTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examPopulateDiseaseTable() {

        ObservableList<Disease> diseaseList = FXCollections.observableArrayList();

        String query = "Select * From Disease";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {

                if(set.getInt("idDisease") == -1) continue;

                Disease disease = new Disease();

                disease.setId(set.getInt("idDisease"));
                disease.setName(set.getString("Name"));
                disease.setSpeciality(set.getString("Speciality"));
                disease.setSymptoms(set.getString("Symptoms"));
                disease.getD().setOnAction(actionEvent -> examDiseaseRemoveRow(disease.getId()));
                disease.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
                disease.getE().setOnAction(actionEvent -> examDiseaseEditRow(disease.getId()));
                disease.getE().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.EDIT));

                diseaseList.add(disease);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        examDiseaseIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        examDiseaseNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        examDiseaseSpecialityCol.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        examDiseaseSymptomsCol.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        examDiseaseECol.setCellValueFactory(new PropertyValueFactory<>("e"));
        examDiseaseDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

        examDiseaseTable.setItems(diseaseList);
    }

    private void examDiseaseEditRow(int id) {
        examDiseaseInPane.setVisible(true);
        examDiseaseEditBtn.setText("Edit");
        examDiseaseIDLabel.setVisible(true);
        examDiseaseIDLabel.setText("ID: #");

        String query = "Select * from Disease Where idDisease="+id;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                examDiseaseIDLabel.setText(examDiseaseIDLabel.getText() + id);
                examDiseaseNameField.setText(set.getString("Name"));
                examDiseaseSpecialityField.setText(set.getString("Speciality"));
                examDiseaseSymptomsField.setText(set.getString("Symptoms"));
                examPopulateDiseaseTable();

            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examDiseaseRemoveRow(int id) {
        String query = "Delete From Disease Where idDisease="+id;
        String query2 = "Update Medicine Set idDisease=-1 Where idDisease="+id;

        try {
            DBUtil.dbExecuteUpdate(query2);
            DBUtil.dbExecuteUpdate(query);
            examPopulateDiseaseTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    /************* Medicine ***********/
    public void examMedicineAddNew() {
        examMedicineInPane.setVisible(true);
        examMedicineClearFields();
        examMedicineEditBtn.setText("Add");
        examMedicineIDLabel.setVisible(false);
    }

    private void examMedicineClearFields() {
        examMedicineNameField.clear();
        examMedicineTypeField.clear();
        examMedicineDoseField.clear();
        examMedicineDiseaseField.clear();
    }

    public void examMedicineClosePane() {
        examMedicineInPane.setVisible(false);
        examMedicineClearFields();
    }

    public void examMedicineComplete() {
        String[] id = examMedicineIDLabel.getText().split("#");
        String name = examMedicineNameField.getText();
        String type = examMedicineTypeField.getText();
        String dose = examMedicineDoseField.getText();
        String disease = examMedicineDiseaseField.getText();
        String query = null;
        if(id.length == 2)
            query = "Update Medicine Set Name='"+name+"',Type='"+type+"',Dose="+dose+",idDisease="+disease+" Where idMedicine="+id[1];
        String query1 = "Insert Into Medicine(Name,Type,Dose,idDisease) Values('"+name+"','"+type+"',"+dose+","+disease+")";

        try {
            if(examMedicineEditBtn.getText().equals("Edit"))
                DBUtil.dbExecuteUpdate(query);
            else
                DBUtil.dbExecuteUpdate(query1);
            examMedicineClosePane();
            examPopulateMedicineTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examPopulateMedicineTable() {

        ObservableList<Medicine> medicineList = FXCollections.observableArrayList();

        String query = "Select * From Medicine";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Medicine medicine = new Medicine();

                medicine.setId(set.getInt("idMedicine"));
                medicine.setName(set.getString("Name"));
                medicine.setType(set.getString("Type"));
                medicine.setDose(set.getInt("Dose"));

                String query2 = "Select Name From Disease Where idDisease="+set.getInt("idDisease");
                ResultSet set1 = DBUtil.dbExecuteQuery(query2);
                if(set1.next())
                    medicine.setDisease(set1.getString("Name"));

                String query3 = "Select SUM(Quantity) from Prescription p, Medicine e where p.idMedicine=e.idMedicine && e.idMedicine="+medicine.getId();
                ResultSet set2 = DBUtil.dbExecuteQuery(query3);
                if(set2.next())
                    medicine.setQuantity(set2.getInt(1));

                medicine.getD().setOnAction(actionEvent -> examMedicineRemoveRow(medicine.getId()));
                medicine.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
                medicine.getE().setOnAction(actionEvent -> examMedicineEditRow(medicine.getId()));
                medicine.getE().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.EDIT));

                medicineList.add(medicine);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        examMedicineIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        examMedicineNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        examMedicineTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        examMedicineDoseCol.setCellValueFactory(new PropertyValueFactory<>("dose"));
        examMedicineDiseaseCol.setCellValueFactory(new PropertyValueFactory<>("disease"));
        examMedicineQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        examMedicineECol.setCellValueFactory(new PropertyValueFactory<>("e"));
        examMedicineDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

        examMedicineTable.setItems(medicineList);
    }

    private void examMedicineEditRow(int id) {
        examMedicineInPane.setVisible(true);
        examMedicineEditBtn.setText("Edit");
        examMedicineIDLabel.setVisible(true);
        examMedicineIDLabel.setText("ID: #");

        String query = "Select * from Medicine Where idMedicine="+id;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                examMedicineIDLabel.setText(examMedicineIDLabel.getText() + id);
                examMedicineNameField.setText(set.getString("Name"));
                examMedicineTypeField.setText(set.getString("Type"));
                examMedicineDoseField.setText(set.getString("Dose"));
                examMedicineDiseaseField.setText(set.getString("idDisease"));
                examPopulateMedicineTable();
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examMedicineRemoveRow(int id) {
        String query = "Delete From Medicine Where idMedicine="+id;
        String pde = "Select distinct idPrescription From Prescription Where idMedicine="+id;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(pde);
            while(set.next()) {

                ResultSet set1 = DBUtil.dbExecuteQuery("Select idMedicine From Prescription Where idPrescription="+
                        set.getString("idPrescription")+" && idMedicine!="+id);
                if(!set1.next()) {
                    DBUtil.dbExecuteUpdate("Delete From PDE Where idPrescription="+ set.getString("idPrescription"));
                }

                DBUtil.dbExecuteUpdate("Delete From Prescription Where idMedicine="+id
                        +" && idPrescription="+set.getString("idPrescription"));
            }
            DBUtil.dbExecuteUpdate(query);
            examPopulateMedicineTable();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    /************* Procedure ***********/
    public void examProcedureAdd() {
        String name = examProcedureAddField.getText();
        String query = "Insert Into Exam(Name) Values('"+name+"')";

        try {
            DBUtil.dbExecuteUpdate(query);
            examPopulateProcedureTable();
            examDoctorNFillExam();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examPopulateProcedureTable() {
        ObservableList<Procedure> procedureList = FXCollections.observableArrayList();

        String query = "Select * From Exam";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);

            while(set.next()) {
                Procedure procedure = new Procedure();

                procedure.setId(set.getInt("idExam"));
                procedure.setName(set.getString("Name"));
                procedure.getD().setOnAction(actionEvent -> examProcedureRemoveRow(procedure.getId()));
                procedure.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
                procedure.getE().setOnAction(actionEvent -> examProcedureEditRow(procedure.getId()));
                procedure.getE().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.EDIT));

                procedureList.add(procedure);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        examProcedureIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        examProcedureNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        examProcedureECol.setCellValueFactory(new PropertyValueFactory<>("e"));
        examProcedureDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

        examProcedureTable.setItems(procedureList);
    }

    private void examProcedureEditRow(int id) {
        examProcedureEditPane.setVisible(true);
        examProcedureIDLabel.setText("ID: #" + id);

        String query = "select Name from Exam where idExam="+id;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                examProcedureEditField.setText(set.getString("Name"));
                examDoctorNFillExam();
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examProcedureRemoveRow(int id) {
        String query = "Delete From Exam Where idExam="+id;
        String q = "Delete From PDE Where idExam="+id;
        String q1 = "Delete From PNE Where idExam="+id;

        try {
            DBUtil.dbExecuteUpdate(q);
            DBUtil.dbExecuteUpdate(q1);
            DBUtil.dbExecuteUpdate(query);
            examPopulateProcedureTable();
            examDoctorNFillExam();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examProcedureEdit() {
        String id = examProcedureIDLabel.getText().split("#")[1];
        String name = examProcedureEditField.getText();
        String query = "Update Exam Set Name = '"+name+"' Where idExam="+id;

        try {
            DBUtil.dbExecuteUpdate(query);
            examPopulateProcedureTable();
            examProcedureEditPane.setVisible(false);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    /*********** Doctor Form ****************/
    ObservableList<Medicine> medList = FXCollections.observableArrayList();
    ObservableList<Medicine> medListR = FXCollections.observableArrayList();

    private void examDoctorNPreOpenPane() {
        if(!examDoctorNPrescriptionCheck.isSelected()) {
            examDoctorNPrescriptionPane.setVisible(false);
            examDoctorNPreNameField.setValue("");
            examDoctorNPreQuantityField.clear();
            examDoctorNPreTypeField.setValue("");
        }else {
            examDoctorNPrescriptionPane.setVisible(true);
        }
    }

    private void examDoctorNNurseOpenPane() {
        if(!examDoctorNReexamCheck.isSelected()) {
            examDoctorNReexamPane.setVisible(false);
            examDoctorNNurseField.clear();
            examDoctorNNurseExamField.setValue("");
        }else {
            examDoctorNReexamPane.setVisible(true);
        }
    }

    public void examDoctorNFillExam() {
        String procedureName = "Select Name From Exam";

        try {
            ResultSet set1 = DBUtil.dbExecuteQuery(procedureName);

            examDoctorNExamField.getItems().clear();
            examDoctorNNurseExamField.getItems().clear();

            while(set1.next()) {
                examDoctorNExamField.getItems().add(set1.getString("Name"));
                examDoctorNNurseExamField.getItems().add(set1.getString("Name"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorNFillDiagnosis() {

        String id = examDoctorNIDField.getText();
        if(id.isEmpty()) return;
        String diagnosisName = "Select Name From Disease Where Speciality=(Select Speciality From Doctor Where idDoctor="+id+")";

        examDoctorNDiagnosisField.getItems().clear();
        examDoctorNDiagnosisField.getItems().addAll("Healthy", "Unknown");
        try {
            ResultSet set = DBUtil.dbExecuteQuery(diagnosisName);
            while(set.next()) {
                examDoctorNDiagnosisField.getItems().add(set.getString("Name"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorNFillMedicine() {

        String diagnosis = examDoctorNDiagnosisField.getValue();
        if(diagnosis==null || diagnosis.equals("Healthy") || diagnosis.equals("Unknown")) {
            examDoctorNPreNameField.getItems().clear();
            examDoctorNPreTypeField.getItems().clear();
        }
        medList.clear();
        examDoctorNPreTable.getItems().clear();

        String medicines ="Select distinct m.Name From Disease d,Medicine m Where m.idDisease=d.idDisease && d.Name='"+diagnosis+"'";

        examDoctorNPreNameField.getItems().clear();
        try {
            ResultSet set = DBUtil.dbExecuteQuery(medicines);
            while(set.next()) {
                examDoctorNPreNameField.getItems().add(set.getString("Name"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorNFillType() {

        String medicine = examDoctorNPreNameField.getValue();
        if(medicine == null) return;
        String types = "Select distinct Type From Medicine Where Name = '"+medicine+"'";

        examDoctorNPreTypeField.getItems().clear();
        try {
            ResultSet set = DBUtil.dbExecuteQuery(types);
            while(set.next()) {
                examDoctorNPreTypeField.getItems().add(set.getString("Type"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    public void examDoctorNComplete() throws SQLException, ClassNotFoundException {

        String doctorID = examDoctorNIDField.getText();
        String patientID = examDoctorNAMKAField.getText();
        String date = examDoctorNDatePicker.getValue().toString();
        String exam = examDoctorNExamField.getValue();
        String diagnosis = examDoctorNDiagnosisField.getValue();
        String idNurse = "NULL", nurseExam = "NULL", idPrescription = "NULL", idPNE = "NULL", idExam = "NULL", idNurseExam = "NULL";

        if(examDoctorNReexamCheck.isSelected()) {
            idNurse = examDoctorNNurseField.getText();
            nurseExam = examDoctorNNurseExamField.getValue();
            idPNE = String.valueOf(findAutoIncrementID("PNE"));
        }

        if(examDoctorNPrescriptionCheck.isSelected() && !medList.isEmpty()) {
            idPrescription = String.valueOf(findAutoIncrementID("Prescription"));
        }

        try {
            String findExamID = "Select idExam From Exam Where Name='"+exam+"'";
            String findNurseExam = "Select idExam From Exam Where Name='"+nurseExam+"'";
            ResultSet set = DBUtil.dbExecuteQuery(findExamID);
            ResultSet set1 = DBUtil.dbExecuteQuery(findNurseExam);
            if(set.next())
                idExam = set.getString(1);
            if(set1.next())
                idNurseExam = set1.getString(1);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return;
        }

        String query = "Insert Into PDE(idPatient,idDoctor,idExam,idPrescription,idPNE,Diagnosis,OperationDate) "+
                        "Values("+patientID+","+doctorID+","+idExam+","+idPrescription+","+idPNE+",'"+diagnosis+"','"+date+"')";

        String query1 = "Insert Into PNE(idPNE,idNurse,idExam) Values("+idPNE+","+idNurse+","+idNurseExam+")";

        String newPatientRecord = "Insert Into Record(idPatient, Diagnosis, DateDiagnosed) VALUES("+patientID+",'"+diagnosis+"','"+date+"')";

        try {
            if(examDoctorNPrescriptionCheck.isSelected() && !medList.isEmpty()) {
                for (Medicine med : medList) {
                    DBUtil.dbExecuteUpdate("Insert Into Prescription Values("+idPrescription+","+med.getId()+","+med.getQuantity()+")");
                }
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            return;
        }

        try {
            if(examDoctorNReexamCheck.isSelected()) {
                DBUtil.dbExecuteUpdate(query1);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            DBUtil.dbExecuteUpdate("Delete From Prescription Where idPrescription="+idPrescription);
        }


        try {
            DBUtil.dbExecuteUpdate(query);

            ResultSet exist = DBUtil.dbExecuteQuery("Select Count(*) From Record " +
                                        "Where idPatient="+patientID+" AND Diagnosis='"+diagnosis+"' AND DateDiagnosed='"+date+"'");
            if(exist.next() && exist.getInt(1)==0)
                DBUtil.dbExecuteUpdate(newPatientRecord);

            medList.clear();
            examDoctorNResultLabel.setVisible(true);
            examDoctorNResultLabel.setText("New Doctor Examination ID:#"+(findAutoIncrementID("PDE")-1));
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            DBUtil.dbExecuteUpdate("Delete From Prescription Where idPrescription="+idPrescription);
            DBUtil.dbExecuteUpdate("Delete From PNE Where idPNE="+idPNE);
        }
    }

    int findAutoIncrementID(String table) {
        String findid = "SELECT `AUTO_INCREMENT` " +
                "FROM INFORMATION_SCHEMA.TABLES " +
                "WHERE TABLE_SCHEMA = '"+DBUtil.getDatabaseName()+"' " +
                "AND TABLE_NAME = '"+table+"'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(findid);
            if(set.next())
                 return set.getInt(1);

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    public void examDoctorNAddMed() {
        String name = examDoctorNPreNameField.getValue();
        String type = examDoctorNPreTypeField.getValue();
        int quantity = Integer.parseInt(examDoctorNPreQuantityField.getText());

        Medicine med = new Medicine();
        med.setName(name);
        med.setType(type);
        med.setQuantity(quantity);
        med.getD().setOnAction(actionEvent -> examDoctorNRemoveRow(med));
        med.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));

        String query = "Select idMedicine, Dose From Medicine Where Name='"+name+"' && Type='"+type+"'";
        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                med.setDose(set.getInt("Dose"));
                med.setId(set.getInt("idMedicine"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            return;
        }


        for (Medicine m : medList) {
            if(m.getId() == med.getId()) {
                m.setQuantity(med.getQuantity()+m.getQuantity());
                examDoctorNPreTable.setItems(medList);
                return;
            }
        }

        medList.add(med);

        examDoctorNPreNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        examDoctorNPreTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        examDoctorNPreDoseCol.setCellValueFactory(new PropertyValueFactory<>("dose"));
        examDoctorNPreQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        examDoctorNPreDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

        examDoctorNPreTable.setItems(medList);
    }

    private void examDoctorNRemoveRow(Medicine med) {
        medList.remove(med);
        examDoctorNPreTable.setItems(medList);
    }

    public void examDoctorNClear() {
        examDoctorNIDField.clear();
        examDoctorNAMKAField.clear();
        examDoctorNExamField.setValue("");
        examDoctorNDiagnosisField.setValue("");
        examDoctorNDatePicker.setValue(LocalDate.now());
        examDoctorNPrescriptionCheck.setSelected(false);
        examDoctorNPreTable.getItems().clear();
        medList.clear();
        examDoctorNPrescriptionPane.setVisible(false);
        examDoctorNPreNameField.setValue("");
        examDoctorNPreQuantityField.clear();
        examDoctorNPreTypeField.setValue("");
        examDoctorNReexamCheck.setSelected(false);
        examDoctorNReexamPane.setVisible(false);
        examDoctorNNurseField.clear();
        examDoctorNNurseExamField.setValue("");
        examDoctorNResultLabel.setVisible(false);
    }

    /***** Doctor Reexam ******/
    public void examDoctorReCancel() {
        examDoctorReMainPane.setVisible(false);
        examDoctorRePrescriptionPane.setVisible(false);
        examDoctorRePreAddPane.setVisible(false);
        examDoctorRePreAddRadio.setSelected(false);
        examDoctorReHospitalisedCheck.setSelected(false);
        examDoctorReReport.clear();
        medListR.clear();
        examDoctorRePreTable.getItems().clear();
    }

    public void examDoctorReAdd() {
        String name = examDoctorRePreNameField.getValue();
        String type = examDoctorRePreTypeField.getValue();
        String quantity = examDoctorRePreQuantityField.getText();

        Medicine med = new Medicine();
        try {
            ResultSet set = DBUtil.dbExecuteQuery("Select idMedicine,Dose From Medicine Where Name='"+name+"' && Type='"+type+"'");
            if(set.next()) {
                med.setId(set.getInt("idMedicine"));
                med.setName(name);
                med.setType(type);
                med.setDose(set.getInt("Dose"));
                med.setQuantity(Integer.parseInt(quantity));
                med.getD().setOnAction(actionEvent -> examDoctorReRemoveRow(med));
                med.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));

                for (Medicine m : medListR) {
                    if(m.getId() == med.getId()) {
                        m.setQuantity(med.getQuantity()+m.getQuantity());
                        examDoctorRePreTable.setItems(medListR);
                        return;
                    }
                }

                medListR.add(med);

                examDoctorReNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                examDoctorReTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                examDoctorReDoseCol.setCellValueFactory(new PropertyValueFactory<>("dose"));
                examDoctorReQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                examDoctorReDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

                examDoctorRePreTable.setItems(medListR);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examDoctorReRemoveRow(Medicine med) {
        medListR.remove(med);
        examDoctorRePreTable.setItems(medListR);
    }

    public void examDoctorReSearch() throws SQLException, ClassNotFoundException {

        String idPDE = examDoctorRePDEIDField.getText();
        String idDoctor = examDoctorReDoctorIDField.getText();
        String idPatient = examDoctorRePatientIDField.getText();
        String idExam = examDoctorReExamIDField.getText();
        String date = null;
        if(examDoctorReOldDatePicker.getValue() != null)
            date = examDoctorReOldDatePicker.getValue().toString();
        ResultSet set = null;

        if(idPDE != null && !idPDE.isEmpty()) {
            String query = "Select * From PDE Where idPDE="+idPDE;
            try {
                set = DBUtil.dbExecuteQuery(query);
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
        }else {
            String query = "Select * From PDE Where idDoctor="+idDoctor+
                            " && idPatient="+idPatient+" && idExam="+idExam+
                            " && OperationDate='"+date+"'";
            try {
                set = DBUtil.dbExecuteQuery(query);
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
        }

        if(set != null && set.next()) {
            examDoctorReIDPDELabel.setText(set.getString("idPDE"));
            examDoctorReMainPane.setVisible(true);
            examDoctorReDoctorIdLabel.setText(set.getString("idDoctor"));
            examDoctorRePatientIDLabel.setText(set.getString("idPatient"));

            ResultSet prevExamName = DBUtil.dbExecuteQuery("Select Name From Exam Where idExam="+set.getString("idExam"));
            if(prevExamName.next())
                examDoctorRePrevExamLabel.setText(prevExamName.getString("Name"));
            examDoctorRePrevDateLabel.setText(set.getString("OperationDate"));

            ResultSet examName = DBUtil.dbExecuteQuery("Select Name From Exam");
            examDoctorReExamNameField.getItems().clear();
            while(examName.next())
                examDoctorReExamNameField.getItems().add(examName.getString("Name"));

            examDoctorReExamDate.setValue(LocalDate.now());

            examDoctorReDiagnosisLabel.getItems().clear();
            examDoctorReDiagnosisLabel.getItems().add(set.getString("Diagnosis"));
            examDoctorRePreMedicineFill();
            examDoctorReDiagnosisLabel.setValue(set.getString("Diagnosis"));
            examDoctorReDiagnosisFill(set.getString("idDoctor"));

            examDoctorReReport.clear();
            if(set.getString("idPNE") != null)
                examDoctorReReportFill(set.getString("idPNE"), set.getString("idPatient"));
            else {
                examDoctorReNurseIDLabel.setText("N/A");
                examDoctorReNurseLabel.setText("N/A");
                examDoctorReReport.setText("N/A");
            }
            examDoctorRePrescriptionPane.setVisible(true);
            medListR.clear();
            if(set.getString("idPrescription") != null) {
                examDoctorRePreFillTable(set.getString("idPrescription"));
                examDoctorRePrescriptionIDLabel.setText("PRESCRIPTION: #"+set.getString("idPrescription"));
            }else {
                examDoctorRePrescriptionIDLabel.setText("NEW PRESCRIPTION:");
            }

        }else {
            examDoctorReCancel();
        }
    }

    private void examDoctorRePreFillTable(String idPrescription) {

        ObservableList<Medicine> list = FXCollections.observableArrayList();
        String query = "Select m.idMedicine, m.Name, m.Type, m.Dose, p.Quantity From Medicine m, Prescription p "+
                "Where p.idPrescription="+idPrescription+" && m.idMedicine=p.idMedicine";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            while(set.next()) {
                Medicine med = new Medicine();
                med.setId(set.getInt("idMedicine"));
                med.setName(set.getString("Name"));
                med.setType(set.getString("Type"));
                med.setDose(set.getInt("Dose"));
                med.setQuantity(set.getInt("Quantity"));
                med.getD().setOnAction(actionEvent -> examDoctorReRemoveRow(med));
                med.getD().setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
                list.add(med);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        examDoctorReNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        examDoctorReTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        examDoctorReDoseCol.setCellValueFactory(new PropertyValueFactory<>("dose"));
        examDoctorReQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        examDoctorReDCol.setCellValueFactory(new PropertyValueFactory<>("d"));

        examDoctorRePreTable.setItems(list);
    }

    private void examDoctorReReportFill(String idPNE, String idPatient) {
        String query = "Select Report From Record, PNE Where dateDiagnosed=OperationDate && idPNE="+idPNE+
                " && idPatient="+idPatient+" && Diagnosis='"+examDoctorReDiagnosisLabel.getValue()+"'";
        String exam = "Select e.Name,n.idNurse From Exam e,PNE n Where idPNE="+idPNE+" && e.idExam=n.idExam";
        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                examDoctorReReport.setText(set.getString("Report"));
            }
            ResultSet set1 = DBUtil.dbExecuteQuery(exam);
            if(set1.next()) {
                examDoctorReNurseLabel.setText(set1.getString("Name"));
                examDoctorReNurseIDLabel.setText(set1.getString("idNurse"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void examDoctorReDiagnosisFill(String idDoctor) {
        String query = "Select d.Name From Disease d, Doctor doc Where d.Speciality=doc.Speciality && doc.idDoctor="+idDoctor;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            examDoctorReDiagnosisLabel.getItems().addAll("Healthy", "Unknown");
            while(set.next()) {
                examDoctorReDiagnosisLabel.getItems().add(set.getString("Name"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorRePreShowMedPane() {
        if(examDoctorRePreAddRadio.isSelected()) {
            examDoctorRePreAddPane.setVisible(true);
            examDoctorRePreNameField.setValue("");
            examDoctorRePreTypeField.setValue("");
            examDoctorRePreQuantityField.clear();
        }else
            examDoctorRePreAddPane.setVisible(false);

    }

    public void examDoctorRePreFillType() {
        String medicine = examDoctorRePreNameField.getValue();
        String query = "Select distinct Type From Medicine Where Name='"+medicine+"'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            examDoctorRePreTypeField.getItems().clear();
            while(set.next())
                examDoctorRePreTypeField.getItems().add(set.getString("Type"));
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorRePreMedicineFill() {
        String diagnosis = examDoctorReDiagnosisLabel.getValue();
        String query = "Select distinct m.Name From Disease d,Medicine m Where m.idDisease=d.idDisease && d.Name='"+diagnosis+"'";

        if(diagnosis==null || diagnosis.equals("Healthy") || diagnosis.equals("Unknown")) {
            examDoctorNPreNameField.getItems().clear();
            examDoctorNPreTypeField.getItems().clear();

        }
        examDoctorRePreNameField.getItems().clear();
        examDoctorRePreTable.getItems().clear();
        medListR.clear();

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            while(set.next()) {
                examDoctorRePreNameField.getItems().add(set.getString("Name"));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examDoctorReComplete() throws SQLException, ClassNotFoundException {
        String idPDE = examDoctorReIDPDELabel.getText();
        String idPatient = examDoctorRePatientIDLabel.getText();
        String idDoctor = examDoctorReDoctorIdLabel.getText();
        String examName = examDoctorReExamNameField.getValue();
        String examDate = examDoctorReExamDate.getValue().toString();
        String diagnosis = examDoctorReDiagnosisLabel.getValue();
        boolean toHospitalise = examDoctorReHospitalisedCheck.isSelected();
        String idExam = null, idPrescription = "NULL";

        String idExamQuery = "Select idExam From Exam Where Name='"+examName+"'";
        try {
            ResultSet EXAM = DBUtil.dbExecuteQuery(idExamQuery);
            if(EXAM.next()) {
                idExam = EXAM.getString("idExam");
            }
            if(!medListR.isEmpty()) {
                idPrescription = String.valueOf(findAutoIncrementID("Prescription"));
                for (Medicine m : medListR) {
                    DBUtil.dbExecuteUpdate("Insert Into Prescription Values(" + idPrescription + "," + m.getId() + "," + m.getQuantity() + ")");
                }
            }
            if(toHospitalise) {
                DBUtil.dbExecuteUpdate("Update PDE Set toHospitalise=true Where idPDE="+idPDE);
            }


            String newPDEQuery = "Insert Into PDE(idPatient,idDoctor,idExam,idPrescription,Diagnosis,toHospitalise,OperationDate) "+
                                "Values("+idPatient+","+idDoctor+","+idExam+","+idPrescription+",'"+diagnosis+"',"+toHospitalise+",'"+examDate+"')";
            DBUtil.dbExecuteUpdate(newPDEQuery);

            String newPatientRecord = "Insert Into Record(idPatient, Diagnosis, DateDiagnosed) VALUES("+idPatient+",'"+diagnosis+"','"+examDate+"')";
            ResultSet exist = DBUtil.dbExecuteQuery("Select Count(*) From Record " +
                    "Where idPatient="+idPatient+" AND Diagnosis='"+diagnosis+"' AND DateDiagnosed='"+examDate+"'");
            if(exist.next() && exist.getInt(1)==0)
                DBUtil.dbExecuteUpdate(newPatientRecord);

            examDoctorReCancel();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
            if(!medListR.isEmpty()) {
                DBUtil.dbExecuteUpdate("Delete From Prescription where idPrescription="+idPrescription);
            }
        }
    }

    /*********** Nurse Form ****************/
    public void examNurseSearch() {
        String idPDE = examNurseIDPDEField.getText();
        String query = "Select n.idNurse, e.Name From PNE n, PDE d, Exam e Where n.idPNE=d.idPNE && e.idExam=n.idExam && idPDE="+idPDE;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                examNurseExamNameField.setText(set.getString("Name"));
                examNurseIDField.setText(set.getString("idNurse"));
                examNurseDateField.setValue(LocalDate.now());
                examNurseReportField.clear();
                examNurseFoundPane.setVisible(true);
            }else {
                examNurseFoundPane.setVisible(false);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void examNurseComplete() {
        String report = examNurseReportField.getText();
        String idPDE = examNurseIDPDEField.getText();
        String query = "Select idPatient,Diagnosis, OperationDate From PDE Where idPDE="+idPDE;

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next()) {
                String idPatient = set.getString("idPatient");
                String diagnosis = set.getString("Diagnosis");
                String date = set.getString("OperationDate");

                String updateRecord;
                ResultSet oldReport = DBUtil.dbExecuteQuery("Select Report From Record " +
                        "Where idPatient="+idPatient+" AND Diagnosis='"+diagnosis+"' AND DateDiagnosed='"+date+"'");
                if(oldReport.next() && oldReport.getString(1) != null) {
                    updateRecord = "Update Record Set Report='"+oldReport.getString(1)+" [UPDATE]: "+report+"' WHERE idPatient="+idPatient+" AND Diagnosis='"+diagnosis+"' AND DateDiagnosed='"+date+"'";
                }else
                    updateRecord = "Update Record Set Report='"+report+"' WHERE idPatient="+idPatient+" AND Diagnosis='"+diagnosis+"' AND DateDiagnosed='"+date+"'";

                DBUtil.dbExecuteUpdate(updateRecord);
                examNurseFoundPane.setVisible(false);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }





    /*********** Statistics ****************/

    public void setDatabasePane(ActionEvent event) {
        if(event.getSource().equals(DB1Btn)) {
            DB1Pane.toFront();
            fillDB1();
        }else if(event.getSource().equals(DB2Btn)) {
            DB2Pane.toFront();
            IncidentsChart.setVisible(false);
            DiseasePieChartPane.setVisible(false);
            ExamPieChartPane.setVisible(false);
            MedPieChartPane.setVisible(false);
        }else if(event.getSource().equals(DB3Btn)) {
            DB3Pane.toFront();
            fillDB3();
        }else if(event.getSource().equals(DB4Btn)) {
            DB4Pane.toFront();
        }else if(event.getSource().equals(DB5Btn)) {
            DB5Pane.toFront();
        }
        DBHeaderPane.toFront();
        tabPane.toFront();
        pieChartLabel.setVisible(false);
        pieChartLabel1.setVisible(false);
    }


    /************* DB1 ***********/
    private void fillDB1() {
        //queries
        String q1 = "Select COUNT(distinct idPatient) FROM PDE Where OperationDate='"+LocalDate.now()+"'";
        String q2 = "SELECT COUNT(s.idEmp) FROM Doctor d, Shift s WHERE d.idDoctor=s.idEmp AND s.shiftDate='"+LocalDate.now()+"'";
        String q3 = "SELECT COUNT(s.idEmp) FROM Nurse n, Shift s WHERE n.idNurse=s.idEmp AND s.shiftDate='"+LocalDate.now()+"'";
        String q4 = "SELECT COUNT(s.idEmp) FROM Employee e, Shift s WHERE e.idEmp=s.idEmp AND e.Position='W' AND s.shiftDate='"+LocalDate.now()+"'";
        String q5 = "SELECT COUNT(idPDE) FROM PDE WHERE OperationDate='"+LocalDate.now()+"'";
        String q6 = "SELECT COUNT(idPNE) FROM PNE WHERE OperationDate='"+LocalDate.now()+"'";
        String q7 = "SELECT COUNT(distinct d.idDisease) FROM PDE, Disease d Where d.Name=PDE.Diagnosis && OperationDate='"+LocalDate.now()+"'";
        String q8 = "SELECT SUM(Quantity) FROM Prescription p, PDE WHERE p.idPrescription=PDE.idPrescription AND OperationDate='"+LocalDate.now()+"'";

        String[] queries = {q1,q2,q3,q4,q5,q6,q7,q8};
        ResultSet[] set = new ResultSet[8];
        Label[] labels = {DB1Incidents,DB1Doctors,DB1Nurses,DB1Workers,DB1PDE,DB1PNE,DB1Diseases,DB1Medicines};

        try {
            for(int i=0; i<8; i++) {
                set[i] = DBUtil.dbExecuteQuery(queries[i]);
                if(set[i].next())
                    labels[i].setText(String.valueOf(set[i].getInt(1)));
            }
            LocalDate d = LocalDate.now();
            DB1Date.setText(format(d.getDayOfWeek().name()) + ", " + d.getDayOfMonth() + " " + format(d.getMonth().name()) + " " + d.getYear());

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }




    }

    /************* DB2 ***********/
    public void showIncidentsNumber() throws SQLException, ClassNotFoundException {
        if(DB2YearField.getValue()==null || DB2MonthField.getValue()== null){
            System.out.println("null");
            return;
        }
        IncidentsChart.getData().clear();
        IncidentsChart.setVisible(true);
        IncidentsChartPane.setVisible(true);
        setChartToFront(IncidentsChartPane);

        String date = "1/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));
        LocalDate startDate = endDate.withDayOfMonth(1);

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (LocalDate d=startDate; d.isBefore(endDate.plusDays(1)); d=d.plusDays(1)) {

            String query = "SELECT COUNT(distinct idPatient) FROM PDE Where OperationDate = '"+d.toString()+"'";
            ResultSet set = DBUtil.dbExecuteQuery(query);
            if(set.next())
                series.getData().add(new XYChart.Data<>(d.getDayOfMonth() + "/" + d.getMonthValue(), set.getInt(1)));
        }

        series.setName("Incidents");
        ChartXAxis.setLabel(format(startDate.getMonth().toString() +" "+ startDate.getYear()));
        IncidentsChart.getData().add(series);
    }

    public void showDiseasesDiagnosed() {
        if(DB2YearField.getValue()==null || DB2MonthField.getValue()== null) return;
        setChartToFront(DiseasePieChartPane);
        DiseasePieChart1.getData().clear();
        DiseasePieChart2.getData().clear();
        pieChartLabel1.setVisible(false);
        pieChartLabel.setVisible(false);
        String date = "1/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));
        System.out.println(endDate.toString());
        LocalDate startDate = endDate.withDayOfMonth(1);

        String diseasesQuery = "SELECT Diagnosis,COUNT(*) as count" +
                " FROM PDE" +
                " Where OperationDate BETWEEN '"+startDate.toString()+"' AND '"+endDate.toString()+"'"+
                " GROUP BY Diagnosis" +
                " ORDER BY count DESC";
        try {
            ResultSet diseases = DBUtil.dbExecuteQuery(diseasesQuery);
            ObservableList<PieChart.Data> pie1 = FXCollections.observableArrayList();
            while(diseases.next()) {
                if(!diseases.getString("Diagnosis").equals("Healthy"))
                    pie1.add(new PieChart.Data(diseases.getString(1), diseases.getInt(2)));
            }
            DiseasePieChart1.setData(pie1);
            DiseasePieChart1.setTitle(format(endDate.getMonth().name()) + " " + endDate.getYear());
            for (final PieChart.Data p : DiseasePieChart1.getData()) {
                p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel,mouseEvent, p));
            }

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        if(DB2DayField.getValue() != null) {
            int day = DB2DayField.getValue();
            if(endDate.getDayOfMonth() < day){
                DB2DayField.setValue(1);
                return;
            }

            String d = day+"/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();
            LocalDate D = LocalDate.parse(d, DateTimeFormatter.ofPattern("d/M/yyyy"));
            String query = "SELECT Diagnosis,COUNT(*) as count" +
                    " FROM PDE" +
                    " Where OperationDate = '"+D.toString()+"'" +
                    " GROUP BY Diagnosis" +
                    " ORDER BY count DESC";
            try {
                ResultSet set = DBUtil.dbExecuteQuery(query);
                ObservableList<PieChart.Data> pie2 = FXCollections.observableArrayList();
                while(set.next()) {
                    if(!set.getString("Diagnosis").equals("Healthy"))
                        pie2.add(new PieChart.Data(set.getString(1), set.getInt(2)));
                }
                DiseasePieChart2.setData(pie2);
                DiseasePieChart2.setTitle(format(D.getDayOfWeek().name())+", "+D.getDayOfMonth()+" "+format(D.getMonth().name())+" "+D.getYear());
                for (final PieChart.Data p : DiseasePieChart2.getData()) {
                    p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                    p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                    p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel1,mouseEvent, p));
                }
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public void showExamsCompleted() {
        if(DB2YearField.getValue()==null || DB2MonthField.getValue()== null) return;
        setChartToFront(ExamPieChartPane);
        ExamPieChart1.getData().clear();
        ExamPieChart2.getData().clear();
        pieChartLabel1.setVisible(false);
        pieChartLabel.setVisible(false);
        String date = "1/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));
        System.out.println(endDate.toString());
        LocalDate startDate = endDate.withDayOfMonth(1);

        String examQuery = "Select Name, SUM(count) " +
                "FROM (" +
                "    (SELECT Name,COUNT(*) as count" +
                "    FROM PDE,Exam" +
                "    Where PDE.OperationDate BETWEEN '"+startDate+"' AND '"+endDate+"'" +
                "    AND Exam.idExam=PDE.idExam" +
                "    GROUP BY Exam.idExam" +
                "    ORDER BY count DESC)" +
                "    UNION ALL" +
                "    (SELECT Name,COUNT(*) as count" +
                "    FROM PNE,Exam" +
                "    Where PNE.OperationDate BETWEEN '"+startDate+"' AND '"+endDate+"'" +
                "    AND Exam.idExam=PNE.idExam" +
                "    GROUP BY Exam.idExam" +
                "    ORDER BY count DESC)" +
                ") t " +
                "group by Name";

        try {
            ResultSet exams = DBUtil.dbExecuteQuery(examQuery);
            ObservableList<PieChart.Data> pie1 = FXCollections.observableArrayList();
            while(exams.next()) {
                    pie1.add(new PieChart.Data(exams.getString(1), exams.getInt(2)));
            }
            ExamPieChart1.setData(pie1);
            ExamPieChart1.setTitle(format(endDate.getMonth().name()) + " " + endDate.getYear());
            for (final PieChart.Data p : ExamPieChart1.getData()) {
                p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel,mouseEvent, p));
            }

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        if(DB2DayField.getValue() != null) {
            int day = DB2DayField.getValue();
            if(endDate.getDayOfMonth() < day){
                DB2DayField.setValue(1);
                return;
            }

            String d = day+"/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();
            LocalDate D = LocalDate.parse(d, DateTimeFormatter.ofPattern("d/M/yyyy"));

            String query = "Select Name, SUM(count) " +
                    "FROM (" +
                    "    (SELECT Name,COUNT(*) as count" +
                    "    FROM PDE,Exam" +
                    "    Where PDE.OperationDate = '"+D+"'" +
                    "    AND Exam.idExam=PDE.idExam" +
                    "    GROUP BY Exam.idExam" +
                    "    ORDER BY count DESC)" +
                    "    UNION ALL" +
                    "    (SELECT Name,COUNT(*) as count" +
                    "    FROM PNE,Exam" +
                    "    Where PNE.OperationDate = '"+D+"'" +
                    "    AND Exam.idExam=PNE.idExam" +
                    "    GROUP BY Exam.idExam" +
                    "    ORDER BY count DESC)" +
                    ") t " +
                    "group by Name";

            try {
                ResultSet exam = DBUtil.dbExecuteQuery(query);
                ObservableList<PieChart.Data> pie2 = FXCollections.observableArrayList();
                while(exam.next()) {
                    pie2.add(new PieChart.Data(exam.getString(1), exam.getInt(2)));
                }
                ExamPieChart2.setData(pie2);
                ExamPieChart2.setTitle(format(D.getDayOfWeek().name())+", "+D.getDayOfMonth()+" "+format(D.getMonth().name())+" "+D.getYear());
                for (final PieChart.Data p : ExamPieChart2.getData()) {
                    p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                    p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                    p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel1,mouseEvent, p));
                }
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public void showMedicinesPrescribed() {
        if(DB2YearField.getValue()==null || DB2MonthField.getValue()== null) return;
        setChartToFront(MedPieChartPane);
        MedPieChart1.getData().clear();
        MedPieChart2.getData().clear();
        pieChartLabel1.setVisible(false);
        pieChartLabel.setVisible(false);
        String date = "1/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));
        System.out.println(endDate.toString());
        LocalDate startDate = endDate.withDayOfMonth(1);

        String examQuery = "SELECT m.idMedicine,m.Name,COUNT(*) as count,SUM(p.Quantity)" +
                " FROM PDE,Medicine m,Prescription p" +
                " Where OperationDate BETWEEN '"+startDate.toString()+"' AND '"+endDate.toString()+"' AND p.idMedicine=m.idMedicine AND p.idPrescription=PDE.idPrescription"+
                " GROUP BY m.idMedicine" +
                " ORDER BY count DESC";
        try {
            ResultSet meds = DBUtil.dbExecuteQuery(examQuery);
            ObservableList<PieChart.Data> pie1 = FXCollections.observableArrayList();
            while(meds.next()) {
                pie1.add(new PieChart.Data("["+meds.getInt(1)+"]"+meds.getString(2)+" x"+meds.getInt(3), meds.getInt(4)));
            }
            MedPieChart1.setData(pie1);
            MedPieChart1.setTitle(format(endDate.getMonth().name()) + " " + endDate.getYear());
            for (final PieChart.Data p : MedPieChart1.getData()) {
                p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel,mouseEvent, p));
            }

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        if(DB2DayField.getValue() != null) {
            int day = DB2DayField.getValue();
            if(endDate.getDayOfMonth() < day){
                DB2DayField.setValue(1);
                return;
            }

            String d = day+"/"+DB2MonthField.getValue().getValue()+"/"+DB2YearField.getValue();
            LocalDate D = LocalDate.parse(d, DateTimeFormatter.ofPattern("d/M/yyyy"));
            String query = "SELECT m.idMedicine,m.Name,COUNT(*) as count,SUM(p.Quantity)" +
                    " FROM PDE, Medicine m, Prescription p" +
                    " Where OperationDate = '"+D.toString()+"' AND p.idMedicine=m.idMedicine AND p.idPrescription=PDE.idPrescription" +
                    " GROUP BY m.idMedicine" +
                    " ORDER BY count DESC";
            try {
                ResultSet med = DBUtil.dbExecuteQuery(query);
                ObservableList<PieChart.Data> pie2 = FXCollections.observableArrayList();
                while(med.next()) {
                    pie2.add(new PieChart.Data("["+med.getInt(1)+"]"+med.getString(2)+" x"+med.getInt(3), med.getInt(4)));
                }
                MedPieChart2.setData(pie2);
                MedPieChart2.setTitle(format(D.getDayOfWeek().name())+", "+D.getDayOfMonth()+" "+format(D.getMonth().name())+" "+D.getYear());
                for (final PieChart.Data p : MedPieChart2.getData()) {
                    p.getNode().setOnMouseEntered(mouseEvent -> p.getNode().setEffect(new Bloom(0.75)));
                    p.getNode().setOnMouseExited(mouseEvent -> p.getNode().setEffect(null));
                    p.getNode().setOnMouseClicked(mouseEvent -> pieChartMouseClicked(pieChartLabel1,mouseEvent, p));
                }
            } catch (SQLException | ClassNotFoundException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private void setChartToFront(Pane pane) {
        pane.setVisible(true);
        pane.toFront();
        DBHeaderPane.toFront();
        tabPane.toFront();
    }

    private void pieChartMouseClicked(Label l, MouseEvent event, PieChart.Data p) {
        l.toFront();
        l.setVisible(true);
        l.setTranslateX(event.getSceneX()-10);
        l.setTranslateY(event.getSceneY()-25);
        l.setText(String.valueOf( (int)p.getPieValue()));
    }

    private String format(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    /************* DB3 ***********/
    private void fillDB3() {

        DB3InfoPane.setVisible(false);
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "Select idPatient, DateDiagnosed From Record Where Diagnosis='Covid-19' Group by idPatient";
        String q = "Select Count(distinct idPatient) From Record Where Diagnosis='Covid-19'";
        try {
            ResultSet s = DBUtil.dbExecuteQuery(q);
            if(s.next()) {
                DB3Cases.setText(s.getString(1));
            }
            ResultSet set = DBUtil.dbExecuteQuery(query);
            list.add("ID\t\tDate Diagnosed");
            while(set.next()) {
                list.add(set.getString(1)+ "\t\t" + set.getString(2));
            }
            DB3PatientList.setItems(list);

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    private void DB3InfoInit(String id) {
        DB3InfoPane.setVisible(true);
        String info = "Select * From Patient Where AMKA="+id;
        String record = "Select distinct Diagnosis,DateDiagnosed From Record Where idPatient="+id;

        try {
            ResultSet i = DBUtil.dbExecuteQuery(info);
            ResultSet r = DBUtil.dbExecuteQuery(record);

            if(i.next()) {
                DB3Name.setText(i.getString("Name"));
                DB3Amka.setText(i.getString("AMKA"));
                DB3Gender.setText(i.getString("Sex"));
                DB3Date.setText(i.getString("DateOfBirth"));
                DB3Address.setText(i.getString("Address"));
                DB3Phone.setText(i.getString("Phone"));
            }
            ObservableList<String> list = FXCollections.observableArrayList();
            list.add("Disease\t\tDateDiagnosed");
            while(r.next()) {
                if(!r.getString(1).equals("Healthy") && !r.getString(1).equals("Covid-19")
                        && !r.getString(1).equals("Unknown"))
                    list.add(r.getString(1)+"\t\t"+r.getString(2));
            }
            DB3DiseaseList.setItems(list);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    /************* DB4 ***********/
    public void fillDB4() {
        DB4InfoPane.setVisible(false);
        ObservableList<String> list = FXCollections.observableArrayList();
        LocalDate date = DB4DatePicker.getValue();
        if(date==null) return;

        LocalDate endDate = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        LocalDate startDate = endDate.withDayOfMonth(1);

        String query = "Select distinct e.idEmp, e.Name, PositionTitle From Employee e, Shift s Where e.idEmp=s.idEmp AND shiftDate BETWEEN '"+startDate+"' AND '"+endDate+"'";

        try {
            ResultSet set = DBUtil.dbExecuteQuery(query);
            list.add("ID\t\tName\t\tPosition Title");
            while(set.next()) {
                list.add(set.getString(1) + "\t\t" + set.getString(2) + "\t" + set.getString(3));
            }
            DB4StaffList.setItems(list);
            DB4Date.setText("For "+format(date.getMonth().name()+" "+date.getYear()));
            DB4MainPane.setVisible(true);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    private void DB4InfoInit(String id) {
        DB4InfoPane.setVisible(true);
        LocalDate date = DB4DatePicker.getValue();
        if(date==null) return;

        DB4Chart.getData().clear();

        LocalDate endDate = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        LocalDate startDate = endDate.withDayOfMonth(1);
        String info = "Select shiftDate, HoursOfWork " +
                "From Shift " +
                "Where idEmp="+id+" AND shiftDate BETWEEN '"+startDate+"' AND '"+endDate+"'";
        String totals = "Select Sum(HoursOfWork),Count(shiftDate) " +
                "From Shift " +
                "Where idEmp="+id+" AND shiftDate BETWEEN '"+startDate+"' AND '"+endDate+"'";
        try {

            XYChart.Series<String,Integer> set1 = new XYChart.Series<>();
            Map<String, Integer> map = new HashMap<>();

            ResultSet set = DBUtil.dbExecuteQuery(info);
            while(set.next()) {
                map.put(set.getString(1), set.getInt(2));
            }
            ResultSet t = DBUtil.dbExecuteQuery(totals);
            if(t.next()) {
                DB4Hours.setText(t.getString(1));
                DB4Shifts.setText(t.getString(2));
            }

            for(LocalDate d = startDate; d.isBefore(endDate.plusDays(1)); d=d.plusDays(1)) {
                if(!map.isEmpty() && map.containsKey(d.toString()))
                    set1.getData().add(new XYChart.Data<>(d.getDayOfMonth()+"/"+d.getMonthValue(), map.get(d.toString()) ));
                else
                    set1.getData().add(new XYChart.Data<>(d.getDayOfMonth()+"/"+d.getMonthValue(), 0));
            }

            DB4Chart.getData().add(set1);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    /************* DB5 ***********/

    private void ExecuteQuery() {

        String query = DB5Query.getText().trim();
        ResultSet set = null;

        try {

            if(query.startsWith("s") || query.startsWith("S"))
                set = DBUtil.dbExecuteQuery(query);
            else
                DBUtil.dbExecuteUpdate(query);

            if(set != null) {

                int colNumber = set.getMetaData().getColumnCount();
                while(set.next()) {
                    List<String> l = FXCollections.observableArrayList();
                    for(int i=1; i<=colNumber; i++)
                        l.add(set.getString(i));

                    DB5ResultTable.getItems().add(l);
                }

                for (int i = 0; i < colNumber; i++) {
                    TableColumn<List<String>, String> col = new TableColumn<>();
                    col.setMinWidth(100);
                    col.setText(set.getMetaData().getColumnName(i+1));
                    final int colIndex = i ;
                    col.setCellValueFactory(data -> {
                        List<String> rowValues = data.getValue();
                        String cellValue ;
                        if (colIndex < rowValues.size())
                            cellValue = rowValues.get(colIndex);
                        else
                            cellValue = "" ;

                        return new ReadOnlyStringWrapper(cellValue);
                    });
                    DB5ResultTable.getColumns().add(col);
                }

            }

            DB5Message.setStyle("-fx-text-fill: LIMEGREEN;");
            DB5Message.setText("Success");

        } catch (SQLException | ClassNotFoundException e) {

            DB5Message.setStyle("-fx-text-fill: red;");
            DB5Message.setText(e.getMessage());
        }
    }

    public void Run() {

        DB5Message.clear();
        DB5ResultTable.getItems().clear();
        DB5ResultTable.getColumns().clear();

        // setup some transition that rotates an icon for 2 seconds
        final RotateTransition rotateTransition = new RotateTransition(Duration.millis(180), Spinner);
        rotateTransition.setByAngle(90);

        Spinner.setVisible(true);
        rotateTransition.playFromStart();

        rotateTransition.setOnFinished((finishHim) -> {
            // execute command
            ExecuteQuery();
            Spinner.setVisible(false);
        });
    }

    public void Excecute(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER && keyEvent.isControlDown())
            Run();
    }
}
