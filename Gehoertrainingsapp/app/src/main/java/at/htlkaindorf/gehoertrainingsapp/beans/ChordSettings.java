package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;

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
    private boolean dominant7th;
    private boolean major7th;
    private boolean minor7th;
    private boolean diminished7th;
    private boolean ascending;
    private boolean descending;
    private boolean harmonic;

    public boolean allIntervalFalse() {
        if(!major && !minor && !augmented && !diminished && !dominant7th &&
                !major7th && !minor7th && !diminished7th) {
            return true;
        } else { return false; }
    }

    public boolean allPlayModeFalse() {
        if(!ascending && !descending  && !harmonic) {
            return true;
        } else { return false; }
    }
}
