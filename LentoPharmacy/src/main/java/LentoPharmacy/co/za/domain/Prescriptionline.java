package LentoPharmacy.co.za.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by aubrey on 07/08/2017.
 */

@Entity
public class Prescriptionline implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lineId;
    private long prescriptionID;
    private String instructions;
    private long medicineID;
    private double price;
    private int quantity;

    @Column(name = "prescriptionID", nullable = true)
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Prescription> prescriptionSet;

    @Column(name = "medicineID",nullable = true)
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Medicine>medicineSet;
    public Prescriptionline() {
    }

    public long getPrescriptionID() {
        return prescriptionID;
    }

    public long getLineId() {
        return lineId;
    }

    public String getInstructions() {
        return instructions;
    }

    public long getMedicineID() {
        return medicineID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalPrescription(){
        return this.quantity * this.price;
    }

    public Prescriptionline(Builder build){
        this.prescriptionID = build.prescriptionID;
        this.lineId = build.lineId;
        this.instructions = build.instructions;
        this.medicineID = build.medicineID;
        this.price = build.price;
        this.quantity = build.quantity;
    }

    public static class Builder{
        private long prescriptionID;
        private long lineId;
        private String instructions;
        private long medicineID;
        private double price;
        private int quantity;

        public Builder prescriptionID(long value){
            this.prescriptionID = value;
            return this;
        }
        public Builder lineID(long value){
            this.lineId = value;
            return this;
        }
        public Builder instructions(String value){
            this.instructions = value;
            return this;
        }
        public Builder medicineID(long value){
            this.medicineID = value;
            return this;
        }

        public Builder price(double value){
            this.price = value;
            return this;
        }
        public Builder quantity(int value){
            this.quantity = value;
            return this;
        }

        public Prescriptionline build(){
            return new Prescriptionline(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescriptionline)) return false;

        Prescriptionline that = (Prescriptionline) o;

        return getLineId() == that.getLineId();
    }

    @Override
    public int hashCode() {
        return (int) (getLineId() ^ (getLineId() >>> 32));
    }
}
