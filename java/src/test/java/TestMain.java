import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Foo {
    static int Count = 0;
    public int sequence = ++Count;
    public int priority = Integer.MAX_VALUE - sequence;

    public String name = "This is number:" + Count + " of Foo , whose priority is:" + priority;

    @Override
    public String toString() {
        return name;
    }
}

public class TestMain {
    private static final List<Foo> List = new ArrayList<>();

    public static void main(String[] __) {
        List.add(new Foo());
        List.add(new Foo());
        List.add(new Foo());
        List.add(new Foo());
        List.add(new Foo());
        List.add(new Foo());
        List<Foo> temp = new ArrayList<>();

        List
                .orderBy(x -> x.priority)
                .aggregate(temp, (s, i) -> {
                    System.out.println(i);
                    return List;
                })
                .orderByDescending(x -> x.sequence)
                .aggregate(temp, (s, i) -> {
                    System.out.println(i);
                    return List;
                })
                .where(x -> x.sequence > 3)
                .aggregate(temp, (s, i) -> {
                    System.out.println(i);
                    return List;
                })
                .findAll(x -> x.sequence > 0)
                .select(x -> x.name)
                .reverse()
                .forEach(System.out::println);
        System.out.println(List.findLastIndex(x -> x.sequence == -1));

        String str = "";
        System.out.println(str.isNullOrEmpty());
        str = null;
        System.out.println(str.isNullOrEmpty());
        str = "0";
        System.out.println(str.toBoolean());
        str = "114";
        System.out.println(str.toShort());
        System.out.println(str.toInt());
        System.out.println(str.toLong());
        str = "114.514";
        System.out.println(str.toFloat());
        System.out.println(str.toDouble());

        Object o = null;
        System.out.println(o.isNull());
        o = "";
        System.out.println(o.notNull().ifNull("").is(String.class));
    }
}
