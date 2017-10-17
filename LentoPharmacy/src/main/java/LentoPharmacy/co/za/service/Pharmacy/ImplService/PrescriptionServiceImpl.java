package LentoPharmacy.co.za.service.Pharmacy.ImplService;

import LentoPharmacy.co.za.domain.Prescription;
import LentoPharmacy.co.za.repository.PrescriptionRepository;
import LentoPharmacy.co.za.service.Pharmacy.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
   private PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription save(Prescription id) {
        return prescriptionRepository.save(id);
    }

    @Override
    public Prescription findById(Long aLong) {
        return prescriptionRepository.findOne(aLong);
    }

    @Override
    public Prescription update(Prescription id) {
        return prescriptionRepository.save(id);
    }

    @Override
    public void delete(Prescription id) {
        prescriptionRepository.delete(id);
    }
}
