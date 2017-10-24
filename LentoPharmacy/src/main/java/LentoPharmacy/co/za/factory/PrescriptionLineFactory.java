package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Prescriptionline;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineFactory {

    public static Prescriptionline getPrescriptionLine(long prescription, String instructions,
                                                       long medicine, double price, int qauntity){

        Prescriptionline prescriptionline = new Prescriptionline.Builder()

                .lineID(KeyGenerator.getEntityId())
                .prescriptionID(prescription)
                .instructions(instructions)
                .price(price)
                .medicineID(medicine)
                .quantity(qauntity)
                .build();
        return prescriptionline;
    }
}
