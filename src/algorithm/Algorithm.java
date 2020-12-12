package algorithm;

import agglomeration.Town;
import java.util.Random;
/**
 * Classe pour les de remplissage automatique des �coles dans une agglom�ration.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Algorithm {
	
	/**
	 * Un algorithme d�approximation (na�f) pour la r�solution de l'accessibilit� des �coles dans une agglom�ration donn� dans l'�nonc�.
	 * @param villeTab agglom�ration qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la r�solution de l'accessibilit� des �coles.
	 * @return villeTab agglom�ration apr�s avoir subi l'algorithme.
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
	 * Un algorithme d�approximation (un peu moins na�f) pour la r�solution de l'accessibilit� des �coles dans une agglom�ration donn� dans l'�nonc�.
	 * @param villeTab agglom�ration qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la r�solution de l'accessibilit� des �coles.
	 * @return villeTab agglom�ration apr�s avoir subi l'algorithme.
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
	 * Permet de r�cup�rer un score d'une agglom�ration, le score �tant le nombre d'�cole pr�sente.
	 * @param villeTab agglom�ration qu'on souhaite �xaminer.
	 * @return score le score de l'agglom�ration �xamin�.
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
