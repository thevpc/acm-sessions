/* 
 * File:   main.c
 * Author: vpc
 *
 * Created on November 23, 2013, 2:12 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int * createTableau(){
    int tab[10];
    int i;
    for (i = 0; i < 10; i++) {
        tab[i]=i;
    }
    return (int*) tab;
}

int * createTableau2(){
    int * tab;
    tab=(int *)malloc(10*sizeof(int));
    int i;
    for (i = 0; i < 10; i++) {
        tab[i]=i;
    }
    return (int*) tab;
}

void pieges(){
    int * tab =createTableau2();
    
    sleep(3);
    printf("%d\n",tab[3]);
    free(tab);
}
/*
 * 
 */
int main(int argc, char** argv) {
    //instantie non initialise
    // tableau : position du premier element du tableau
    //contenu du tableau 
//    int x1[5];
//
//    //instantie et initialise    
//    int x2[5]={1,2,3,6,5};
//    
//    //non instantie et non initilise
//    int * x3;
//    
//    //creation 
//    x3=(int *) malloc(5 * sizeof(int));
//    
//    x3[3]=x2[0]=x1[2];
//    
//    
//    free(x3);
    pieges();
    return (EXIT_SUCCESS);
}

