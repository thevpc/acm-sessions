/* 
 * File:   main.c
 * Author: vpc
 *
 * Created on November 30, 2013, 2:22 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "myheaders/mytypes.h"

char* chaineVille(Ville ville,char * buffer,int length){
    switch(ville){
        case TUNIS:{
            if(length>5){
                strcpy(buffer,"TUNIS");
            }
            break;
        }
        case SOUSSE:{
            if(length>6){
                strcpy(buffer,"SOUSSE");
            }
            break;
        }
        case JERBA:{
            if(length>5){
                strcpy(buffer,"JERBA");
            }
            break;
        }
        case SFAX:{
            if(length>4){
                strcpy(buffer,"SFAX");
            }
            break;
        }
        default:{
            if(length>1){
                strcpy(buffer,"?");
            }
        }
    }
    return buffer;
}

void afficherPersonne(Personne p){
    char buffer[50];
    printf("%s %s, agé de %d, habitant %s\n",
            p.nom,p.prenom,p.age,
            chaineVille(p.ville,buffer,50)
            );
    p.age++;
}

/*
 * 
 */
int main(int argc, char** argv) {
    Personne e;
    e.nom="hamadi";
    e.prenom="agrebi";
    e.age=91;
    e.ville=SOUSSE;
    afficherPersonne(e);
    afficherPersonne(e);
    return (EXIT_SUCCESS);
}

