package classes.interfaces;

import classes.Shortee;

public interface StoveMethods {
    void raiseBy(Shortee...shortees);
    void dropBy(Shortee...shortees);
    void chokeFire();
    public void chokeFire(Shortee shortee);
    void setFire(Shortee shortee);
    boolean getBurningStatus();
    boolean getStatus();
    void setWeight(double weight);
    double getWeight();
    @Override
    String toString();
    @Override
    boolean equals(Object ob);
    @Override
    int hashCode();
}
