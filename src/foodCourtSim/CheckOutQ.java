package Project_4;

import java.util.ArrayList;

public class CheckOutQ {
	private ArrayList<Person> q;
	private int maxQ;
	
	public CheckOutQ() {
		q = new ArrayList<Person>();
		maxQ = 0;
	}
	
	public void add(Person p) {
		q.add(p);
		if(q.size() > maxQ)
			maxQ = q.size();
	}
	
	public Person remove(int i) {
		return q.remove(i);
	}
	
	public int size() {
		return q.size();
	}
	
	public int maxQ() {
		return maxQ;
	}
}
