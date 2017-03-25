/**
 * 
 */
package Project_4;

/**
 * @author   Roger Ferguson
 */
public class Person {
	private int tickTime;  // master clock time
	protected double eateryTime;  // time it takes to order food at eatery
	protected double checkOutTime;
	
	public double getCheckOutTime() {
		return checkOutTime;
	}

	public double getEateryTime() {
		return eateryTime;
	}
		
	public int getTickTime() {
		return tickTime;
	}

	public void setCheckOutTime(double checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	public void setEateryTime(double time) {
		this.eateryTime = time;
	}
}
