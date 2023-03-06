package Classes;

public abstract class Creature implements CreatureMethods {

    private String name;
    private int age;
    private int height;
    private double weight = 0;
    private boolean inConscious = true;

    public Creature() {}

    public Creature(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    @Override
    public void laugh() {
        if (inConscious == true) {System.out.println(name + " смеётся.");}
    }
    @Override
    public void rest() {
        System.out.println(getName() + " отдыхает.");
    }
    @Override
    public void look(String string) {
        if (getСonsciousness() == true) {
            System.out.println(getName() + " посмотрел на " + string);
        }
    }
    @Override
    public String say(String phrase) {
        if (inConscious == true) {
            return name + " сказал: \"" + phrase + "\"";
        } else {return name + " что-то промычал сквозь сон.";}
    }
    @Override
    public String say(String phrase, Creature opponent) {
        if (inConscious == true) {
            return name + " сказал " + opponent.getName() + ": \"" + phrase + "\"";
        } else {return name + " что-то промычал сквозь сон.";}
    }
    @Override
    public void move(Direction direction) {
        if (inConscious == true) {System.out.println(name + " переместился в следующем направлении: " + direction);}
    }

    @Override
    public void loseConsciousness() {
        if (inConscious == true) {
            System.out.println(getName() + " отключился.");
            this.inConscious = false;
        }
    }
    @Override
    public void wakeUp() {
        if (inConscious == false) {
            System.out.println(getName() + " очнулся.");
            this.inConscious = true;
        }
    }
    @Override
    public String getName() {
        if (name != null) {
            return name;
        } else return "*имя не указано*";
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean getСonsciousness() {
        return inConscious;
    }
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String strAge;
        String strHeight;
        String strWeight;
        if (getAge() == 0) {
            strAge = "*возраст не указан*";
        } else {strAge = Integer.toString(getAge());}

        if (getHeight() == 0) {
            strHeight = "*рост не указан*";
        } else {strHeight = Integer.toString(getHeight());}

        if (getWeight() == 0) {
            strWeight = "*вес не указан*";
        } else {strWeight = Double.toString(getWeight());}

        return "INFO: " + "\n" + "Имя " + getName() + "\n" + "Возраст " + strAge + "\n" + "Рост " + strHeight + "\n" + "Вес " + strWeight;
    }

    @Override
    public boolean equals(Object ob) {
        Creature creature = (Creature) ob;
        if (this == creature){return true;}
        if ((getName() == creature.getName()) && (getWeight() == creature.getWeight()) && (getHeight() == creature.getHeight()) && (getAge() == creature.getAge())) {
            return true;
        } else {return false;}
    }

//    @Override
//    public int hashCode() {}

}

