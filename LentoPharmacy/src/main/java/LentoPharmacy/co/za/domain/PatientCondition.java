package LentoPharmacy.co.za.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by aubrey on 07/08/2017.
 */
@Entity
public class PatientCondition implements Serializable {

    @Id
    private long Id;
    private long patientID;
    private long conditionId;
    private Date dateDiagnosed;

    @Column(name ="patientID", nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Patient> patientSet;

    @Column(name ="conditionId", nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Conditions>conditionsSet;


    public PatientCondition() {
    }


    public long getId() {
        return Id;
    }

    public long getPatientId() {
        return patientID;
    }

    public long getConditionId() {
        return conditionId;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public PatientCondition(Builder build){

        this.Id = build.Id;
        this.patientID = build.patientID;
        this.conditionId = build.conditionId;
        this.dateDiagnosed = build.dateDiagnosed;
    }


    public static class Builder{

        private long Id;
        private long patientID;
        private long conditionId;
        private Date dateDiagnosed;

        public Builder id(long value){
            this.Id = value;
            return this;
        }
        public Builder patientIdentity(long value){
            this.patientID = value;
            return this;
        }
        public Builder conditionIdentity(long value){
            this.conditionId = value;
            return this;
        }
        public Builder dateDiagnosed(Date value){
            this.dateDiagnosed = value;
            return this;
        }
        public PatientCondition build(){
            return new PatientCondition(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientCondition)) return false;

        PatientCondition that = (PatientCondition) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
