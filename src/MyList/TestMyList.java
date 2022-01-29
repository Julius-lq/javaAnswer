package MyList;

/**
 * @author:liuqing
 * @date: 2022/1/28/ 13:23
 * @description:
 */
public class TestMyList {
    public static void main(String[] args) {
        Mylist mylist = new Mylist();
        mylist.add(123);
        mylist.add("abc");
        mylist.add(456);
        mylist.add(789);
        System.out.println("添加四组数据后结果为：\t"+mylist);
        mylist.remove(456);
        System.out.println("添加456后结果为：\t\t"+mylist);

        Integer[] list = new Integer[2];
        list[0]=8;
        list[1]=9;
        mylist.addAll(list);
        System.out.println("添加一个数组后结果为：\t"+mylist);

        Object[] newlist = mylist.clone();
        System.out.print("逐个打印mylist中的值：\t");
        for (Object obj:newlist)
            System.out.print(obj+" ");
        System.out.print("\nmylist的hash值为：\t"+mylist.hashCode());
    }

}
