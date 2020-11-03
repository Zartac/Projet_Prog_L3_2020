package agglomeration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K"
				,"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
		Town[] tab = new Town[10]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(alphabet[i]); // On cr�e 10 ville
			assertEquals(false, tab[i].isSchool()); // On v�rifie que chaque ville n'a pas d'�cole
			assertEquals("A", tab[0].getName()); // On v�rifie que la 1ere ville est nomm� 'A'
			assertEquals(1, tab[0].getSerial()); // On v�rifie que la 1ere ville a un serial "1"
			assertEquals(alphabet[i], tab[i].getName()); // On v�rifie que chaque ville a un nom qui correspond � l'alphabet
			for (int j = 0; j < i; ++j)
				assertNotEquals(tab[i].getSerial(), tab[j].getSerial()); // On v�rifie que chaque ville a un serial diff�rent
		}
		assertEquals(true, Town.checkTownExist(tab, 1)); // On v�rifie que la ville 1 existe dans notre tableau de ville.
		tab[0].addToLink(tab[0].getLink(),4); // On rajoute la ville 4 comme lien � la ville 1
		tab[0].addToLink(tab[0].getLink(),5); // On rajoute la ville 5 comme lien � la ville 1
		tab[0].addToLink(tab[0].getLink(),6); // On rajoute la ville 6 comme lien � la ville 1
		assertEquals(ToString.toStringLink(tab[0].getLink()), "4, 5, 6."); // On v�rifie que la ville 1 a comme lien 4, 5 et 6.
		assertEquals(false, Town.checkLinkSchool(tab, 1)); // On v�rifie que la ville 1 n'est pas reli� a une ville avec une �cole.
	}

}
