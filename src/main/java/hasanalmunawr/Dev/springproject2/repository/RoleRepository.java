package hasanalmunawr.Dev.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleRepository, Long> {

    Optional<RoleRepository> findByNameIgnoreCase(String roleName);
}
