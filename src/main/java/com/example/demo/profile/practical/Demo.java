package com.example.demo.profile.practical;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Demo {

	private final static Logger log = Logger.getLogger(Demo.class.getName());

	public static void main(String[] args) {

		/*
		 * Write generic function List<Integer> abc={5,7,15,16}
		 * 
		 * Filter this list to elements which are divisible by 5 and find max element
		 * 
		 */

		List<Integer> abc = List.of(5, 7, 15, 16);

		System.out.println("Divisble by 5 " + abc.stream().filter(n -> n % 5 == 0).toList());

		System.out.println("Max: " + abc.stream().max(Comparator.naturalOrder()));

		System.out.println("Divisble by 5 & max " + 
				abc.stream()
				.filter(n -> n % 5 == 0)
				.max(Comparator.naturalOrder()
						).get());

	}
	
	// Table -employee, column - empno, salary, department.
	// max salary per department
	
	//select max(salary) from employee group by deparetment
	
	//select department, MAX(salary) AS max_salary FROM employee GROUP BY department;
	
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		// Calculate the length of the linked list
		int length = 1;
		ListNode tail = head;
		while (tail.next != null) {
			length++;
			tail = tail.next;
		}

		// Adjust k to be less than the length of the list
		k = k % length;
		if (k == 0) {
			return head;
		}

		// Find the new tail node
		ListNode newTail = head;
		for (int i = 0; i < length - k - 1; i++) {
			newTail = newTail.next;
		}

		// Form a cycle by connecting the original tail node to the original head node
		tail.next = head;

		// Update the head pointer to the node next to the new tail node
		head = newTail.next;

		// Update the new tail node's next pointer to null to break the cycle
		newTail.next = null;

		return head;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}