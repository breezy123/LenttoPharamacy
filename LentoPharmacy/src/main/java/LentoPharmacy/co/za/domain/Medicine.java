package LentoPharmacy.co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * Created by aubrey on 07/08/2017.
 */
@Entity
public class Medicine implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicineID ;
    private String medicineName;
    private double medicinePrice;
    private int quantity;
    private String medicinZdetails;

    public Medicine() {
    }

    public long getMedicineID() {
        return medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDetails() {
        return medicinZdetails;
    }

    public Medicine(Builder build){
        this.medicineID = build.medicineID;
        this.medicineName = build.medicineName;
        this.medicinePrice =build.medicinePrice;
        this.quantity = build.quantity;
        this.medicinZdetails = build.medicinZdetails;

    }



    public static class Builder{
        private long medicineID ;
        private String medicineName;
        private double medicinePrice;
        private int quantity;
        private String medicinZdetails;

        public Builder medicineId(long value){
            this.medicineID = value;
            return this;
        }
        public Builder medicineName(String value){
            this.medicineName = value;
            return this;
        }
        public Builder medicinePrice(double value){
            this.medicinePrice = value;
            return this;
        }
        public Builder quantity(int value){
            this.quantity = value;
            return this;
        }
        public Builder details(String value){
            this.medicinZdetails = value;
            return this;
        }
        public Medicine build(){
            return new Medicine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;

        Medicine medicine = (Medicine) o;

        return getMedicineID() == medicine.getMedicineID();
    }

    @Override
    public int hashCode() {
        return (int) (getMedicineID() ^ (getMedicineID() >>> 32));
    }
}
