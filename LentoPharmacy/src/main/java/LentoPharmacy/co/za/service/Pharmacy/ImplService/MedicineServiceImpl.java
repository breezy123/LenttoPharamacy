package LentoPharmacy.co.za.service.Pharmacy.ImplService;

import LentoPharmacy.co.za.domain.Medicine;
import LentoPharmacy.co.za.repository.MedicineRepository;
import LentoPharmacy.co.za.service.Pharmacy.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class MedicineServiceImpl implements MedicineService {

   @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine save(Medicine id) {
        return medicineRepository.save(id);
    }

    @Override
    public Medicine findById(Long aLong) {
        return medicineRepository.findOne(aLong);
    }

    @Override
    public Medicine update(Medicine id) {
        return medicineRepository.save(id);
    }

    @Override
    public void delete(Medicine id) {
        medicineRepository.delete(id);
    }
}
