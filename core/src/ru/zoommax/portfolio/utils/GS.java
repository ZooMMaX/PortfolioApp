package ru.zoommax.portfolio.utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.kotcrab.vis.ui.widget.VisImage;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;

public class GS {

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
    private static String proj1Text, proj2Text, proj3Text, proj4Text, iamText;

    @Getter
    @Setter
    private static byte[] pdf;
}
