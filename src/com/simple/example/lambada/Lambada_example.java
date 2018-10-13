/**
 * 
 */
package com.simple.example.lambada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** 
 * @ClassName: Lambada_example 
 * @Description: lambda表达式的使用
 * @author: pengyu
 * @date: 2018年7月31日 上午11:26:02  
 */

public class Lambada_example {
	/***
	 * 使用lambda就在于延迟执行，如果你想立即执行一段代码，无须将代码封装进lambda,你可以直接调用。
	 * 适用举例:
	 * 1.在另一个单独的线程中运行代码  
	 * 2.多次运行代码   repeat(10,() -> System.out.println("Hello"))
	 * 3.在算法的恰当时刻运行代码(例如，排序中的比较操作)
	 * 4.当某些情况发生时运行代码(按钮被单击、数据到达等)
	 * 5.只有在需要的时候才运行代码
	 * @param args
	 */
	public static void main(String[] args) {
		//例子1:如果lambda表达式没有参数，提供空的小括号，就像没有参数的方法
		//另外，如果lambda表达式的参数类型可以被推导出来，则可以省略类型
		Runnable r= () -> {
			for(int i=0;i<100;i++) {
				System.out.println(i);
			}
		};
		Thread t=new Thread(r);
		t.start();
		
		/*案例二:
		 * lambda表达式的方法引用: 操作符::将方法名称与类或对象名称分隔开，有以下三种使用方式：
		 * 1.类::实例方法
		 * 2.类::静态方法
		 * 3.对象::实例方法
		 * 补充：
		 * 1.可以在方法引用中捕获this参数：this::equals等同于x -> this.equals(x)
		 * 2.可以以外部类.this::方法名称捕获外部类的this引用。
		 * 3.构造函数的引用  类名::new ,例如: Streams<Employee> stream=names.stream().map(Employee::new);
		 * 返回指定类型的数组  Employee[] buttons=stream.toArray(Emploeyee[]::new);
		 * 
		 * */
		String[] strings=new String[] {"sdfsfsdf","dsfsdfsdf"};
		// 等价于  Arrays.sort(strings,(x,y) -> x.compareToIgnoreCase(y)),属于第一种使用方式
		Arrays.sort(strings,String::compareToIgnoreCase);
		
		List<Object> list=new ArrayList<>();
		//从集合中移除可能为空的对象  Objects::isNull 相当于 Objects.isNull(Object),属于第二种使用方式
		list.removeIf(Objects::isNull);
		
		//System.out::println 相当于 x -> System.out.println(x),属于第三种使用方式
		list.forEach(System.out::println);
		
		repeatMessage("hello",3);
		
	}
	
	//这里的this与普通的this一样,调用的是本类的toString,而不是Runnable实例的toString
	//lambda表达式的作用域被嵌套在doWork方法中
	public void doWork() {
		Runnable runner=() -> {System.out.println(this.toString());};
	}
	
	public static void repeatMessage(String text,int count){
		Runnable r=() ->{
			for(int i=0;i<count;i++){
				System.out.println(text);
			}
		};
		Thread t=new Thread(r);
		t.start();
		
	}
	
	
}
