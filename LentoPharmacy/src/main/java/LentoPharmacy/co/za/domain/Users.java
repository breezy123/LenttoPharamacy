package LentoPharmacy.co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by aubrey on 09/09/2017.
 */
@Entity
public class Users implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Users() {
    }

    public long getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

   public Users(Users.Builder builder){
       this.userID = builder.userID;
       this.firstName = builder.firstName;
       this.lastName = builder.lastName;
       this.userName = builder.userName;
       this.password = builder.password;
   }
    public static class Builder{
        private long userID;
        private String firstName;
        private String lastName;
        private String userName;
        private String password;

        public Users.Builder userID(long value){
            this.userID = value;
            return this;
        }
        public Users.Builder firstName(String value){
            this.firstName = value;
            return this;
        }
        public Users.Builder lastName(String value){
            this.lastName = value;
            return this;
        }
        public Users.Builder username(String value){
            this.userName = value;
            return this;
        }
        public Users.Builder password(String value){
            this.password = value;
            return this;
        }

        public Users builder(){
            return new Users(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        return getUserID() == users.getUserID();
    }

    @Override
    public int hashCode() {
        return (int) (getUserID() ^ (getUserID() >>> 32));
    }
}

