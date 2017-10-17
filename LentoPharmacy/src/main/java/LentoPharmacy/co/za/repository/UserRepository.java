package LentoPharmacy.co.za.repository;

import LentoPharmacy.co.za.domain.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aubrey on 09/09/2017.
 */
public interface UserRepository extends CrudRepository<Users, Long> {
}
