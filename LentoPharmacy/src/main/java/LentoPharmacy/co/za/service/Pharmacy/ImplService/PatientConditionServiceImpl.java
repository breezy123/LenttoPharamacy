package LentoPharmacy.co.za.service.Pharmacy.ImplService;
import LentoPharmacy.co.za.domain.PatientCondition;
import LentoPharmacy.co.za.service.Pharmacy.PatientConditionService;
import LentoPharmacy.co.za.repository.PatientConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class PatientConditionServiceImpl implements PatientConditionService {

    @Autowired
    private PatientConditionRepository patientConditionRepository;

    @Override
    public PatientCondition save(PatientCondition id) {
        return patientConditionRepository.save(id);
    }

    @Override
    public PatientCondition findById(Long aLong) {
        return patientConditionRepository.findOne(aLong);
    }

    @Override
    public PatientCondition update(PatientCondition id) {
        return patientConditionRepository.save(id);
    }

    @Override
    public void delete(PatientCondition id) {
        patientConditionRepository.delete(id);
    }
}
