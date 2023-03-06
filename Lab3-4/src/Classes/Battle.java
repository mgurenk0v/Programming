package Classes;

public abstract class Battle {
    private static Shortee[] battleParticipantsT1;
    private static Shortee[] battleParticipantsT2;
    public static Team winnerTeam;
    public static void start(Stove stove, Shortee...shortees) {

        int inTeam1 = 0;
        int inTeam2 = 0;
        for (int i = 0; i < shortees.length; i++) {
            if (shortees[i].getTeam() == Team.TEAM1) {
                inTeam1 ++;
            } else {
                inTeam2 ++;
            }
        }

        battleParticipantsT1 = new Shortee[inTeam1];
        battleParticipantsT2 = new Shortee[inTeam2];

        int j1 = 0;
        int j2 = 0;
        for (int i = 0; i < shortees.length; i++) {
            if (shortees[i].getTeam() == Team.TEAM1) {
                battleParticipantsT1[j1] = shortees[i];
                j1 ++;
            } else {
                battleParticipantsT2[j2] = shortees[i];
                j2 ++;
            }
        }

        while (true) {

            Team whichTeamLeft = null;
            int inTeam = 0;
            int inCons = 0;

            for (int i = 0; i < shortees.length; i++) {    //перебираем каждого участника битвы и вызываем метод attack у каждого из них с рандомным (среди всех участников битвы) аргументом
                int j = i;
                while (j == i) {    // не допускаем атаку на самого себя
                    j = (int) Math.round(Math.random() * (shortees.length - 1));
                    if ((shortees[j].getСonsciousness() == false) | (shortees[i].getTeam() == shortees[j].getTeam())) { // не допускаем атаку на потерявшего сознание и на члена своей "команды"
                        j = i;
                    }
                }
                shortees[i].attack(shortees[j]);

                if (shortees[j].getСonsciousness() == false) {
                    if ((stove.getStatus() == true) && (shortees[j].getWeight() >= stove.getWeight())) {  //тот, кто отключился, роняет печку (типа падает на неё), если вес потерявшего сознания достаточен
                        shortees[j].dropTheStove(stove);
                    }
                    for (int i3 = 0; i3 < shortees.length; i3++) {
                        if ((shortees[i3].getTeam() == shortees[i].getTeam()) && (shortees[i3].getСonsciousness() == true) && (shortees[i3] != shortees[i])) {
                            System.out.println(shortees[i3].say("Молодец, так его!", shortees[i]));
                            break;
                        }
                    }
                }

                if (shortees[j].getСonsciousness() == false) {
                    for (int i3 = 0; i3 < shortees.length; i3++) {
                        if ((shortees[i3].getTeam() != shortees[i].getTeam()) && (shortees[i3].getСonsciousness() == true) && (shortees[i3] != shortees[i])) {
                            System.out.println(shortees[i3].say("Держись, я за тебя отомщу!", shortees[j]));
                            System.out.println(shortees[j].say("zrdgvzb"));
                            break;
                        }
                    }
                }

                if (shortees[j].getСonsciousness() == false) {          //после атаки делаем проверку: если после атаки кто-либо отключился, то смотрим кто всё ещё
                    whichTeamLeft = null;                               //учавствует в битве: если все участники являются одной командой, то битва заканчивается.
                    inTeam = 0;
                    inCons = 0;
                    for (int i2 = 0; i2 < shortees.length; i2++) {
                        if (shortees[i2].getСonsciousness() == true) {
                            inCons ++;
                            if (whichTeamLeft == null) {
                                whichTeamLeft = shortees[i2].getTeam();
                                inTeam ++;
                            } else {
                                if (whichTeamLeft == shortees[i2].getTeam()) {
                                    inTeam ++;
                                }
                            }
                        }
                    }

                    if (inTeam == inCons) {break;}
                }
            }


            if ((inTeam == inCons) && (inCons != 0)) {
                winnerTeam = whichTeamLeft;
                break;
            }
        }
    }

    public static Shortee[] getBattleParticipants(Team team) {
        if (team == Team.TEAM1) {
            return battleParticipantsT1;
        } else {
            return battleParticipantsT2;
        }
    }
}
