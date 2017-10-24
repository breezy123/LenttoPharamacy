package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Medicine;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 07/08/2017.
 */
public class MedicineFactory {

    public static Medicine getMedicine(String medicineName, double medicinePrice,int quantity, String medicineDetails){

        Medicine medicine = new Medicine.Builder()
                .medicineId(KeyGenerator.getEntityId())
                .medicineName(medicineName)
                .medicinePrice(medicinePrice)
                .quantity(quantity)
                .details(medicineDetails)
                .build();

        return medicine;
    }

    public static Medicine updateMedicine(long medicineID, String medicineName, double medicinePrice,int quantity, String medicineDetails){

        Medicine medicine = new Medicine.Builder()
                .medicineId(medicineID)
                .medicineName(medicineName)
                .medicinePrice(medicinePrice)
                .quantity(quantity)
                .details(medicineDetails)
                .build();

        return medicine;
    }
}
