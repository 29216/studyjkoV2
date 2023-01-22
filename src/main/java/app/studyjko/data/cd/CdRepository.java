package app.studyjko.data.cd;

import app.studyjko.model.CdEntity;
import app.studyjko.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdRepository extends JpaRepository<CdEntity, Long> {
}
