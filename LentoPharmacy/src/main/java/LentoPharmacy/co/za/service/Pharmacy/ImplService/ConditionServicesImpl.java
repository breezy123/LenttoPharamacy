package LentoPharmacy.co.za.service.Pharmacy.ImplService;

import LentoPharmacy.co.za.domain.Conditions;
import LentoPharmacy.co.za.repository.ConditionRepository;
import LentoPharmacy.co.za.service.Pharmacy.ConditionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class ConditionServicesImpl implements ConditionServices {

    @Autowired
    private ConditionRepository userrepository;

    @Override
    public Conditions save(Conditions id) {
        return userrepository.save(id);
    }

    @Override
    public Conditions findById(Long aLong) {
        return userrepository.findOne(aLong);
    }

    @Override
    public Conditions update(Conditions id) {
        return userrepository.save(id);
    }

    @Override
    public void delete(Conditions id) {
        userrepository.delete(id);
    }
}
