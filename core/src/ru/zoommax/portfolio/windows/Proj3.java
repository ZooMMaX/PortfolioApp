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


        GS.setProj3Text("As Second Life studio - студия разработки плагинов для minecraft серверов.\n\n" +
                "Роль: Java разработчик.\n" +
                "За время участия в этом проекте мною были разработаны различные плагины.\n" +
                "Вот некоторые из них:\n" +
                "   - ZooMMaX-Autodonate - это плагин реализующий игровой магазин через Telegram бота с автоматической выдачей покупок. " +
                "В ПО задействованы API Telegram, QIWI, Spigot.\n" +
                "   - DiscordAuthModule - это плагин реализующий:\n" +
                "       - регистрацию на игровом сервере с проверкой сервера Discord на факт вступления аккаунта пользователя в соответствующий Discord сервер;\n" +
                "       - авторизацию на игровом сервере с проверкой как и при регистрации, а так же запросом разрешения на авторизацию в личных сообщениях Discord;\n" +
                "       - выдачу прав в игре согласно правам участника сервера в Discord.\n" +
                "В ПО задействованы API Spigot, Discord, ejCore (собственная разработка студии), LuckPerms (сторонний плагин управления правами на игровом сервере).\n" +
                "   - ejCore - это библиотека созданная для упрощения разработки плагинов для Minecraft, а так же для создания единой экосистемы для плагинов выпускаемых студией.\n" +
                "Дополнительно мной разрабатывались две системы лицензирования для плагинов. Одна система была с локальной проверкой лицензии, а во второй для проверки задействован сервер лицензий.");


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
