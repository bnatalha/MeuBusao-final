/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.model;

//"ID", "Cont. passageiros", "Vel. média", "Hora inicial", "Hora final", "Pass. Meia", "Pass. Inteira", "Pass. Gratuita", "Pass. Total", "Dia", "Gasolina", "Infracoes", "Linha", "Placa"

import java.util.Date;

/**
 *
 * @author Pedro Neto, Natália Brito
 */
public class Viagem {
    private Date horaInicial;
    private Date horaFinal;
    private Date dia;

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    
}
