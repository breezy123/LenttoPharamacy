package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.PatientCondition;
import LentoPharmacy.co.za.utility.KeyGenerator;

import java.util.Date;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionFactory {

    public static PatientCondition getPatientCondition(long patient,long conditions,Date dateDiagnosed){

        PatientCondition patientCondition = new PatientCondition.Builder()
                .id(KeyGenerator.getEntityId())
                .patientIdentity(patient)
                .conditionIdentity(conditions)
                .dateDiagnosed(dateDiagnosed)
                .build();

        return patientCondition;
    }
}
