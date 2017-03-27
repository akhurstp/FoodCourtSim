package Project_4;

public class Sim {

	public static void main (String[] args) {
		int numEateries = 5;
		int numCheckOuts = 2;

		CheckOutQ q = new CheckOutQ();

		Clock clk = new Clock();
		Eatery[] eateryList = new Eatery[numEateries];	//array of eateries so multiple can be made
		CheckOut[] checkoutList = new CheckOut[numCheckOuts];

		for(int k = 0; k < numEateries; k++) {
			eateryList[k] = new Eatery(q);		//adds an eatery to the array
			clk.add(eateryList[k]);
		}

		for(int c = 0; c < numCheckOuts; c++) {
			checkoutList[c] = new CheckOut(q);
			clk.add(checkoutList[c]);
		}

		PersonProducer produce = new PersonProducer(eateryList, checkoutList, 20, 60, 10);	
		clk.add(produce);

		clk.run(10000);

		int peopleInLine = q.size();
		int throughPut = 0;
		int numPeople = produce.getNumPeople();
		for(int i = 0; i < numEateries; i++) {
			peopleInLine = peopleInLine + eateryList[i].getLeft();
		}
		for(int j = 0; j < numCheckOuts; j++) {
			throughPut = throughPut + checkoutList[j].getThroughPut();
		}
		
		System.out.println("Through put is " + throughPut + " people out of " + numPeople);
		System.out.println("There are " + peopleInLine + " in line still");
		System.out.println("Max Q cashier line " + q.maxQ());
	}
}
