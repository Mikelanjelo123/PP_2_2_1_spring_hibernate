package hiber.model;


import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {


    @Column(name = "model")
    private String model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "series")
    private int serial;

    public Car() {

    }

    public Car(String model, int serial) {
        this.model = model;
        this.serial = serial;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int series) {
        this.serial = series;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + ", series=" + serial + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return serial == car.serial && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, serial);
    }
}
