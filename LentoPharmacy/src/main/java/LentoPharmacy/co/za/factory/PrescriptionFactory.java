package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Prescription;
import LentoPharmacy.co.za.utility.KeyGenerator;

import java.util.Date;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionFactory {

    public static Prescription getPrecscription(Date datedescription, String doctorID,
                                                long patient, long pharmacist){

        Prescription prescription = new Prescription.Builder()

                .prescriptionID(KeyGenerator.getEntityId())
                .prescriptionDate(datedescription)
                .doctorId(doctorID)
                .patientID(patient)
                .pharmacistID(pharmacist)
                .build();

        return prescription;
    }
}
