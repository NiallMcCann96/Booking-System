public class Seats_Page {

	private int num;
	private String type;
	private String window;
	private boolean table;
	private String direction;
	private boolean access;
	private String email = "";

	public Seats_Page(int num, String type, String window, String direction,
			boolean table, boolean access) {
		this.num = num;
		this.type = type;
		this.window = window;
		this.table = table;
		this.direction = direction;
		this.access = access;
		this.email = "";
	}

	public int getNum() {
		return num;
	}

	public boolean match(String classtype, String window, String direction,
			boolean table, boolean access) {
		return this.type.equals(classtype) && this.window.equals(window)
				&& this.direction.equals(direction) && this.table == table
				&& this.access == access;
	}

	public void print() {
		System.out.print("Number: " + num);
		System.out.print(" Class: " + type);
		System.out.print(" Window: " + window);
		System.out.print(" Table: " + table);
		System.out.print(" Direction: " + direction);
		System.out.print(" Access: " + access);
		System.out.print(" Email: " + email);
		System.out.println();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void cancel() {
		email = "";
	}

	public boolean isReserved() {
		if (email.length() == 0)
			return false;
		else
			return true;
	}

}
