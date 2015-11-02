package matchmaking;

import java.util.ArrayList;
import java.util.List;

public class DancerTest {

	static List<DancePair> dancePairs = new ArrayList<DancePair>();
	static List<Dancer> unMatchedDancerList = new ArrayList<Dancer>();

	//DancePair [lead=Dancer [dancerType=LEAD], follow=Dancer [dancerType=FOLLOW], changeable=false]
	public static void testFL(){
		Dancer d1 = new Dancer();
		d1.setDancerType(DancerType.FOLLOW);
		Dancer d2 = new Dancer();
		d2.setDancerType(DancerType.LEAD);
		
		unMatchedDancerList.add(d2);
		DancePair pair = Matching.doMatches(d1, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
		unMatchedDancerList = Matching.getWaitingList();
		System.out.println( unMatchedDancerList.toString());
	}
	
	//DancePair [lead=Dancer [dancerType=LEAD], follow=Dancer [dancerType=FOLLOW], changeable=false]
	public static void testLF(){
		Dancer d1 = new Dancer();

		d1.setDancerType(DancerType.LEAD);
		Dancer d2 = new Dancer();
		d2.setDancerType(DancerType.FOLLOW);
		unMatchedDancerList.add(d2);
		System.out.println( unMatchedDancerList.toString());
		DancePair pair = Matching.doMatches(d1, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
		unMatchedDancerList = Matching.getWaitingList();
		System.out.println( unMatchedDancerList.toString());
	}
	
	//DancePair [lead=Dancer [dancerType=SWITCH], follow=Dancer [dancerType=FOLLOW], changeable=false]
	public static void testFS(){
				Dancer d3 = new Dancer();
				d3.setDancerType(DancerType.FOLLOW);
				Dancer d4 = new Dancer();
				d4.setDancerType(DancerType.SWITCH);
				unMatchedDancerList.add(d3);
				System.out.println( unMatchedDancerList.toString());
				DancePair pair = Matching.doMatches(d4, unMatchedDancerList);
				if (pair!=null) {
					dancePairs.add(pair);
					System.out.println(pair.toString());
				}
				else{
					System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
				}
	}
//[Dancer [dancerType=FOLLOW], Dancer [dancerType=FOLLOW], Dancer [dancerType=SWITCH]]
	public static void testSF(){
		Dancer d3 = new Dancer();
		d3.setDancerType(DancerType.SWITCH);
		Dancer d4 = new Dancer();
		d4.setDancerType(DancerType.FOLLOW);
		unMatchedDancerList.add(d3);
		System.out.println( unMatchedDancerList.toString());
		DancePair pair = Matching.doMatches(d4, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
}
	//DancePair [lead=Dancer [dancerType=LEAD], follow=Dancer [dancerType=SWITCH], changeable=false]
	public static void testSL(){
		Dancer d3 = new Dancer();
		d3.setDancerType(DancerType.SWITCH);
		Dancer d4 = new Dancer();
		d4.setDancerType(DancerType.LEAD);
		unMatchedDancerList.add(d3);
		System.out.println( unMatchedDancerList.toString());
		DancePair pair = Matching.doMatches(d4, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
}
	
	//DancePair [lead=Dancer [dancerType=LEAD], follow=Dancer [dancerType=SWITCH], changeable=false]
	public static void testLS(){
		Dancer d3 = new Dancer();
		d3.setDancerType(DancerType.LEAD);
		Dancer d4 = new Dancer();
		d4.setDancerType(DancerType.SWITCH);
		unMatchedDancerList.add(d3);
		System.out.println( unMatchedDancerList.toString());
		DancePair pair = Matching.doMatches(d4, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
}
	
	public static void testF(){
		Dancer d3 = new Dancer();
		d3.setDancerType(DancerType.FOLLOW);
		DancePair pair = Matching.doMatches(d3, unMatchedDancerList);
		if (pair!=null) {
			dancePairs.add(pair);
			System.out.println(pair.toString());
		}
		else{
			System.out.println("New dancer added to waiting list");// probably want to be able to process and pretty print waiting list
		}
}
	
	public static void main(String[] args){
		testFL();
		unMatchedDancerList =Matching.getWaitingList();
		System.out.println("Current waiting list: " + unMatchedDancerList);
		testLF();
		System.out.println("Current waiting list: " + unMatchedDancerList);
		

//
		
		
		testFS();
		unMatchedDancerList =Matching.getWaitingList();
		testSF();
		unMatchedDancerList =Matching.getWaitingList();
		
		testSL();
		unMatchedDancerList =Matching.getWaitingList();
		testLS();
		unMatchedDancerList =Matching.getWaitingList();
		
		testF();
		System.out.println("All the pairs: "+ dancePairs);
	}

}
