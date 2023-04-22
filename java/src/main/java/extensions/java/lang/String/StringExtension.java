package extensions.java.lang.String;

public class StringExtension {

    /**
     * 该 {@link String} 为 {@code null} 或者 为 {@code ""}
     *
     * @param string 字符串
     * @return {@link Boolean}
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * 确保非 {@code null}
     *
     * @param string 可能为空的字符串
     * @return {@link String}
     */
    public static String ensure(String string) {
        return string != null ? string : "";
    }

    /**
     * 转换为 {@link Boolean}
     *
     * @param string 布尔值
     * @return {@link Boolean}
     */
    public static boolean toBoolean(String string) {
        return Boolean.parseBoolean(string);
    }

    /**
     * 转换为 {@link Short}
     *
     * @param string 数字
     * @return {@link Short}
     */
    public static short toShort(String string) {
        return Short.parseShort(string);
    }

    /**
     * 转换为 {@link Integer}
     *
     * @param string 数字
     * @return {@link Integer}
     */
    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    /**
     * 转换为 {@link Long}
     *
     * @param string 数字
     * @return {@link Long}
     */
    public static long toLong(String string) {
        return Long.parseLong(string);
    }

    /**
     * 转换为 {@link Float}
     *
     * @param string 字符串
     * @return {@link Float}
     */
    public static float toFloat(String string) {
        return Float.parseFloat(string);
    }

    /**
     * 转换为 {@link Double}
     *
     * @param string 数字
     * @return {@link Double}
     */
    public static double toDouble(String string) {
        return Double.parseDouble(string);
    }
}
