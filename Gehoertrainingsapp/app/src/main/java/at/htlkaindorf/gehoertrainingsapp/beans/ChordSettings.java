package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ChordSettings implements Serializable {
    private boolean major;
    private boolean minor;
    private boolean augmented;
    private boolean diminished;
    private boolean major7th;
    private boolean minor7th;
    private boolean dominant7th;
    private boolean minorMaj7th;
    private boolean halfDim7th;
    private boolean diminished7th;
    private boolean ascending;
    private boolean descending;
    private boolean harmonic;

    public boolean allIntervalFalse() {
        if(!major && !minor && !augmented && !diminished && !major7th &&
                !minor7th && !dominant7th && !minorMaj7th && !halfDim7th && !diminished7th) {
            return true;
        } else { return false; }
    }

    public boolean allPlayModeFalse() {
        if(!ascending && !descending  && !harmonic) {
            return true;
        } else { return false; }
    }

    public List<String> getPossibleChordList() {
        List<String> possibleChordList = new ArrayList<>();
        if(major) { possibleChordList.add("major");}
        if(minor) { possibleChordList.add("minor");}
        if(augmented) { possibleChordList.add("augmented");}
        if(diminished) { possibleChordList.add("diminished");}
        if(major7th) { possibleChordList.add("major7th");}
        if(minor7th) { possibleChordList.add("minor7th");}
        if(dominant7th) { possibleChordList.add("dominant7th");}
        if(minorMaj7th) { possibleChordList.add("minormaj7th");}
        if(halfDim7th) { possibleChordList.add("halfdim7th");}
        if(diminished7th) { possibleChordList.add("diminished7th");}
        return possibleChordList;
    }

    public List<String> getPossiblePlayMode() {
        List<String> possiblePlayMode = new ArrayList<>();
        if(ascending) { possiblePlayMode.add("asc");}
        if(descending) { possiblePlayMode.add("desc");}
        if(harmonic) { possiblePlayMode.add("harm");}
        return possiblePlayMode;
    }
}
