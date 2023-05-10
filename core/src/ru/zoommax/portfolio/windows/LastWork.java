package ru.zoommax.portfolio.windows;

import com.badlogic.gdx.graphics.Texture;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.utils.GS;

import java.util.ArrayList;

public class LastWork extends VisWindow {
    public LastWork(String title) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        VisTable window = new VisTable();

        VisTable cdekLogo = new VisTable();
        VisTable cdekInfo = new VisTable();
        VisImage logo = new VisImage(new Texture(GS.getCdekLogo()));
        VisLabel name = new VisLabel("ООО \"СДЭК-ГЛОБАЛ\"    ");
        cdekInfo.add(name);
        LinkLabel url = new LinkLabel("https://www.cdek.ru/");
        cdekInfo.add(url).row();
        cdekInfo.add(new VisLabel("Локальное подразделение:    "));
        cdekInfo.add(new VisLabel("ООО \"РОСТОВСКАЯ И ПАРТНЕРЫ\"")).row();
        cdekInfo.add(new VisLabel("Должность: "));
        cdekInfo.add(new VisLabel("системный администратор"));
        cdekInfo.add(new VisLabel("+7 (916) 686-53-03")).row();
        cdekLogo.add(logo);
        cdekLogo.add(new VisLabel("  "));
        cdekLogo.add(cdekInfo).row();

        VisTable job = new VisTable();
        job.add(new VisLabel("Должностные обязанности ")).growX();
        job.addSeparator(true);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Сборка, ремонт и обслуживание ПК");
        strings.add("Обслуживание и ремонт периферийного оборудования");
        strings.add("Установка, настройка, обслуживание ОС");
        strings.add("Настройка и обслуживание системы видеонаблюдения");
        strings.add("Настройка и обслуживание локальной сети и VPN");
        strings.add("Техническая поддержка сотрудников");

        VisTable table = new VisTable();
        for (String s : strings){
            table.add(new VisLabel(s)).growX().row();
        }
        VisScrollPane scrollPaneTable = new VisScrollPane(table);
        scrollPaneTable.setFlickScroll(false);
        scrollPaneTable.setFadeScrollBars(false);
        job.add(scrollPaneTable).row();


        window.add(cdekLogo).growX().row();
        window.add(new VisLabel()).row();
        window.addSeparator().growX().row();
        window.addSeparator().growX().row();
        window.add(job).growX().row();
        window.addSeparator();


        VisScrollPane scrollPane = new VisScrollPane(window);
        scrollPane.setFlickScroll(false);
        scrollPane.setFadeScrollBars(false);

        add(scrollPane).growX().row();
    }
}
