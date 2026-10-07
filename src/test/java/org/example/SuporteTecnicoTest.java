package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuporteTecnicoTest {

    @Test
    void deveNotificarUmTecnico() {
        Chamado chamado = new Chamado(1001, "Microvix", "Falha de Login", "Aberto");
        SuporteTecnico tecnico = new SuporteTecnico("Técnico 1");
        tecnico.acompanhar(chamado);
        chamado.atualizarStatus("Em Resolução");
        assertEquals("Técnico 1, atualização recebida no Chamado{protocolo=1001, sistema='Microvix', problema='Falha de Login', status='Em Resolução'}", tecnico.getUltimaNotificacao());
    }

    @Test
    void deveNotificarTecnicos() {
        Chamado chamado = new Chamado(1001, "Microvix", "Falha de Login", "Aberto");
        SuporteTecnico tecnico1 = new SuporteTecnico("Técnico 1");
        SuporteTecnico tecnico2 = new SuporteTecnico("Técnico 2");
        tecnico1.acompanhar(chamado);
        tecnico2.acompanhar(chamado);
        chamado.atualizarStatus("Em Resolução");
        assertEquals("Técnico 1, atualização recebida no Chamado{protocolo=1001, sistema='Microvix', problema='Falha de Login', status='Em Resolução'}", tecnico1.getUltimaNotificacao());
        assertEquals("Técnico 2, atualização recebida no Chamado{protocolo=1001, sistema='Microvix', problema='Falha de Login', status='Em Resolução'}", tecnico2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarTecnico() {
        Chamado chamado = new Chamado(1001, "Microvix", "Falha de Login", "Aberto");
        SuporteTecnico tecnico = new SuporteTecnico("Técnico 1");
        chamado.atualizarStatus("Em Resolução");
        assertEquals(null, tecnico.getUltimaNotificacao());
    }

    @Test
    void deveNotificarTecnicoChamadoA() {
        Chamado chamadoA = new Chamado(1001, "Microvix", "Falha de Login", "Aberto");
        Chamado chamadoB = new Chamado(1002, "Virtual Age", "Impressora Inativa", "Aberto");
        SuporteTecnico tecnico1 = new SuporteTecnico("Técnico 1");
        SuporteTecnico tecnico2 = new SuporteTecnico("Técnico 2");
        tecnico1.acompanhar(chamadoA);
        tecnico2.acompanhar(chamadoB);
        chamadoA.atualizarStatus("Em Resolução");
        assertEquals("Técnico 1, atualização recebida no Chamado{protocolo=1001, sistema='Microvix', problema='Falha de Login', status='Em Resolução'}", tecnico1.getUltimaNotificacao());
        assertEquals(null, tecnico2.getUltimaNotificacao());
    }
}