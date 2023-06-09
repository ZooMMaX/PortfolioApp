package ru.zoommax.portfolio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.*;
import com.kotcrab.vis.ui.widget.file.FileChooser;
import com.kotcrab.vis.ui.widget.file.StreamingFileChooserListener;
import lombok.SneakyThrows;
import ru.zoommax.portfolio.actors.Background;
import ru.zoommax.portfolio.utils.GS;
import ru.zoommax.portfolio.utils.position.Percent;
import ru.zoommax.portfolio.utils.position.SIDE;
import ru.zoommax.portfolio.windows.*;
import ru.zoommax.portfolio.windows.Error;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main extends ApplicationAdapter {

	Stage bg;
	public static Stage stage;
	OrthographicCamera camera;
	Actor background;

	VisTextButton iamButt, proj1, proj2, proj3, proj4, liteVer;
	VisWindow iamWin, proj1Win, proj2Win, proj3Win, proj4Win, load, err;
	VisImage avatar;
	boolean startLoad = true;
	boolean buttShow = false;

	public static float w,h;

    VisLabel testIn, loadPhoto, loadIam, loadP1, loadP2, loadP3, loadP4;

	@Override
	public void create () {
		VisUI.load();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		bg = new Stage(new ScreenViewport(camera));
		background = new Background();
		bg.addActor(background);

		stage = new Stage(new ScreenViewport(camera));
		Gdx.input.setInputProcessor(stage);

		iamButt = new VisTextButton("Личная информация", new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				avatar = new VisImage(new Texture(GS.getAvatar()));
				avatar.setSize(h*20, h*20);
				Percent.pos(avatar, SIDE.PARENTTOPLEFT, null, 0,0);

				iamWin = new Iam("Личная информация", avatar);
				iamWin.setSize(w * 50f, h * 40f);
				Percent.pos(iamWin, SIDE.TOPofBOTTOM, avatar, 0, 0);

				stage.addActor(avatar);
				stage.addActor(iamWin);
			}
		});

		proj1 = new VisTextButton("Проект №1", new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				proj1Win = new Proj1("CdekScanPC");
				Percent.size(proj1Win, 50, 50);
				Percent.pos(proj1Win, SIDE.PARENTCENTER, null, 0,0);
				stage.addActor(proj1Win);
			}
		});

		proj2 = new VisTextButton("Проект №2", new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				proj2Win = new Proj2("GreyWebsVPN");
				Percent.size(proj2Win, 50, 50);
				Percent.pos(proj2Win, SIDE.PARENTCENTER, null, 0,0);
				stage.addActor(proj2Win);
			}
		});

        proj3 = new VisTextButton("Проект №3", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                proj3Win = new Proj3("As Second Life studio");
                Percent.size(proj3Win, 50, 50);
                Percent.pos(proj3Win, SIDE.PARENTCENTER, null, 0,0);
                stage.addActor(proj3Win);
            }
        });

		proj4 = new VisTextButton("Проект №4", new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				proj4Win = new Proj4("Система учета рабочего времени и пропускного контроля на базе NFC карт");
				Percent.size(proj4Win, 50, 50);
				Percent.pos(proj4Win, SIDE.PARENTCENTER, null, 0,0);
				stage.addActor(proj4Win);
			}
		});

		liteVer = new VisTextButton("Обычное резюме", new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				VisWindow lr = new VisWindow("Обычное резюме");
				lr.addCloseButton();
				lr.closeOnEscape();

				lr.add(new LinkLabel("Посмотреть резюме", "https://github.com/ZooMMaX/portfolio/blob/main/p.md")).row();
				lr.add(new VisTextButton("Сохранить в PDF", new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						FileChooser.setDefaultPrefsName("com.kotcrab.vis.ui.test.manual");
						FileChooser.setSaveLastDirectory(true);
						FileChooser chooser = new FileChooser(com.kotcrab.vis.ui.widget.file.FileChooser.Mode.OPEN);
						chooser.setSelectionMode(FileChooser.SelectionMode.FILES_AND_DIRECTORIES);
						chooser.setDefaultFileName("FilatovYuriy.pdf");
						chooser.setListener(new StreamingFileChooserListener() {
							@SneakyThrows
							@Override
							public void selected (FileHandle file) {
								FileOutputStream outputStream = new FileOutputStream(file.path());
								outputStream.write(GS.getPdf());
								outputStream.close();
							}
						});
						chooser.setMode(FileChooser.Mode.SAVE);
						Percent.size(chooser, 70, 70);
						Percent.pos(chooser, SIDE.PARENTCENTER, null, 0, 0);
						stage.addActor(chooser.fadeIn());
					}
				})).growX().row();
				Percent.size(lr, 10, 10);
				Percent.pos(lr, SIDE.PARENTCENTER, null, 0,0);
				stage.addActor(lr);
			}
		});

        load = new VisWindow("Загрузка");
        testIn = new VisLabel("Проверка доступа в интернет: "+Loading.WAIT);
        loadPhoto = new VisLabel("Загрузка фото: "+Loading.WAIT);
        loadIam = new VisLabel("Загрузка личных данных: "+Loading.WAIT);
        loadP1 = new VisLabel("Загрузка данных по проекту №1: "+Loading.WAIT);
        loadP2 = new VisLabel("Загрузка данных по проекту №2: "+Loading.WAIT);
        loadP3 = new VisLabel("Загрузка данных по проекту №3: "+Loading.WAIT);
        loadP4 = new VisLabel("Загрузка данных по проекту №4: "+Loading.WAIT);
		load.add(testIn).row();
		load.add(loadPhoto).row();
		load.add(loadIam).row();
		load.add(loadP1).row();
		load.add(loadP2).row();
		load.add(loadP3).row();
		load.add(loadP4).row();
		Percent.size(load, 30,30);
		Percent.pos(load, SIDE.PARENTCENTER, null, 0,0);
		stage.addActor(load);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		bg.act();
		bg.draw();
        stage.act();
        stage.draw();
		if (GS.isLoad() && startLoad){
			GS.getLoading().start();
			startLoad = false;
		}

		if (!GS.isLoad()) {
			if (GS.getAvatar() != null && !buttShow) {
				buttShow = true;
				Percent.pos(iamButt, SIDE.PARENTTOPRIGHT, null, -0.2f,0);
				Percent.pos(proj1, SIDE.TOPofBOTTOM, iamButt, 0, -0.2f);
				Percent.pos(proj2, SIDE.TOPofBOTTOM, proj1, 0, -0.2f);
                Percent.pos(proj3, SIDE.TOPofBOTTOM, proj2, 0, -0.2f);
				Percent.pos(proj4, SIDE.TOPofBOTTOM, proj3, 0, -0.2f);
				Percent.pos(liteVer, SIDE.TOPofBOTTOM, proj4, 0, -0.2f);
				proj1.setSize(iamButt.getWidth(), iamButt.getHeight());
				proj2.setSize(iamButt.getWidth(), iamButt.getHeight());
				proj3.setSize(iamButt.getWidth(), iamButt.getHeight());
				proj4.setSize(iamButt.getWidth(), iamButt.getHeight());
				liteVer.setSize(iamButt.getWidth(), iamButt.getHeight());
				stage.addActor(iamButt);
				stage.addActor(proj1);
				stage.addActor(proj2);
                stage.addActor(proj3);
				stage.addActor(proj4);
				stage.addActor(liteVer);
				load.remove();
			}
		}else{
            if (GS.isTestIn()){
				testIn.setText("Проверка доступа в интернет: "+Loading.DONE);
			}else {
				testIn.setText("Проверка доступа в интернет: "+Loading.LOAD);
			}
			if (GS.getLoadIam()[0] && GS.getLoadIam()[1]){
				loadIam.setText("Загрузка личных данных: "+Loading.DONE);
			}else {
				loadIam.setText("Загрузка личных данных: "+Loading.LOAD);
			}
			if (GS.getLoadPhoto()[0] && GS.getLoadPhoto()[1]){
				loadPhoto.setText("Загрузка фото: "+Loading.DONE);
			}else {
				loadPhoto.setText("Загрузка фото: "+Loading.LOAD);
			}
			if (GS.isLoadP1()){
				loadP1.setText("Загрузка данных по проекту №1: "+Loading.DONE);
			}else {
				loadP1.setText("Загрузка данных по проекту №1: "+Loading.LOAD);
			}
			if (GS.isLoadP2()){
				loadP2.setText("Загрузка данных по проекту №2: "+Loading.DONE);
			}else {
				loadP2.setText("Загрузка данных по проекту №2: "+Loading.LOAD);
			}
			if (GS.isLoadP3()){
				loadP3.setText("Загрузка данных по проекту №3: "+Loading.DONE);
			}else {
				loadP3.setText("Загрузка данных по проекту №3: "+Loading.LOAD);
			}
			if (GS.isLoadP4()){
				loadP4.setText("Загрузка данных по проекту №4: "+Loading.DONE);
			}else {
				loadP4.setText("Загрузка данных по проекту №4: "+Loading.LOAD);
			}
        }
		if (GS.isErr()){
			err = new Error();
			Percent.size(err, 30,30);
			Percent.pos(err, SIDE.PARENTTOPLEFT, null,0,0);
			stage.addActor(err);
			GS.setErr(false);
		}
	}

	@Override
	public void resize(int width, int height){
		camera.setToOrtho(false, width, height);
		stage.getViewport().setScreenSize(width, height);
		w = width/100f;
		h = height/100f;
		Percent.pos(iamButt, SIDE.PARENTTOPRIGHT, null, -0.2f,0);
		Percent.pos(proj1, SIDE.TOPofBOTTOM, iamButt, 0, -0.2f);
        Percent.pos(proj2, SIDE.TOPofBOTTOM, proj1, 0, -0.2f);
        Percent.pos(proj3, SIDE.TOPofBOTTOM, proj2, 0, -0.2f);
		Percent.pos(proj4, SIDE.TOPofBOTTOM, proj3, 0, -0.2f);
		Percent.pos(liteVer, SIDE.TOPofBOTTOM, proj4, 0, -0.2f);
		if (iamWin != null) {
			avatar.setSize(h*20, h*20);
			Percent.pos(avatar, SIDE.PARENTTOPLEFT, null, 0,0);
			iamWin.setSize(w * 50f, h * 40f);
			Percent.pos(iamWin, SIDE.TOPofBOTTOM, avatar, 0, 0);
		}
		if (proj1Win != null){
			Percent.size(proj1Win, 50, 50);
			Percent.pos(proj1Win, SIDE.PARENTCENTER, null, 0,0);
		}
		if (proj2Win != null){
			Percent.size(proj2Win, 50, 50);
			Percent.pos(proj2Win, SIDE.PARENTCENTER, null, 0,0);
		}
        if (proj3Win != null){
            Percent.size(proj3Win, 50, 50);
            Percent.pos(proj3Win, SIDE.PARENTCENTER, null, 0,0);
        }
		if (proj4Win != null){
			Percent.size(proj4Win, 50, 50);
			Percent.pos(proj4Win, SIDE.PARENTCENTER, null, 0,0);
		}
        if (load.isVisible()){
			Percent.size(load, 30,30);
			Percent.pos(load, SIDE.PARENTCENTER, null, 0,0);
        }
	}
	
	@Override
	public void dispose () {
		VisUI.dispose();
	}
}
