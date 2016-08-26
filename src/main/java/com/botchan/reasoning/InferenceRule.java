package com.botchan.reasoning;

public class InferenceRule {
	
	private InferenceReactionType type;
	private InferencePremise premise;
	private Fact conclusion;
	
	// Simple inference
	public InferenceRule(Fact premise, Fact conclusion, InferenceReactionType type) {
		this.type = type;
		this.premise = new InferencePremise(premise);
		this.conclusion = conclusion;
	}
	
	// Complex inference
	public InferenceRule(InferencePremise premise, Fact conclusion, InferenceReactionType type) {
		this.type = type;
		this.premise = premise;
		this.conclusion = conclusion;
	}
}
