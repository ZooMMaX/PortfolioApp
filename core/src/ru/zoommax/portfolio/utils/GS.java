package ru.zoommax.portfolio.utils;

import com.badlogic.gdx.graphics.Pixmap;
import lombok.Getter;
import lombok.Setter;

public class GS {

    @Getter
    @Setter
    private static boolean testIn = false;
    @Getter
    private static boolean[] loadPhoto = {false,false};
    public static void setLoadPhoto1(boolean load){
        loadPhoto[0] = load;
    }
    public static void setLoadPhoto2(boolean load){
        loadPhoto[1] = load;
    }

    @Getter
    private static boolean[] loadIam = {false, false};
    public static void setLoadIam1(boolean load){
        loadIam[0] = load;
    }
    public static void setLoadIam2(boolean load){
        loadIam[1] = load;
    }
    @Getter
    @Setter
    private static boolean loadP1 = false;
    @Getter
    @Setter
    private static boolean loadP2 = false;
    @Getter
    @Setter
    private static boolean loadP3 = false;
    @Getter
    @Setter
    private static boolean loadP4 = false;

    @Getter
    @Setter
    private static Thread loading;

    @Getter
    @Setter
    private static boolean load = true;

    @Getter
    @Setter
    private static Pixmap avatar, cdekLogo;

    @Getter
    @Setter
    private static String proj1Text;

    @Getter
    @Setter
    private static String proj2Text;

    @Getter
    @Setter
    private static String proj3Text;

    @Getter
    @Setter
    private static String proj4Text;

    @Getter
    @Setter
    private static String iamText;

    @Getter
    @Setter
    private static byte[] pdf;

    @Getter
    @Setter
    private static String error;

    @Getter
    @Setter
    private static boolean err = false;
}
