package town;

public class Town 
{
	private static int serialcounter = 0;
	private char name;
	private int serial;
	private boolean school;
	private int[] link;
	
	public Town(char name)
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
	}

	public char getName() {
		return name;
	}

	public int getSerial() {
		return serial;
	}

	public boolean isSchool() {
		return school;
	}

	public void setSchool(boolean value) {
		this.school = value;
	}

	public int[] getLink() {
		return link;
	}	
	

	
}
