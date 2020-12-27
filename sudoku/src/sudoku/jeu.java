package sudoku;
import java.util.Scanner; 
// les grilles proviennent du site
//https://www.e-sudoku.fr/jouer-sudoku-solo.php

public class jeu 
{
	String nomJoueur;
	Scanner scan;

	static int[][] sudoku1={{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
	//static int[][] sudoku1={{1,2,3,8,6,9,5,7,4},{8,9,7,5,4,1,2,6,3},{5,4,6,3,7,2,0,8,9},{6,1,8,4,5,7,3,9,2},{4,7,9,2,3,6,8,1,5},{3,5,2,1,9,8,6,4,7},{2,6,4,7,8,5,9,3,1},{7,8,5,9,1,3,4,2,6},{9,3,1,6,2,4,7,5,8}};
	//la grille en commentaire a été utilisée pour tester la condition d'arret.
	static int[][] sudoku2= {{0,1,3,0,0,2,5,0,9},{8,5,9,0,6,1,0,0,0},{0,2,0,0,0,9,8,0,0},{1,0,0,0,0,0,9,0,0},{7,6,4,0,0,0,3,2,8},{0,0,8,0,0,0,0,0,1},{0,0,2,3,0,0,0,8,0},{0,0,0,2,4,0,6,9,5},{5,0,6,9,0,0,2,7,0}};//facile
	static int[][] sudoku3= {{7,0,0,0,0,3,6,8,0},{0,3,0,4,5,8,0,9,0},{0,0,8,9,6,0,0,0,0},{4,8,0,3,1,0,0,0,0},{2,1,0,0,0,0,0,4,6},{0,0,0,0,4,2,0,7,3},{0,0,0,0,9,5,4,0,0},{0,4,0,7,8,1,0,6,0},{0,6,1,2,0,0,0,0,8}};//facile
	static int[][] sudoku8= {{2,0,0,5,0,6,0,0,8},{0,0,0,0,3,0,0,0,0},{0,0,3,8,9,2,4,0,0},{4,0,1,0,2,0,5,0,7},{0,2,5,4,0,7,9,3,0},{9,0,7,0,5,0,2,0,4},{0,0,6,2,7,5,8,0,0},{0,0,0,0,4,0,0,0,0},{3,0,0,1,0,9,0,0,2}};//TrèsDifficile
	static int[][] sudoku9= {{0,0,5,2,7,0,3,0,0},{0,0,6,0,0,3,0,0,0},{7,0,0,0,6,0,0,4,2},{0,7,0,8,0,4,0,0,1},{5,0,4,0,0,0,2,0,7},{3,0,0,6,0,7,0,5,0},{1,3,0,0,9,0,0,0,4},{0,0,0,1,0,0,8,0,0},{0,0,9,0,8,2,1,0,0}};//TrèsDifficile
	static int[][] sudoku7= {{0,0,0,0,4,7,0,9,0},{0,5,4,0,0,1,0,0,0},{0,0,7,0,5,0,0,3,0},{4,0,0,1,0,0,0,0,8},{0,2,0,0,8,0,0,1,0},{8,0,0,0,0,9,0,0,5},{0,3,0,0,9,0,8,0,0},{0,0,0,5,0,0,2,6,0},{0,8,0,6,2,0,0,0,0}};//difficile
	static int[][] sudoku6= {{3,8,0,0,0,0,0,1,2},{0,2,0,4,1,0,0,0,0},{4,0,0,0,0,9,0,3,0},{0,0,4,0,0,0,0,6,0},{8,0,0,0,7,0,0,0,9},{0,6,0,0,0,0,3,0,0},{0,5,0,3,0,0,0,0,4},{0,0,0,0,5,7,0,9,0},{6,9,0,0,0,0,0,8,3}};//difficile
	static int[][] sudoku5= {{0,2,0,4,0,0,6,1,0},{0,0,6,0,7,0,9,0,0},{0,0,0,9,0,0,0,0,3},{0,0,0,3,0,5,0,8,2},{0,3,0,0,1,0,0,5,0},{6,8,0,7,0,2,0,0,0},{2,0,0,0,0,7,0,0,0},{0,0,3,0,8,0,1,0,0},{0,1,9,0,0,3,0,6,0}};//moyen
	static int[][] sudoku4= {{3,9,0,0,0,0,0,0,0},{0,8,0,0,0,0,3,4,1},{0,0,6,3,0,0,0,2,0},{9,0,0,7,0,3,0,0,0},{4,6,0,8,0,5,0,9,7},{0,0,0,4,0,9,0,0,8},{0,2,0,0,0,6,7,0,0},{5,3,1,0,0,0,0,8,0},{0,0,0,0,0,0,0,5,4}};//moyen
	static int[][] sudoku10={{8,0,0,0,0,0,0,0,0},{0,0,3,6,0,0,0,0,0},{0,7,0,0,9,0,2,0,0},{0,5,0,0,0,7,0,0,0},{0,0,0,0,4,5,7,0,0},{0,0,0,1,0,0,0,3,0},{0,0,1,0,0,0,0,6,8},{0,0,8,5,0,0,0,1,0},{0,9,0,0,0,0,4,0,0}};//difficulte maximum
	static int[][][] sudokuFacile= {sudoku1,sudoku2,sudoku3};
	static int[][][] sudokuMoyens= {sudoku4,sudoku5};
	static int[][][] sudokuDifficiles= {sudoku6,sudoku7};
	static int[][][] sudokuTresDifficiles= {sudoku8,sudoku9,sudoku10};
	static int[][][][]ensembleSudoku= {sudokuFacile,sudokuMoyens,sudokuDifficiles,sudokuTresDifficiles};
	public jeu()
	{
		scan = new Scanner(System.in);
		System.out.println("veuillez entrer votre nom");
		this.nomJoueur=scan.nextLine();
	}
	public int[][]choixSudoku(int difficulte)
	{
		int rand=(int)(Math.random()*jeu.ensembleSudoku[difficulte].length);
		return jeu.ensembleSudoku[difficulte][rand];
		
		
	}
	public void lancerPartie()
	{
		boolean quitter=false;
		System.out.println("Bienvenue "+this.nomJoueur+ " veuillez choisir une difficulté de sudoku");
		System.out.println("Entrez 0 pour des sudoku faciles");
		System.out.println("Entrez 1 pour des sudoku moyens");
		System.out.println("Entrez 2 pour des sudoku difficiles");
		System.out.println("Entrez 3 pour des sudoku très difficiles");
		int nbCoupsJoueurs=0;
		int diff=scan.nextInt();
		while(diff<0 || diff>3)
		{
			System.out.println("veuillez entrer une valeur entre 0 et 3");
			diff=scan.nextInt();
		}
		int[][]tab=choixSudoku(diff);//sudoku de base
		grille sudoku=new grille(tab);
		grille sudokuResolu= new grille(tab);
		grille sudokuDeBase= new grille(tab);
		int nbCoups=sudokuResolu.resolutionSudokuV1();
		boolean identique=false;
		while(identique==false)
		{
			
			System.out.println(sudoku);
			System.out.println("vous avez deja réalisé "+nbCoupsJoueurs+" coups");
			System.out.println("que voulez vous faire");
			System.out.println("Entrez 1 pour jouer un nouveau coup");
			System.out.println("entrez 2 pour reinitialiser la grille");
			System.out.println("entrez 3 pour quitter");
			int choix=scan.nextInt();
			if(choix==2)
			{
				for(int i=0;i<sudoku.taille;i++)
				{
					for(int j=0;j<sudoku.taille;j++)
					{
						sudoku.tab[i][j].valeur=sudokuDeBase.tab[i][j].valeur;
						System.out.println("sudoku de base");
						System.out.println(sudokuDeBase);
						
					}
				}
				System.out.println("le sudoku a bien été reinitialisé");

			}
			if(choix==1)
			{
				System.out.println("veuillez choisir la colonne que vous voulez modifier");
				int colonne=scan.nextInt();
				System.out.println("veuillez choisir la ligne");
				int ligne=scan.nextInt();
				if(ligne<0 || ligne>sudoku.taille-1 ||colonne<0||colonne>sudoku.taille-1)
				{
					System.out.println("les valeurs de ligne et colonnes doivent être comprises entre 0 et "+(sudoku.taille-1));
				}
				else
				{
					if(sudoku.caseFromCoords(colonne, ligne).ordre==-1)
					{
						System.out.println("vous ne pouvez pas modifier cette case c'est une case de base");
					}
					else
					{
						System.out.println("quel valeur voulez vous attribuer à la case");
						int val=scan.nextInt();
						boolean ajout=true;
						if(sudoku.valeurPossibleCarre(val, colonne, ligne)==false)
						{
							System.out.println("impossible d'ajouter la valeur" +val +"elle est deja présente dans le carré"+"\n");
							ajout=false;
						}
						if(sudoku.valeurPossibleColonne(val, colonne, ligne)==false)
						{
							System.out.println("impossible d'ajouter la valeur"+val+" elle est deja présente sur la colonne"+"\n");
							ajout=false;
						}
						if(sudoku.valeurPossibleLigne(val, colonne, ligne)==false)
						{
							System.out.println("impossible d'ajouter la valeur"+val +" elle est deja presente sur la ligne"+"\n");
							ajout=false;
								
						}
						if(ajout)
						{
							sudoku.tab[colonne][ligne].valeur=val;
						}
					}
					nbCoupsJoueurs++;

					
				}
				
			}
			if(choix==3)
			{
				quitter=true;
				identique=true;
				System.out.println("la solution était");
				System.out.println(sudokuResolu);
			}
			boolean verif=true;
			for(int i=0;i<sudoku.taille;i++)
			{
				for(int j=0;j<sudoku.taille;j++)
				{
					if(sudoku.tab[i][j].valeur!=sudokuResolu.tab[i][j].valeur&&quitter==false)//le sudoku n'est pas résolu
					{
						verif=false;
					}
				}
			}
			identique=verif;
			
			
		}
		if(quitter==false)
		{
			System.out.println("Felicitation vous avez résolu le sudoku en "+ nbCoupsJoueurs+" coups");

		}
		System.out.println("L'ordinateur a réalisé ce sudoku en "+nbCoups+" coups");
		System.out.println("voulez vous rejouer?");
		System.out.println("entrez 1 si vous voulez rejouer");
		System.out.println("0 sinon");
		int rejouer=scan.nextInt();
		while(rejouer!=0 && rejouer!=1)
		{
			System.out.println("veuillez entrer une valeur entre 0 et 1");
			rejouer=scan.nextInt();
		}
		if(rejouer==1)
		{
			this.lancerPartie();
		}
		
		return;
	}
}
