package ru.zoommax.portfolio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import lombok.SneakyThrows;
import ru.zoommax.portfolio.utils.GS;

import java.awt.*;
import java.nio.charset.StandardCharsets;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		GS.setLoading(new Thread(new preShow()));
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaximized(true);
		config.setForegroundFPS(60);
		config.setResizable(true);
		config.setTitle("Portfolio");
		new Lwjgl3Application(new Main(), config);
	}
}

class preShow implements Runnable{

	@Override
	@SneakyThrows
	public void run() {
		Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
		request.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/iam.png");
		Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {
			@Override
			public void handleHttpResponse (Net.HttpResponse httpResponse) {
				final FileHandle tmpFile = FileHandle.tempFile("texturea");
				tmpFile.write(httpResponse.getResultAsStream(), false);
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run () {
						Pixmap pixmap = new Pixmap(tmpFile);
						GS.setAvatar(pixmap);
					}
				});
			}

			@Override
			public void failed(Throwable t) {

			}

			@Override
			public void cancelled() {

			}
		});

		Net.HttpRequest request2 = new Net.HttpRequest(Net.HttpMethods.GET);
		request2.setUrl("https://upload.wikimedia.org/wikipedia/ru/c/cf/%D0%A1%D0%AD%D0%94%D0%9A.jpg");
		Gdx.net.sendHttpRequest(request2, new Net.HttpResponseListener() {
			@Override
			public void handleHttpResponse (Net.HttpResponse httpResponse) {
				final FileHandle tmpFile = FileHandle.tempFile("textureb");
				tmpFile.write(httpResponse.getResultAsStream(), false);
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run () {
						Pixmap pixmap = new Pixmap(tmpFile);
						GS.setCdekLogo(pixmap);
					}
				});
			}

			@Override
			public void failed(Throwable t) {

			}

			@Override
			public void cancelled() {

			}
		});

		Net.HttpRequest request3 = new Net.HttpRequest(Net.HttpMethods.GET);
		request3.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/iam.txt");
		Gdx.net.sendHttpRequest(request3, new Net.HttpResponseListener() {
			@Override
			public void handleHttpResponse(Net.HttpResponse httpResponse) {
				FileHandle tmpFile = FileHandle.tempFile("iam");
				tmpFile.write(httpResponse.getResultAsStream(), false);
				GS.setIamText(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
			}

			@Override
			public void failed(Throwable t) {

			}

			@Override
			public void cancelled() {

			}
		});

		Net.HttpRequest request4 = new Net.HttpRequest(Net.HttpMethods.GET);
		request4.setUrl("https://github.com/ZooMMaX/portfolio/raw/main/p.pdf");
		Gdx.net.sendHttpRequest(request4, new Net.HttpResponseListener() {
			@Override
			public void handleHttpResponse(Net.HttpResponse httpResponse) {
				FileHandle tmpFile = FileHandle.tempFile("pdfmd");
				tmpFile.write(httpResponse.getResultAsStream(), false);
				GS.setPdf(tmpFile.readBytes());
			}

			@Override
			public void failed(Throwable t) {

			}

			@Override
			public void cancelled() {

			}
		});

		GS.setLoad(false);
	}
}
