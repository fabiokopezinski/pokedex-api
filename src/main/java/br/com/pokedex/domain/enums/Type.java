package br.com.pokedex.domain.enums;

public enum Type {
	
	FIRE("Fogo"),
	WATER("Água"),
	EARTH("Terra"),
	ELECTRIC("Elétrico"),
	NORMAL("Normal"),
	GRASS("Grama"),
	ICE("Gelo"),
	FIGHTER("Lutador"),
	POISONOUS("Venenoso"),
	FLYING("Voador"),
	PSYCHIC("Psíquico"),
	BUG("Inseto"),
	STONE("Pedra"),
	GHOST("Fantasma"),
	DRAGON("Dragão"),
	NIGHT("Noturno"),
	FAIRY("Fada"),
	STEEL("Aço");

	private final String description;
	
	private Type(String description) {
		this.description=description;
	}
	
	public  String getDescription() {
		return description;
	}

}
