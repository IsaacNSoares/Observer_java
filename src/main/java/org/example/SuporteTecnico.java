package org.example;

import java.util.Observable;
import java.util.Observer;

public class SuporteTecnico implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public SuporteTecnico(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(Chamado chamado) {
        chamado.addObserver(this);
    }

    public void update(Observable chamado, Object arg1) {
        this.ultimaNotificacao = this.nome + ", atualização recebida no " + chamado.toString();
    }
}