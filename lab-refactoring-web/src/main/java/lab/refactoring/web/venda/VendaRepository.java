package lab.refactoring.web.venda;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Integer> {
  public Iterable<Venda> findByDataGreaterThan(Date data);
}