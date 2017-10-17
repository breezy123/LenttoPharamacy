package LentoPharmacy.co.za.utility;

import java.security.SecureRandom;
/**
 * Created by aubrey on 17/08/2017.
 */
public class KeyGenerator {

    public static long getEntityId(){
        SecureRandom rand = new SecureRandom();
        long uniqueNo;

            uniqueNo = 100 + rand.nextInt(900);


        return uniqueNo;
    }
}
