package aima.core.probability.proposed.model.proposition;

import java.util.Map;

import aima.core.probability.proposed.model.RandomVariable;

public class AssignmentProposition extends TermProposition {
	private Object value = null;
	//
	private String toString = null;
	
	public AssignmentProposition(RandomVariable forVariable, Object value) {
		super(forVariable);
		if (null == value) {
			throw new IllegalArgumentException(
					"The value for the Random Variable must be specified.");
		}

		
		this.value = value;
	}
	

	@Override
	public boolean matches(Map<RandomVariable, Object> possibleWorld) {		
		return value.equals(possibleWorld.get(getRandomVariable()));
	}
	
	@Override
	public String toString() {
		if (null == toString) {
			StringBuilder sb = new StringBuilder();
			sb.append(getRandomVariable().getName());
			sb.append(" = ");
			sb.append(value);
			
			toString = sb.toString();
		}
		return toString;
	}
}
