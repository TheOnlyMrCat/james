package com.dockdev.james;

import java.awt.Canvas;
import java.awt.Dimension;

/**
 * The engine for J.A.M.E.S: Java Attributed Multipurpose Engine for Speech
 * @author TheOnlyMrCat
 *
 */

public class James extends Canvas implements Runnable {

	public static James james;
	public Engine engine;
	private static final long serialVersionUID = -7869422721863325480L;

	private Thread thread = new Thread("JAMES");

	private boolean running;
	
	private Window window;
	public boolean muted;
	
	public Window getWindow() {
		return window;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public class Engine {
		public void buttonPush(String button) {
			switch (button) {
				case "respond": getResponse(window.speech.getText());
				case "mute": if (muted) {
						muted = false;
					} else if (!muted) {
						muted = true;
					}
				case "microphone":
				case "exit": stop(); break;
				default: break;
			}
		}
		
		public SpeechResponse getResponse(String text) {
			SpeechResponse.getSpeechResponse(text);
			return null;
		}
	}
	
	public James(Window window) {
		this.window = window;
		start();
	}
	
	public synchronized void start() {
		System.out.println("Starting");
		running = true;
		thread.start();
		
		window.pack();
		window.setVisible(true);
		
		System.out.println("Started");
	}
	
	public synchronized void stop() {
		System.out.println("Stopping");
		running = false;
		try {
			thread.join();
			System.out.println("Terminated");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	@Override
	public void run() {
		do {
			
		} while (running);
	}
	
	public static void main(String args[]) {
		System.out.println("Initializing application");
		james = new James(new Window("JAMES Console", new Dimension(240, 120)));
		james.setEngine(james.new Engine());
	}
}
