package com.simple.example.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/***
 * 
 *1.流(Stream)提供了数据视图,可以在比集合类更高的概念层上指定操作。使用流，只需要指定做什么
 *，而不是怎么做。只需要将操作的调度执行留给实现。例如，假设想要计算某个属性的平均值，只需指定
 *数据源和属性，然后流类库会优化计算，比如使用多线程来求和，技术以及合并结果 。
 *2.可以从结合、数组、生成器或迭代器创建流。
 *3.使用过滤器filter来选择元素，使用map进行元素转换。
 *4.对于转换流的操作还包括limit、distinct、sorted。
 *5.要从Stream中获得结果，请使用归纳操作，如count、max、min、findFirst或者findAny，返回
 *Option类型值。
 *6.流与集合的区别:
 *(1)流不存储元素。
 *(2)流操作不改变它们的数据源，例如filter方法不会从一个新流中删除元素，而是生成一个不包含特定元素的新流。
 *(3)如果可能的话,Stream操作可能是延迟执行的。
 *
 *
 */
public class StreamKnowledge {
	
	//希望统计一本书中的所有长单词
	//stream遵循做什么，而不是去怎么做。本例描述了要做的是:找到长单词并对它们计数。
	public long stream_filter_example() throws Exception{
		String contents=new String(Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		List<String> words=Arrays.asList(contents.split("\\+"));
		long count=words.stream().filter(w ->w.length() >12).count();
		return count;
	}
	
	//将所有单词转换成小写形式和提取每个单词的第一个字符
	public Stream<String> stream_map_example() throws Exception{
		String contents=new String(Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		List<String> words=Arrays.asList(contents.split("\\+"));
		//将所有单词转换成小写形式
		Stream<String> lowercaseWords=words.stream().map(String::toLowerCase);
		//提取每个单词的第一个字符
		Stream<String> firstLetters=words.stream().map(s -> s.substring(0, 1));
		return lowercaseWords;
	}
	
	//distinct方法会根据原始流中的元素返回一个具有相同顺序、抑制了重复元素的新流。
	public Stream<String> stream_distinct_example() {
		//只获取了一个jack
		Stream<String> uniqueWords=Stream.of("jack","jack","jack","jack").distinct();
		return uniqueWords;
	}
	
	//简单规约,Option<T>类型的值，可能会封装返回值，也可能表示没有返回(当流为空时)
	//Optional类型是一种更好的表名缺少返回值的方式。
	//Optional<T>对象是一个T类型对象或空对象的封装。
	public void jiandanguiyue() throws IOException{
		String contents=new String(Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		List<String> words=Arrays.asList(contents.split("\\+"));
		//获取一个流中的最大值:
		Optional<String> largest=words.stream().max(String::compareToIgnoreCase);
		System.out.println("largest:"+largest.orElse(""));
		
		//与filter结合，findFirst返回非空集合中的第一个值
		Optional<String> startsWithQ=words.stream().
				filter(s -> s.startsWith("Q")).findFirst();
		
		//如果不是要第一个，则可以使用findAny
		Optional<String> startsWithQany=words.stream().parallel().
				filter(s -> s.startsWith("Q")).findFirst();
		
		//如果你只是想知道流中是否含有匹配元素，则使用anyMatch方法，这个方法接受
		//一个predicate参数，所以不需要使用filter方法。
		/**
		 * 另外，如果所有元素都跟predicate匹配的话，allMatch方法将返回true,如果没有
		 * 元素匹配的话，noneMatch方法返回true，这两个方法都可以通过并行而提高速度。
		 */
		boolean aWordStartsWithQ=words.stream().parallel().
				anyMatch(s -> s.startsWith("Q"));
		
		/**
		 * 使用flatMap来组合可选值函数
		 * 假设有一个返回Optional<T>的方法f,并且T有一个会返回Optional<U>的方法g
		 * 如果他们都是普通的方法，则可以调用s.f().g()将之组合，但在这里不行，因为
		 * s.f()方法返回Optional<T>,而不是T。但是，我们可以调用:
		 * Optional<U> result=s.f().flatMap(T::g);
		 * 如果s.f()存在，会继续调用g;否则，返回空的Optional<U>.
		 * 假设有一个Stream<Person>对象:
		 * Map<Integer,String> idToName=people.collect(
		 * Collectors.toMap(Person::getId,Person::getName)
		 * );
		 * 如果此时值为实际元素，则用:
		 * Map<Integer,Person> idToPerson=people.collect(
		 * Collectors.toMap(Person::getId,Function.identity()));
		 * 
		 */
		
	}

}
