package classes;

import classes.enums.Profession;
import classes.exceptions.checked.NoPermissionException;
public class Door {
    private boolean isOpen = true;
    private boolean isLocked = false;
    public void open(Shortee shortee) {
        if (shortee.getСonsciousness() == true) {
            if (isLocked == false) {
                if (isOpen == false) {
                    isOpen = true;
                    System.out.println(shortee.getName() + " открыл дверь.");
                }
            } else {
                System.out.println("Дверь закрыта на замок, её невозможно открыть этим методом.");
            }
        }
    }
    public void close(Shortee shortee) {
        if (shortee.getСonsciousness() == true) {
            if (isLocked == false) {
                if (isOpen == true) {
                    isOpen = false;
                    System.out.println(shortee.getName() + " закрыл дверь. Дверь хлопнула.");
                } else {
                    System.out.println("Дверь уже закрыта.");
                }
            }
        }
    }

    static class Key { // статический вложенный класс
        public Key(){}
        public void ring() {
            System.out.println("Ключ зазвенел.");
        }
    }
    Key key = new Key();
    public void lock(Shortee shortee) throws NoPermissionException {
        if (shortee.getСonsciousness() == true){
            if (shortee.profession == Profession.POLICEMAN) {
                if (isOpen == false) {
                    if (isLocked == false) {
                        isLocked = true;
                        System.out.println(shortee.getName() + " закрыл дверь на ключ.");
                        key.ring();
                    } else {
                        System.out.println("Дверь уже закрыта");
                    }
                } else {
                    System.out.println("Чтобы закрыть дверь на ключ, необходимо сначала её просто закрыть.");
                }
            } else {
                throw new NoPermissionException("Дверь могут запереть только полицейские!");
            }
        }
    }

    public void unLock(Shortee shortee) throws NoPermissionException {
        if (shortee.getСonsciousness() == true) {
            if (shortee.profession == Profession.POLICEMAN) {
                if (isLocked == true) {
                    isLocked = false;
                    key.ring();
                    System.out.println(shortee.getName() + " открыл дверь ключом.");
                } else {
                    System.out.println("Дверь уже открыта");
                }
            } else {
                throw new NoPermissionException("Дверь могут запереть только полицейские!");
            }
        }
    }

    public boolean getOpenStatus() {
        if (isOpen == true) {
            return true;
        } else {return false;}
    }

    public boolean getLockStatus() {
        if (isLocked == true) {
            return true;
        } else {return false;}
    }

    @Override
    public String toString() {
        String strOpen;
        String strLocked;
        if (getOpenStatus() == true) {
            strOpen = "Открыта";
        } else {strOpen = "Закрыта";}

        if (getLockStatus() == true) {
            strLocked = "Закрыта";
        } else {strLocked = "Не закрыта";}

        return "INFO: " + "\n" + "Открыта\\Закрыта: " + strOpen + "\n" + "Открыта\\Закрыта на ключ: " + strLocked;
    }

    @Override
    public boolean equals(Object ob) {
        Door door = (Door) ob;
        if (this == door){return true;}
        if ((getOpenStatus() == door.getOpenStatus()) && (getLockStatus() == door.getLockStatus())) {
            return true;
        } else {return false;}
    }

    @Override
    public int hashCode() {
        int lockedCode = 0, openCode = 0;

        if (isLocked == true) {
            lockedCode = 1 * 34;
        } else {
            lockedCode = 39;
        }

        if (isOpen== true) {
            openCode = 1 * 87;
        } else {
            openCode = 12;
        }

        return Integer.parseInt(String.valueOf(openCode) + String.valueOf(lockedCode));
    }
}
