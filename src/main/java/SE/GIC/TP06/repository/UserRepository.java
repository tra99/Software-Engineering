package SE.GIC.TP06.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import SE.GIC.TP06.entity.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long>{
    Optional<MyUser> findByUsername(String username);
    void deleteByUsername(String username);
    List<MyUser> findAll();
}
