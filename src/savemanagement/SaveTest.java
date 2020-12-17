package savemanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import menu.Display;
import agglomeration.Town;

/**
 * Classe de test pour la classe "Save.java".
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */

class SaveTest {

	@Test
	void test() {
		new Save();
		ArrayList<String> alphabetLimited = new ArrayList<String>(); // on créer une liste de 8 noms.
		alphabetLimited.add("A");
		alphabetLimited.add("B");
		alphabetLimited.add("C");
		alphabetLimited.add("D");
		alphabetLimited.add("E");
		alphabetLimited.add("F");
		alphabetLimited.add("G");
		alphabetLimited.add("H");
		Save.setNameTown(alphabetLimited); // on créer une liste de noms de villes avec les 8 noms
		Save.setNbTown(Save.getNameTown().size()); // le nombre de ville correspond à la taille de la liste de noms, donc 8
		Save.setSchoolLocation(alphabetLimited); // on met une école partout
		Town[] villeTab = Town.createTownLoop(Save.getNbTown(), Save.getNameTown()); // création de ville
		for (int i = 0; i < villeTab.length; ++i) 
		{
			assertEquals(alphabetLimited.get(i), villeTab[i].getName()); // on vérifie que les villes ont bel et bien les noms qu'on veut.
		}
		for (int i = 0; i < villeTab.length; ++i) 
		{
			assertEquals(i+1,Save.convertTownNameToSerial(villeTab, alphabetLimited.get(i))); // on vérifie le nom de chaque ville correspond avec le bon serial.
		}
		
	}

}
