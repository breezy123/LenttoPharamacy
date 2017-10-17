package LentoPharmacy.co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * Created by aubrey on 07/08/2017.
 */
@Entity
public class Pharmacist implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pharmacistID;
    private String pharmacistName;
    private String qualification;


    public Pharmacist() {
    }

    public long getPharmacistID() {
        return pharmacistID;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public String getQualification() {
        return qualification;
    }

    public Pharmacist(Builder build){
        this.pharmacistID = build.pharmacistID;
        this.pharmacistName = build.pharmacistName;
        this.qualification = build.qualification;
    }


    public static class Builder{
        private long pharmacistID;
        private String pharmacistName;
        private String qualification;

        public Builder pharmacistID(long value){
            this.pharmacistID =value;
            return this;
        }
        public Builder pharmacistName(String value){
            this.pharmacistName =value;
            return this;
        }
        public Builder qualification(String value){
            this.qualification =value;
            return this;
        }
        public Pharmacist build(){
            return new Pharmacist(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pharmacist)) return false;

        Pharmacist that = (Pharmacist) o;

        return getPharmacistID() == that.getPharmacistID();
    }

    @Override
    public int hashCode() {
        return (int) (getPharmacistID() ^ (getPharmacistID() >>> 32));
    }
}
