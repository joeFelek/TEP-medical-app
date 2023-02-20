package HY360.TableEntities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Medicine {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final IntegerProperty dose = new SimpleIntegerProperty();
    private final StringProperty disease = new SimpleStringProperty();
    private final IntegerProperty quantity = new SimpleIntegerProperty();
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

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getDose() {
        return dose.get();
    }

    public IntegerProperty doseProperty() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose.set(dose);
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

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public Button getE() {
        return e;
    }

    public Button getD() {
        return d;
    }
}
