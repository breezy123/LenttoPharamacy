package LentoPharmacy.co.za.service.Pharmacy.ImplService;
import LentoPharmacy.co.za.domain.Prescriptionline;
import LentoPharmacy.co.za.repository.PrescriptionLineRepository;
import LentoPharmacy.co.za.service.Pharmacy.PrescriptionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by aubrey on 08/08/2017.
 */
@Component
public class PrescriptionLineServiceImpl implements PrescriptionLineService {

    @Autowired
    private PrescriptionLineRepository prescriptionLineRepository;

    @Override
    public Prescriptionline save(Prescriptionline id) {
        return prescriptionLineRepository.save(id);
    }

    @Override
    public Prescriptionline findById(Long aLong) {
        return prescriptionLineRepository.findOne(aLong);
    }

    @Override
    public Prescriptionline update(Prescriptionline id) {
        return prescriptionLineRepository.save(id);
    }

    @Override
    public void delete(Prescriptionline id) {
        prescriptionLineRepository.delete(id);
    }
}
