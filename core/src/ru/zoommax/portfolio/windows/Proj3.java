package ru.zoommax.portfolio.windows;

import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.utils.GS;

public class Proj3 extends VisWindow {
    public Proj3(String title) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        VisTable window = new VisTable();

        VisTable passport = new VisTable();
        passport.addSeparator();
        passport.add(new VisLabel("Языки:")).growX().row();
        passport.add(new VisLabel("Java 7+")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Библиотеки и API:")).growX().row();
        passport.add(new VisLabel("Telegram API")).row();
        passport.add(new VisLabel("Discord API")).row();
        passport.add(new VisLabel("QIWI API")).row();
        passport.add(new VisLabel("LuckPerms lib & API")).row();
        passport.add(new VisLabel("ejCore lib & API")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Видео:")).growX().row();
        passport.add(new LinkLabel("ZooMMaX Autodonate plugin", "https://youtu.be/a3QufyMMhy4")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Ссылки на GitHub проекты:")).growX().row();
        passport.add(new LinkLabel("As Second Life studio GitHub", "https://github.com/asl-std")).row();
        passport.add(new LinkLabel("ejCore GitHub", "https://github.com/asl-std/ejCore")).row();
        passport.add(new LinkLabel("ZooMMaX Autodonate plugin подробное описание на GitHub", "https://github.com/ZooMMaX/ZooMMaX-Autodonate-plugin")).row();
        passport.addSeparator();


        VisTextArea textArea = new VisTextArea(GS.getProj3Text());
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
