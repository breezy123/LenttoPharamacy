package LentoPharmacy.co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by aubrey on 07/09/2017.
 */
@Entity
public class Conditions implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conditionId;
    private String conditionName;

    public Conditions() {
    }

    public long getConditionId() {
        return conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public Conditions(Conditions.Builder build){
        this.conditionId = build.conditionId;
        this.conditionName = build.conditionName;
    }

    public static class Builder{
        private long conditionId;
        private String conditionName;

        public Conditions.Builder conditionId(long value) {
            this.conditionId = value;
            return this;
        }
        public Conditions.Builder conditionName(String value) {
            this.conditionName = value;
            return this;
        }
        public Conditions build(){
            return new Conditions(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conditions)) return false;

        Conditions that = (Conditions) o;

        return getConditionId() == that.getConditionId();
    }

    @Override
    public int hashCode() {
        return (int) (getConditionId() ^ (getConditionId() >>> 32));
    }
}
