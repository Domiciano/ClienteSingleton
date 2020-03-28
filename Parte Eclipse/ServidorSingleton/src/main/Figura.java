package main;

import processing.core.PApplet;

public class Figura {

	private int x, y, color;
	
	public void pintar(PApplet app) {
		app.fill(color);
		app.ellipse(x, y, 50, 50);
	}
	
	public Figura(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	
	
}
