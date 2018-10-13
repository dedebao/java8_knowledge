package com.simple.example.lambada;

import java.util.Comparator;

//处理或返回函数的函数被称为高阶函数
public class HignFunction {

	//返回函数的方法,创建一个产生正确比较器的方法，传1产生升序比较器，传-1会产生降序比较器
	//应用举例:Arrays.sort(friends,compareInDirection(-1))
	public static Comparator<String> compareInDirection(int direction){
		return (x,y) -> direction*x.compareTo(y);
	}
	
	//修改函数的方法,接收一个函数并返回一个修改后的函数。
	public static Comparator<String> reverse(Comparator<String> comp){
		return (x,y) -> comp.compare(x, y);
	}
	
	
	
	
}
