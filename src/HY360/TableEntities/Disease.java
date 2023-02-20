package HY360.TableEntities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Disease {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty speciality = new SimpleStringProperty();
    private final StringProperty symptoms = new SimpleStringProperty();
    private final Button e = new Button();
    private final Button d = new Button();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getSymptoms() {
        return symptoms.get();
    }

    public StringProperty symptomsProperty() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms.set(symptoms);
    }

    public Button getE() {
        return e;
    }

    public Button getD() {
        return d;
    }
}
