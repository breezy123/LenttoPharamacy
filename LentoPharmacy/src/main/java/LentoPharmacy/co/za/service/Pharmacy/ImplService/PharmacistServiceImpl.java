package LentoPharmacy.co.za.service.Pharmacy.ImplService;
import LentoPharmacy.co.za.domain.Pharmacist;
import LentoPharmacy.co.za.repository.PharmacistRepository;
import LentoPharmacy.co.za.service.Pharmacy.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Override
    public Pharmacist save(Pharmacist id) {
        return pharmacistRepository.save(id);
    }

    @Override
    public Pharmacist findById(Long aLong) {
        return pharmacistRepository.findOne(aLong);
    }

    @Override
    public Pharmacist update(Pharmacist id) {
        return pharmacistRepository.save(id);
    }

    @Override
    public void delete(Pharmacist id) {
        pharmacistRepository.delete(id);
    }
}
