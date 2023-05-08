package ru.zoommax.portfolio.utils.position;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Percent {
    public static void pos(Actor a, SIDE side, Actor b, float indentX, float indentY){
        float cuX = Gdx.graphics.getWidth()/100f;
        float cuY = Gdx.graphics.getHeight()/100f;

        float cuXA = a.getWidth()/cuX;
        float cuYA = a.getHeight()/cuY;


        float cuXB = 0f;
        float cuYB = 0f;
        float posBX = 0f;
        float posBY = 0f;
        if (b != null) {
            cuXB = b.getWidth() / cuX;
            cuYB = b.getHeight() / cuY;
            posBX = b.getX()/cuX;
            posBY = b.getY()/cuY;
        }

        float x = 0f;
        float y = 0f;
        if (side == SIDE.PARENTTOPLEFT){
            x = indentX;
            y = 100f-cuYA+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.PARENTBOTTOMLEFT){
            x = indentX;
            y = indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.PARENTBOTTOMRIGHT){
            x = 100f-cuXA+indentX;
            y = indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.PARENTTOPRIGHT){
            x = 100f-cuXA+indentX;
            y = 100f-cuYA+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.BOTTOMofTOP){
            x = posBX+indentX;
            y = posBY+cuYB+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.TOPofBOTTOM){
            x = posBX+indentX;
            y = posBY-cuYA+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.PARENTCENTER){
            x = 50f-cuXA/2+indentX;
            y = 50f-cuYA/2+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.RIGHTofLEFT){
            x = posBX-cuXA+indentX;
            y = posBY+indentY;
            a.setPosition(x*cuX, y*cuY);
        }else if (side == SIDE.LEFTofRIGHT){
            x = posBX+cuXB+indentX;
            y = posBY+indentY;
            a.setPosition(x*cuX, y*cuY);
        }
    }

    public static void size(Actor actor, float width, float height){
        float cuX = Gdx.graphics.getWidth()/100f;
        float cuY = Gdx.graphics.getHeight()/100f;

        actor.setSize(cuX*width, cuY*height);
    }
}
