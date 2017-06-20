package java8ex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Listadd {

	public static void main(String[] args) {
		
		List<Student_details> list=Arrays.asList(
				new Student_details("ravi",12,"M"),
				new Student_details("ram",54,"M"),
				new Student_details("sania",25,"F"),
				new Student_details("kuresh",60,"M"),
				new Student_details("sonia",28,"F")
				);
//		Student_details result=list.stream()
//				.filter(x->"ravi".equals(x.getName()))
//				.findAny()
//				.orElse(null);
//		System.out.println(result);
		
		Student_details result=list.stream()
				.filter((p->p.age<50))
				.findAny()
				.orElse(null);
		System.out.println(result);
		System.out.println(result.getAge());
		
//		list.stream()
//			.filter(p->p.age<50)
//			.map(pm->pm.age)
//			.forEach(System.out::println);
		
		List<Integer> collect= list.stream()
				.filter(p->p.age<50)
				.map(Student_details::getAge)
				.collect(Collectors.toList());
		//collect.forEach(System.out::println);
		
		System.out.println(collect);
		
		List<Object> listage =list.stream()
				.filter(p1->p1.age<50)
				//.forEach(System.out::println);
				.collect(Collectors.toList());
//				.findAny()
//				.orElse(null);
		System.out.println(listage);
		
		
		List<Integer> collectage= list.stream()
				.map(Student_details::getAge)
				.collect(Collectors.toList());
		//collectage.forEach(System.out::println);
		System.out.println(collectage);
		

	}
	

}
