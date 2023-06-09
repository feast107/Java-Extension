package extensions.java.util.List;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

@Extension
public class ListExtension {

    /**
     * 获取数量
     *
     * @param source 源对象
     * @param <E>    对象类型
     * @return 数量
     */
    public static <E> int count(@This List<E> source) {
        return source.size();
    }

    /**
     * 通过下标获取一个值
     *
     * @param source 源列表
     * @param index  下标
     * @param <E>    对象类型
     * @return 值
     */
    public static <E> E at(@This List<E> source, int index) {
        return source.get(index);
    }

    /**
     * 有任何一个满足
     *
     * @param source 源列表
     * @param match  匹配条件
     * @param <E>    对象类型
     * @return 是否
     */
    public static <E> boolean any(@This List<E> source, Predicate<E> match) {
        return source.stream().anyMatch(match);
    }

    /**
     * 全部满足
     *
     * @param source 源列表
     * @param match  匹配条件
     * @param <E>    对象类型
     * @return 是否
     */
    public static <E> boolean all(@This List<E> source, Predicate<E> match) {
        return source.stream().allMatch(match);
    }

    /**
     * 查找符合条件的 {@link E}
     *
     * @param source 源数据列表
     * @param match  符合条件
     * @param <E>    对象类型
     * @return 找到的E，可能为空
     */
    public static <E> E find(@This List<E> source, Predicate<E> match) {
        for (E i : source) {
            if (match.test(i)) {
                return i;
            }
        }
        return null;
    }

    /**
     * 查找符合条件的E的下标
     *
     * @param source 源列表
     * @param match  符合条件
     * @param <E>    对象类型
     * @return 下标，如果没找到则为 {@code -1}
     */
    public static <E> int findIndex(@This List<E> source, Predicate<E> match) {
        for (int i = 0; i < source.size(); i++) {
            if (match.test(source.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回最后一个符合条件的对象
     *
     * @param source 源列表
     * @param match  匹配条件
     * @param <E>    对象类型
     * @return 对象 or null
     */
    public static <E> E findLast(@This List<E> source, Predicate<E> match) {
        var iter = source.listIterator(source.size());
        while (iter.hasPrevious()) {
            var e = iter.previous();
            if (match.test(e)) return e;
        }
        return null;
    }

    /**
     * 返回最后一个符合条件的对象的下标
     *
     * @param source 源列表
     * @param match  匹配条件
     * @param <E>    对象类型
     * @return 下标 没找到则为 -1
     */
    public static <E> int findLastIndex(@This List<E> source, Predicate<E> match) {
        var iter = source.listIterator(source.size());
        while (iter.hasPrevious()) {
            if (match.test(iter.previous())) return iter.nextIndex();
        }
        return -1;
    }

    /**
     * 返回所有满足条件的 {@link E}
     *
     * @param source 源对象
     * @param match  判断条件
     * @param <E>    对象类型
     * @return 目标列表
     */
    public static <E> List<E> findAll(@This List<E> source, Predicate<E> match) {
        var ret = new ArrayList<E>();
        for (E e : source) {
            if (match.test(e)) {
                ret.add(e);
            }
        }
        return ret;
    }

    /**
     * 返回首个元素
     *
     * @param source 源列表
     * @param <E>    对象类型
     * @return 首个元素，如果没有则为 {@literal null}
     */
    public static <E> E firstOrNull(@This List<E> source) {
        return source.stream().findAny().orElse(null);
    }

    /**
     * 所有符合条件的对象
     *
     * @param source 源列表
     * @param match  符合条件
     * @param <E>    对象类型
     * @return 目标列表，不为空
     */
    public static <E> List<E> where(@This List<E> source, Predicate<E> match) {
        List<E> ret = new ArrayList<>();
        for (E e : source) {
            if (match.test(e)) {
                ret.add(e);
            }
        }
        return ret;
    }

    /**
     * 得到基于对象属性的子队列
     *
     * @param source   源列表
     * @param selector 属性选择器
     * @param <E>      对象类型
     * @param <R>      子容器对象类型
     * @return 新的队列
     */
    public static <E, R> List<R> select(@This List<E> source, Function<E, R> selector) {
        List<R> ret = new ArrayList<>();
        source.forEach(x -> ret.add(selector.apply(x)));
        return ret;
    }

    public static <E, R> List<R> convertAll(@This List<E> source, Function<E, R> converter) {
        return source.select(converter);
    }

    /**
     * 提供种子进行全局遍历
     *
     * @param source 源列表
     * @param seed   种子
     * @param action 遍历的操作
     * @param <E>    对象类型
     * @param <R>    种子类型
     * @return 最终的种子
     */
    public static <E, R> R aggregate(@This List<E> source, R seed, BiFunction<R, E, R> action) {
        for (E i : source) {
            seed = action.apply(seed, i);
        }
        return seed;
    }

    /**
     * 反转
     *
     * @param source 源列表
     * @param <E>    对象类型
     * @return 反转后的列表
     */
    public static <E> List<E> reverse(@This List<E> source) {
        var ret = new ArrayList<E>();
        for (E e : source) {
            ret.add(0, e);
        }
        return ret;
    }

    /**
     * 去重
     *
     * @param source 源列表
     * @param <E>    对象类型
     * @return 去重后的列表
     */
    public static <E> List<E> distinct(@This List<E> source) {
        return source.stream().distinct().toList();
    }

    /**
     * 根据属性去重
     *
     * @param source   源列表
     * @param selector 属性选择器
     * @param <E>      对象类型
     * @param <R>      属性类型
     * @return 去重后的列表
     */
    public static <E, R> List<E> distinctBy(@This List<E> source, Function<E, R> selector) {
        List<E> ret = new ArrayList<>();
        source.forEach(x -> {
            if (!ret.any(e -> selector.apply(e).equals(selector.apply(x)))) {
                ret.add(x);
            }
        });
        return ret;
    }

    /**
     * 升序排序
     *
     * @param source   源列表
     * @param selector 排序依据的属性
     * @param <E>      对象类型
     * @param <R>      属性类型
     * @return 排序后的列表
     */
    public static <E, R extends Comparable<R>> List<E> orderBy(@This List<E> source, Function<E, R> selector) {
        List<E> ret = new ArrayList<>();
        source.forEach(x -> {
            for (int i = 0; i < ret.size(); i++) {
                if (selector.apply(x) < selector.apply(ret.get(i))) {
                    ret.add(i, x);
                    return;
                }
            }
            ret.add(x);
        });
        return ret;
    }

    /**
     * 降序排序
     *
     * @param source   源列表
     * @param selector 排序依据的属性
     * @param <E>      对象类型
     * @param <R>      属性类型
     * @return 排序后的列表
     */
    public static <E, R extends Comparable<R>> List<E> orderByDescending(@This List<E> source, Function<E, R> selector) {
        List<E> ret = new ArrayList<>();
        source.forEach(x -> {
            for (int i = 0; i < ret.count(); i++) {
                if (selector.apply(x) > selector.apply(ret.at(i))) {
                    ret.add(i, x);
                    return;
                }
            }
            ret.add(x);
        });
        return ret;
    }

    /**
     * 转换为 {@link HashMap}
     *
     * @param source        源列表
     * @param keySelector   键选择器
     * @param valueSelector 值选择器
     * @param <E>           对象类型
     * @param <K>           键类型
     * @param <V>           值类型
     * @return HashMap
     */
    public static <E, K, V> Map<K, V> toMap(@This List<E> source, Function<E, K> keySelector, Function<E, V> valueSelector) {
        Map<K, V> ret = new HashMap<>();
        source.forEach(x -> {
            ret.put(keySelector.apply(x), valueSelector.apply(x));
        });
        return ret;
    }
}
