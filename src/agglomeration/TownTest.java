package agglomeration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import menu.Display;
import menu.ToString;

/**
 * Classe de test pour la classe "Town.java".
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
class TownTest {

	@Test
	void test() 
	{
		ArrayList<String>alphabet = Display.createAlphabet(); //Cr�ation d'un alphabet
		Town[] villeTab = new Town[10]; 
		for (int i = 0; i < villeTab.length; ++i) 
		{
			villeTab[i] = new Town(alphabet.get(i)); // On cr�e 10 ville
			assertEquals(false, villeTab[i].isSchool()); // On v�rifie que chaque ville n'a pas d'�cole
			assertEquals("A", villeTab[0].getName()); // On v�rifie que la 1ere ville est nomm� 'A'
			assertEquals(1, villeTab[0].getSerial()); // On v�rifie que la 1ere ville a un serial "1"
			assertEquals(alphabet.get(i), villeTab[i].getName()); // On v�rifie que chaque ville a un nom qui correspond � l'alphabet
			for (int j = 0; j < i; ++j)
				assertNotEquals(villeTab[i].getSerial(), villeTab[j].getSerial()); // On v�rifie que chaque ville a un serial diff�rent
		}
		assertEquals(true, Town.checkTownExist(villeTab, 1)); // On v�rifie que la ville 1 existe dans notre tableau de ville.
		villeTab[0].addToLink(villeTab[0].getLink(),4); // On rajoute la ville 4 comme lien � la ville 1
		villeTab[0].addToLink(villeTab[0].getLink(),5); // On rajoute la ville 5 comme lien � la ville 1
		villeTab[0].addToLink(villeTab[0].getLink(),6); // On rajoute la ville 6 comme lien � la ville 1
		assertEquals(ToString.toStringLink(villeTab[0].getLink()), "4, 5, 6."); // On v�rifie que la ville 1 a comme lien 4, 5 et 6.
		assertEquals(false, Town.checkLinkSchool(villeTab, 1)); // On v�rifie que la ville 1 n'est pas reli� a une ville avec une �cole.
	}

}
