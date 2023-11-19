package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Essa classe representa o descanso e os processos que acontecem dentro do descanso do aluno.
 * @author fernando.gentil.pinheiro.pacheco
 */
public class Descanso {
    private int horasDescanso;

    private int semanas;

    /**
     * Esse método define as horas de descanso do aluno.
     * 
     * @param valor basicamente o valor das horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Esse método define o número das semanas que irá conter a hora de descanso do aluno; 
     * @param valor o valor do número de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        this.semanas = valor;
    }

    /**
     * Essa função retorna o valor caso o aluno tenha descansado o suficiente, ou caso ele não tenha descansado
     * o suficiente.
     * @return retorna se está cansado ou descansado.
     */
    public String getStatusGeral() {
        String descanso = "cansado";

        if(semanas > 0) {
            if(horasDescanso / semanas >= 26) {
                descanso = "descansado";
            }  else {
                descanso = "cansado";
            }
        }
        return descanso;
    
    }
}
