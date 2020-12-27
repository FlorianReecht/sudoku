package sudoku;
import java.util.ArrayList; 
//une case correspond à une valeur du sudoku
/**
 * 
 * @author reflo
 *Une case contient une liste qui correspond aux valeurs possible pour la résolution
 *ainsi qu'un ordre pour choisir l'ordre dans lequel nous allons résoudre le sudoku.
 */
public class Case 
{
	grille grille;//grille a laquel appartient la case.
	static int compteur=1;
	int valeur;
	ArrayList<Integer> valeurPossible; //qui correspond aux valeurs que la case peut prendre
	ArrayList<Integer> valeurPossibleInit;//sera utlisé pour reset les valeurs possibles.
	int ordre;//correspond au rang durant lequel la case doit être remplie lors de la résolution.
	int ligne;
	int colonne;
	public Case(int val,grille g,int ligne,int colonne)
	{
		this.ligne=ligne;
		this.colonne=colonne;
		this.grille=g;
		this.valeur=val;
		valeurPossible= new ArrayList<Integer>();
		valeurPossibleInit=new ArrayList<Integer>();
	}
	public int[] getValPossible()
	{
		int[]retour=new int[9];
		{
			int cp=0;
			for(int i=1;i<10;i++)
			{
				//si la valeur n'est ni sur la ligne ni sur la colonne si sur la case de la grille alors on ajoute cette valeur à la liste
				if(grille.valeurPossibleLigne(i,this.ligne,this.colonne)&&grille.valeurPossibleColonne(i,this.ligne,this.colonne)&&grille.valeurPossibleCarre(i,this.ligne,this.colonne))
				{
					retour[cp]=i;
					cp++;
				}
				
			}
			return retour;
		}
	}

}
