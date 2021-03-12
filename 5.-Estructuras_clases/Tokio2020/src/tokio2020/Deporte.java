/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokio2020;

enum TipoDeporte
{
    ATLETISME, CICLISME, NATACIO, ARTS_MARCIALS;
}
 
/**
 *
 * @author Alumne
 */
public class Deporte {
    TipoDeporte nomEsport;
    Atleta[] participants;
    int[] medalles;
    int num_atletas_participan;
}
