package com.botchan;

public enum Predicate {
	// Relational
	Love, Like, Hate, Neutral, Friend, Dislike, Unknown,
	
	// State
	Is,
	
	// Past action
	Insulted, Spammed,
	
	// Procedures
	IncreaseAffection_by, IncreaseRespect_by, IncreaseLink_by
}
