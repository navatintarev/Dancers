package matchmaking;

public class DancePair {
	Dancer lead = null;
	Dancer follow = null;
	boolean changeable = false;
	
	public DancePair(Dancer newDancer, Dancer possibleMatch, boolean changeable) {
		DancerType newDancerType = newDancer.getDancerType();
		DancerType possibleMatchType = possibleMatch.getDancerType();
		
		if (!changeable){// there is no switch and a clear allocation of roles
			//set follow
			if (newDancerType.equals(DancerType.FOLLOW)) follow = newDancer;
			else if (possibleMatchType.equals(DancerType.FOLLOW)) follow = possibleMatch;
			//set lead
			if (newDancerType.equals(DancerType.LEAD)) lead = newDancer;
			else if (possibleMatchType.equals(DancerType.LEAD)) lead = possibleMatch;
		}
		else{
			if (newDancerType.equals(DancerType.SWITCH)) {// New dancer is a switch
				if(possibleMatchType.equals(DancerType.LEAD)){// Possible match (d2) is a LEAD, so switch new dancer (d1) needs to be a follow
					follow = newDancer;
					lead = possibleMatch;
				}
				else {// Possible match is a FOLLOW or SWITCH, so switch new dancer (d1) needs to be a LEAD
					follow = possibleMatch;
					lead = newDancer;
				}
			}
			else if (possibleMatchType.equals(DancerType.SWITCH)){// Possible match is a switch
				if(newDancerType.equals(DancerType.FOLLOW)){// new dancer is a follow
					follow = newDancer;
					lead = possibleMatch;
				}
				else {
					lead = newDancer;
					follow = possibleMatch;
				}
			}
			
		}
	}
	public DancePair() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\nDancePair [lead=" + lead.toString() + ", follow=" + follow.toString() + ", changeable=" + changeable + "]";
	}
	public boolean isChangeable() {
		return changeable;
	}
	public void setChangeable(boolean changeable) {
		this.changeable = changeable;
	}
	public Dancer getLead() {
		return lead;
	}
	public void setLead(Dancer lead) {
		this.lead = lead;
	}
	
	public Dancer getFollow() {
		return follow;
	}
	public void setFollow(Dancer follow) {
		this.follow = follow;
	}
	

	

}
