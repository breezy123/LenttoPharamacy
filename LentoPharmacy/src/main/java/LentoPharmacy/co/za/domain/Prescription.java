package LentoPharmacy.co.za.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by aubrey on 07/08/2017.
 */

@Entity
public class Prescription implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prescriptionID;
    private Date prescriptionDate;
    private String doctorId;
    private long patientID;
    private long pharmacistID;


    @Column(name = "patientID", nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Patient> patientSet;

    @Column(name = "pharmacistID", nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pharmacist>pharmacistSet;

    public Prescription() {
    }

    public long getPrescriptionID() {
        return prescriptionID;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public long getPatientID() {
        return patientID;
    }

    public long getPharmacistID() {
        return pharmacistID;
    }

    public Prescription(Builder build){
        this.prescriptionID = build.prescriptionID;
        this.prescriptionDate =build.prescriptionDate;
        this.doctorId = build.doctorId;
        this.patientID = build.patientID;
        this.pharmacistID =build.pharmacistID;
    }



    public static class Builder{
        private long prescriptionID;
        private Date prescriptionDate;
        private String doctorId;
        private long patientID;
        private long pharmacistID;

        public Builder prescriptionID(long value){
            this.prescriptionID = value;
            return this;
        }
        public Builder prescriptionDate(Date value){
            this.prescriptionDate = value;
            return this;
        }
        public Builder doctorId(String value){
            this.doctorId = value;
            return this;
        }
        public Builder patientID(long value){
            this.patientID = value;
            return this;
        }
        public Builder pharmacistID(long value){
            this.pharmacistID = value;
            return this;
        }
        public Prescription build(){
            return new Prescription(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescription)) return false;

        Prescription that = (Prescription) o;

        return getPrescriptionID() == that.getPrescriptionID();
    }

    @Override
    public int hashCode() {
        return (int) (getPrescriptionID() ^ (getPrescriptionID() >>> 32));
    }
}
