package com.botchan;

public class Person {

	private String identifier; // Identifies somebody as an physical entity (usually DiscordTag)
	private String main_surname;
	private GenderType gender = GenderType.Unknown;
	
	private AffectionType emitted_affection = AffectionType.Unknown;
	private AffectionType perceived_affection = AffectionType.Unknown;
	
	private int link_strength = 0; // Changes with time and interactions to give emphasis to a relation
	private int affection_rate = 0; // -inf to inf
	private int respect = 0; // -inf to inf
	
	public Person(String identifier) {
		this.identifier = identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public void setMain_surname(String main_surname) {
		this.main_surname = main_surname;
	}

	public void setEmitted_affection(AffectionType emitted_affection) {
		this.emitted_affection = emitted_affection;
	}

	public void setPerceived_affection(AffectionType perceived_affection) {
		this.perceived_affection = perceived_affection;
	}

	public void setLink_strength(int link_strength) {
		this.link_strength = link_strength;
	}

	public void setAffection_rate(int affection_rate) {
		this.affection_rate = affection_rate;
	}

	public void setRespect(int respect) {
		this.respect = respect;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getMain_surname() {
		return main_surname;
	}

	public AffectionType getEmitted_affection() {
		return emitted_affection;
	}

	public AffectionType getPerceived_affection() {
		return perceived_affection;
	}

	public int getLink_strength() {
		return link_strength;
	}

	public int getAffection_rate() {
		return affection_rate;
	}

	public int getRespect() {
		return respect;
	}
}
