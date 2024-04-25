package hasanalmunawr.Dev.springproject2.repository;

import hasanalmunawr.Dev.springproject2.entity.CredentialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends CrudRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> getCredentialEntityByUserEntityId(Long userEntityId);
}
