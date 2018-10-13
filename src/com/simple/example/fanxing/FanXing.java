package com.simple.example.fanxing;

public class FanXing {
/**
 * 1.? exends Employee:表示一个未知的Employee子类型，可以给这个方法传递一个
 * ArrayList<Employee>或者由其子类组成的数组列表，比如ArrayList<Manager>
 * 2.ArrayList<? extends Employee>的get方法会返回的变量可以赋值给Employee的变量，
 * 但是将Manager类型的变量通过add方法加入上述集合则编译器将拒绝。所以，对于这类的集合
 * ArrayList<? extends Employee>中读数据，但不能写数据。
 * 3.? super Employee:代表Employee的一个父类型。super的泛型集合与extends的
 * 泛型集合相反，适合写数据而不适合读数据。一般情况下，当给方法指定一个泛型函数式接口的参数
 * 时，你应该使用super通配符。
 * 4.所谓的“PECS”助记码:生产者用extends,消费者用super.从ArrayList读取数据，那就是
 * 生产者，应使用extends通配符。把值加入这个集合，那就是消费者，用super通配符。
 * 5.在虚拟机中，只有原始类型，转换成泛型类型是无效的，但却是合法的。如:
 * Object result=...;
 * ArrayList<String> list=(ArrayList<String>)result;
 * 如果result是一个非常通用过程的结果(比如通过反射调用一个方法),并且编译器不知晓它的准确类型，
 * 则程序员必须使用转换，转换成ArrayList或者ArrayList<?>是不够的。
 * 为了消除警告，像这样注解变量:
 * @SuppressWarings("unchecked") ArrayList<String> list=
 * 		(ArrayList<String>)result;
 * 滥用@SuppressWarings会导致堆污染,本应该属于一个特定泛型类型实例的对象，
 * 实际上却属于一个不同的泛型，例如将ArrayList<Employee>赋值给一个ArrayList<String>引用。
 * 对污染的麻烦在于，报告的运行时错误距离问题的根源还很遥远。
 * 6.反射与泛型:
 * (1) newInstance方法声明：返回一个类型为T的对象,因此String.class有Class<String>类型
 * ，它的newInstance方法返回一个String。
 * public Class<T>{ public T newInstance() throws ...{...}}
 * 例如：
 * public static <T> ArrayList<T> repeat(int n,Class<T> cl)throws ReflectiveOperationException{
 * 		ArrayList<T> result=new ArrayList<>();
 * 		for(int i=0;i<n;i++){
 * 			result.add(cl.newInstance());
 * 		}
 * 		return result;
 * }
 * 假设这样调用repeat(10,Employee.class)调用该方法，由于Employee.class有
 * Class<Employee>类型，因而T被推断为Employee类型。所以，返回类型是ArrayList<Employee>。
 * 除了newInstance方法外，Class类还有几个使用类型参数的其他方法:
 * Class<? super T> getSuperclass()
 * <U> Class<? extends U> asSubclass(Class<U> clazz)
 * T cast(Object obj)
 * Constructor<T> getConstructor(Class<?>... parameterTypes)
 * COnstructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 * T[] getEnumConstants()
 * 7.异常与泛型:
 * (1)不能抛出或捕获一个泛型类对象，实际上，甚至不能构建一个Throwable的泛型子类:
 * public class Problem<T> extends Exception //错误，泛型类不能是Throwable的子类
 * (2)不能在catch子句中使用类型变量:
 * public satic <T extends Throwable> void doWork(Runnable r,Class<T> cl){
 * 		try{
 * 			r.run();
 * 		}catch(T ex){//错误，不能捕获类型变量
 * 			Logger.error(...,ex);
 * 		}
 * }
 * (3)但是在throws声明中，可以使用类型变量：
 * public static<V,T> V doWork(Callable<V> c,T ex) throws T{
 * 		try{
 * 			return c.call();
 * 		}catch(Throwable realEX){
 * 			ex.initCause(realEX);
 * 			throw ex;
 * 		}
 * }
 * 
 * 
 */
}
