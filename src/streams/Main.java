package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	private static List<Person> getPeople() {
		return List.of(new Person("Antonio", 20, Gender.MALE), new Person("Alina Smith", 33, Gender.FEMALE),
				new Person("Helen White", 57, Gender.FEMALE), new Person("Alex Boz", 14, Gender.MALE),
				new Person("Jamie Goa", 99, Gender.MALE), new Person("Anna Cook", 7, Gender.FEMALE),
				new Person("Zelda Brown", 120, Gender.FEMALE));
	}

	public static void main(String[] args) {

		List<Customer> customers = EkartDataBase.getAll();

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> customer.getEmail()
		// customer -> customer.getEmail() one to one mapping
		List<String> emails = customers.stream().map(c -> c.getEmail()).collect(Collectors.toList());
		emails.stream().forEach(System.out::println);

//customer -> customer.getPhoneNumbers()  ->> one to many mapping
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<List<String>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(phoneNumbers);

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> phone Numbers
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<String> phones = customers.stream()
				.flatMap(customer -> customer.getPhoneNumbers().stream().map(n -> n + 0)).collect(Collectors.toList());
		System.out.println(phones);

		List<Person> people = getPeople();
		List<Person> female = people.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());
		female.forEach(System.out::println);
		people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList())
				.forEach(System.out::println);
		boolean b=people.stream().allMatch(p -> p.getAge()>5);
		System.out.println(b);
		people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::print);
		people.stream().collect(Collectors.groupingBy(Person::getGender)).forEach((gender,people1) ->{
			System.out.println(gender);
			people1.stream().forEach(System.out::println);
		});
		
	}
}
