# MyGson

### json是一种轻量级的数据交换格式，可以用来传输各种基于基本数据类型的对象。

例如：![image-20220307194959146](C:\Users\zzp\AppData\Roaming\Typora\typora-user-images\image-20220307194959146.png)

Person person = new Person("张三", 18, true);这个person对象所对应的json字符串则为

{"name":"张三"，"age":18, "isAdult":true}

### 那Gson是啥？

Gson是google开发的一个解析json的框架，也是android开发中最常用的一个json框架。

代码实例：

![image-20220307195932279](C:\Users\zzp\AppData\Roaming\Typora\typora-user-images\image-20220307195932279.png)

![image-20220307200059201](C:\Users\zzp\AppData\Roaming\Typora\typora-user-images\image-20220307200059201.png)

### 进入正题：

仿造Gson，使用泛型和反射写一个MyGson。只要求实现toJson和fromJson两个方法，参数和返回值与上面两图中一致，能够替换掉上面两图中的Gson且输出结果一致。（fromJson的返回值类型别就是一个Person）

​	

