package matchmaking;

public class Dancer {
	DancerType dancerType;
	String level;
	String track;
	String name;
	int id;
	
	public Dancer(){}
	
	public DancerType getDancerType() {
		return dancerType;
	}
	@Override
	public String toString() {
		return "Dancer [dancerType=" + dancerType + "]";
	}

	public void setDancerType(DancerType dancerType) {
		this.dancerType = dancerType;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}

	

}
