package com.simple.example.fanxing;

//一个用来存储键/值对的简单泛型类
public class Entry<K, V> {
	private K key;
	private V value;
	public Entry(K key,V value){
		this.key=key;
		this.value=value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	
	
}
