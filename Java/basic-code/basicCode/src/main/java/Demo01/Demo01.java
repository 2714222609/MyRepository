package Demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("李元芳");
        coll.add("孙尚香");
        coll.add("狄仁杰");
        coll.add("虞姬");

        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String s : coll) {
            System.out.println(s);
        }
    }
}
