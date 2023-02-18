package app.studyjko.data.parms;

import app.studyjko.model.ParmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParmsRepository extends JpaRepository<ParmsEntity, Long> {
    ParmsEntity findParmsEntityByName(String name);
}
