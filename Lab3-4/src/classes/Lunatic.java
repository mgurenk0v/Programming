package classes;

import classes.abstracts.Creature;

public class Lunatic extends Creature {

    public Lunatic() {
    }

    public Lunatic(String name, int age, int height) {
        super(name, age, height);
    }

    public void goTo(Creature opponent) {
        if (getСonsciousness() == true) {
            System.out.println(getName() + " подошел к " + opponent.getName() + ".");
        }
    }
}