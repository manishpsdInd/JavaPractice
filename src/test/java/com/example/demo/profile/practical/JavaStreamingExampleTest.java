package com.example.demo.profile.practical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JavaStreamingExampleTest {

	/**
	 * Question1: How would you use the Stream API to calculate 
	 * the sum of all even numbers in a list of integers?
	 */
	@Test
	public void Question1()	{
		List<Integer> sample = Arrays.asList(1, 2, 3, 4, 5, 6);
		int expected = 12;
		int actual = sample.stream()
                .filter(n -> n % 2 == 0) // Intermediate operations return a new stream and are lazy
                .mapToInt(Integer::intValue) // Intermediate operations return a new stream and are lazy
                .sum(); //  Terminal operation
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question2: How can you use the Stream API 
	 * to transform a list of strings into a list of their lengths? 
	 */
	@Test
	public void Question2()	{
		List<String> sample = Arrays.asList("apple", "banana", "cherry");
		List<Integer> expected = List.of(5,6,6);
		List<Integer> actual = sample.stream()
				.map(String::length)
				.toList();
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question3: How would you use the Stream API 
	 * to group a list of employees name by their department?
	 */
	@Test
	public void Question3()	{
		List<Employee> sample = Employee.getEmpListImmutable();
		Map<String, List<Employee>> actual = sample.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		Map<String, List<Employee>> expected = sample.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question4: How can you use the Stream API 
	 * to sort a list of custom objects by a specific field, such as age?
	 */
	@Test
	public void Question4()	{
		List<Employee> sample = Employee.getEmpListMutable();
		List<Employee> actual = sample.stream()
				.sorted((e1, e2) -> e1.getAge() - e2.getAge())
				//.sorted(Comparator.comparing(Employee::getSalary))
				.toList();
		Comparator<Employee> comparator =
				(Employee emp1, Employee emp2) -> Integer.compare(emp1.getAge(), emp2.getAge());
        //Not Working - (Employee emp1, Employee emp2) -> emp1.getAge() - emp2.getAge();

		Collections.sort(sample, comparator);
		Assert.assertEquals(sample, actual);
	}
	
	/**
	 * Question5: How would you use the Stream API 
	 * to find the highest salary value in a list of Employee?
	 */
	@Test
	public void Question5()	{
		Double expected = 42000.42d;
		List<Employee> sample = Employee.getEmpListImmutable();
		Optional<Employee> optional = sample.stream()
                .max(Comparator.comparing(Employee::getSalary));
		Double actual = optional.isPresent()?optional.get().salary:0.0d;
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question6: How can you use the Stream API 
	 * to remove all null values from a list?
	 */
	@Test
	public void Question6()	{
		List<Employee> sample = Employee.getEmpListImmutable();
		List<Employee> actual = sample.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		List<Employee> expected = sample.stream()
				.filter(e -> Objects.nonNull(e))
				//.filter(e -> e.getSalary()>40000d)
				.collect(Collectors.toList());
		
		Assert.assertEquals(true, expected.equals(actual));
	}
	
	/**
	 * Question7: How would you use the Stream API to 
	 * concatenate all employee names into a single comma-separated string?
	 */
	@Test
	public void Question7()	{
		List<Employee> sample = Employee.getEmpListImmutable();
		String actual = sample.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(","));
		String expected = "Adi,Jone,Jane,Visu,Keya,Lucy,Adri,Sam";
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question8: How can you use the Stream API 
	 * to partition a list of numbers into even and odd numbers?
	 */
	@Test
	public void Question8_I()	{
		List<Employee> data = Employee.getEmpListImmutable();
		List<Integer> sample = data.stream()
				.map(e -> e.getAge())
				.toList();
		
		List<Integer> even = sample.stream()
				.filter(i -> i%2==0)
				.collect(Collectors.toList());
		List<Integer> expectedEven = List.of(40,26,46,30);
		Assert.assertEquals(expectedEven, even);

		List<Integer> odd = sample.stream()
				.filter(i -> i%2!=0)
				.collect(Collectors.toList());
		List<Integer> expectedOdd = List.of(23,21,33,35);
		Assert.assertEquals(expectedOdd, odd);
	}
	
	/**
	 * Question8: How can you use the Stream API 
	 * to partition a list of numbers into even and odd numbers?
	 */
	@Test
	public void Question8_II()	{
		List<Integer> sample = Employee.getEmpListImmutable().stream()
				.map(e -> e.getAge())
				.toList();
		
		Map<Boolean, List<Integer>> partitioned = sample.stream()
				.collect(Collectors.partitioningBy(i -> i%2==0));

		List<Integer> even = List.of(40,26,46,30);
		Assert.assertEquals(partitioned.get(true), even);
		
		List<Integer> odd = List.of(23,21,33,35);
		Assert.assertEquals(partitioned.get(false), odd);
	}
	
	/**
	 * Question9: How would you use the Stream API 
	 * to flatten a nested list of strings into a single list? 
	 */
	@Test
	public void Question9()	{
		List<String> name = Employee.getEmpListImmutable().stream()
				.map(e -> e.getName())
				.toList();
		List<String> dept = Employee.getEmpListImmutable().stream()
				.map(e -> e.getDepartment())
				.distinct()
				.toList();
		List<List<String>> sample = Arrays.asList(name, dept);
		
		List<String> actual = sample.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		String expectedData = "Adi,Jone,Jane,Visu,Keya,Lucy,Adri,Sam,"
		                		+ "Advance Engineering Service,"
		                		+ "Advance Business Service," 
		                		+ "Engineering Portfolio";
		String[] expectedArray = expectedData.split(",");
		List<String> expected = Arrays.asList(expectedArray);
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Question10: How can you use the Stream API to 
	 * calculate the average age of a list of people? 
	 */
	@Test
	public void Question10()	{
		List<Employee> sample = Employee.getEmpListMutable();
		Double actual = sample.stream()
				.collect(Collectors.averagingDouble(Employee::getAge));
		Double expected = 31.75d;
		Assert.assertEquals(expected, actual);
		
		List<Integer> data = sample.stream()
				.map(Employee::getAge)
				.toList();
		Double dt = data.stream().mapToInt(Integer::intValue).average().getAsDouble();
		Assert.assertEquals(expected, dt);
		
		Double row = Employee.getEmpListMutable().stream()
			.map(e -> e.getAge())
			.mapToInt(a -> a)
			.average()
			.getAsDouble();
		Assert.assertEquals(expected, row);
	}
	
	/*
	 * Question24: How can you use the Stream API 
	 * to convert a list of objects to a map with a specific field as the key?
	 */
	@Test
	public void Question24()	{
		List<Employee> sample = Employee.getEmpListImmutable();
		Map<String, List<Employee>> actual = sample.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		Assert.assertEquals(true, true);
	}
	
	/*
	 * Question23: How can you use the Stream API 
	 * to find the name of the second largest salaried employee from the list of Employees?
	 */
	@Test
	public void Question23()	{
		List<Employee> sample = Employee.getEmpListImmutable();
		String expected = "Jane"; 
		String actual = 
				sample.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(1)
				.findFirst()
				.map(Employee::getName)
				.get();
		
		Assert.assertEquals(expected, actual);
	}
	
	/*
	 * Question30: How can you use the Stream API 
	 * to generate a stream of random numbers and limit it to a specific size?
	 */
	@Test
	public void Question26()	{
		Assert.assertEquals(true, true);
	}
	
	/*
	 * Question30: How can you use the Stream API 
	 * to generate a stream of random numbers and limit it to a specific size?
	 */
	@Test
	public void Question27()	{
		Assert.assertEquals(true, true);
	}
		
	public static class Employee {
		private String name;
		private String department;
		private int age;
		private double salary;
		
		Employee(String name, String department, int age, double salary)	{
			this.name = name;
			this.department = department;
			this.age = age;
			this.salary = salary;
		}
		
		public static List<Employee> getEmpListImmutable()	{
			return List.of(
					new Employee("Adi","Advance Engineering Service", 23,32000.32),
					new Employee("Jone","Advance Business Service", 21,12000.31),
					new Employee("Jane","Advance Business Service", 33,35000.12),
					new Employee("Visu","Engineering Portfolio", 40,42000.42),
					new Employee("Keya","Advance Engineering Service", 26,11000.36),
					new Employee("Lucy","Advance Business Service", 46,32000.62),
					new Employee("Adri","Engineering Portfolio", 35,22000.78),
					new Employee("Sam","Advance Engineering Service", 30,35000.01)
			);
		}

		public static List<Employee> getEmpListMutable()	{
			List<Employee> empList = new ArrayList<>();
			empList.add(new Employee("Adi","Advance Engineering Service", 23,32000.32));
			empList.add(new Employee("Jone","Advance Business Service", 21,12000.31));
			empList.add(new Employee("Jane","Advance Business Service", 33,35000.12));
			empList.add(new Employee("Visu","Engineering Portfolio", 40,42000.42));
			empList.add(new Employee("Keya","Advance Engineering Service", 26,11000.36));
			empList.add(new Employee("Lucy","Advance Business Service", 46,32000.62));
			empList.add(new Employee("Adri","Engineering Portfolio", 35,22000.78));
			empList.add(new Employee("Sam","Advance Engineering Service", 30,35000.01));
			return empList;
		}
		
		public static List<Employee> getEmpListWithNull()	{
			List<Employee> empList = new ArrayList<>();
			empList.add(new Employee("Adi","Advance Engineering Service", 23,32000.32));
			empList.add(null);
			empList.add(new Employee("Jone","Advance Business Service", 21,12000.31));
			empList.add(new Employee("Jane","Advance Business Service", 33,35000.12));
			empList.add(null);
			empList.add(null);
			empList.add(null);
			empList.add(new Employee("Visu","Engineering Portfolio", 40,42000.42));
			empList.add(new Employee("Keya","Advance Engineering Service", 26,11000.36));
			empList.add(new Employee("Lucy","Advance Business Service", 46,32000.62));
			empList.add(new Employee("Adri","Engineering Portfolio", 35,22000.78));
			empList.add(null);
			empList.add(new Employee("Sam","Advance Engineering Service", 30,35000.01));
			empList.add(null);
			empList.add(null);
			return empList;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + ", salary=" + salary
					+ "]";
		}
	}
}
