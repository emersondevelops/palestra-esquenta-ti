package br.com.esquentati.turistasjp.repository;

import br.com.esquentati.turistasjp.model.Turista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TuristaRepository extends CrudRepository<Turista, Long> {

    Optional<Turista> findByCpf(String cpf);

}
