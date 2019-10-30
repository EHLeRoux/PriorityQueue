package Easy;


import java.util.PriorityQueue;

public class priority {

	/**i
	 * Calculates the intersection of two priority sets and returns the new queue
	 * @param first
	 * @param second
	 * @return returns the new intersection of the two sets
	 */
	public static PriorityQueue<String> intersectionF(PriorityQueue<String> first, PriorityQueue<String> second) {
		PriorityQueue<String> intersec = new PriorityQueue<String>();
		for (String name : first) {
			for (String name2 : second) {
				if (name == name2) {
					intersec.add(name);
				}
			}
		}
		return intersec;

	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return returns the union of the two sets
	 */

	public static PriorityQueue<String> unionF(PriorityQueue<String> first, PriorityQueue<String> second) {
		PriorityQueue<String> union = new PriorityQueue<String>();
		for (String name : first) {
			if (union.contains(name)) {
			} else {
				union.add(name);
			}
			for (String name2 : second) {
				if (union.contains(name2)) {
				} else {
					union.add(name2);
				}
			}
		}
		return union;
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return returns the difference between the two sets
	 */
	
	public static PriorityQueue<String> differenceF(PriorityQueue<String> first, PriorityQueue<String> second) {
		PriorityQueue<String> difference = new PriorityQueue<String>();
		PriorityQueue<String> intersection = new PriorityQueue<String>();
		difference = unionF(first, second);
		intersection = intersectionF(first, second);
		for (String value: intersection) { 
			difference.remove(value);
		}
		for (String value: second) { 
			difference.remove(value);
		}
		return difference;
	}
	
	
	/**
	 * 
	 * These two methods fill in the two priority queues before the other functions 
	 * are called to get the union, intersection and difference.
	 */

	public static PriorityQueue<String> fill() {
		PriorityQueue<String> names1 = new PriorityQueue<String>();
		names1.add("George");
		names1.add("Jim");
		names1.add("John");
		names1.add("Blake");
		names1.add("Kevin");
		names1.add("Michael");
		return names1;

	}

	public static PriorityQueue<String> fill2() {
		PriorityQueue<String> names2 = new PriorityQueue<String>();
		names2.add("George");
		names2.add("Katie");
		names2.add("Kevin");
		names2.add("Michelle");
		names2.add("Ryan");
		return names2;

	}

	public static void main(String[] args) {

		PriorityQueue<String> names1 = fill();
		PriorityQueue<String> names2 = fill2();
		System.out.println("First Queue of Names: ");
		System.out.println(names1);
		System.out.println("Second Queue of Names: ");
		System.out.println(names2);
		System.out.println("Intersection: ");
		System.out.println(intersectionF(names1, names2));
		System.out.println("Union, without duplicates:  ");
		System.out.println(unionF(names1, names2));
		System.out.println("Difference between two sets: ");
		System.out.println(differenceF(names1, names2));

	}

}
