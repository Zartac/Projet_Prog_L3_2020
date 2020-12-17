package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import agglomeration.Town;

class AlgorithmTest {

	@Test
	void test() {
		ArrayList<String> alphabetLimited = new ArrayList<String>(); // on créer une liste de 8 noms.
		alphabetLimited.add("A");
		alphabetLimited.add("B");
		alphabetLimited.add("C");
		alphabetLimited.add("D");
		alphabetLimited.add("E");
		alphabetLimited.add("F");
		alphabetLimited.add("G");
		alphabetLimited.add("H");
		alphabetLimited.add("I");
		alphabetLimited.add("J");
		alphabetLimited.add("K");
		Town[] villeTab = Town.createTownLoop(alphabetLimited.size(), alphabetLimited);
		Town.securedLinkCreation(villeTab, 1, 2); //route(A,B)
		Town.securedLinkCreation(villeTab, 1, 4); //route(A,D)
		Town.securedLinkCreation(villeTab, 2, 3); //route(B,C)
		Town.securedLinkCreation(villeTab, 2, 8); //route(B,H)
		Town.securedLinkCreation(villeTab, 3, 4); //route(C,D)
		Town.securedLinkCreation(villeTab, 3, 9); //route(C,I)
		Town.securedLinkCreation(villeTab, 4, 5); //route(D,E)
		Town.securedLinkCreation(villeTab, 5, 6); //route(E,F)
		Town.securedLinkCreation(villeTab, 5, 7); //route(E,G)
		Town.securedLinkCreation(villeTab, 8, 9); //route(H,I)
		Town.securedLinkCreation(villeTab, 8, 10); //route(H,J)
		Town.securedLinkCreation(villeTab, 8, 11); //route(H,K)
		Town.securedAddSchool(villeTab, 2); //ecole(B)
		Town.securedAddSchool(villeTab, 5); //ecole(E)
		Town.securedAddSchool(villeTab, 8); //ecole(H)
		assertEquals(3, Algorithm.getScore(villeTab)); // On vérifie que le score original de la ville est 3
		Algorithm.algorithm1(villeTab, villeTab.length);
		assertNotEquals(0, Algorithm.getScore(villeTab)); // On vérifie que l'algorithme 1 a bien trouvé une solution qui n'est pas 0
		Algorithm.algorithm2(villeTab, villeTab.length);
		assertNotEquals(0, Algorithm.getScore(villeTab)); // On vérifie que l'algorithme 2 a bien trouvé une solution qui n'est pas 0
		Algorithm.algorithmCustom(villeTab);
		assertEquals(3, Algorithm.getScore(villeTab)); // On vérifie que l'algorithme a trouvé une solution optimal qui est de 3
	}

}
