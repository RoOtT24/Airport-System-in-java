package application;

public class Seat implements Comparable<Seat> {

	private int rowNum;
	private int columnNum;
	private String seatNum;
	private Passenger passenger;

	public Seat() {
		super();
	}

	protected Seat(String seatNum) {
		super();

		this.seatNum = seatNum;
		this.passenger = null;
		//this.rowNum = rowNum;
		//this.columnNum = columnNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Seat [rowNum=" + rowNum + ", columnNum=" + columnNum + ", "
				+ (seatNum != null ? "seatNum=" + seatNum + ", " : "")
				+ (passenger != null ? "passenger=" + passenger : "") + "]";
	}

	@Override
	public int compareTo(Seat o) {
		if(this.seatNum.compareTo(o.seatNum)>0)
			return 1;
		else if(this.seatNum.compareTo(o.seatNum)<0)
		return -1;
		else return 0 ;
	}


	// protected abstract Seat seat(String seatNum);

	

}