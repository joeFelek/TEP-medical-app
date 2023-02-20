package HY360.TableEntities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Staff {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty pos = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty addr = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final Button button = new Button();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPos() {
        return pos.get();
    }

    public StringProperty posProperty() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos.set(pos);
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

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAddr() {
        return addr.get();
    }

    public StringProperty addrProperty() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr.set(addr);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public Button getButton() {
        return button;
    }
}
