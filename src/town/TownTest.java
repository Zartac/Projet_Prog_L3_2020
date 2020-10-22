package town;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownTest {

	@Test
	void test() 
	{
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		Town[] tab = new Town[10]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(alphabet[i]); // On crée 10 ville
			assertEquals(tab[i].isSchool(), false); // On verifie que chaque ville n'a pas d'école
			assertEquals(tab[0].getName(), 'A'); // On vérifie que la 1ere ville est 'A'
			assertEquals(tab[i].getName(), alphabet[i]); // On vérifie que chaque ville a un nom qui correspond à l'alphabet
			for (int j = 0; j < i; ++j)
				assertNotEquals(tab[i].getSerial(), tab[j].getSerial()); // On vérifie que chaque ville a un serial différent
		}
	}

}
