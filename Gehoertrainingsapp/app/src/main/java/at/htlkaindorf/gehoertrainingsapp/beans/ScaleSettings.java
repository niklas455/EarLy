package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScaleSettings implements Serializable {
    private boolean majorIonian;
    private boolean naturalMinorAeolian;
    private boolean harmonicMinor;
    private boolean melodicMinor;
    private boolean dorian;
    private boolean phrygian;
    private boolean lydian;
    private boolean mixolydian;
    private boolean locrian;
    private boolean ascending;
    private boolean descending;

    public boolean allIntervalFalse() {
        if(!majorIonian && !naturalMinorAeolian && !harmonicMinor && !melodicMinor && !dorian
                && !phrygian && !lydian && !mixolydian && !locrian) {
            return true;
        } else { return false; }
    }

    public boolean allPlayModeFalse() {
        if(!ascending && !descending) {
            return true;
        } else { return false; }
    }

    public List<String> getPossibleScaleList() {
        List<String> possibleScaleList = new ArrayList<>();
        if(majorIonian) { possibleScaleList.add("major_ionian");}
        if(naturalMinorAeolian) { possibleScaleList.add("natural_minor_aeolian");}
        if(harmonicMinor) { possibleScaleList.add("harmonic_minor");}
        if(melodicMinor) { possibleScaleList.add("melodic_minor");}
        if(dorian) { possibleScaleList.add("dorian");}
        if(phrygian) { possibleScaleList.add("phrygian");}
        if(lydian) { possibleScaleList.add("lydian");}
        if(mixolydian) { possibleScaleList.add("mixolydian");}
        if(locrian) { possibleScaleList.add("locrian");}
        return possibleScaleList;
    }

    public List<String> getPossiblePlayMode() {
        List<String> possiblePlayMode = new ArrayList<>();
        if(ascending) { possiblePlayMode.add("asc");}
        if(descending) { possiblePlayMode.add("desc");}
        return possiblePlayMode;
    }
}
