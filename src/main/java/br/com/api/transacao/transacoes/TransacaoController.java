package br.com.api.transacao.transacoes;

import br.com.api.transacao.exceptions.FieldErrorOutputDto;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    private MeterRegistry meterRegistry;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository, MeterRegistry meterRegistry) {
        this.transacaoRepository = transacaoRepository;
        this.meterRegistry = meterRegistry;
    }

    public void criarGauge(List<EventoTransacaoDto> transacao) {

        this.meterRegistry.gauge("gauge_lista_transacao", transacao.size());
    }

    @GetMapping("transacoes/{idCartao}")
    public ResponseEntity<?> listaTransacoes(@PathVariable("idCartao") String idCartao,
                                             @PageableDefault(sort = "efetivadaEm",direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){

        Page<EventoDeTransacao> transacoes = transacaoRepository.findByCartaoId(idCartao,paginacao);
        if(transacoes.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FieldErrorOutputDto( "idCartao","Numero do cartao informado nao e valido"));
        }
        List<EventoTransacaoDto> listatransacao = transacoes.map(transacao -> new EventoTransacaoDto(transacao)).getContent();

        criarGauge(listatransacao);
        return ResponseEntity.ok().body(listatransacao);


    }
}
