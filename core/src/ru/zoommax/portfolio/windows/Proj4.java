package ru.zoommax.portfolio.windows;

import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.utils.GS;

public class Proj4 extends VisWindow {
    public Proj4(String title) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        VisTable window = new VisTable();

        VisTable passport = new VisTable();
        passport.addSeparator();
        passport.add(new VisLabel("Языки:")).growX().row();
        passport.add(new VisLabel("Java 8+")).row();
        passport.addSeparator();


        VisTextArea textArea = new VisTextArea(GS.getProj4Text());
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
