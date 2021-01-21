package br.com.pokedex.domain.enums;


public enum Type {
	
	FOGO("Fogo"),
	AGUA("Água"),
	TERRA("Terra"),
	ELETRICO("Elétrico"),
	NORMAL("Normal"),
	GRAMA("Grama"),
	GELO("Gelo"),
	LUTADOR("Lutador"),
	VENENOSO("Venenoso"),
	VOADOR("Voador"),
	PSIQUICO("Psiquico"),
	INSETO("Inseto"),
	PEDRA("Pedra"),
	FANTASMA("Fanstama"),
	DRAGAO("Dragao"),
	NOTURNO("Noturno"),
	FADA("Fada"),
	ACO("Aco");

	private String typee;
	private Type(String typee){
		this.typee=typee;
	}

	public String getType(){
		return typee;
	}

	public static Type getTypee(String name){
		for(Type type:Type.values()){
			if(type.name().equalsIgnoreCase(name)){
				return type;
			}
		}
		return null;
	}

}
