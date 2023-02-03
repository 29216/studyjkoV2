package app.studyjko.data.cd;

import app.studyjko.model.CdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdRepository extends JpaRepository<CdEntity, Long> {
    List<CdEntity> findCdEntitiesByUserId(Long id);
}
