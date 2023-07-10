package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScaleSettings implements Serializable {
    private boolean major;
    private boolean naturalMinor;
    private boolean harmonicMinor;
    private boolean melodicMinor;
    private boolean ascending;
    private boolean descending;

    public boolean allIntervalFalse() {
        if(!major  && !naturalMinor && !harmonicMinor && !melodicMinor) {
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
        if(major) { possibleScaleList.add("majorscale");}
        if(naturalMinor) { possibleScaleList.add("naturalminorscale");}
        if(harmonicMinor) { possibleScaleList.add("harmonicminorscale");}
        if(melodicMinor) { possibleScaleList.add("melodicminorscale");}
        return possibleScaleList;
    }

    public List<String> getPossiblePlayMode() {
        List<String> possiblePlayMode = new ArrayList<>();
        if(ascending) { possiblePlayMode.add("asc");}
        if(descending) { possiblePlayMode.add("desc");}
        return possiblePlayMode;
    }
}
