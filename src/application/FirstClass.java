package application;

public class FirstClass extends Seat {

	@Override
	public int compareTo(Seat o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FirstClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FirstClass(String seatNum) {
	//	super(seatNum.length() == 2 &&(seatNum.charAt(0) == 'A' || seatNum.charAt(0) == 'C' || seatNum.charAt(0) == 'D'
		//		|| seatNum.charAt(0) == 'F') && (int) seatNum.charAt(1) < 4 && (int) seatNum.charAt(1) > 0 ? seatNum
			//: null);
		super(seatNum);
		super.setRowNum(Integer.parseInt(new StringBuilder().append(seatNum.charAt(1)).toString()));
		super.setColumnNum(seatNum.charAt(0) == 'A' ? 1 : seatNum.charAt(0) == 'C'? 2 : seatNum.charAt(0) == 'D' ? 3 : 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FirstClass [getRowNum()=" + getRowNum() + ", getColumnNum()=" + getColumnNum() + ", "
				+ (getSeatNum() != null ? "getSeatNum()=" + getSeatNum() + ", " : "")
				+ (getPassenger() != null ? "getPassenger()=" + getPassenger() + "" : "") + "]";
	}

}