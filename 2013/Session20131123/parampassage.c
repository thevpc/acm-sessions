
#include <stdio.h>
#include <stdlib.h>

//passage par copie de "int"
int add(int xx,int y){
    int e=xx+y;
    xx++;
    y--;
    return e;
}

//passage par copie de "int *"
//passage par ref de "int"
int add2(int * x,int * y){
    int e=*x+*y;
    *x++;
    *y--;
    return e;
}


//passage par copie de "int *"
//passage par ref de "int"

//a l appel xx=100, xx @201
//          y =101, y @202
int add3(int * xx,int * y){
// @200 e =7= 3 (val(@100)) + 4 (val(@101))
    int e=*xx+*y;
    // @100 --> 3 --> inc --> 4
    *xx++;
    // @101 --> 4 --> dec --> 3
    *y--;
    //@201 (old val 100)--> new val 202
    xx=y;
    // la valeur de x n'a pas été modifiée
    return e;
}

int appelleAdd(){
    int x=3;
    int y=4;
    int z;
    z=add(x,y);
    printf("%d %d %d \n");
    //3 4 7
}

int appelleAdd2(){
    int x=3;
    int y=4;
    int z;
    z=add2(&x,&y);
    printf("%d %d %d \n");
    //4 3 7
}

int appelleAdd3(){
    //@100, x =3
    int x=3;
    //@101, y =4
    int y=4;
    //@102, z =?
    int z;
    // add3(100,101)
    z=add3(&x,&y);
    printf("%d %d %d \n");
    //3 3 7
}

int pointeur1(){
    int * x;
    int y;
    
    x=&y; // x l'adresse de y
    
    y=*x; // y la valeur référencée par x
    
    x=&*x;
    
    y=*&y;
}

int pointeurTab(){
    int * x;
    x=(int *)malloc(5*sizeof(int));
    
    *x=1;
    *(x+1)=2;
    *x=*(x+1);
}
