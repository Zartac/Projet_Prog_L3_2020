package menu;

import java.util.ArrayList;

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
	
	/**
	 * Affichage des choix lors de la r�solution automatique de l'accessibilit� des �coles.
	 */
	public static void displayInterface2()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|=================== S�lection automatique ===================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Utiliser l'algorithme 1 (na�f).                           |");
		System.out.println("|2) Utiliser l'algorithme 2 (moins na�f).                     |");
		System.out.println("|3) Demander � Thanos.                                        |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage du Easter Egg, aujourd'hui, c'est sur le th�me Avengers!
	 */
	public static void displayThanos(Town[] villeTab)
	{
		String thanos1[] = {
				"- The hardest choices",
				"- Require the strongest wills.",
				"- I am inevitable."
            };
        for (int i = 0; i < thanos1.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos1[i]);
        }
        System.out.println("");
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
    	System.out.println("<!>Toutes les �coles se sont volatilis�s<!>");        
        ArrayList<Integer> tempSchool = new ArrayList<Integer>();
        for (int i = 0; i < villeTab.length; ++i)
        {
        	if (villeTab[i].isSchool()==true)
        	{
        		tempSchool.add(villeTab[i].getSerial());
        	}
        }
        System.out.println("");
		String thanos2[] = {
                "- Reality can be whatever I want.",
				"- What did it cost?",
				"- Everything."
            };
        for (int i = 0; i < thanos2.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos2[i]);
        }
        System.out.println("");
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
    	for (int i = 0; i < tempSchool.size(); ++i)
    	{
    		System.out.println(ToString.toStringSchoolAdded(villeTab[tempSchool.get(i)-1]));    		
    	}
    	System.out.println(ToString.toStringSchoolList(villeTab));
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
        System.out.println("");
		String thanos3[] = {
                "- You couldn't live with your own failure.",
				"- And where did that bring you?",
				"- Back to me."
            };
        for (int i = 0; i < thanos2.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos3[i]);
        }
    	
    	
	}
	/**
	 * affichage easteregg NyanCat
	 */
	public static void nyan() 
	{
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::##############                              :::::::::::::::::::");
		System.out.println("############################  ##############################  :::::::::::::::::");
		System.out.println("#########################  ######???????????????????????######  :::::::::::::::");
		System.out.println("=========================  ####??????????()????()?????????####  :::::::::::::::");
		System.out.println("=========================  ##????()??????????????    ()?????##  ::::    :::::::");
		System.out.println("------------=============  ##??????????????????  ;;;;  ?????##  ::  ;;;;  :::::");
		System.out.println("-------------------------  ##??????????()??????  ;;;;;;?????##    ;;;;;;  :::::");
		System.out.println("-------------------------  ##??????????????????  ;;;;;;         ;;;;;;;;  :::::");
		System.out.println("++++++++++++-------------  ##??????????????????  ;;;;;;;;;;;;;;;;;;;;;;;  :::::");
		System.out.println("+++++++++++++++++++++++++  ##????????????()??  ;;;;;;;;;;;;;;;;;;;;;;;;;;;  :::");
		System.out.println("+++++++++++++++++    ;;;;  ##??()????????????  ;;;;;;@@  ;;;;;;;;@@  ;;;;;  :::");
		System.out.println("~~~~~~~~~~~~~++++;;;;;;;;  ##????????????????  ;;;;;;    ;;;  ;;;    ;;;;;  :::");
		System.out.println("~~~~~~~~~~~~~~~  ;;  ~~~~  ####??????()??????  ;;[];;;;;;;;;;;;;;;;;;;;;[]  :::");
		System.out.println("$$$$$$$$$$$$$~~~~  ~~~~~~  ######?????????????  ;;;;;;              ;;;;  :::::");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$    ###################  ;;;;;;;;;;;;;;;;;;;;  :::::::");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$  ;;;;                                       :::::::::::");
		System.out.println(":::::::::::::$$$$$$$$$$  ;;;;  ::  ;;  ::::::::::::  ;;  ::  ;;;;  ::::::::::::");
		System.out.println(":::::::::::::::::::::::      ::::::    :::::::::::::     ::::      ::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::::NN::YY::::YY:::AAAAAA:::NN::::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NNNN::NN::YY::::YY::AA::::AA::NNNN::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NNNN::NN::YY::::YY::AA::::AA::NNNN::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::NNNN::::YYYY::::AAAAAAAA::NN::NNNN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::NNNN:::::YY:::::AA::::AA::NN::NNNN:::::::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::::NN:::::YY:::::AA::::AA::NN::::NN:::!!::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");	
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
			if (choice5 == 1) // l'utilisateur choisi algo1
			{
				System.out.println("==>Execution de l'algorithme 1 :");
				Algorithm.algorithm1(villeTab, villeTab.length);
				displayScore(villeTab);
			}
			else if (choice5 == 2) // l'utilisateur choisi algo2
			{
				System.out.println("==>Execution de l'algorithme 2 :");
				Algorithm.algorithm2(villeTab, villeTab.length);
				displayScore(villeTab);
			}
			else if (choice5 == 3) // l'utilisateur choisi Thanos
			{
				System.out.println("==>Execution de l'algorithme Thanos :");
				Algorithm.algorithmCustom(villeTab);
				displayThanos(villeTab);
				System.out.println("");
				System.out.println("==>V�rification des contraintes d'accessibilit� :");
				if (Town.checkConstraintAccess(villeTab)==false)
				{
					System.out.println("<!>L'agglom�ration ne respecte pas les contraintes d'accessibilit�<!>");
				}
				else if (Town.checkConstraintAccess(villeTab)==true)
				{
					System.out.println("*L'agglom�ration respecte les contraintes d'accessibilit�*");
				}
				displayScore(villeTab);
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