package com.kalpa.video;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 列表排序工具类，提供多种列表排序方法。
 */
public class ListSortUtils {
    
    /**
     * 对实现了Comparable接口的元素列表进行自然顺序排序。
     * 
     * @param list 待排序的列表
     * @param <T>  列表元素类型，必须实现Comparable接口
     */
    public static <T extends Comparable<? super T>> void sortNatural(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }


        Collections.sort(list);
    }
    
    /**
     * 使用自定义比较器对列表进行排序。
     * 
     * @param list       待排序的列表
     * @param comparator 自定义比较器
     * @param <T>        列表元素类型
     */
    public static <T> void sortWithComparator(List<T> list, Comparator<? super T> comparator) {
        if (list == null || list.isEmpty() || comparator == null) {
            return;
        }
        Collections.sort(list, comparator);
    }
    
    /**
     * 对实现了Comparable接口的元素列表进行逆序排序。
     * 
     * @param list 待排序的列表
     * @param <T>  列表元素类型，必须实现Comparable接口
     */
    public static <T extends Comparable<? super T>> void sortReverse(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.sort(Collections.reverseOrder());
    }
}