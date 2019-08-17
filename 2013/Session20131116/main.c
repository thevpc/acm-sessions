/* 
 * File:   main.c
 * Author: vpc
 *
 * Created on November 16, 2013, 2:42 PM
 */

//#include "main.h"
#include "main.h"
#include <stdlib.h>
#include <stdio.h>

//printf(char *, ...)
/*
 * cette fonction fait batati batata 
 */
int main(int argc, char** argv) {
    int * tab=hett_le_tableau();
    printf("%d\n",tab[0]);
    int x=hett_l_entier();
    
    //detruite 
    free(tab);
    return (EXIT_SUCCESS);
}

void lire_fichier(){
  FILE * f=fopen("/home/vpc/f.txt","r");
  int entier;
  char chaine[500];
//  scanf("%d %s",&entier,&chaine);
  fscanf(f,"%d %s",&entier,&chaine);
  
  
  fclose(f);
}

void ecrire_fichier(){
  FILE * f=fopen("/home/vpc/f.txt","w");
  int entier=3;
  char * chaine ="hello";
//  scanf("%d %s",&entier,&chaine);
  fprintf(f,"%d %s",entier,chaine);
  
  
  fclose(f);
}

int * hett_le_tableau(){
    //int tab[3]={5,9,14};
    
    // non instantiés non initialisé
    int * ibib;
    // instantiés non initialisé
    int ibi[5];
    // instantiés initialisé
    int ibi[5]={1,5,8,9,6};
    
    int * tab;
    //creer tableau
    tab=(int *)malloc(3 * sizeof(int));
    return tab;
}

int hett_l_entier(){
    int e=8;
    return e;
}