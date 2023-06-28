package at.htlkaindorf.gehoertrainingsapp.beans;

import java.io.Serializable;

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
}
