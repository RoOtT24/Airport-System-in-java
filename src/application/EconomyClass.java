package application;

public class EconomyClass extends Seat {

	@Override
	public int compareTo(Seat o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public EconomyClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EconomyClass(String seatNum) {
		//super((seatNum.length() == 2 && (int) seatNum.charAt(1) > 5)
			//	|| (seatNum.length() == 3 && !((seatNum.charAt(1) == '1' && (seatNum.charAt(2) == '3'))
				//		|| !((int) seatNum.charAt(1) >= 3 && (int) seatNum.charAt(2) > 0))) && seatNum.charAt(0) >= 'A'
					//	&& seatNum.charAt(0) <= 'F' ? seatNum : null);
		super(seatNum);
		super.setRowNum(seatNum.length() == 2?   Integer.parseInt(new StringBuilder().append(seatNum.charAt(1)).toString()) : Integer.parseInt(new StringBuilder().append(seatNum.charAt(1)).append(seatNum.charAt(2)).toString()));
		super.setColumnNum(seatNum.charAt(0) == 'A' ? 1 : seatNum.charAt(0) == 'B'? 2 : seatNum.charAt(0) == 'C' ? 3 : seatNum.charAt(0) == 'D' ? 4 : seatNum.charAt(0) == 'E' ? 5 : 6);

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EconomyClass [getRowNum()=" + getRowNum() + ", getColumnNum()=" + getColumnNum() + ", "
				+ (getSeatNum() != null ? "getSeatNum()=" + getSeatNum() + ", " : "")
				+ (getPassenger() != null ? "getPassenger()=" + getPassenger() + "" : "") + "]";
	}
	

}