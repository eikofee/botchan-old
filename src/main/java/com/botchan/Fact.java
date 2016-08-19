package com.botchan;

/* Example of fact :
 * - Echo is Male
 * - Evla is Male
 * - Echo love Evla
 * - Evla love Echo
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
