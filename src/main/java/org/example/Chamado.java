package org.example;

import java.util.Observable;

public class Chamado extends Observable {

    private Integer numeroProtocolo;
    private String sistemaAfetado;
    private String tipoProblema;
    private String statusAtual;

    public Chamado(Integer numeroProtocolo, String sistemaAfetado, String tipoProblema, String statusAtual) {
        this.numeroProtocolo = numeroProtocolo;
        this.sistemaAfetado = sistemaAfetado;
        this.tipoProblema = tipoProblema;
        this.statusAtual = statusAtual;
    }

    public void atualizarStatus(String novoStatus) {
        this.statusAtual = novoStatus;
        setChanged();
        notifyObservers();
    }

    public String toString() {
        return "Chamado{" +
                "protocolo=" + numeroProtocolo +
                ", sistema='" + sistemaAfetado + '\'' +
                ", problema='" + tipoProblema + '\'' +
                ", status='" + statusAtual + '\'' +
                '}';
    }
}