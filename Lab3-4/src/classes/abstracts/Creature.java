package classes.abstracts;

import classes.enums.Direction;
import classes.exceptions.unchecked.AgeOutOfRangeException;
import classes.exceptions.unchecked.HeightOutOfRangeException;
import classes.exceptions.unchecked.WeightOutOfRangeException;
import classes.interfaces.CreatureMethods;

public abstract class Creature implements CreatureMethods {

    private String name;
    private int age;
    private int height;
    private double weight = 0;
    private boolean inConscious = true;

    public Creature() {}

    public Creature(String name, int age, int height) throws AgeOutOfRangeException, HeightOutOfRangeException {
        if (age < 0) {
            throw new AgeOutOfRangeException("Возраст не может быть отрицательным!");
        } else if (age > 210) {
            throw new AgeOutOfRangeException("Слишком большой возраст!");
        } else {this.age = age;}

        if (height < 0) {
            throw new HeightOutOfRangeException("Рост не может быть отрицательным");
        } else if (height > 210) {
            throw new HeightOutOfRangeException("Слишком высокий рост!");
        } else {this.height = height;}

        this.name = name;
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
    public void setAge(int age) throws AgeOutOfRangeException {
        if (age < 0) {
            throw new AgeOutOfRangeException("Возраст не может быть отрицательным!");
        } else if (age > 210) {
            throw new AgeOutOfRangeException("Слишком большой возраст!");
        } else {this.age = age;}
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setHeight(int height) throws HeightOutOfRangeException {
        if (height < 0) {
            throw new HeightOutOfRangeException("Рост не может быть отрицательным");
        } else if (height > 210) {
            throw new HeightOutOfRangeException("Слишком высокий рост!");
        } else {this.height = height;}
    }

    @Override
    public boolean getСonsciousness() {
        return inConscious;
    }
    @Override
    public void setWeight(double weight) throws WeightOutOfRangeException {
        if (weight < 0) {
            throw new WeightOutOfRangeException("Вес не может быть отрицательным!");
        } else if (weight > 200) {
            throw new WeightOutOfRangeException("Слишком большой вес!");
        } else {this.weight = weight;}
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

    @Override
    public int hashCode() {
        int nameCode = 0, weightCode = 0, heightCode = 0, ageCode = 0;
        String strNameCode;

        if (name != null) {
            strNameCode = String.valueOf(name.hashCode());
            char[] charsNameCode = strNameCode.toCharArray();
            if (charsNameCode.length >= 6) {
                strNameCode = String.valueOf(charsNameCode[1]) + String.valueOf(charsNameCode[2]) + String.valueOf(charsNameCode[3]) + String.valueOf(charsNameCode[4]) + String.valueOf(charsNameCode[5]);
                nameCode = Integer.parseInt(strNameCode);
            } else {
                nameCode = name.hashCode();
            }
        }

        String strWeight = String.valueOf(weight);
        String[] splited = strWeight.split("\\.");
        String strResult = splited[0] + splited[1];
        if (splited[1].equals("0")) {
            strResult = splited[0];
        }
        weightCode = Integer.parseInt(strResult);
        if (weightCode != weight) {
            weightCode *= -1;
        }

        heightCode = height;
        ageCode = age;
        return Integer.parseInt(String.valueOf(nameCode) + String.valueOf(heightCode + ageCode + weightCode * 123));
    }
}

