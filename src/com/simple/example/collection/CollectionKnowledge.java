package com.simple.example.collection;

public class CollectionKnowledge {
/**
 * 1.Collections类的有用方法:
 * boolean disjoint(Collection<?> c1,Collection<?> c2):如果两个集合不含有相同的元素,则返回true
 * boolean copy(List<? super T>dest,List<? extends T>src):从src中复制元素到dest中的相同索引位置上
 * ，dest长度至少和src一样。
 * boolean replaceAll(List<T> list, T oldVal T newVal):使用newVal替代所有oldVal,两者可能都会
 * 为null,至少一个匹配时返回true。
 * void fill(List<? super T>list,T obj):将list的所有元素加入obj中
 * int frequency(Collection<?> c,Object o):返回c中与o相等元素的数量
 * int indexOfSubList(List<?> source,List<?> target)与int LastIndexOfSubList(List<?> source,List<?> target)
 * 返回target列表在source列表中第一次或最后一次出现的起始位置，不存在的话返回-1
 * sort(List<T> list,Comparator<? super T>c):使用自然元素顺序或者c顺序对list进行排序
 * 2.Map返回键、值、记录的视图:
 * Set<K> keySet()
 * Collection<V> values
 * Set<Map.Entry<K,V>> entrySet()
 * 返回的集合不是map数据的拷贝，但他们与map相联，如果从视图中移除了键或记录，那么该记录也将
 * 从实际关联的map中删除。要迭代map中的所有key和value,可以遍历entrySet方法返回的set：
 * for(Map.Entry<String,Integer> entry:counts.entrySet()){
 * 		String k=entry.getKey();
 * 		Integer v=entry.getValue();
 *     //处理k ,v
 * }
 * 或者使用forEach方法:
 * counts.forEach((k,v) -> {
 * 		处理 k, v
 * });
 */
}
