# 停车场管理系统

本次任务需要做一个停车场管理系统，并且需要在系统中简单模拟一个停车场进出的情况

## 基本要求

* 模拟汽车入库出库

* 使用多线程并发操作模拟多辆车进出库

* 停车场只有一个出口一个入口

* 记录停车信息，基本信息：订单号，进出时间，单位时间内收费，总收费，车牌，车型，可以理解为一张收据

* 汽车出库时将停车信息（收据）以文本文件的形式写入文件，并打印在控制台

* 能够在系统中展示所有收据

## 需要实现的基础类

### Car类

* 抽象类，所有车型的基类

* 有3个String类型的字段（品牌，型号，车牌）

* 品牌和型号又子类初始化，且不可改变，车牌由构造方法给出

  要求重写以下3个方法

  ```
  public int hashCode() {} 
  public boolean equals(Object obj) {} 
  public String toString() {} 
  ```

Car类示例

  ```
  public abstract class Car {
      private String number;
      private final String brand = initBrand();
      private final String model = initModel();
  
      public Car(String number) {
          this.number = number;
      }
  
      public String getNumber() {
          return number;
      }
  
      public String getBrand() {
          return brand;
      }
  
  
      public String getModel() {
          return model;
      }
  
      protected abstract String initBrand();
  
      protected abstract String initModel();
  
      @Override
      public int hashCode() {//略}
  
      @Override
      public boolean equals(Object obj) {//略}
  
      @Override
      public String toString() {//略}
  }
  ```

* Car类子类，要求至少写3个Car类子类作为具体汽车类子类示例

```
public class DerivedCar extends Car {
    
    public DerivedCar(String number) {
        super(number);
    }

    @Override
    protected String initBrand() {
        return "品牌";
    }

    @Override
    protected String initModel() {
        return "型号";
    }
}
```

### Transaction类

* 事务类，基本字段：事务编号（订单号），入库时间，出库时间，收费，Car。

* 实现序列化接口

* 构造方法中传入订单号和Car，并以当前时间设置为入库时间。

* 拥有一个出库方法，在出库方法中以当前时间设置出库时间，并计算收费将订单号 + 入库时间 + 出库时间 + 车辆信息 + 收费 以字符串的形式作为返回值返回

### Park类

* 停车场类，采用单例（因为是一个停车场）

* 模拟一个出口一个入口（一个入库方法一个出库方法）

* 为了更好的模拟汽车出入库的停留时间，出入库时需要将该线程sleep 1秒

* 有一个容器字段，存放Transaction对象

* 汽车入库时容器中存入一个Transaction对象

* 出库时从容其中去除相应的Transaction对象，并将停车信息（收据）以文本文件的形式写入文件，并打印在控制台

* 系统正常退出时将容器序列化到文件（即保存当前停车状态）
* 系统打开时从文件中反序列化得到退出时的状态（反序列得到容器对象）

## 你应该思考的问题

* 什么是单例？怎么实现？

* 什么是多线程？怎样理解并发，并行？

* 怎样模拟只有一个出口一个入口？

* 怎样保证容器的线程安全？

* 怎样将对象序列化到文件？怎样从文件中反序列化？

* 怎样将字符串输出到文本文件？怎样从文本文件中读取？

* 常量应该用什么关键字修饰？什么时候使用静态常量？

## 代码要求

* 多人合作，统一的命名规范和代码格式

* 一个方法一个功能，当某个方法中实现了多个功能时你应该考虑将其拆分

## 其他

* 以上只是基本要求，请策划具体完善该管理系统

* 任务时间初定为2周

* 答辩时间：待定