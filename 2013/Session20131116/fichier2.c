/* 
 * File:   fichier2.c
 * Author: vpc
 *
 * Created on November 16, 2013, 3:42 PM
 */

#include <stdio.h>
#include <stdlib.h>
//static double d;

int add(int x,int y){
    static int k=0;
    k++;
    printf("%d\n",k);
    return x+y;
}
