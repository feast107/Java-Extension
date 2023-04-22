package extensions.java.lang.Object;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;
import org.jetbrains.annotations.Debug;

import java.util.Objects;

@Extension
public class ObjectExtension {
    /**
     * @param o 对象
     * @return 对象
     * @throws NullPointerException 如果为空
     */
    public static @Self Object notNull(@This Object o) {
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
    public static <T> @Self Object ifNull(@This Object o, T or) {
        return o != null ? o : or;
    }

    /**
     * 是否为空
     *
     * @param o 对象
     * @return 是否为空
     */
    public static boolean isNull(@This Object o) {
        return o == null;
    }

    /**
     * 判断对象是否是类型 {@link T}
     *
     * @param o     对象
     * @param type 类型
     * @param <T>   类型
     * @return {@link Boolean}
     */
    public static <T> boolean is(@This Object o, Class<T> type) {
        return o.getClass() == type;
    }
}
