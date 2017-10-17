package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Patient;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientFactory {

    public static Patient getPatient(String patientName, String medicalaidName, int medicalaidNumber){

        Patient patient = new Patient.Builder()
                .patientId(KeyGenerator.getEntityId())
                .patientName(patientName)
                .medicalaidName(medicalaidName)
                .medicalaidNumber(medicalaidNumber)
                .build();

        return patient;
    }
}
