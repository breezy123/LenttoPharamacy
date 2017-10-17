package LentoPharmacy.co.za.factory;

/**
 * Created by aubrey on 07/08/2017.
 */

import LentoPharmacy.co.za.domain.Conditions;
import LentoPharmacy.co.za.utility.KeyGenerator;

public class ConditionFactory {

    public static Conditions buildCondition(String conditionName){

        Conditions conditionFactory = new Conditions.Builder()
                 .conditionId(KeyGenerator.getEntityId())
                .conditionName(conditionName)
                .build();

        return conditionFactory;
    }
}
