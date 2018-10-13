package com.simple.example.InnerClass;

import java.util.ArrayList;

//当内部类的实例需要知道它属于外部类的哪个实例时,使用普通内部类
public class Network {
	
	private ArrayList<Member> members;//网络内的所有成员
	
	public class Member{//普通内部类
		private String name;
		private ArrayList<Member> friends;//结识的朋友		
		
		public Member(String name){
			this.name=name;
			friends=new ArrayList<>();
		}
		
		//成员想离开
		public void leave(){
			//内部类的方法可以访问外部成员的变量
			//这里相当于Network.this.members.remove(this)
			members.remove(this);
		}
		
		//需要明确外部类引用的情形，检查一个Member是否属于某个特定网络
		public boolean belongsTo(Network n){
			return Network.this==n;
		}
	}
	
	
	public Member enroll(String name){
		Member member=new Member(name);
		members.add(member);
		return member;
	}
	
	
	
	public static void main(String[] args) {
		Network network=new Network();
		Network.Member fred=network.enroll("pengyu");
		//在外部类的任何实例上调用内部类构造函数
		Network.Member pengyu=network.new Member("pengyu");
	}
}
