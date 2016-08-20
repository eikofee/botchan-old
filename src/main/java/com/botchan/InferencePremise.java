package com.botchan;

public class InferencePremise {
	
	private InferenceType type;
	private InferencePremise left;
	private InferencePremise right;
	
	// If this is an operator node
	private InferenceOperator operator;
	
	// If this is a fact node
	private Fact fact;
	
	// Constructor for operators
	public InferencePremise(InferenceOperator op, InferencePremise left, InferencePremise right) {
		if (op == null || left == null || right == null) {
			try {
				throw new Exception("InferenceRule arguments can't be null");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.type = InferenceType.Operator;
		this.operator = op;
		this.left = left;
		this.right = right;
	}
	
	// Constructor for facts
	public InferencePremise(Fact fact) {
		this.fact = fact;
		this.left = null;
		this.right = null;
	}
}
