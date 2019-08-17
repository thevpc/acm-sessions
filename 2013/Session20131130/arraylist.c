
#include <stdlib.h>
#include <string.h>

typedef struct {
    int * elements;
    int allocSize;
    int realSize;
    float resizeFactor;
} ArrayList;

ArrayList * createArrayList(int size) {
    ArrayList * a = (ArrayList *) malloc(
            sizeof (ArrayList)
            );
    //(*a).size=size;
    a->allocSize = size;
    a->realSize = 0;
    a->elements = (int *) malloc(
            size * sizeof (int)
            );
    a->resizeFactor = 1.5;
    return a;
}

void freeArrayList(ArrayList * a) {
    free(a->elements);
    free(a);
}

void addElementArrayList(ArrayList * a, int elem) {
    if (a->realSize >= a->allocSize) {
        resizeArrayList(a, (int) (a->allocSize * a->resizeFactor));
    }
    a->elements[a->realSize++] = elem;
}

void removeElementAtArrayList(ArrayList * a, int pos) {
    if (pos == a->realSize - 1) {
        a->realSize--;
    } else {
        int x = pos;
        while (x<a->realSize - 1) {
            a->elements[x] = a->elements[x+1];
        }
    }
}

void resizeArrayList(ArrayList * a, int newSize) {
    int * newTab=(int*)malloc(newSize*sizeof(int));
    memcpy(newTab,a->elements,a->realSize*sizeof(int));
    free(a->elements);
    a->elements=newTab;
    a->allocSize=newSize;
}

int findElementArrayList(ArrayList * a, int elem) {

}
