package br.com.api.transacao.listenerkafka;


import br.com.api.transacao.transacoes.EventoDeTransacaoForm;
import br.com.api.transacao.transacoes.TransacaoRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.api.transacao.transacoes.EventoDeTransacao;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ListenerDeTransacao {

    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    TransacaoRepository transacaoRepository;

    private Counter contadorTransacoesSalvas;

    @PostConstruct
    public void metricasCounter() {
        Collection<Tag> tags = new ArrayList<>();
        this.contadorTransacoesSalvas = this.meterRegistry.counter("transacao_criada_com_sucesso", tags);
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacaoForm eventoDeTransacao) {
        EventoDeTransacao evento = eventoDeTransacao.converte();
        if (evento.getId() != null) {
            contadorTransacoesSalvas.increment();
        }
        System.out.println("Evento Chamado");
        transacaoRepository.save(evento);
        System.out.println("Evento Salvo");
    }
}
