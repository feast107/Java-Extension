package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.jetbrains.annotations.Nullable;

@Extension
public class StringExtension {

    /**
     * 该 {@link String} 为 {@code null} 或者 为 {@code ""}
     *
     * @param string 字符串
     * @return {@link Boolean}
     */
    public static boolean isNullOrEmpty(@This String string) {
        return string == null || string.isEmpty();
    }

    /**
     * 确保非 {@code null}
     *
     * @param string 可能为空的字符串
     * @return {@link String}
     */
    public static String ensure(@This String string) {
        return string != null ? string : "";
    }

    /**
     * 转换为 {@link Integer}
     * @param string 数字
     * @return {@link Integer}
     */
    public static int toInt(@This String string){
        return Integer.parseInt(string);
    }

    /**
     * 转换为 {@link Long}
     * @param string 数字
     * @return {@link Long}
     */
    public static long toLong(@This String string){
        return Long.parseLong(string);
    }

    /**
     * 转换为 {@link Float}
     * @param string 字符串
     * @return {@link Float}
     */
    public static float toFloat(@This String string){
        return Float.parseFloat(string);
    }
}
