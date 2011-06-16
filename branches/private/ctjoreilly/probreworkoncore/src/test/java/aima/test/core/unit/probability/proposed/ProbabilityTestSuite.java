package aima.test.core.unit.probability.proposed;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import aima.test.core.unit.probability.proposed.bayes.approx.PriorSampleTest;
import aima.test.core.unit.probability.proposed.bayes.approx.RejectionSamplingTest;
import aima.test.core.unit.probability.proposed.bayes.exact.EliminationAskTest;
import aima.test.core.unit.probability.proposed.bayes.exact.EnumerationAskTest;
import aima.test.core.unit.probability.proposed.bayes.impl.CPTTest;
import aima.test.core.unit.probability.proposed.bayes.model.FiniteBayesModelTest;
import aima.test.core.unit.probability.proposed.full.FullJointProbabilityModelTest;
import aima.test.core.unit.probability.proposed.util.ProbabilityTableTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( { ProbabilityTableTest.class, FiniteBayesModelTest.class,
		FullJointProbabilityModelTest.class, PriorSampleTest.class,
		RejectionSamplingTest.class, EnumerationAskTest.class,
		EliminationAskTest.class, CPTTest.class })
public class ProbabilityTestSuite {

}
