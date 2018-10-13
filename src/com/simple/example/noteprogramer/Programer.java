package com.simple.example.noteprogramer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programer {
	
	public static void main(String[] args) {
		//1.数组转集合两种写法
		String[] names=new String[]{"Lucy","Lily","Liming"};
		List<String> nameLists=new ArrayList(Arrays.asList(names));
		List<String> nameLists2=new ArrayList(Arrays.asList(
		"Lucy","LiMing","Lily"		
		));
		
		/**
		 * 1.手动打jar包:
		 * jar cvte program.jar com.mycompany.Main.class com/mycompany/*.class
		 * 2.
		 * */
		
		
		
	}

}
