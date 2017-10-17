package LentoPharmacy.co.za.factory;

import LentoPharmacy.co.za.domain.Users;
import LentoPharmacy.co.za.utility.KeyGenerator;

/**
 * Created by aubrey on 09/09/2017.
 */
public class UsersFactory {

    public static Users buildUsers(String firstName, String lastName, String userName, String password){

        Users users = new Users.Builder()

                .userID(KeyGenerator.getEntityId())
                .firstName(firstName)
                .lastName(lastName)
                .username(userName)
                .password(password)
                .builder();

        return users;

    }
}
