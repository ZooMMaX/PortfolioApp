package ru.zoommax.portfolio.windows;

import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.utils.GS;

public class Proj2 extends VisWindow {
    public Proj2(String title) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        VisTable window = new VisTable();

        VisTable passport = new VisTable();
        passport.addSeparator();
        passport.add(new VisLabel("Языки:")).growX().row();
        passport.add(new VisLabel("Kotlin")).row();
        passport.add(new VisLabel("JavaScript")).row();
        passport.add(new VisLabel("Java 8")).row();
        passport.add(new VisLabel("Bash")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Видео:")).growX().row();
        passport.add(new LinkLabel("Презентация", "https://youtu.be/-sbv8skaRpU")).row();
        passport.addSeparator();
        passport.add(new VisLabel("Приложение")).growX().row();
        passport.add(new LinkLabel("Google Play", "https://play.google.com/store/apps/details?id=app.greywebs.vpn")).row();
        passport.addSeparator();


        GS.setProj2Text("VPN для мобильных устройств на базе IOS и Android.\n\n" +
                "Роль: менеджера проекта.\n" +
                "В мои обязанности входит:\n" +
                "   - создание ТЗ для аутсорсных программистов;\n" +
                "   - описание процессов взаимодействия;\n" +
                "   - руководство и курирование процессов производства;\n" +
                "   - подбор и тестирование серверов для VPN;\n" +
                "   - настройка и поддержка DNS серверов.");


        VisTextArea textArea = new VisTextArea(GS.getProj2Text());
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
