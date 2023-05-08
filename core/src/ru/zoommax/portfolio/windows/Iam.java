package ru.zoommax.portfolio.windows;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;
import ru.zoommax.portfolio.Main;
import ru.zoommax.portfolio.utils.GS;
import ru.zoommax.portfolio.utils.position.Percent;
import ru.zoommax.portfolio.utils.position.SIDE;

public class Iam extends VisWindow {

    VisImage avatar;
    public Iam(String title, final VisImage avatar) {
        super(title);
        closeOnEscape();
        addCloseButton();
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();
        this.avatar = avatar;

        VisTable window = new VisTable();
        VisTable buttons = new VisTable();

        String text = GS.getIamText();
        VisTextArea textArea = new VisTextArea(text);
        textArea.setPrefRows(text.split("\n").length);
        textArea.setReadOnly(true);

        VisTextButton contacts = new VisTextButton("Контактная информация", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                VisWindow con = new VisWindow("Контактная информация");
                con.closeOnEscape();
                con.addCloseButton();

                VisTextField phone = new VisTextField("+79990950742");
                phone.setReadOnly(true);
                VisTextField email = new VisTextField("zoommax2009@gmail.com");
                email.setReadOnly(true);

                con.add(new VisLabel("Телефон: "));
                con.add(phone).growX().row();
                con.add(new VisLabel("Email: "));
                con.add(email).growX().row();
                con.add(new VisLabel("GitHub"));
                con.add(new LinkLabel("ZooMMaX", "https://github.com/ZooMMaX")).growX().row();


                Percent.size(con, 15, 20);
                Percent.pos(con, SIDE.LEFTofRIGHT, avatar, 0,0);
                Main.stage.addActor(con);
            }
        });

        VisTextButton lastWork = new VisTextButton("Последнее место работы", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                VisWindow lastWorkWin = new LastWork("Последнее место работы");
                Percent.size(lastWorkWin, 50,50);
                Percent.pos(lastWorkWin, SIDE.PARENTCENTER, null, 0,0);
                Main.stage.addActor(lastWorkWin);
            }
        });



        window.add(textArea).growX().row();
        buttons.add(contacts).growX();
        buttons.addSeparator(true);
        buttons.add(lastWork).growX().row();
        window.add(new VisLabel()).row();
        window.add(buttons).growX().row();

        VisScrollPane scrollPane = new VisScrollPane(window);
        scrollPane.setFlickScroll(false);
        scrollPane.setFadeScrollBars(false);

        add(scrollPane).growX().row();
    }

    @Override
    public void close(){
        avatar.remove();
        super.close();
    }
}
