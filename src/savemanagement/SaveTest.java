package savemanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import menu.Display;
import agglomeration.Town;

class SaveTest {

	@Test
	void test() {
		new Save();
		ArrayList<String> alphabetLimited = new ArrayList<String>();
		alphabetLimited.add("A");
		alphabetLimited.add("B");
		alphabetLimited.add("C");
		alphabetLimited.add("D");
		alphabetLimited.add("E");
		alphabetLimited.add("F");
		alphabetLimited.add("G");
		alphabetLimited.add("H");
		Save.setNameTown(alphabetLimited);
		Save.setNbTown(alphabetLimited.size());
		Save.setSchoolLocation(alphabetLimited);
		Town[] villeTab = Town.createTownLoop(Save.getNbTown(), Save.getNameTown());
		for (int i = 0; i < villeTab.length; ++i)
		{
			assertEquals(alphabetLimited.get(i), villeTab[i].getName());			
		}
	}

}
