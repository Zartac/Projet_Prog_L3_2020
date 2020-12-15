package menu;

import agglomeration.Town;
import algorithm.Algorithm;

public class DisplayRendu2 {
	
	/**
	 * Affichage des choix lors de la r�solution de l'accessibilit� des �coles.
	 */
	public static void displayInterface1()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|========= R�solution de l'accessibilit� des �coles ==========|");
		System.out.println("|=============================================================|");
		System.out.println("|1) R�soudre manuellement.                                    |");
		System.out.println("|2) R�soudre automatiquement.                                 |");
		System.out.println("|3) Sauvegarder.                                              |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	public static void displayInterface2()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|=================== R�solution automatique ==================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Utiliser l'algorithme 1 (na�f).                           |");
		System.out.println("|2) Utiliser l'algorithme 2 (moins na�f).                     |");
		System.out.println("|3) Demander � Thanos.                                        |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	public static void nyan() 
	{
		System.out.println("trouv� Nyan Cat");
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour le menu principale .
	 * @param villeTab tableau de ville pr�cedemment cr��
	 */
	public static void displayTopMenu(Town[] villeTab) {
		if (villeTab.length!=0)
		{
			int choice4;
			String commandPrompt3 = "==>Veuillez entrer votre choix :";
			do {
				displayInterface1();
				choice4 = Display.protectedIntInput(commandPrompt3);
				if (choice4 == 1) // l'utilisateur choisi r�soudre manuellement
				{
					Display.displaySchool(villeTab);
					displayScore(villeTab);
				}
				else if (choice4 == 2) // l'utilisateur choisi r�soudre automatiquement
				{
					displayAutoMenu(villeTab);
				}
				else if (choice4 == 3) // l'utilisateur choisi de sauvegarder
				{
					System.out.println("<!>Code pas encore fini<!>");
				}
				else if (choice4 == 4)
				{
					break;
				}
				else // l'utilisateur tape un choix qui n'existe pas
				{
					System.out.println("<!>Vous n'avez pas entr� un choix valide<!>");
				}
			} while (choice4 != 4);
		}
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour le menu principale .
	 * @param villeTab tableau de ville pr�cedemment cr��
	 */
	public static void displayAutoMenu(Town[] villeTab) {
		int choice5;
		String commandPrompt3 = "==>Veuillez entrer votre choix :";
		do {
			displayInterface2();
			choice5 = Display.protectedIntInput(commandPrompt3);
			System.out.println("");
			if (choice5 == 1) // l'utilisateur choisi r�soudre manuellement
			{
				System.out.println("==>Execution de l'algorithme 1 :");
				Algorithm.algorithm1(villeTab, villeTab.length);
				displayScore(villeTab);
			}
			else if (choice5 == 2) // l'utilisateur choisi r�soudre automatiquement
			{
				System.out.println("==>Execution de l'algorithme 2 :");
				Algorithm.algorithm2(villeTab, villeTab.length);
				displayScore(villeTab);
			}
			else if (choice5 == 3) // l'utilisateur choisi de sauvegarder
			{
				System.out.println("<!>Code pas encore fini<!>");
			}
			else if (choice5 == 4)
			{
				break;
			}
			else // l'utilisateur tape un choix qui n'existe pas
			{
				System.out.println("<!>Vous n'avez pas entr� un choix valide<!>");
			}
		} while (choice5 != 4);
	}
	
	public static void displayScore(Town[] villeTab)
	{
		System.out.println("");
		System.out.println("==>Score de l'agglom�ration :");
		System.out.println(ToStringRendu2.toStringScore(villeTab));
	}

}
