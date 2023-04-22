package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public class StringExtension {

    /**
     * 该 {@link String} 为 {@code null} 或者 为 {@code ""}
     * @param string 字符串
     * @return {@link Boolean}
     */
    public static boolean isNullOrEmpty(@This String string){
        return string == null || string.isEmpty();
    }

    /**
     * 确保非 {@code null}
     * @param string 可能为空的字符串
     * @return {@link String}
     */
    public static String ensure(@This String string){
        return string != null ? string : "";
    }
}
