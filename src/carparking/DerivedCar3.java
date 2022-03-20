package carparking;

import java.io.Serializable;

public class DerivedCar3 extends Car implements Serializable {
    public DerivedCar3(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "奇瑞";
    }

    @Override
    protected String initModel() {
        return "艾瑞泽GX 冠军版";
    }
}
