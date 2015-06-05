package es.uji.natureadventure.enums;

public enum Difficulties {

	baja,media, alta;
	
	
	private Difficulties(){
	}
	
	public static Difficulties getOpcion(int posicion){
		return values()[posicion];
	}
}
