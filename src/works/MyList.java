package works;

/**
 * 作业要求：实现myList的所有函数，并对所有函数以合适的方法测试
 */
public class MyList implements Cloneable{
    private int size = 0;
    private static final int MIN_SIZE = 10;//方便初始化使用
    private Object[] list = new Object[MIN_SIZE];
    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public Object get(int index){
        return  null;
    }

    /**
     * 将某元素o放入index位置
     * @param index
     * @param o
     */
    public void set(int index,Object o){

    }

    /**
     * 在末尾添加元素
     * @param o
     */
    public void add(Object o) {

    }

    /**
     * 把other的所有元素添加到当前myList中
     * @param other
     */
    public void addAll(MyList other) {

    }

    /**
     * 去除掉o元素,
     */
    public boolean remove(Object o) {
        return false;
    }
    /**
     * 去除掉other中的所有元素
     */
    public boolean removeAll(MyList other){
        return false;
    }
    /**
     * 清除列表元素
     */
    public void clear() {

    }
    /**
     * 判断是否含元素o
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return false;
    }

    /**
     * 判断列表是否为空
     */
    public void isEmpty() {

    }

    /**
     * 获取o元素的位置，没有则返回-1
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * 从最后开始遍历获取o元素位置
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * 获取myList的元素个数
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * 创建一个元素相同的副本
     * @return
     */
    @Override
    protected MyList clone() {
        return new MyList();
    }

    /**
     * 将myList转换为字符串
     * @return
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * 获取元素的hash值 （不会？请去百度）
     * @return
     */
    @Override
    public int hashCode() {
        return 1;
    }
}

