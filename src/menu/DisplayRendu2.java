package menu;

import agglomeration.Town;
import algorithm.Algorithm;

public class DisplayRendu2 {
	
	/**
	 * Affichage des choix lors de la résolution de l'accessibilité des écoles.
	 */
	public static void displayInterface1()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|========= Résolution de l'accessibilité des écoles ==========|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Résoudre manuellement.                                    |");
		System.out.println("|2) Résoudre automatiquement.                                 |");
		System.out.println("|3) Sauvegarder.                                              |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	public static void nyan() 
	{
		System.out.println("trouvé Nyan Cat");
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour le menu principale .
	 * @param villeTab tableau de ville précedemment créé
	 */
	public static void displayTopMenu(Town[] villeTab) {
		int choice4;
		String commandPrompt3 = "==>Veuillez entrer votre choix :";
		do {
			displayInterface1();
			choice4 = Display.protectedIntInput(commandPrompt3);
			if (choice4 == 1) // l'utilisateur choisi résoudre manuellement
			{
				Display.displaySchool(villeTab);
				Algorithm.getScore(villeTab);
			}
			else if (choice4 == 2) // l'utilisateur choisi résoudre automatiquement
			{
				Algorithm.algorithm1(villeTab, villeTab.length);
				System.out.println("Score de l'agglomération : " + Algorithm.getScore(villeTab));
			}
			else if (choice4 == 3) // l'utilisateur choisi de sauvegarder
			{
				System.out.println("<!>Code pas encore fini<!>");
			}
			else if (choice4 == 4) // l'utilisateur est au courant de notre Easter Egg ;)
			{
				break;
			}
			else // l'utilisateur tape un choix qui n'existe pas
			{
				System.out.println("<!>Vous n'avez pas entré un choix valide<!>");
			}
		} while (choice4 != 4);
	}

}
