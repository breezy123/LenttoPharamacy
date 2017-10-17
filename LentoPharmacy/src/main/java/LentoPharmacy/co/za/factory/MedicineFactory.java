package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Medicine;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 07/08/2017.
 */
public class MedicineFactory {

    public static Medicine getMedicine(String medicineName, double medicinePrice){

        Medicine medicine = new Medicine.Builder()
                .medicineId(KeyGenerator.getEntityId())
                .medicineName(medicineName)
                .medicinePrice(medicinePrice)
                .build();

        return medicine;
    }
}
