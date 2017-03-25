/**
 * 
 */
package Project_4;


/**
 * @author Roger Ferguson
 *
 */
public class Sim {

	public static void main (String[] args) {
		int numEateries = 5;
		int numCheckOuts = 2;


		Clock clk = new Clock();
		Eatery[] eateryList = new Eatery[numEateries];	//array of eateries so multiple can be made
		CheckOut[] checkoutList = new CheckOut[numCheckOuts];

		// 		int numOfTicksNextPerson = 20 
		//      int averageBoothTime = 20

		for(int k = 0; k < numEateries; k++)
			eateryList[k] = new Eatery();		//adds an eatery to the array

		for(int c = 0; c < numCheckOuts; c++)
			checkoutList[c] = new CheckOut();

		PersonProducer produce = new PersonProducer(eateryList, checkoutList, 20, 18, 45);	
		clk.add(produce);

		for(int i = 0; i < numEateries; i++)
			clk.add(eateryList[i]);
		
		for(int p = 0; p < numCheckOuts; p++)
			clk.add(checkoutList[p]);

		clk.run(10000);

		for(int j = 0; j < numEateries; j++) {		//prints out data for all of the eateries
			System.out.println("Eatery " + (j+1) + ":");
			System.out.println("Through put is: " + eateryList[j].getThroughPut() + " people.");
			System.out.println("People that are still in the Q:" + eateryList[j].getLeft() + " people.");
			System.out.println ("Max Q length:" + eateryList[j].getMaxQlength() + " people.\n");

		}
		for(int l = 0; l < numCheckOuts; l++) {		//prints out data for all of the eateries
			System.out.println("Check Out " + (l+1) + ":");
			System.out.println("Through put is: " + checkoutList[l].getThroughPut() + " people.");
			System.out.println("People that are still in the Q:" + checkoutList[l].getLeft() + " people.");
			System.out.println ("Max Q length:" + checkoutList[l].getMaxQlength() + " people.\n");
		}
	}
}
