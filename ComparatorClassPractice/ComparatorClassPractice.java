import java.util.*;

public class ComparatorClassPractice{
	public static void main(String[] args){
		PriorityQueue<Person> list = new PriorityQueue<Person>((a,b) -> a.age<b.age ? (a.state.equals(b.state) ? -1 : 1) : 1);

		list.add(new Person("Dhairya", 21, "Seattle4"));
		list.add(new Person("Dhairya", 22, "Seattle5"));
		list.add(new Person("Dhairya", 23, "Seattle9"));
		list.add(new Person("Dhairya", 24, "Seattle6"));
		list.add(new Person("Dhairya", 25, "Seattle8"));
		list.add(new Person("Dhairya", 26, "Seattle2"));
		list.add(new Person("Dhairya", 27, "Seattle1"));

		// Collections.sort(list, new Comparator<Person>(){
		// 	@Override
		// 	public int compare(Person p1, Person p2){
		// 		return p2.name.compareTo(p1.name);
		// 	}
		// });

		while(list.size()>0){
			Person each = list.poll();
			System.out.println("------------------");
			System.out.println("Name: "+each.name);	
			System.out.println("Age: "+each.age);
			System.out.println("State: "+each.state);
			System.out.println("------------------");
		} 

	}


	static class Person{
		int age;
		String name;
		String state;

		public Person(String name, int age, String state){
			this.age = age;
			this.name = name; 
			this.state = state;
		}
	}
}