package application;

import java.util.Arrays;
import java.util.Date;

public class Trip {

	private Seat[][] seat = new Seat[32][];
	private String tripNum;
	private String from;
	private String to;
	private Date date;

	public Trip() {
		//super();
	}

	public Trip(String tripNum, String from, String to, Date date) {
		//super();
		this.tripNum = tripNum;
		this.from = from;
		this.to = to;
		this.date = date;
		for (int i = 1; i < seat.length; i++) {
			if (i < 4)
				seat[i] = new FirstClass[4];

			else if (i!=4 || i!=5 || i!=13)
				seat[i] = new EconomyClass[6];
			else seat[i] = null ;
		}
		
		for (int i = 1; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if (i < 4) {
					char[] fc = { 'A', 'C', 'D', 'F' };
					//System.out.println("j = "+j+"	i = "+i+"	"+new StringBuilder().append(fc[j]).append(i).toString());
					seat[i][j] = new FirstClass(new StringBuilder().append(fc[j]).append(i).toString());
					//System.out.println(seat[i][j].toString());
				}

				else if (i!=4 && i!=5 && i!=13) {
					char[] ec = { 'A', 'B', 'C', 'D', 'E', 'F' };
					//System.out.println("j = "+j+"	i = "+i+"	"+new StringBuilder().append(ec[j]).append(i).toString());
					seat[i][j] = new EconomyClass(new StringBuilder().append(ec[j]).append(i).toString());
				}
				else seat[i] = new Seat[0];
			}
		}
	}

	public Seat[][] getSeat() {
		return seat;
	}

	public void setSeat(Seat[][] seat) {
		this.seat = seat;
	}

	public String getTripNum() {
		return tripNum;
	}

	public void setTripNum(String tripNum) {
		this.tripNum = tripNum;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Trip [" + (seat != null ? "seat=" + Arrays.toString(seat) + ", " : "")
				+ (tripNum != null ? "tripNum=" + tripNum + ", " : "") + (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "") + (date != null ? "date=" + date : "") + "]";
	}

	public void reserveSeat(String seatNum, Passenger p) {

	/*	if (seatNum.length() == 3 && ((seatNum.charAt(1) == '1' && seatNum.charAt(2) == '3')
				|| ((int) seatNum.charAt(1) >= 3 && (int) seatNum.charAt(2) > 0)))
			return;
		else if (seatNum.length() == 2 && (seatNum.charAt(1) == '4') || (seatNum.charAt(1) == '5'))
			return;
*///System.out.println(p.toString());
		if (isSeatEmpty(seatNum) && this.getSeat(seatNum) != null) 
			this.getSeat(seatNum).setPassenger(p);
			//System.out.println(p.toString());
		//	System.out.println(this.getSeat(seatNum).getPassenger().toString());
		
	}

	public boolean isSeatEmpty(String seatNum) {

	/*	if (seatNum.length() == 3 && ((seatNum.charAt(1) == '1' && seatNum.charAt(2) == '3')
				|| ((int) seatNum.charAt(1) >= 3 && (int) seatNum.charAt(2) > 0)))
			return false;
		else if (seatNum.length() == 2 && (seatNum.charAt(1) == '4') || (seatNum.charAt(1) == '5'))
			return false;
*/
		for (int i = 1; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
			//	System.out.println(seat[i].length);
				if(i != 13 && i != 4 && i != 5)
				if (this.seat[i][j].getSeatNum() != null) 
			
				if (this.seat[i][j].getSeatNum().trim().equalsIgnoreCase(seatNum.trim()) && this.seat[i][j].getPassenger()==null) 
				return true;
				
			}
		}
		return false;
	}

	public Seat getSeat(String seatNum) {

		/*if (seatNum.length() == 3 && ((seatNum.charAt(1) == '1' && seatNum.charAt(2) == '3')
				|| ((int) seatNum.charAt(1) >= 3 && (int) seatNum.charAt(2) > 0)))
			return null;
		else if (seatNum.length() == 2 && (seatNum.charAt(1) == '4') || (seatNum.charAt(1) == '5'))
			return null;*/
		for (int i = 1; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if(i != 13 && i != 4 && i != 5)
				if (this.seat[i][j].getSeatNum().trim().equalsIgnoreCase(seatNum.trim())) {
					// if (this.seat[i][j].getPassenger() != null)
					//System.out.println("hi");
					return seat[i][j];
				}
			}
		}
		return null;

	}
}