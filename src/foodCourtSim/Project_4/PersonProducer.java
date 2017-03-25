/**
 * 
 */
package Project_4;

import java.util.Random;

/**
 * @author Roger Ferguson
 */
public class PersonProducer implements ClockListener {

	private int nextPerson = 0;
	private Eatery[] eatery;
	private CheckOut[] checkout;
	private int numOfTicksNextPerson;
	private int averageEateryTime;
	private int averageCheckOutTime;

	private Random r = new Random();

	public PersonProducer(Eatery[] eatery,
			CheckOut[] checkout,
			int numOfTicksNextPerson, 
			int averageEateryTime, 
			int averageCheckOutTime) {
		
		this.eatery = new Eatery[eatery.length];
		this.checkout = new CheckOut[checkout.length];

		for(int i = 0; i < eatery.length; i++)	//transfers all of the eateries
			this.eatery[i] = eatery[i];
		
		for(int k = 0; k < checkout.length; k++)
			this.checkout[k] = checkout[k];
		
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		this.averageCheckOutTime = averageCheckOutTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}


	// This is the method that is called by the clock. 
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = (int) (tick + Math.max(0,numOfTicksNextPerson*0.5*r.nextGaussian() + numOfTicksNextPerson +.5));

			Person person = new Person();

			//int rNumber = (int)(Math.random() * 100);

			person.setEateryTime(Math.max(0,averageEateryTime*0.5*r.nextGaussian() + averageEateryTime +.5));
			person.setCheckOutTime(Math.max(0,averageCheckOutTime*0.5*r.nextGaussian() + averageCheckOutTime +.5));
			person.setTickTime(tick);
			eatery[(int)(Math.random()*eatery.length)].add(person);	//assigns person to a random eatery
		}
	}

}
