package extensions.java.lang.Object;


import lombok.experimental.ExtensionMethod;

import java.util.Objects;

public class ObjectExtension {

    /**
     * @param o 对象
     * @return 对象
     * @throws NullPointerException 如果为空
     */
    public static Object notNull(Object o) {
        return Objects.requireNonNull(o);
    }

    /**
     * 返回对象本身或者 {@link T}
     *
     * @param o   对象
     * @param or  如果为空的值
     * @param <T> 类型
     * @return 对象
     */
    public static <T> Object ifNull(Object o, T or) {
        return o != null ? o : or;
    }

    /**
     * 是否为空
     *
     * @param o 对象
     * @return 是否为空
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * 判断对象是否是类型 {@link R}
     *
     * @param o    对象
     * @param type 类型
     * @param <R>  类型
     * @return {@link Boolean}
     */
    public static <R> boolean is(Object o, Class<R> type) {
        return o.getClass() == type;
    }
}

