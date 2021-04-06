/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokio2020;

enum tipoDeporte
{
    ATLETISME, CICLISME, NATACIO, ARTS_MARCIALS;

}
/**
 *
 * @author mati
 */
public class Esport {
    
    tipoDeporte nom_deporte;
    
    Atleta[] participantes;
    int[] medallas;
    int cont_participantes; //cuantos atletas he inscrito
}
