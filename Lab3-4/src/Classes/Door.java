package Classes;

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
    public void lock(Shortee shortee) {
        if (shortee.getСonsciousness() == true){
            if (shortee.profession == Profession.POLICEMAN) {
                if (isOpen == false) {
                    if (isLocked == false) {
                        isLocked = true;
                        System.out.println(shortee.getName() + " закрыл дверь на ключ. Ключ в замке зазвенел.");
                    } else {
                        System.out.println("Дверь уже закрыта");
                    }
                } else {
                    System.out.println("Чтобы закрыть дверь на ключ, необходимо сначала её просто закрыть.");
                }
            } else {
                System.out.println("Дверь могут запереть только полицейские.");
            }
        }
    }

    public void unLock(Shortee shortee) {
        if (shortee.getСonsciousness() == true) {
            if (shortee.profession == Profession.POLICEMAN) {
                if (isLocked == true) {
                    isLocked = false;
                    System.out.println(shortee.getName() + " открыл дверь ключом.");
                } else {
                    System.out.println("Дверь уже открыта");
                }
            } else {
                System.out.println("Дверь могут отпереть только полицейские.");
            }
        }
    }
}
