package carparking;

import java.io.Serializable;

public class DerivedCar1 extends Car implements Serializable {
    public DerivedCar1(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "红旗";
    }

    @Override
    protected String initModel() {
        return "红旗H7 1.8T";
    }
}
