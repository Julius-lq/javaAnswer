package mylist;

import java.util.Arrays;

/**
 * 作业要求：实现myList的所有函数，并对所有函数以合适的方法测试
 */
public class Mylist {
    private int size = 0;
    private static final int MIN_SIZE = 10;//方便初始化使用
    private Object[] a;
    private int k = 7;//(java常用31)

    public Mylist(int size) {
        this.a = new Object[size];
    }

    public Mylist() {
        this.a = new Object[MIN_SIZE];
    }

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index >= size) {
            System.out.println("数组越界");
            return -1;
        }
        return a[index];
    }

    /**
     * 将某元素o放入index位置
     * @param index
     * @param o
     */
    public Object set(int index, Object o) {
        if (index >= size) return -1;
        this.a[index] = o;
        return a[index];
    }

    /**
     * 在末尾添加元素
     * @param o
     */
    public boolean add(Object o) {
        if (size >= a.length) a = Arrays.copyOf(a, a.length * 2);
        a[size] = o;
        size++;
        return a[size] == o;
    }

    /**
     * 把other的所有元素添加到当前myList中
     * @param other
     */
    public boolean addAll(Object[] other) {
        for (int i = 0; i < other.length; i++) {
            this.add(other[i]);
        }
        return this.containsAll(other);
    }

    /**
     * 去除掉o元素,
     */
    public boolean remove(Object o) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == null && o == null) continue;
            if (a[i] == null) continue;
            if (a[i].equals(o)) {
                a[i] = null;
            }
        }
        return (!this.contains(o)) || o == null;
    }

    /**
     * 去除掉other中的所有元素
     */
    public boolean removeAll(Object[] e) {
        boolean b = true;
        for (int i = 0; i < e.length; i++) {
            if (!this.remove(e[i])) b = false;
        }
        return b;
    }

    /**
     * 清除列表元素
     */
    public void clear() {
        for (int i = 0; i < a.length; i++) {
            this.a[i] = null;
        }
    }

    /**
     * 判断是否含元素o
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == null && o == null) {
                return true;
            }
            if (a[i] == null) continue;
            if (a[i].equals(o)) return true;
        }
        return false;
    }

    /**
     * 把other的所有元素添加到当前myList中
     * @param other
     */
    public boolean containsAll(Object[] other) {
        int i;
        for (i = 0; i < other.length; i++) {
            if (!this.contains(other[i])) return false;
        }
        return true;
    }

    /**
     * 判断列表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取o元素的位置，没有则返回-1
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == null && o == null) {
                return i;
            }
            if (a[i] == null) continue;
            if (a[i].equals(o)) return i;
        }
        return -1;
    }

    /**
     * 从最后开始遍历获取o元素位置
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        int i;
        for (i = a.length - 1; i > 0; i--) {
            if (a[i] == null && o == null) {
                return i;
            }
            if (a[i] == null) continue;
            if (a[i].equals(o)) return i;
        }
        return -1;
    }

    /**
     * 获取myList的元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 创建一个元素相同的副本
     * @return
     */
    @Override
    public Object[] clone() {
        Object[] b = new Object[size];
        System.arraycopy(a, 0, b, 0, size);
        return b;
    }

    /**
     * 将myList转换为字符串
     * @return
     */
    @Override
    public String toString() {
        int i = 0;
        StringBuilder s = new StringBuilder("[");
        s.append(a[i]);
        i++;
        for (; i < size; i++) {
            s.append(",").append(a[i]);
        }
        s = new StringBuilder(s.toString().concat("]"));
        return s.toString();
    }

    /**
     * 获取元素的hash值 （不会？请去百度）
     * @return
     */
    public int hashCode() {
        int hash=0;
        for (int i=0;i<size;++i){
//            hash+=Math.pow(k,i)*Objects.hash(a[i]);
            if(a[i]!=null)hash+=Math.pow(k,i)*a[i].hashCode();
        }
        return hash;
    }
}