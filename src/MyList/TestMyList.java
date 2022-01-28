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
        System.out.println(mylist);
        mylist.remove(456);
        System.out.println(mylist);

        Object[] newlist = mylist.clone();
        for (Object obj:newlist)
            System.out.print(obj+" ");
        System.out.print(mylist.hashCode());
    }

}
