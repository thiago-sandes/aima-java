package aima.core.probability.proposed.model.proposition;

import java.util.Map;

import aima.core.probability.proposed.model.RandomVariable;

// TODO - page 489 (13.4)
public class DisjunctiveProposition extends BinarySentenceProposition {

	private Proposition left = null;
	private Proposition right = null;
	//
	private String toString = null;
	
	public DisjunctiveProposition(Proposition left, Proposition right) {
		if (null == left) {
			throw new IllegalArgumentException("Left side of disjunction must be specified.");
		}
		if (null == right) {
			throw new IllegalArgumentException("Right side of disjunction must be specified.");
		}
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean matches(Map<RandomVariable, Object> possibleWorld) {
		return left.matches(possibleWorld) || right.matches(possibleWorld);
	}
	
	@Override
	public String toString() {
		if (null == toString) {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(left.toString());
			sb.append(" OR ");
			sb.append(right.toString());
			sb.append(")");
			
			toString = sb.toString();
		}
		
		return toString;
	}
}