package ru.zoommax.portfolio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import ru.zoommax.portfolio.utils.GS;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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
	public void run() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean stop = false;
				while (!stop && !GS.isErr()){
					if (GS.isLoadP1() && GS.isLoadP2() && GS.isLoadP3() && GS.isLoadP4() && GS.isTestIn() && GS.getLoadPhoto()[0] && GS.getLoadPhoto()[1] && GS.getLoadIam()[0] && GS.getLoadIam()[1]){
						stop = true;
						GS.setLoad(false);
					}
					System.out.print("");
				}
			}
		}).start();

		try {
			URL url = new URL("https://github.com/ZooMMaX");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() == 200) {
				GS.setTestIn(true);

				Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
				request.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/iam.png");
				Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						final FileHandle tmpFile = FileHandle.tempFile("texturea");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						Gdx.app.postRunnable(new Runnable() {
							@Override
							public void run() {
								Pixmap pixmap = new Pixmap(tmpFile);
								GS.setAvatar(pixmap);
								GS.setLoadPhoto1(true);
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
				request2.setUrl("https://github.com/ZooMMaX/portfolio/blob/main/cdek.png?raw=true");
				Gdx.net.sendHttpRequest(request2, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						final FileHandle tmpFile = FileHandle.tempFile("textureb");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						Gdx.app.postRunnable(new Runnable() {
							@Override
							public void run() {
								Pixmap pixmap = new Pixmap(tmpFile);
								GS.setCdekLogo(pixmap);
								GS.setLoadPhoto2(true);
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
				request3.setUrl("https://github.com/ZooMMaX/portfolio/raw/main/p.pdf");
				Gdx.net.sendHttpRequest(request3, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("pdfmd");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setPdf(tmpFile.readBytes());
						GS.setLoadIam1(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});

				Net.HttpRequest request4 = new Net.HttpRequest(Net.HttpMethods.GET);
				request4.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/iam.txt");
				Gdx.net.sendHttpRequest(request4, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("iam");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setIamText(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
						GS.setLoadIam2(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});

				Net.HttpRequest request5 = new Net.HttpRequest(Net.HttpMethods.GET);
				request5.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/p1");
				Gdx.net.sendHttpRequest(request5, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("p1t");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setProj1Text(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
						GS.setLoadP1(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});

				Net.HttpRequest request6 = new Net.HttpRequest(Net.HttpMethods.GET);
				request6.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/p2");
				Gdx.net.sendHttpRequest(request6, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("p2t");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setProj2Text(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
						GS.setLoadP2(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});

				Net.HttpRequest request7 = new Net.HttpRequest(Net.HttpMethods.GET);
				request7.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/p3");
				Gdx.net.sendHttpRequest(request7, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("p3t");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setProj3Text(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
						GS.setLoadP3(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});

				Net.HttpRequest request8 = new Net.HttpRequest(Net.HttpMethods.GET);
				request8.setUrl("https://raw.githubusercontent.com/ZooMMaX/portfolio/main/p4");
				Gdx.net.sendHttpRequest(request8, new Net.HttpResponseListener() {
					@Override
					public void handleHttpResponse(Net.HttpResponse httpResponse) {
						FileHandle tmpFile = FileHandle.tempFile("p4t");
						tmpFile.write(httpResponse.getResultAsStream(), false);
						GS.setProj4Text(new String(tmpFile.readBytes(), StandardCharsets.UTF_8));
						GS.setLoadP4(true);
					}

					@Override
					public void failed(Throwable t) {

					}

					@Override
					public void cancelled() {

					}
				});
			} else {
				GS.setError("err!200");
				GS.setErr(true);
			}
			con.disconnect();
		} catch (IOException e) {
			GS.setError(e.toString());
			GS.setErr(true);
		}
	}
}
