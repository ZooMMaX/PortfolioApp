package ru.zoommax.portfolio.windows;

import com.kotcrab.vis.ui.widget.VisTextArea;
import com.kotcrab.vis.ui.widget.VisWindow;
import ru.zoommax.portfolio.utils.GS;

public class Error extends VisWindow {

    public Error() {
        super("Ошибка");
        addCloseButton();
        closeOnEscape();

        String text = GS.getError();
        if (text.equals("err!200")){
            text = "Проверьте доступ к сети интернет";
        }
        VisTextArea err = new VisTextArea(text);
        err.setReadOnly(true);
        add(err).growY().growX().row();
    }
}
