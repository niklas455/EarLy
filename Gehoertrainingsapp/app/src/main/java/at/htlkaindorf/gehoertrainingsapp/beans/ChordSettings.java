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
    private boolean ascending;
    private boolean descending;
    private boolean harmonic;
}
