/* 
 * File:   myypes.h
 * Author: vpc
 *
 * Created on November 30, 2013, 2:27 PM
 */

#ifndef MYYPES_H
#define	MYYPES_H

#ifdef	__cplusplus
extern "C" {
#endif

    typedef enum {
        SFAX, SOUSSE, JERBA, TUNIS
    } Ville;
    
    typedef char * Chaine;

    typedef struct {
        Chaine nom;
        Chaine prenom;
        int age;
        Ville ville;
    } Personne;


#ifdef	__cplusplus
}
#endif

#endif	/* MYYPES_H */

