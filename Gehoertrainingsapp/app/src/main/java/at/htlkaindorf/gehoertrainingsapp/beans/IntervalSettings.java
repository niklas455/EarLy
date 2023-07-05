package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IntervalSettings implements Serializable {
    private boolean unison;
    private boolean minor2nd;
    private boolean major2nd;
    private boolean minor3rd;
    private boolean major3rd;
    private boolean perfect4th;
    private boolean triton;
    private boolean perfect5th;
    private boolean minor6th;
    private boolean major6th;
    private boolean minor7th;
    private boolean major7th;
    private boolean octave;
    private boolean ascending;
    private boolean descending;
    private boolean harmonic;

    public boolean allIntervalFalse() {
        if(!unison && !minor2nd && !major2nd && !minor3rd && !major3rd &&
                !perfect4th && !triton && !perfect5th && !minor6th  && !major6th &&
                !minor7th && !major7th  && !octave) {
            return true;
        } else { return false; }
    }

    public boolean allPlayModeFalse() {
        if(!ascending && !descending  && !harmonic) {
            return true;
        } else { return false; }
    }

    public List<String> getPossibleIntervalList() {
        List<String> possibleIntervalList = new ArrayList<>();
        if(unison) { possibleIntervalList.add("unison");}
        if(minor2nd) { possibleIntervalList.add("minor2nd");}
        if(major2nd) { possibleIntervalList.add("major2nd");}
        if(minor3rd) { possibleIntervalList.add("minor3rd");}
        if(major3rd) { possibleIntervalList.add("major3rd");}
        if(perfect4th) { possibleIntervalList.add("perfect4th");}
        if(triton) { possibleIntervalList.add("tritone");}
        if(perfect5th) { possibleIntervalList.add("perfect5th");}
        if(minor6th) { possibleIntervalList.add("minor6th");}
        if(major6th) { possibleIntervalList.add("major6th");}
        if(minor7th) { possibleIntervalList.add("minor7th");}
        if(major7th) { possibleIntervalList.add("major7th");}
        if(octave) { possibleIntervalList.add("octave");}
        return possibleIntervalList;
    }

    public List<String> getPossiblePlayMode() {
        List<String> possiblePlayMode = new ArrayList<>();
        if(ascending) { possiblePlayMode.add("asc");}
        if(descending) { possiblePlayMode.add("desc");}
        if(harmonic) { possiblePlayMode.add("harm");}
        return possiblePlayMode;
    }

}
