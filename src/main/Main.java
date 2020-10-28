package main;

import java.util.Scanner;
import town.Town;
import menu.Display;

/**
 * Classe principale pour le lancement de l'application.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Main {
	public static void main(String[]args)
	{
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K'
				,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		//Test Github
		Display.displayLaunch();
		System.out.println("==>Veuillez entrer le nombre de ville que vous voulez cr�er:");
		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt();
		/*
		 * Erf, y'a un bug, quand tu entre 0 et ensuite un truc au dessus de 26, �a passe :/
		-- Jack
		*/
		if(choice>26 || choice <=0) {
			while(choice>26) 
			{
				System.out.println("<!>Le nombre choisit est incorrect<!>");
				System.out.println(">Cette version du projet ne peut avoir plus de 26 villes.<");
				System.out.println("==>Veuillez en ressaisir un autre : ");
				choice = sc1.nextInt();
			}
			while(choice<=0) // Au cas o� l'utilisateur troll -- Jack
			{
				System.out.println("<!>La nombre choisit est incorrect<!>");
				System.out.println(">Vous ne pouvez pas avoir 0 villes ou moins.<");
				System.out.println("==>Veuillez en ressaisir un autre : ");
				choice = sc1.nextInt();
			}
			/*
			 * 
			 * Ameliorable en formant une classe qui permet de compacter tout ca
			 * 
			 */
			Town[] tab = new Town[choice]; 
			for (int i = 0; i < tab.length; ++i) 
			{
				tab[i] = new Town(alphabet[i]); // On cr�e autant de ville que l'utilsateur a choisi
				System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a �t� cr�e.");
			}
		}
		else {
			Town[] tab = new Town[choice]; 
			for (int i = 0; i < tab.length; ++i) 
			{
				tab[i] = new Town(alphabet[i]); // On cr�e autant de ville que l'utilsateur a choisi
				System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a �t� cr�e.");
			}
		}
		Display.displayInterface1();
	}

}

