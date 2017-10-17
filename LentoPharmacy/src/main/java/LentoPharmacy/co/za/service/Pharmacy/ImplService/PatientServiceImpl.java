package LentoPharmacy.co.za.service.Pharmacy.ImplService;

import LentoPharmacy.co.za.domain.Patient;
import LentoPharmacy.co.za.repository.PatientRepository;
import LentoPharmacy.co.za.service.Pharmacy.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient save(Patient id) {
        return patientRepository.save(id);
    }

    @Override
    public Patient findById(Long aLong) {
        return patientRepository.findOne(aLong);
    }

    @Override
    public Patient update(Patient id) {
        return patientRepository.save(id);
    }

    @Override
    public void delete(Patient id) {
        patientRepository.delete(id);
    }
}
