package carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pista {
	
	private List<Caballo<String>> carrera;
	private final int numCaballos;
	private final int TAMAŅO;
	private final Random random;
	
	public Pista (int tamaņoPista, int numeroCaballos) {
		this.TAMAŅO = tamaņoPista;
		this.numCaballos = numeroCaballos;
		this.carrera = new ArrayList<Caballo<String>>();
		random = new Random();
		llenarPista(tamaņoPista);
	}
	
	private void llenarPista(int tamaņoPista) {
		for (int i = 0; i < this.numCaballos; i++) this.aņadirCaballo(this.numeroCaballo(i + 1));
	}
	
	private void aņadirCaballo(String numeroCaballo) {
		Caballo<String> caballo = new Caballo<String>(this.TAMAŅO, numeroCaballo, "[ ]");
		this.carrera.add(caballo);
	}

	private String numeroCaballo(int numeroCaballo) {
		return "[" + String.valueOf(numeroCaballo) + "]";
	}
	
	public boolean siguienteTurno() {
		int numCaballosGanadores = 0;
		for (Caballo<String> caballo : this.carrera) {
			if (random.nextInt(2) == 1) caballo.avanzar(); 
			if(caballo.ganador()) numCaballosGanadores++;
		}
		if (numCaballosGanadores > 0) return true;
		else return false;
	}
	
	public String mostrarPista() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---------------------------------------------------------------------------------------------------------------------\n");
		for (Caballo<String> caballo : this.carrera) buffer.append(caballo.toString() + "\n");
		buffer.append("---------------------------------------------------------------------------------------------------------------------\n");
		return buffer.toString();
	}	
	
	public String ganador() {
		int numCaballosGanadores = 0;
		StringBuffer buffer = new StringBuffer();
		for (Caballo<String> caballo : carrera) {
			if (caballo.ganador()) {
				numCaballosGanadores++;
				buffer.append(caballo.caballoToString() + "\n");
			}
		}
		if (this.numCaballos == 0) return "Error";
		else if (this.numCaballos == numCaballosGanadores) return "Empate";
		else return buffer.toString();
	}
}
