package HY360.TableEntities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Shift {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();

    private final IntegerProperty hoursOfWork = new SimpleIntegerProperty();
    private final StringProperty shiftStart = new SimpleStringProperty();

    private final StringProperty available = new SimpleStringProperty();
    private final Button button = new Button();

    public void setAvailable(String available) {
        this.available.set(available);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty positionProperty() {
        return position;
    }

    public IntegerProperty hoursOfWorkProperty() {
        return hoursOfWork;
    }

    public StringProperty shiftStartProperty() {
        return shiftStart;
    }

    public StringProperty availableProperty() {
        return available;
    }

    public Button getButton() {
        return button;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart.set(shiftStart);
    }

    public void setHoursOfWork(int hoursOfWork) {
        this.hoursOfWork.set(hoursOfWork);
    }

}
