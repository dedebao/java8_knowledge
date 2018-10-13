package com.simple.example.InnerClass;

import java.util.Random;

/***
 * 局部内部类：
 * 在方法内定义一个类，称为局部类。常常发生在:当一个类实现了一个接口并且方法的调用者
 * 只关心接口，而不是类时。
 * 创建局部类的两个好处:
 * 1.类名隐藏在方法范围内
 * 2.局部类的方法可以访问来自闭合作用域的变量。
 * @author pengyu
 *
 */
public class PartInner {
	
	private static Random generator=new Random();
	//产生给定范围内的无限序列随机整数
	public static IntSequence randomInts1(int low,int high){
		//如果将RamdomSequece转变为嵌套类，则不得不提供一个显示的构造函数，让它接收这些值
		//并将这些值存储在实例变量中。
		
		class RandomSequence implements IntSequence{

			@Override
			public int next() {
				// TODO Auto-generated method stub
				return low+generator.nextInt(high -low +1);
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return true;
			}			
		}
		return new RandomSequence();
	}
	
	/***
	 * randomInts1中类名RandomSequence用了一次，用来构造返回值。
	 * 这种情况，可以使用匿名内部类
	 *
	 */
	public static IntSequence randomInts2(int low,int high){
		return new IntSequence(){

			@Override
			public int next() {
				// TODO Auto-generated method stub
				return low+generator.nextInt(high -low +1);
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return true;
			}
			
		};
	}
}
