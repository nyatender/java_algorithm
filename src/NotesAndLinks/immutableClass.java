package NotesAndLinks;

import java.util.Date;

public class immutableClass {
    public static void main(String[] args) {
    }

    /**
     * Integer and String classes are immutable whereas Date class is mutable
     */
    private final Integer immutableInteger;
    private final String immutableString;
    private final Date mutableDate;

    public immutableClass(Integer i, String s, Date d) {
        this.immutableInteger = i;
        this.immutableString = s;
        this.mutableDate = new Date(d.getTime());
    }

    public String getImmutableString() {
        return immutableString;
    }

    public Integer getImmutableInteger() {
        return immutableInteger;
    }

    public Date getMutableDate() {
        return new Date(mutableDate.getTime());
    }

    @Override
    public String toString() {
        return immutableInteger + ", " + immutableString + ", " + mutableDate;
    }
}