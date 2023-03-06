package Classes;

public class Shortee extends Creature {

    protected Profession profession;
    private final int numberOfHits = 3;
    private Team team;
    protected boolean hasWater = false;
    protected boolean hasFire = false;
    private boolean onTheShelf = false;

    public Shortee() {}
    public Shortee(String name, int age, int height) {super(name, age, height);}
    public void group() {
        if (getСonsciousness() == true) {
            if (profession == Profession.POLICEMAN) {
                System.out.println(super.getName() + " встал на свое место в шеренге.");
            } else {
                System.out.println(super.getName() + " присоединился к собирающейся толпе.");
            }
        }
    }

    public void attack(Creature opponent) {
        if (getСonsciousness() == true) {
            if (profession == Profession.POLICEMAN) {
                for (int i = 0; i < numberOfHits; i++) {
                    System.out.println(super.getName() + " ударил дубинкой " + opponent.getName());
                }
                if (Math.random() <= 0.5) {
                    opponent.loseConsciousness();
                }
            } else if (profession == Profession.PRISONER) {
                for (int i = 0; i < (numberOfHits - 1); i++) {
                    System.out.println(super.getName() + " ударил заточкой " + opponent.getName());
                }
                if (Math.random() <= 0.5) {
                    opponent.loseConsciousness();
                }
            } else {
                System.out.println(super.getName() + " ударил " + opponent.getName());
                if (Math.random() <= 0.3) {
                    opponent.loseConsciousness();
                }
            }
        }
    }

    public void hide() {
        if ((getСonsciousness() == true)&&(onTheShelf == false)) {
            onTheShelf = true;
            System.out.println(getName() + " спрятался под полку.");
        }
    }

    public void unHide() {
        if ((getСonsciousness() == true)&&(onTheShelf == true)) {
            onTheShelf = false;
            System.out.println(getName() + " Вылез из-под полки.");
        }
    }

    public void climb() {
        if ((getСonsciousness() == true)&&(onTheShelf == false)) {
            onTheShelf = true;
            System.out.println(getName() + " залез на полку.");
        }
    }

    public void getOff() {
        if ((getСonsciousness() == true)&&(onTheShelf == true)) {
            onTheShelf = false;
            System.out.println(getName() + " слез с полки.");
        }
    }
    public void dropTheStove(Stove stove) {
        if (stove.getStatus() == true) { //нет проверки на наличие сознания так как можно уронить печку, теряя сознание в это время
            if (getWeight() >= stove.getWeight()) { //коротышка не может ронять и поднимать вещи тяжелее своего веса
                stove.isStanding = false;
                System.out.println(getName() + " уронил печку.");
            } else {
                System.out.println("У " + getName() + " не хватает сил, чтобы уронить печку.");
            }
        }
    }
    public void raiseTheStove(Stove stove) {
        if (getСonsciousness() == true) {
            if (stove.getStatus() == false) {
                if (getWeight() >= stove.getWeight()) {
                    stove.isStanding = true;
                    System.out.println(getName() + " поднял печку.");
                } else {
                    System.out.println("У " + getName() + " не хватает сил, чтобы поднять печку.");
                }
            }
        }
    }

    public void findStaff() {
        if (getСonsciousness() == true) {
            System.out.println(getName() + " начал искать свои вещи.");
        }
    }

    public void foundStaff(Staff staff) {
        if (staff == Staff.STAFF) {
            System.out.println(getName() + " нашёл свои вещи.");
        } else {
            System.out.println(getName() + " не может найти " + staff);
        }
    }

    public void whoIsInConsious(Shortee...shortees) {
        if (getСonsciousness() == true) {
            int whoIsInConsious = 0;
            for (int i = 0; i < shortees.length; i++) {
                if (shortees[i].getСonsciousness() == true) {
                    whoIsInConsious ++;
                }
            }
            if (whoIsInConsious != 0) {
                System.out.println(getName() + " заметил, что в сознании находятся " + whoIsInConsious + " коротышек.");
            } else {System.out.println(getName() + " убедился, что все коротышки находятся без сознания.");}
        }
    }
    public void getWater() {
        if (getСonsciousness() == true) {
            if (hasWater == false) {
                hasWater = true;
                System.out.println(getName() + " набрал воды из-под крана");
            } else {
                System.out.println(getName() + " уже набрал воды, больше стаканов у него нет.");
            }
        }
    }
    public void getFire() {
        if (getСonsciousness() == true) {
            if (hasFire == false) {
                hasFire = true;
                System.out.println(getName() + " нашёл зажигалку.");
            } else {System.out.println("У " + getName() + " уже есть зажигалка.");}
        }
    }
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Team getTeam() { return team; }

}
