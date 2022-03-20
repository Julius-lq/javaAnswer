package carparking;

import java.io.Serializable;

public class DerivedCar2 extends Car implements Serializable {
    public DerivedCar2(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "长安";
    }

    @Override
    protected String initModel() {
        return "CS55PLUS";
    }
}
