package Classes;

public abstract class RoomStatus {
    private static boolean isNoisy = true;
    private static boolean isClean = false;
    private static boolean isCleanAir = true;
    private static boolean isWarm = true;
    public static void steam() {
        if (isCleanAir == true) {
            isCleanAir = false;
            System.out.println("Помещение наполнилось паром.");
        } else {
            System.out.println("Воздух в помещении грязный.");
        }
    }

    public static void quiet() {
        if (isNoisy == true) {
            isNoisy = false;
            System.out.println("В помещении стало тихо.");
        } else {
            System.out.println("В помещении тихо.");
        }
    }

    public static void clean() {
        if (isClean == false) {
            isClean = true;
            System.out.println("В помещении начали убираться.");
        } else {
            System.out.println("В помещении убрано.");
        }
    }

    public static void warm() {
        if (isWarm == false) {
            isWarm = true;
            System.out.println("В помещении стало тепло.");
        } else {
            System.out.println("В помещении тепло.");
        }
    }
    public static void cold() {
        if (isWarm == true) {
            isWarm = false;
            System.out.println("В помещении стало холодно.");
        } else {
            System.out.println("В помещении холодно.");
        }
    }
}
