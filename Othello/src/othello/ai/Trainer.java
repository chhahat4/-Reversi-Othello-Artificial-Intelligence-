/**
 * 
 */
package othello.ai;

import java.util.ArrayList;


public class Trainer {
	private ArrayList<DataBlob> getData() {
		// For testing
		String fileName = "1423417408889";
		
		return DataCollector.read(fileName);
	}
	
	public static void main(String[] args) {
		Trainer trainer = new Trainer();
		ArrayList<DataBlob> data = trainer.getData();
		
		System.out.println("Read " + data.size() + " rows");
		
		for(DataBlob blob : data)
			System.out.println(blob);
	}
}
