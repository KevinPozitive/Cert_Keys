package by.nces.sert_Keys.repo;

import by.nces.sert_Keys.models.MembersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface MembersRepo extends JpaRepository<MembersModel, Long> {
}
