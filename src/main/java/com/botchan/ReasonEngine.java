package com.botchan;

import java.util.ArrayList;

public class ReasonEngine {
	
	private ArrayList<InferenceRule> reasoning_sandbox; // For backward-chaining temporary inferences
	private ArrayList<ArrayList<InferenceRule>> global_reasoning_rules; // See ReasoningRuleType.java for indices

}
