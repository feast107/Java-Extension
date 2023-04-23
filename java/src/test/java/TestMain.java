import org.jetbrains.annotations.TestOnly;

import java.util.*;

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

    private static void print(Object o) {
        System.out.println(o);
    }

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
        print(List.findLastIndex(x -> x.sequence == -1));

        String str = String.empty();
        str += "1";
        print(String.empty());
        print(str.isNullOrEmpty());
        str = null;
        print(str.isNullOrEmpty());
        str = "0";
        print(str.toBoolean());
        str = "114";
        print(str.toShort());
        print(str.toInt());
        print(str.toLong());
        str = "114.514";
        print(str.toFloat());
        print(str.toDouble());

        Object o = null;
        print(o.isNull());
        o = "";
        print(o.notNull().ifNull("").is(String.class));

        Date d = Date.now().add(Date.fromDays(1));
        print(d);
        d = d.addSeconds(14);
        print(d);
        d = d.addMinutes(3);
        print(d);
        d = d.addHours(2);
        print(d);
        d = d.addDays(15);
        print(d);
        d = Date.now().add(Date.fromDays(2)).minus(Date.now());
        print(d.totalMillionSeconds());
        print(d.totalSeconds());
        print(d.totalMinutes());
        print(d.totalHours());
        print(d.totalDays());
    }
}
