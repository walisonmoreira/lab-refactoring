package lab.refactoring.web;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Long> {
  List<Venda> findByPro(String pro);
}