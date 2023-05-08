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



        GS.setProj4Text("Проприетарный проект реализующий систему учета рабочего времени и пропускного конторля.\n" +
                "Мои задачи в проекте были:\n" +
                "   - создать клиент-серверное решение для программирования пропусков;\n" +
                "   - написать клиентское приложение под Андроид:\n" +
                "       - чтение данных с NFC карт;\n" +
                "       - запись данных на NFC карты;\n" +
                "       - написать UI для добавления, удаления и изменения данных на пропусках (NFC картах);\n" +
                "       - написать UI для получения информации о рабочем времени сотрудников;\n" +
                "       - создать функционал для подключения приложения к серверному ПО.\n" +
                "   - написать серверное ПО:\n" +
                "       - работа с БД MySQL и MongoDB;\n" +
                "       - создать методы сохранения, изменения, удаления, шифрования данных;\n" +
                "       - написать WEB API.\n" +
                "   - установка сервера;\n" +
                "   - настройка сервера;\n" +
                "   - настройка сети;\n" +
                "   - настройка внутреннего DNS;\n" +
                "   - настройка ssl сертификатов;\n" +
                "   - настройка Apache Web Server в качестве программного прокси.\n" +
                "В целом суть андроид приложения была в том, чтобы дать начальникам отделов возможность самостоятельно настраивать пропуска, а так же получать оперативную информацию о времени прихода, ухода сотрудников." +
                " Необходимость делать данную систему клиент-серверной заключалась в том, что разные отделы компании физически находились в разных местах.");


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
