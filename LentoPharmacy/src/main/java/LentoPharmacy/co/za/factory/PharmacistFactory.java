package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Pharmacist;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PharmacistFactory {

    public static Pharmacist getPharmacist(String pharmacistName, String quailification){

        Pharmacist pharmacist = new Pharmacist.Builder()
                .pharmacistID(KeyGenerator.getEntityId())
                .pharmacistName(pharmacistName)
                .qualification(quailification)
                .build();

        return pharmacist;
    }

    public static Pharmacist updatePharmacy(long pharmacyId,String pharmacistName, String quailification){

        Pharmacist pharmacist = new Pharmacist.Builder()
                .pharmacistID(pharmacyId)
                .pharmacistName(pharmacistName)
                .qualification(quailification)
                .build();

        return pharmacist;
    }
}
