package by.nces.sert_Keys.repo;

import by.nces.sert_Keys.models.CertSetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CertSetRepo extends JpaRepository<CertSetModel, Long> {
}
