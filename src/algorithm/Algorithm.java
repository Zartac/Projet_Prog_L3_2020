package algorithm;

import agglomeration.Town;
import java.util.Random;
/**
 * Classe pour les de remplissage automatique des écoles dans une agglomération.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Algorithm {
	
	/**
	 * Un algorithme d’approximation (naïf) pour la résolution de l'accessibilité des écoles dans une agglomération donné dans l'énoncé.
	 * @param villeTab agglomération qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la résolution de l'accessibilité des écoles.
	 * @return villeTab agglomération après avoir subi l'algorithme.
	 */
	public static Town[] algorithm1(Town[] villeTab, int k)
	{
		int i = 0;
		do
		{
			int randomIndex = new Random().nextInt(villeTab.length); // selection d'un index au hasard parmi le tableau de Town.
			if (villeTab[randomIndex].isSchool()==true)
			{
				Town.securedRemoveSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index
			}
			else
			{
				Town.securedAddSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index				
			}
			i++;
		} while (i<k);
		return villeTab;
	}
	
	/**
	 * Un algorithme d’approximation (un peu moins naïf) pour la résolution de l'accessibilité des écoles dans une agglomération donné dans l'énoncé.
	 * @param villeTab agglomération qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la résolution de l'accessibilité des écoles.
	 * @return villeTab agglomération après avoir subi l'algorithme.
	 */
	public static Town[] algorithm2(Town[] villeTab, int k)
	{
		int i = 0;
		int scoreCourant = getScore(villeTab);
		do
		{
			int randomIndex = new Random().nextInt(villeTab.length); // selection d'un index au hasard parmi le tableau de Town.
			if (villeTab[randomIndex].isSchool()==true)
			{
				Town.securedRemoveSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index
			}
			else
			{
				Town.securedAddSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index				
			}
			if (getScore(villeTab)<scoreCourant)
			{
				i = 0;
				scoreCourant = getScore(villeTab);
			}
			else
			{
				i++;
			}
		} while (i<k);
		return villeTab;
	}
	
	/**
	 * Permet de récupérer un score d'une agglomération, le score étant le nombre d'école présente.
	 * @param villeTab agglomération qu'on souhaite éxaminer.
	 * @return score le score de l'agglomération éxaminé.
	 */
	public static int getScore(Town[] villeTab)
	{
		int score = 0;
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if(villeTab[i].isSchool()==true)
			{
				++score;
			}
		}
		return score;
	}

}
