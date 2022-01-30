package Complex;

import java.math.*;

/**
 * @author: liuqing
 * date: 2022/1/30 15:04
 * Description:复数类
 * @author: yuansk
 * @date: 2021/1/26 / 17:16
 * @description: 复数表示： a + bi，
 * 属性:
 * 实部a ，虚部b，均为整数
 * <p>
 * 构造器：
 * 无参构造器：默认a=0,b=0
 * 有参构造器：1.参数为a,b
 * 2.参数为一个复数，要求new出的复数和传入的复数a,b相同
 * <p>
 * 方法：
 * 复数加法 add
 * 减法 minus
 * 乘法 multiply
 * 获取实部 getRealPart
 * 获取虚部 getImaginaryPart
 * <p>
 * 重写方法：
 * toString: 要求显示的字符串为 a+bi形式 ，如 -1+2i, 1-2i
 * equals：a,b相等时返回true
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