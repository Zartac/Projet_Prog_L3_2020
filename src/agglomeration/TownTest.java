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
		ArrayList<String>alphabet = Display.createAlphabet(); //Création d'un alphabet
		Town[] villeTab = new Town[10]; 
		for (int i = 0; i < villeTab.length; ++i) 
		{
			villeTab[i] = new Town(alphabet.get(i)); // On crée 10 ville
			assertEquals(false, villeTab[i].isSchool()); // On vérifie que chaque ville n'a pas d'école
			assertEquals("A", villeTab[0].getName()); // On vérifie que la 1ere ville est nommé 'A'
			assertEquals(1, villeTab[0].getSerial()); // On vérifie que la 1ere ville a un serial "1"
			assertEquals(alphabet.get(i), villeTab[i].getName()); // On vérifie que chaque ville a un nom qui correspond à l'alphabet
			for (int j = 0; j < i; ++j)
				assertNotEquals(villeTab[i].getSerial(), villeTab[j].getSerial()); // On vérifie que chaque ville a un serial différent
		}
		assertEquals(true, Town.checkTownExist(villeTab, 1)); // On vérifie que la ville 1 existe dans notre tableau de ville.
		villeTab[0].addToLink(villeTab[0].getLink(),4); // On rajoute la ville 4 comme lien à la ville 1
		villeTab[0].addToLink(villeTab[0].getLink(),5); // On rajoute la ville 5 comme lien à la ville 1
		villeTab[0].addToLink(villeTab[0].getLink(),6); // On rajoute la ville 6 comme lien à la ville 1
		assertEquals(ToString.toStringLink(villeTab[0].getLink()), "4, 5, 6."); // On vérifie que la ville 1 a comme lien 4, 5 et 6.
		assertEquals(false, Town.checkLinkSchool(villeTab, 1)); // On vérifie que la ville 1 n'est pas relié a une ville avec une école.
	}

}
