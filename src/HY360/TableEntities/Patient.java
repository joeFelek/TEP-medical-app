package HY360.TableEntities;

import javafx.beans.property.*;

import java.util.ArrayList;

public class Patient {

    private final StringProperty date = new SimpleStringProperty();
    private final StringProperty disease = new SimpleStringProperty();
    private final StringProperty exam = new SimpleStringProperty();
    private final StringProperty diagnosedBy = new SimpleStringProperty();
    private final StringProperty speciality = new SimpleStringProperty();
    private final BooleanProperty hospitalised = new SimpleBooleanProperty();
    private final IntegerProperty prescription = new SimpleIntegerProperty();

    private ArrayList<Medicine> medicine;

    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(ArrayList<Medicine> med) {
        this.medicine = med;
    }

    public int getPrescription() {
        return prescription.get();
    }

    public IntegerProperty prescriptionProperty() {
        return prescription;
    }

    public void setPrescription(int prescription) {
        this.prescription.set(prescription);
    }

    public boolean isHospitalised() {
        return hospitalised.get();
    }

    public BooleanProperty hospitalisedProperty() {
        return hospitalised;
    }

    public void setHospitalised(boolean hospitalised) {
        this.hospitalised.set(hospitalised);
    }

    public String getSpeciality() {
        return speciality.get();
    }

    public StringProperty specialityProperty() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality.set(speciality);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDisease() {
        return disease.get();
    }

    public StringProperty diseaseProperty() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease.set(disease);
    }

    public String getExam() {
        return exam.get();
    }

    public StringProperty examProperty() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam.set(exam);
    }

    public String getDiagnosedBy() {
        return diagnosedBy.get();
    }

    public StringProperty diagnosedByProperty() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy.set(diagnosedBy);
    }

}
