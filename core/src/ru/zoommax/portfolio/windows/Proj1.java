package ru.zoommax.portfolio.windows;

import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.utils.GS;

public class Proj1 extends VisWindow {
    public Proj1(String title) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        VisTable window = new VisTable();

        VisTable passport = new VisTable();
        passport.addSeparator();
        passport.add(new VisLabel("Язык:")).growX().row();
        passport.add(new VisLabel("Java 11")).row();
        passport.add(new VisLabel("Библиотеки:")).growX().row();
        passport.add(new VisLabel("JavaFX 17")).row();
        passport.add(new VisLabel("ZBar bar code reader")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Видео:")).growX().row();
        passport.add(new LinkLabel("Установка", "https://youtu.be/sC4v_doHqOs")).row();
        passport.add(new LinkLabel("Вход в аккаунт и установка лицензии", "https://youtu.be/uvvtALo1myI")).row();
        passport.add(new LinkLabel("Процесс работы", "https://youtu.be/Ll0QRmtmrdI")).row();
        passport.addSeparator();

        VisTextArea textArea = new VisTextArea(GS.getProj1Text());
        textArea.setReadOnly(true);
        textArea.setPrefRows(textArea.getPrefHeight());


        window.add(passport).growX().row();
        window.add(new VisLabel()).growX().row();
        window.add(textArea).growX().row();

        VisScrollPane scrollPane = new VisScrollPane(window);
        scrollPane.setFlickScroll(false);
        scrollPane.setFadeScrollBars(false);

        add(scrollPane).growX().row();
    }
}
