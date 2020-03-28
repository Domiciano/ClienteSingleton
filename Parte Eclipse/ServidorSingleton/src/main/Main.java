package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet implements ComunicacionTCP.OnMessageListener{
	
	private ComunicacionTCP comunicacionTCP;
	private ArrayList<Figura> figuras;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		figuras = new ArrayList<Figura>();
		comunicacionTCP = new ComunicacionTCP();
		comunicacionTCP.setObserver(this);
		comunicacionTCP.esperarConexion();
	}
	
	public void draw() {
		background(255);
		for(int i=0 ; i<figuras.size() ; i++) {
			figuras.get(i).pintar(this);
		}
	}

	@Override
	public void onMessage(String mensaje) {
		if(mensaje.startsWith("POS")) {
			String[] coordenadas = mensaje.split("::");
			int x = Integer.parseInt(coordenadas[1]);
			int y = Integer.parseInt(coordenadas[2]);
			figuras.add(new Figura(x, y, color(0,0,0)));
		}else if(mensaje.startsWith("COLOR")) {
			String color = mensaje.split("::")[1];
			
			Figura ultimaFigura = figuras.get( figuras.size()-1 );
			
			switch(color) {
				case "ROJO":
					ultimaFigura.setColor(color(255,0,0));
					break;
				case "VERDE":
					ultimaFigura.setColor(color(0,255,0));
					break;
				case "AZUL":
					ultimaFigura.setColor(color(0,0,255));
					break;
			}
		}
		
	}

}
