package Classes;

public interface CreatureMethods {
    void laugh();

    void rest();

    void look(String string);

    String say(String phrase);

    String say(String phrase, Creature opponent);

    void move(Direction direction);

    void loseConsciousness();

    void wakeUp();

    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);

    int getHeight();

    void setHeight(int height);

    boolean getСonsciousness();

    void setWeight(double weight);

    double getWeight();

    @Override
    String toString();
    @Override
    boolean equals(Object ob);
    @Override
    int hashCode();
}
