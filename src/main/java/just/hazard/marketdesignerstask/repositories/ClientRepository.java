package just.hazard.marketdesignerstask.repositories;

import just.hazard.marketdesignerstask.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
