package com.botchan;

/* Example of fact :
 * - Echo is Male
 * - Evla is Male
 * - Echo love Evla
 * - Evla love Echo
 * 
 * Single letters are variables that match anything : A, B, C, X, Y, Z...
 * Abstract fact aren't use for knowledges but for inferences only
 */

public class Fact {
	
	private String subjectA;
	private Predicate predicate;
	private String subjectB;
	
	public Fact(String subjectA, Predicate predicate, String subjectB) {
		this.subjectA = subjectA;
		this.predicate = predicate;
		this.subjectB = subjectB;
	}
	
}
