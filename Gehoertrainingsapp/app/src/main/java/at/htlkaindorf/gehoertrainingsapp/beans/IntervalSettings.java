package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;

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

}
