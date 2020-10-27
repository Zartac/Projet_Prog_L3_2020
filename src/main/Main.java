package main;

import java.util.Scanner;
import town.Town;
import menu.Launch;

public class Main {
	public static void main(String[]args)
	{
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K'
				,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		//Test Github
		Launch.displayLaunch();
		System.out.println("Veuillez entrer le nombre de ville que vous voulez créer:");
		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt();
		/*
		Créer ici une boucle qui demande à l'utilisateur de resaisir lorsqu'il tape >26
		et blinder la saisie si l'utilsateur tape autre chose qu'un chiffre
		-- Jack
		*/
		if(choice>26) {
			while(choice>26) {
				System.out.println("La nombre choisit est incorrect");
				System.out.println("Veuillez en ressaisir un autre : ");
				choice = sc1.nextInt();
			}
			Town[] tab = new Town[choice]; 
			for (int i = 0; i < tab.length; ++i) 
			{
				tab[i] = new Town(alphabet[i]); // On crée autant de ville que l'utilsateur a choisi
				System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a été crée.");
			}
		}
		else {
			Town[] tab = new Town[choice]; 
			for (int i = 0; i < tab.length; ++i) 
			{
				tab[i] = new Town(alphabet[i]); // On crée autant de ville que l'utilsateur a choisi
				System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a été crée.");
			}
		}
	}

}
