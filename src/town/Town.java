package town;

/**
 * Classe pour la cr�ation et la modification de ville.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Town 
{
	private static int serialcounter = 0;
	private char name; // J'ai un peu oublier comment on utiliser les string en Java -- Jack
	private int serial;
	private boolean school;
	private int[] link;
	
	/**
	 * Cr�ation basique d'une ville sans �cole, cette ville a un num�ro de s�rie unique.
	 * @param name
	 */
	public Town(char name) //Penser � bouger en String pour les prochaines parties
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
	}
	
	/**
	 * R�cup�re le nom de la ville.
	 * @return Nom de la ville.
	 */
	public char getName() 
	{
		return name;
	}

	/**
	 * R�cup�re le num�ro de s�rie de la ville.
	 * @return Num�ro de s�rie.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * V�rifie la pr�sence ou non d'une �cole dans la ville.
	 * @return True/False sur l'existence de l'�cole.
	 */
	public boolean isSchool() 
	{
		return school;
	}

	/**
	 * Ajoute ou retire une �cole dans cette ville.
	 * @param value (True/False).
	 */
	public void setSchool(boolean value) 
	{
		this.school = value;
	}

	/**
	 * R�cup�re la liste des voisins de cette ville.
	 * @return Tableau de "int".
	 */
	public int[] getLink() 
	{
		return link;
	}	
	

	
}