package classes;

import classes.exceptions.unchecked.WeightOutOfRangeException;
import classes.interfaces.StoveMethods;

public class Stove implements StoveMethods {
    protected boolean isStanding = true;
    private boolean isBurning = true;

    private double weight;
    public Stove() {}

    public Stove(double weight) throws WeightOutOfRangeException {
        if (weight < 0) {
            throw new WeightOutOfRangeException("Вес не может быть отрицательным!");
        } else if (weight > 500) {
            throw new WeightOutOfRangeException("Слишком большой вес!");
        } else {this.weight = weight;}
    }
    @Override
    public void raiseBy(Shortee...shortees) {
        double sumWeight = 0;
        if (shortees.length > 1) {
            for (int i = 0; i < shortees.length; i++) {
                sumWeight += shortees[i].getWeight();
            }

            if (getStatus() == false) {
                if (sumWeight >= getWeight()) {
                    isStanding = true;
                    for (int i = 0; i < shortees.length; i++) {
                        if (i != (shortees.length - 1)) {
                            System.out.print(shortees[i].getName() + ", ");
                        } else {
                            System.out.print(shortees[i].getName() + " ");
                        }
                    }
                    System.out.print("подняли печку.");
                    System.out.println("");
                } else {
                    System.out.print("У ");
                    for (int i = 0; i < shortees.length; i++) {
                        if (i != (shortees.length - 1)) {
                            System.out.print(shortees[i].getName() + ", ");
                        } else {
                            System.out.print(shortees[i].getName() + " ");
                        }

                    }
                    System.out.print("не хватает сил, чтобы поднять печку.");
                    System.out.println("");
                }
            }
        } else {
            System.out.println("Используйте метод из класса Shortee");
        }

    }
    @Override
    public void dropBy(Shortee...shortees) {
        double sumWeight = 0;
        if (shortees.length > 1) {
            for (int i = 0; i < shortees.length; i++) {
                sumWeight += shortees[i].getWeight();
            }

            if (getStatus() == true) {
                if (sumWeight >= getWeight()) {
                    isStanding = false;
                    for (int i = 0; i < shortees.length; i++) {
                        if (i != (shortees.length - 1)) {
                            System.out.print(shortees[i].getName() + ", ");
                        } else {
                            System.out.print(shortees[i].getName() + " ");
                        }
                    }
                    System.out.print("уронили печку.");
                    System.out.println("");
                } else {
                    System.out.print("У ");
                    for (int i = 0; i < shortees.length; i++) {
                        if (i != (shortees.length - 1)) {
                            System.out.print(shortees[i].getName() + ", ");
                        } else {
                            System.out.print(shortees[i].getName() + " ");
                        }

                    }
                    System.out.print("не хватает сил, чтобы уронить печку.");
                    System.out.println("");
                }
            }
        } else {
            System.out.println("Используйте метод из класса Shortee");
        }

    }

    class Steam { // нестатический вложенный класс
        Steam(){}
        public void go() {
            if (isBurning == false) {
                System.out.println("Из печки повалил пар.");
            } else {
                System.out.println("Пар ниоткуда не повалил, печь горит.");
            }
        }
    }
    Steam steam = new Steam();
    @Override
    public void chokeFire() {
        if (isBurning == true) {
            isBurning = false;
            System.out.println("Печка потухла");
            steam.go();
        } else {
            System.out.println("Печь как не горела, так и не горит");
        }
    }
    @Override
    public void chokeFire(Shortee shortee) {
        if (isBurning == true) {
            if (shortee.hasWater == true) {
                isBurning = false;
                shortee.hasWater = false;
                System.out.println(shortee.getName() + " потушил печку.");
                steam.go();
            } else {
                System.out.println(shortee.getName() + " не может потушить печку, нужна вода.");
            }
        } else {
            System.out.println("Нельзя потушить печь, которая не горит.");
        }
    }
    @Override
    public void setFire(Shortee shortee) {
        if (isBurning == false) {
            if (shortee.hasFire == true) {
                isBurning = true;
                System.out.println(shortee.getName() + " зажег печку.");
            } else {
                System.out.println(shortee.getName() + " не может зажечь печку, нужен огонь.");
            }
        } else {
            System.out.println("Печь уже и так горит.");
        }
    }
    @Override
    public boolean getBurningStatus() {
        return isBurning;
    }
    @Override
    public boolean getStatus() {
        return isStanding;
    }
    @Override
    public void setWeight(double weight) throws WeightOutOfRangeException {
        if (weight < 0) {
            throw new WeightOutOfRangeException("Вес не может быть отрицательным!");
        } else if (weight > 500) {
            throw new WeightOutOfRangeException("Слишком большой вес!");
        } else {this.weight = weight;}
    }
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String strWeight;
        String strIsBurning;
        String strIsStanding;
        if (getWeight() == 0) {
            strWeight = "*вес не указан*";
        } else {strWeight = Double.toString(getWeight());}

        if (isBurning == true) {
            strIsBurning = "горит";
        } else {
            strIsBurning = "не горит";
        }

        if (isStanding == true) {
            strIsStanding = "стоит как надо";
        } else {
            strIsStanding = "лежит на боку";
        }

        return "INFO: " + "\n" + "Вес: " + strWeight + "\n" + "Статус: " + strIsBurning + "\n" + "Положение: " + strIsStanding;
    }

    @Override
    public boolean equals(Object ob) {
        Stove stove = (Stove) ob;
        if (this == stove){return true;}
        if ((getWeight() == stove.getWeight()) && (getStatus() == stove.getStatus()) && (getBurningStatus() == stove.getBurningStatus())) {
            return true;
        } else {return false;}
    }

    @Override
    public int hashCode() {
        int statusCode = 0, weightCode = 0, burningStatusCode = 0;

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

        if (isStanding == true) {
            statusCode = 1 * 23;
        } else {
            statusCode = 22;
        }

        if (isBurning == true) {
            burningStatusCode = 1 * 74;
        } else {
            burningStatusCode = 94;
        }

        return Integer.parseInt(String.valueOf(statusCode) + String.valueOf(weightCode) + String.valueOf(burningStatusCode));
    }
}
