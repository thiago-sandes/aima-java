package aima.test.logictest.foltest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;
import aima.logic.fol.inference.FOLFCAsk;
import aima.logic.fol.kb.DefiniteClauseKnowledgeBase;
import aima.logic.fol.parsing.DomainFactory;
import aima.logic.fol.parsing.ast.Constant;
import aima.logic.fol.parsing.ast.Predicate;
import aima.logic.fol.parsing.ast.Term;
import aima.logic.fol.parsing.ast.Variable;

/**
 * @author Ciaran O'Reilly
 * 
 */
public class FOLFCAskTest extends TestCase {

	public void testBasicForwardChainingFails() {
		DefiniteClauseKnowledgeBase kkb = createKingsKnowledgeBase();
		List<Term> terms = new ArrayList<Term>();
		terms.add(new Variable("x"));
		Predicate query = new Predicate("Criminal", terms);
		Set<Map<Variable, Term>> answer = kkb.ask(query);
		assertTrue(null != answer);
		assertTrue(0 == answer.size());
	}

	public void testBasicForwardChainingSucceeds() {
		DefiniteClauseKnowledgeBase kkb = createKingsKnowledgeBase();
		List<Term> terms = new ArrayList<Term>();
		terms.add(new Variable("x"));
		Predicate query = new Predicate("Evil", terms);
		Set<Map<Variable, Term>> answer = kkb.ask(query);
		assertTrue(null != answer);
		assertEquals(1, answer.size());
		assertEquals(1, answer.iterator().next().size());
		assertEquals(new Constant("John"), answer.iterator().next().get(new Variable("x")));
	}

	public void testComplexForwardChainingSucceeds() {
		DefiniteClauseKnowledgeBase wkb = createWeaponsKnowledgeBase();
		List<Term> terms = new ArrayList<Term>();
		terms.add(new Variable("x"));
		Predicate query = new Predicate("Criminal", terms);

		Set<Map<Variable, Term>> answer = wkb.ask(query);
		assertTrue(null != answer);
		assertEquals(1, answer.size());
		assertEquals(1, answer.iterator().next().size());
		assertEquals(new Constant("West"), answer.iterator().next().get(new Variable("x")));
	}

	public DefiniteClauseKnowledgeBase createKingsKnowledgeBase() {
		DefiniteClauseKnowledgeBase kb = new DefiniteClauseKnowledgeBase(
				DomainFactory.kingsDomain(), new FOLFCAsk());
		kb.tell("((King(x) AND Greedy(x)) => Evil(x))");
		kb.tell("King(John)");
		kb.tell("King(Richard)");
		kb.tell("Greedy(John)");
		
		return kb;
	}

	private DefiniteClauseKnowledgeBase createWeaponsKnowledgeBase() {
		DefiniteClauseKnowledgeBase kb = new DefiniteClauseKnowledgeBase(
				DomainFactory.weaponsDomain(), new FOLFCAsk());
		kb
				.tell("( (((American(x) AND Weapon(y)) AND Sells(x,y,z)) AND Hostile(z)) => Criminal(x))");
		kb.tell(" Owns(NoNo, Mone)");
		kb.tell(" Missile(Mone)");
		kb.tell("((Missile(x) AND Owns(NoNo,x)) => Sells(West,x,NoNo))");
		kb.tell("(Missile(x) => Weapon(x))");
		kb.tell("(Enemy(x,America) => Hostile(x))");
		kb.tell("American(West)");
		kb.tell("Enemy(NoNo,America)");

		return kb;
	}
}