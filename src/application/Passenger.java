package application;

public class Passenger extends Person {

	private long passport;
	private int seatPref;
	final static int WINDOW = 0;
	final static int AISLE = 1;
	final static int NONE = 2;

	public Passenger() {
		super();
	}

	public Passenger(String name, long passport, int seatPref) {
		super(name);
		this.passport = passport;
		this.seatPref = seatPref;
	}

	public long getPassport() {
		return passport;
	}

	public void setPassport(long passport) {
		this.passport = passport;
	}

	public int getSeatPref() {
		return seatPref;
	}

	public void setSeatPref(int seatPref) {
		this.seatPref = seatPref;
	}

	public static int getWindow() {
		return WINDOW;
	}

	public static int getAisle() {
		return AISLE;
	}

	public static int getNone() {
		return NONE;
	}

	@Override
	public String toString() {
		return "Passenger [name=" +super.getName()+", passport=" + passport + ", seatPref=" + seatPref + "]";
	}

	/*	@Override
	protected Person person(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

}