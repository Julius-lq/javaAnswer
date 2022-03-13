package complex;

import java.math.*;

/**
 * @author: liuqing
 * date: 2022/1/30 15:04
 * Description:复数类
 */
public class Complex {
    public double a, b;

    //无参构造器
    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    //有int参构造器
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //有Complex参数的构造器
    public Complex(Complex y) {
        this.a = y.a;
        this.b = y.b;
    }

    //重写toString方法——显示虚数字符串
    public String toString() {
        if (this.b < 0) {
            String s1, s2;
            s1 = String.valueOf(this.a);
            s2 = String.valueOf(this.b);
            return s1 + s2 + "i";
        } else if (this.b > 0) {
            String s1, s2;
            s1 = String.valueOf(this.a);
            s2 = String.valueOf(this.b);
            return s1 + "+" + s2 + "i";
        } else {
            String s = String.valueOf(this.a);
            return s;
        }
    }

    //重写equals方法——判断两个虚数是否相等
    public boolean equals(Complex y) {
        BigDecimal aThis = new BigDecimal(this.a);
        BigDecimal bThis = new BigDecimal(this.b);
        BigDecimal aY = new BigDecimal(y.a);
        BigDecimal bY = new BigDecimal(y.b);
        if (aThis.equals(aY) && bThis.equals(bY))
            return true;
        else
            return false;
    }

    //加法：add
    public Complex add(Complex y) {
        double A = this.a + y.a;
        double B = this.b + y.b;
        Complex NEW = new Complex(A, B);
        return NEW;
    }

    //减法：minus
    public Complex minus(Complex y) {
        double A = this.a - y.a;
        double B = this.b - y.b;
        Complex NEW = new Complex(A, B);
        return NEW;
    }

    //乘法：multiply
    public Complex multiply(Complex y) {
        double A = this.a * y.a - this.b * y.b;
        double B = this.a * y.b + this.b * y.a;
        Complex NEW = new Complex(A, B);
        return NEW;
    }
}