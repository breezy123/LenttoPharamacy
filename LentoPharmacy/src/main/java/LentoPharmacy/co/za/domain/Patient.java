package LentoPharmacy.co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * Created by aubrey on 07/08/2017.
 */
@Entity
public class Patient implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientID;
    private String patientName;
    private String medicalaidName;
    private int medicalaidNumber;

    //public String getPatientID;

    public Patient() {
    }


    public String getPatientName() {
        return patientName;
    }

    public String getMedicalaidName() {
        return medicalaidName;
    }

    public int getMedicalaidNumber() {
        return medicalaidNumber;
    }

    public long getPatientID() {
        return patientID;
    }

    public Patient(Builder build){

        this.patientID = build.patientID;
        this.patientName = build.patientName;
        this.medicalaidName = build.medicalaidName;
        this.medicalaidNumber = build.medicalaidNumber;
    }



    public static class Builder{

        private long patientID;
        private String patientName;
        private String medicalaidName;
        private int medicalaidNumber;

        public Builder patientId(long value){
            this.patientID = value;
            return this;
        }
        public Builder patientName(String value){
            this.patientName = value;
            return this;
        }
        public Builder medicalaidName(String value){
            this.medicalaidName = value;
            return this;
        }
        public Builder medicalaidNumber(int value){
            this.medicalaidNumber = value;
            return this;
        }
        public Patient build(){
            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        return getPatientID() == patient.getPatientID();
    }

    @Override
    public int hashCode() {
        return (int) (getPatientID() ^ (getPatientID() >>> 32));
    }
}
