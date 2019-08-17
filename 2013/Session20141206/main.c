/* 
 * File:   main.c
 * Author: vpc
 *
 * Created on December 6, 2014, 3:08 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * 
 */
int lecture(int argc, char** argv) {
//    fopen("c:\\work\\exemple.toto","w")
    FILE *f = fopen("/home/vpc/var/exemple.toto","r");
    int n;
    int p;
    int err;
    n=-1;
    err=fscanf(f,"%d %d",&n,&p);
    printf("%d %d %d\n",err,n,p);
    
//    n=-1;
    err=fscanf(f,"%d",&n);
    printf("%d %d\n",err,n);
    
//    n=-1;
    fscanf(f,"%d",&n);
    err=printf("%d %d\n",err,n);
    
    fclose(f);
    
    return (EXIT_SUCCESS);
}

int ecriture(int argc, char** argv) {
//    fopen("c:\\work\\exemple.toto","w")
    FILE *f = fopen("/home/vpc/var/exemple.titi","w");
    int n=88;
    int p=36;
    fprintf(f,"%d %d\n",n,p);
    fclose(f);
    
    return (EXIT_SUCCESS);
}

int lecture_argcargv(int argc, char** argv) {
    int i=0;
    char t[10][100];
    
    FILE *f=fopen("/home/vpc/test.txt","w");
    fprintf(f,"Le nombre d arguments %d \n",argc);
    for(i=0;i<argc;i++){
        fprintf(f,"l argument à la position %d est %s\n",i,argv[i]);
    }
    fclose(f);
    return 0;
}

typedef struct {
    char * chaine;
    int longueur;
} Chaine;

int main(int argc, char** argv) {
    FILE *f=fopen("convert.in","r");
    int n;
    int i;
    
    
    char ligne[1024];
    fscanf(f,"%d\n",&n);
    Chaine * chaines;
    chaines= (Chaine *) malloc(n * sizeof(Chaine));
    printf("le nomnbre de ligne est %d\n",n);
    for(i=0;i<n;i++){
        //fscanf(f,"%s",&ligne);
        fgets(&ligne,1024,f);
        chaines[i].chaine=(char *)malloc((strlen(ligne)+1)*sizeof(char));
        strcpy(chaines[i].chaine,ligne)
        chaines[i].longueur=strlen(ligne);
        printf("read %s\n",ligne);
    }
    
    fclose(f);
}
