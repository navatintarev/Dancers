package matchmaking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Matching {
	static List<Dancer> waitingList = new ArrayList<Dancer>();
	


	/**
	 * @param newDancer - dancer entering the system
	 * @param unMatchedDancers - all previously unmatched dancers
	 * @param dancePairs - existing pairs
	 * @return dancePair - returns a dance pair if successfull, null if not
	 */
	public static DancePair doMatches(Dancer newDancer, List<Dancer> unMatchedDancers){
		DancerType dancerType1 = newDancer.getDancerType();
		DancerType dancerType2 = null;
		Dancer possibleMatch = null;
		DancePair dancePair = null;
		boolean isMatched = false; 
		waitingList = new ArrayList<Dancer>();
		// Try a L-F, F-L match first
		Iterator<Dancer> dancerIt = unMatchedDancers.iterator();
		while (dancerIt.hasNext()){
			possibleMatch = dancerIt.next();
			dancerType2 = possibleMatch.getDancerType();
			if (isCompatible(dancerType1, dancerType2)){
				dancePair = new DancePair(newDancer, possibleMatch, false);
				isMatched = true;
				
				while (dancerIt.hasNext()){// match found so return other dancers to the pool
					dancerIt.next();
					possibleMatch = dancerIt.next();
					waitingList.add(possibleMatch); 
				}
				break;//pair found, break
			}
		}

		//If a L-F match is not possible, try to do a L-S or F-S match
		if (isMatched == false){
			waitingList = new ArrayList();
			Iterator<Dancer> dancerIt2 = unMatchedDancers.iterator();
			while (dancerIt2.hasNext()){
				possibleMatch = dancerIt2.next();
				dancerType2 = possibleMatch.getDancerType();
				
				if (isSwitch(dancerType1, dancerType2)){
					dancePair = new DancePair(newDancer, possibleMatch, true);
					isMatched = true;
					
					while (dancerIt2.hasNext()){// match found so return other dancers to the pool
						dancerIt2.next();
						possibleMatch = dancerIt2.next();
						waitingList.add(possibleMatch); 
					}	
					break; //pair found, break
				}
				 
			}
		}
		
		if (isMatched == false) waitingList.add(possibleMatch); // possible match still in the pool
		
		return dancePair;
	}

	public static List<Dancer> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(List<Dancer> waitingList) {
		this.waitingList = waitingList;
	}

	private static boolean isCompatible(DancerType dancerType1, DancerType dancerType2) {
		if (dancerType1.equals(DancerType.FOLLOW) && dancerType2.equals(DancerType.LEAD)) return true;
		else if (dancerType2.equals(DancerType.FOLLOW) && dancerType1.equals(DancerType.LEAD)) return true;
		else return false;
	}

	private static boolean isSwitch(DancerType dancerType1, DancerType dancerType2) {
		if (dancerType1.equals(DancerType.SWITCH) || dancerType2.equals(DancerType.SWITCH)) return true;
		else return false;
	}


	/* TODO
	 * Reorganize matchings to see if switches can be released
	 * */

}
