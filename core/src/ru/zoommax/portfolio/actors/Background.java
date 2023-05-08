package ru.zoommax.portfolio.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {

    ShaderProgram shader;
    Sprite sprite;
    float time = 1f;

    public Background(){
        this.setPosition(0, 0);
        this.setBounds(0,0, getWidth(), getHeight());
        sprite = new Sprite(new Texture(Gdx.files.internal("bg.jpg")));
        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(new SpriteBatch().getShader().getVertexShaderSource(), Gdx.files.internal("background.frag").readString());
        if (!shader.isCompiled()) {
            System.out.println(shader.getLog());
            System.exit(0);
        }
    }

    @Override
    public void draw(Batch batch, float alfa){
        batch.end();
        time += Gdx.graphics.getDeltaTime()/8;
        batch.setShader(shader);
        shader.bind();
        shader.setUniformf("resolution", Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        shader.setUniformf("time", time);
        batch.begin();
        batch.draw(sprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
