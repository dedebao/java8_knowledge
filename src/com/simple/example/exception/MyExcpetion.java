package com.simple.example.exception;

/**
 * 自己封装的异常
 * 对于异常:
 * 1.如果没有任何地方捕获异常，就会显示堆栈踪迹(stack trace),异常抛出时，所有未决
 * 方法的调用信息，堆栈信息会被送到错误信息的流System.err
 * 2.如果要存储异常的堆栈踪迹，可以把它放进一个字符串中:
 * ByteArrayOutputStream out=new ByteArrayOutputStream();
 * ex.printStackTrace(out);
 * String description=out.toString();
 * 
 * @author pengyu
 *
 */
public class MyExcpetion extends Exception {

	/**
	 * MyException的用法:
	 * try{
	 * 
	 * }catch(sqlException ex){
	 *   Throwable ex2=new MyException("出现异常");
	 *   ex2.initCause(ex);
	 *   throw ex2;//ex2保存异常原因，调用initCause,抛出
	 * 
	 * }
	 */
	private static final long serialVersionUID = 1L;
	
	public MyExcpetion(Throwable cause){
		initCause(cause);
	}
	
	public MyExcpetion(String message,Throwable cause){
		super(message);
		initCause(cause);
	} 

}
