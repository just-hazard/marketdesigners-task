package just.hazard.marketdesignerstask.repositories;

import just.hazard.marketdesignerstask.entity.HomeMoveApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeMoveRepository extends JpaRepository<HomeMoveApplication,Long> {
}
