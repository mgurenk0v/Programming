package Classes;

public class Stove implements StoveMethods {
    protected boolean isStanding = true;
    private boolean isBurning = true;

    private double weight;
    public Stove() {}

    public Stove(double weight) {
        this.weight = weight;
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
    @Override
    public void chokeFire() {
        if (isBurning == true) {
            isBurning = false;
            System.out.println("Печка потухла");
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
                System.out.println("Из печки повалил пар.");
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
    public void setWeight(double weight) {
        this.weight = weight;
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
}
