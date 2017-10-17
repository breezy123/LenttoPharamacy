package LentoPharmacy.co.za.service.Pharmacy.ImplService;

import LentoPharmacy.co.za.domain.Users;
import LentoPharmacy.co.za.repository.UserRepository;
import LentoPharmacy.co.za.service.Pharmacy.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aubrey on 09/09/2017.
 */
@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userrepository;

    @Override
    public Users save(Users id) {
        return userrepository.save(id);
    }

    @Override
    public Users findById(Long aLong) {
        return userrepository.findOne(aLong);
    }

    @Override
    public Users update(Users id) {
        return userrepository.save(id);
    }

    @Override
    public void delete(Users id) {
        userrepository.delete(id);
    }
}
