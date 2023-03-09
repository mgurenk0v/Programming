import classes.*;
import classes.abstracts.Battle;
import classes.abstracts.RoomStatus;
import classes.enums.*;
import classes.exceptions.checked.NoPermissionException;

public class Main {
    public static void message(String string) {
        System.out.println("");
        System.out.println("*" + string.toUpperCase() + "*");
        System.out.println("");
    }
    public static void main(String[] args) {


        Lunatic lunatic = new Lunatic("Козлик", 13, 151);
        Stove stove = new Stove(100); // Создаем печь
        Door door = new Door();
        Shortee shortee1 = new Shortee("Незнайка", 14, 140);
        Shortee shortee2 = new Shortee("Стрига", 15, 140);
        shortee1.setProfession(Profession.UNEMPLOYED);  //Профессии влияют только на атаки, поэтому тем, кто не участвует в битве, профессии не присваиваем.
        shortee2.setProfession(Profession.UNEMPLOYED);
        Shortee shortee11 = new Shortee("КоротышкаТрусишка1", 16, 142);
        Shortee shortee12 = new Shortee("КоротышкаТрусишка2", 25, 139);
        Shortee shortee13 = new Shortee("КоротышкаТрусишка3", 23, 146);
        Shortee shortee14 = new Shortee("КоротышкаТрусишка4", 18, 143);
        shortee11.setWeight(50); //присваиваем им какой-то вес (но чтобы в сумме было >= 100), чтобы они позже смогли вместе поднять печку
        shortee12.setWeight(42);
        shortee13.setWeight(36);

        Shortee shortee3 = new Shortee("КоротышкаБоец1", 16, 141);
        Shortee shortee4 = new Shortee("КоротышкаБоец2", 21, 143);
        shortee3.setProfession(Profession.PRISONER);
        shortee4.setProfession(Profession.PRISONER);

        Shortee shortee7 = new Shortee("Дригль", 38, 141);
        Shortee shortee8 = new Shortee("Сигль", 48, 144);
        Shortee shortee9 = new Shortee("Жмигль", 39, 142);
        Shortee shortee10 = new Shortee("Пхигль", 42, 150);
        shortee7.setProfession(Profession.POLICEMAN);
        shortee8.setProfession(Profession.POLICEMAN);
        shortee9.setProfession(Profession.POLICEMAN);
        shortee10.setProfession(Profession.POLICEMAN);

        shortee1.setTeam(Team.TEAM1);
        shortee2.setTeam(Team.TEAM1);
        shortee3.setTeam(Team.TEAM1);
        shortee4.setTeam(Team.TEAM1);
        shortee3.setWeight(100); //пусть у этого коротышки будет достаточный вес, чтобы уронить печь (берем коротышку из этой команды так как она все равно проиграет)

        shortee7.setTeam(Team.TEAM2);
        shortee8.setTeam(Team.TEAM2);
        shortee9.setTeam(Team.TEAM2);
        shortee10.setTeam(Team.TEAM2);

        message("пугливые коротышки прячутся под полки");
        shortee11.hide();
        shortee12.hide();
        shortee13.hide();
        shortee14.hide();

        message("начинается драка между полицейскими и коротышками");

        int sch = 0;
        int sch2 = 0;
        boolean someoneNotInConsSch = false;
        while (true) {
            sch ++;
            System.out.println("");
            System.out.println(" РАУНД " + sch);

            if (sch != 1) { //выводим на экран информацию о тех, кто в отключке(58-79)
                for (int i = 0; i < Battle.getBattleParticipants(Team.TEAM1).length; i++) { // проверяем потерял ли хоть кто-нибудь созание из команды коротышек (59-64)
                    if ((Battle.getBattleParticipants(Team.TEAM1)[i].getСonsciousness() == false)) {
                        someoneNotInConsSch = true;
                        break;
                    }
                }
                if (someoneNotInConsSch = true) {
                    System.out.print("(Но ");
                    sch2 = 0;
                    for (int i = 0; i < Battle.getBattleParticipants(Team.TEAM1).length; i++) {
                        if ((Battle.getBattleParticipants(Team.TEAM1)[i].getСonsciousness() == false)) {
                            sch2 ++;
                            if (sch2 != 1) {
                                System.out.print(", ");
                            }
                            System.out.print(Battle.getBattleParticipants(Team.TEAM1)[i].getName());
                        }
                    }
                    System.out.println(" всё ещё в отключке)");
                }
            }

            System.out.println("");
            Battle.start(stove, shortee3, shortee7, shortee9, shortee4, shortee1, shortee8, shortee2, shortee10);  //битва между коротышками и полицейскими
            if (Battle.winnerTeam == Team.TEAM2) {
                break;
            } else {
                shortee7.wakeUp();
                if (shortee1.getСonsciousness() == true) {System.out.println(shortee1.say("О нет, что происходит?!"));}
                shortee8.wakeUp();
                shortee9.wakeUp();
                if ((shortee2.getСonsciousness() == true) && (shortee1.getСonsciousness() == true)) {System.out.println(shortee2.say("Кажется они приходят в себя...", shortee1));}
                shortee10.wakeUp();
                if (shortee3.getСonsciousness() == true) {System.out.println(shortee3.say("На позиции!!!"));}
            }
        }
        if (shortee7.getСonsciousness() == false) {
            shortee7.wakeUp();
            for (int i = 0; i < Battle.getBattleParticipants(Team.TEAM2).length; i++) {
                if ((Battle.getBattleParticipants(Team.TEAM2)[i].getСonsciousness() == true) && (Battle.getBattleParticipants(Team.TEAM2)[i] != shortee7)) {
                    System.out.println(Battle.getBattleParticipants(Team.TEAM2)[i].say("О, ты очнулся", shortee7));
                    break;
                }
            }
        }

        message("драка закончена");

        shortee8.wakeUp();
        shortee9.wakeUp();
        shortee10.wakeUp();

        shortee7.look("поле битвы");
        shortee7.whoIsInConsious(Battle.getBattleParticipants(Team.TEAM1));

        shortee7.getWater();
        stove.chokeFire(shortee7);
        RoomStatus.steam();
        RoomStatus.cold();

        System.out.println(shortee7.say("Ого, сколько тут пара!"));
        shortee8.laugh();
        shortee9.laugh();
        shortee10.laugh();

        message("насмеялись");

        for (Shortee i : Battle.getBattleParticipants(Team.TEAM2)) {
            i.group();
        }

        for (Shortee i : Battle.getBattleParticipants(Team.TEAM2)) {
            i.move(Direction.BACK_TO_HIS_PLACE);
        }

        door.close(shortee10);

        try {
            door.lock(shortee10);
        } catch (NoPermissionException e) {
            System.out.println(e.getMessage());
        }

        RoomStatus.quiet();

        message("те, кто спрятались в начале драки начали потихоньку вылезать из-под полок");

        shortee11.unHide();
        shortee12.unHide();
        shortee13.unHide();
        shortee14.unHide();

        message("коротышки, побитые полицейскими тоже начали приходить в себя и расползаться по своим местам");

        for (Shortee i : Battle.getBattleParticipants(Team.TEAM1)) {
            i.wakeUp();
            i.move(Direction.BACK_TO_HIS_PLACE);
        }

        message("коротышки отдыхают после драки");
        for (Shortee i : Battle.getBattleParticipants(Team.TEAM1)) {
            i.rest();
        }

        message("коротышки начали искать свои вещи");

        for (Shortee i : Battle.getBattleParticipants(Team.TEAM1)) {
            i.findStaff();
        }

        message("коротышки начали убираться");

        RoomStatus.clean();

        stove.raiseBy(shortee11, shortee12, shortee13);
        shortee12.getFire();
        stove.setFire(shortee12);
        RoomStatus.warm();

        message("Постепенно порядок был наведен, все вещи были разысканы. Только Стрига нигде не мог отыскать Незнайкину шляпу.");
        for (Shortee i : Battle.getBattleParticipants(Team.TEAM1)) {
            if (i != shortee2) {
                i.foundStaff(Staff.STAFF);
            } else {i.foundStaff(Staff.HAT);}
        }

        RoomStatus.clean();

        message("Они оба полезли на свои полки. К Незнайке подошел Козлик");

        shortee1.climb();
        shortee2.climb();
        lunatic.goTo(shortee1);

        message("конец");

        message("Переопределенный метод tostring для класса creature (а также lunatic и shortee)");
        System.out.println(shortee1.toString());
        System.out.println("");
        System.out.println(lunatic.toString());

        message("Переопределенный метод tostring для класса stove");
        System.out.println(stove.toString());

        message("Переопределенный метод tostring для класса door");
        System.out.println(door.toString());

        message("Переопределенный метод equals для класса creature (а также lunatic и shortee)");

        Shortee shortee_ = new Shortee("qqq", 123, 12);
        Shortee shortee__ = new Shortee("qqq", 123, 12);
        System.out.println(shortee__.equals(shortee_));
        shortee_.setName("www");
        System.out.println(shortee__.equals(shortee_));

        message("Переопределенный метод equals для класса door");
        Door door2 = new Door();
        System.out.println(door.equals(door2));
        door2.close(shortee7);

        try {
            door2.lock(shortee7);
        } catch (NoPermissionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(door.equals(door2));

        message("Переопределенный метод equals для класса stove");
        Stove stove2 = new Stove();
        System.out.println(stove.equals(stove2));
        stove2.setWeight(100);
        System.out.println(stove.equals(stove2));

        message("Переопределенный метод hashcode для класса creature (а также lunatic и shortee)");
        System.out.println(shortee__.hashCode());
        System.out.println(shortee_.hashCode());
        shortee_.setName("qqq");
        System.out.println(shortee_.hashCode());

        message("Переопределенный метод hashcode для класса stove");
        System.out.println(stove.hashCode());
        System.out.println(stove2.hashCode());
        stove2.setWeight(213);
        System.out.println(stove2.hashCode());

        message("Переопределенный метод hashcode для класса door");
        System.out.println(door.hashCode());
        System.out.println(door2.hashCode());

        try {
            door2.unLock(shortee7);
        } catch (NoPermissionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(door2.hashCode());
    }
}