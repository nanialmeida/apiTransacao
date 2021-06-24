package br.com.api.transacao.transacoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransacaoRepository extends JpaRepository<EventoDeTransacao, String> {


    Page<EventoDeTransacao> findByCartaoId(String idCartao, Pageable paginacao);
}
