package Project_4;

public class CheckOut implements ClockListener {

	private int timeOfNextEvent = 0;
	private Person person;   // this is the person at the Checkout. 
	private int completed = 0;
	private CheckOutQ Q;
	
	public CheckOut(CheckOutQ q) {
		Q = q;
	}

	public void event (int tick){
		if (tick >= timeOfNextEvent) {

			if (Q.size() >= 1) {
				person = Q.remove(0);		// do not send this person as of yet, make them wait. 
				timeOfNextEvent = tick + (int) (person.getCheckOutTime() + 1);
				
				completed++;
			}	
		}
	}

	public int getThroughPut() {
		return completed;
	}
	
	public int getLeft() {
		return Q.size();
	}
}
