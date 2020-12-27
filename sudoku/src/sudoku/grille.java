package sudoku;
import java.util.ArrayList; 

/**
 * 
 * @author reflo
 * La classe grille dispose d'un constructeur par défault qui remplis une matrice de dimension taille avec des
 * valeures aléatoire entre 0 et range
 * 
 * La classe grille dispose d'un constructeur prenant un tableau d'entier en parametre
 * c'est ce constructeur qui est utilisé pour construire le sudoku.
 * 
 *
 */
public class grille 
{
	//attributs de la classe grille
	Case[][] tab;
	int taille;
	int range;
	//cette methode construit un tableau de dimension t avec des valeurs comprises entre 0 et r
	public grille(int t,int r)
	{
		this.taille=t;
		this.range=r;
		this.tab= new Case [taille][taille];
		for(int i=0;i<taille;i++)
		{
			for(int j=0;j<taille;j++)
			{
				tab[i][j]=new Case((int) (( Math.random())*range),this,i,j);

			}
		}
	}
	//CETTE METHODE SERA UTILISEE POUR CONSTRUIRE LE SUDOKU DE DIMENSION 9 PAR 9
	public grille(int[][] aux)
	{
		int compteurOrdre=1;
		this.taille=9;
		this.range=9;
		this.tab=new Case[taille][taille];
		for(int i=0;i<taille;i++)
		{
			for(int j=0;j<taille;j++)
			{
				
				tab[i][j]=new Case(aux[i][j],this,i,j);
			}
		}
		//une fois que toutes les cases sont initialisées on attribue l'ordre et les valeurs possibles
		for(int i=0;i<taille;i++)
		{
			for(int j=0;j<taille;j++)
			{
				if(tab[i][j].valeur==0)//si la case n'est pas une valeur de base du sudoku elle doit être remplie par l'utilisateur
				{
					//on ajoute toutes les valeurs possible et on détermine l'ordre
					tab[i][j].ordre=compteurOrdre;
					compteurOrdre++;
					int[]liste=tab[i][j].getValPossible();
					for(int k=0;k<liste.length;k++)
					{
						tab[i][j].valeurPossible.add(liste[k]);
						tab[i][j].valeurPossibleInit.add(liste[k]);
					}
					
				}
				else//la case est une case Initiale du sudoku non modifiable elle ne doit pas être traitée 
					//par l'algo de résolution
				{
					tab[i][j].ordre=-1;
					
				}
				
			}
		}
		
	}
	//ToString de la classe grille
	public String toString() 
	{
		String retour="";
		for(int i=0;i<taille;i++)
		{
			if((i%3==0)&&(i!=0))
			{
				retour+="----------------------\n";
			}
			for(int j=0;j<taille;j++)
			{
				if((j%3==0)&&(j!=0))
				{
					retour+="| ";
				}
				retour+=this.tab[i][j].valeur+" ";
			}
			retour+="\n";
			
		
		}
		return retour;
	}
	//fonction qui retourne la case d'ordre o
	public Case caseFromOrdre(int o)
	{
		int retouri=0;
		int retourj=0;
		for(int i=0;i<taille;i++)
		{
			for(int j=0;j<taille;j++)
			{
				if(tab[i][j].ordre==o)
				{
					retouri=i;
					retourj=j;
				}
			}
		}
		return this.tab[retouri][retourj];
		
	}
	//fonction qui retourne la case de coordonnées ij
	public Case caseFromCoords(int i,int j)
	{
		return tab[i][j];
	}
	//les 3 prochaines méthodes permettent de retourner les valeurs présente dans le carré,la ligne 
	//et la colonne de la case de coordonnées ij

	public int[] returnCarre(int i0,int j0)
	{
		int cp=0;
		int[] retour=new int[9];
		for(int i=(i0/3)*3;i<((i0/3)*3)+3;i++)
		{
			for(int j=(j0/3)*3;j<((j0/3)*3)+3;j++)
			{
				retour[cp]=tab[i][j].valeur;
				cp++;
			}
		}
		return retour;
	}
	public int[] returnLigne(int i0,int j0)
	{
		int cp=0;
		int[] retour= new int[9];
		for(int i=0;i<taille;i++)
		{
			retour[cp]=tab[i0][i].valeur;
			cp++;
		}
		return retour;
	}
	public int[] returnColonne(int i0,int j0)
	{
		int cp=0;
		int[] retour= new int[9];
		for(int i=0;i<taille;i++)
		{
			retour[cp]=tab[i][j0].valeur;
			cp++;
		}
		return retour;
	}
	//les trois prochaines méthodes permettent de vérifier si on peut ajouter une valeur 
	//sans rendre le sudoku incorrect
	
	//vérifiz si ajouter la valeur val dans la grille ne rend pas la ligne incorecte.
	public boolean valeurPossibleLigne(int val,int i,int j)
	{
		int[]list=this.returnLigne(i, j);
		boolean retour=true;
		for(int k=0;k<list.length;k++)
		{
			if(list[k]==val)
			{
				retour=false;
			}
		}
		return retour;
	}
	//vérifie si ajouter la valeur val à une case ne rend pas la colonne incorecte
	public boolean valeurPossibleColonne(int val,int i,int j)
	{
		int[]list=this.returnColonne(i, j);
		boolean retour=true;
		for(int k=0;k<list.length;k++)
		{
			if(list[k]==val)
			{
				retour=false;
			}
		}
		return retour;
	}
	//vérifie si ajouter une valeur à une case ne rend pas le carré incorrect.
	public boolean valeurPossibleCarre(int val,int i0,int j0)
	{
		int[]list=this.returnCarre(i0, j0);
		boolean retour=true;
		for(int i=0;i<list.length;i++)
		{
            if(list[i]==val)
            {
            	retour=false;
            }
		}
		return retour;
		
	}
	//retourne le nombre de case que l'utilisateur doit remplir

	public int GetNbCasesARemplir()
	{
		int retour=0;
		for(int i=0;i<taille;i++)
		{
			for(int j=0;j<taille;j++)
			{
				if(tab[i][j].ordre!=-1)
				{
					retour++;
				}
			}
		}
		return retour;
	}
	//algo qui se charge de résoudre le sudoku à l'aide des fonctions écrites au dessus
	//retourne le nombre de tours de boucle réalisé par l'algorithme.
	
	public int resolutionSudokuV1()
	{
		int nbCoups=0;
		int currentOrdre=1;
		int maxOrdre=this.GetNbCasesARemplir();
		//tant que toutes les cases ne sont pas remplies
		while(currentOrdre<=maxOrdre)
		{
			//System.out.println("tour numero "+ nbCoups+"  ordre ="+currentOrdre);
			//System.out.println(this.caseFromOrdre(currentOrdre).valeurPossible);
			//System.out.println(this.caseFromOrdre(currentOrdre).valeurPossibleInit);
			//System.out.println(this);
			Case currentCase=this.caseFromOrdre(currentOrdre);//on récupère la case que l'on doit traiter
			int testVal=currentCase.valeurPossible.get(0);
			nbCoups++;
			currentCase.valeur=0;
			//si il reste une valeur possible
			if(testVal!=0)
			{
				//si cette valeur possible peut être attribuée sans rendre le sudoku incorrect alors on l'attribue 
				//et on passe à la case suivante
				if((this.valeurPossibleCarre(testVal,currentCase.ligne, currentCase.colonne)&&(this.valeurPossibleLigne(testVal,currentCase.ligne, currentCase.colonne))&&(this.valeurPossibleColonne(testVal,currentCase.ligne, currentCase.colonne))))
				{
					currentCase.valeur=testVal;
					currentCase.valeurPossible.remove(0);
					currentOrdre++;
					this.caseFromOrdre(currentOrdre).valeurPossible=new ArrayList <Integer>(this.caseFromOrdre(currentOrdre).valeurPossibleInit);

				}
				else
				{
					//System.out.println("la valeur ne correspond pas");
					currentCase.valeurPossible.remove(0);
				}
				

				
			}
			else
			{
				//si il la valeur dans la liste vaut 0 alors il 
				//n'y a pas de valeur possible, 
				//et on reinitialise la liste et on retourne à la case d'ordre précédent
				//System.out.println("AUCUNE VALEUR POSSIBLE ON REPASSE A LA CASE DAVANT");
				currentCase.valeurPossible=currentCase.valeurPossibleInit;
				currentOrdre--;
				//System.out.println("current ordre=" +currentOrdre);
				
			}

			
			
		}
		//le sudoku est résolu
		return nbCoups;
		
	}
	



	
}
