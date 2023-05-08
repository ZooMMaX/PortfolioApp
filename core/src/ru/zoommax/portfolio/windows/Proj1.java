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


        GS.setProj1Text("ПО требует выполнить вход в аккаунт сотрудника компании СДЭК.\n\n" +
                "Далее требуется поместить графические файлы накладных во внутреннюю директорию программы. В программе имеется кнопка, нажатие на которую предоставляет бустрый доступ к внутренней директории.\n\n" +
                "После запуска обработки данных программа выполняет следующие шаги:\n" +
                "   - обработка графических файлов с помощью библиотеки ZBar;\n" +
                "   - обнаружение ШК в графическом файле;\n" +
                "   - распознание ШК и получение номера накладной;\n" +
                "   - по номеру накладной из сети подгружаются данные по накладной;\n" +
                "   - производится автоматическое определение признака \"груз отправлен\" или \"груз выдан\";\n" +
                "   - если признак \"груз выдан\", то графический файл подгружается в общую БД накладных, а графический файл, при условии отсутствия ошибок, удаляется с диска;\n" +
                "   - если признак \"груз отправлен\", то, при условии отсутствия ошибок, происходит удаление графического файла;\n" +
                "   - независимо от признака по всем полученным данным из накладных производится проверка на факт незавершенных действий, если таковые имеются, " +
                "то накладная добавляется в массив ошибок с присвоением описания ошибки;\n" +
                "   - в некоторых случаях библиотека ZBar не может найти или распознать ШК накладной, такие накладные добавляеются в массив ошибок с присвоением описания ошибки;\n" +
                "   - после отработки основной логики приложения появляется возможность вывести на экран окно ручной обработки с накладными при работе с которыми возникли ошибки.\n\n" +
                "В данной программе была реализована система лицензирования ПО с локальной проверкой лицензии. Лицензия привязывается к MAC-адресу ПК. В системе лицензирования используется ассиметричное шифрование.");


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
