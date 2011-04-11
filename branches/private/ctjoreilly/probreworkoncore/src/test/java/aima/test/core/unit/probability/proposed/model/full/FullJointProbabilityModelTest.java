package aima.test.core.unit.probability.proposed.model.full;

import org.junit.Test;

import aima.core.probability.proposed.model.full.example.FullJointDistributionBurglaryAlarmModel;
import aima.core.probability.proposed.model.full.example.FullJointDistributionMeningitisStiffNeckModel;
import aima.core.probability.proposed.model.full.example.FullJointDistributionPairFairDiceModel;
import aima.core.probability.proposed.model.full.example.FullJointDistributionToothacheCavityCatchModel;
import aima.core.probability.proposed.model.full.example.FullJointDistributionToothacheCavityCatchWeatherModel;
import aima.test.core.unit.probability.proposed.model.CommonFiniteProbabilityModelTests;

public class FullJointProbabilityModelTest extends
		CommonFiniteProbabilityModelTests {

	//
	// ProbabilityModel Tests
	@Test
	public void test_RollingPairFairDiceModel() {
		FullJointDistributionPairFairDiceModel model = new FullJointDistributionPairFairDiceModel();

		test_RollingPairFairDiceModel(model, model.getDice1(), model.getDice2());
	}

	@Test
	public void test_ToothacheCavityCatchModel() {
		FullJointDistributionToothacheCavityCatchModel model = new FullJointDistributionToothacheCavityCatchModel();

		test_ToothacheCavityCatchModel(model, model.getToothache(),
				model.getCavity(), model.getCatch());
	}

	@Test
	public void test_ToothacheCavityCatchWeatherModel() {
		FullJointDistributionToothacheCavityCatchWeatherModel model = new FullJointDistributionToothacheCavityCatchWeatherModel();

		test_ToothacheCavityCatchWeatherModel(model, model.getToothache(),
				model.getCavity(), model.getCatch(), model.getWeather());
	}

	@Test
	public void test_MeningitisStiffNeckModel() {
		FullJointDistributionMeningitisStiffNeckModel model = new FullJointDistributionMeningitisStiffNeckModel();

		test_MeningitisStiffNeckModel(model, model.getMeningitis(),
				model.getStiffNeck());
	}

	@Test
	public void test_BurglaryAlarmModel() {
		FullJointDistributionBurglaryAlarmModel model = new FullJointDistributionBurglaryAlarmModel();

		test_BurglaryAlarmModel(model, model.getBurglary(),
				model.getEarthquake(), model.getAlarm(), model.getJohnCalls(),
				model.getMaryCalls());
	}

	//
	// FiniteProbabilityModel Tests
	@Test
	public void test_RollingPairFairDiceModel_Distributions() {
		FullJointDistributionPairFairDiceModel model = new FullJointDistributionPairFairDiceModel();

		test_RollingPairFairDiceModel_Distributions(model, model.getDice1(),
				model.getDice2());
	}

	@Test
	public void test_ToothacheCavityCatchModel_Distributions() {
		FullJointDistributionToothacheCavityCatchModel model = new FullJointDistributionToothacheCavityCatchModel();

		test_ToothacheCavityCatchModel_Distributions(model,
				model.getToothache(), model.getCavity(), model.getCatch());
	}

	@Test
	public void test_ToothacheCavityCatchWeatherModel_Distributions() {
		FullJointDistributionToothacheCavityCatchWeatherModel model = new FullJointDistributionToothacheCavityCatchWeatherModel();

		test_ToothacheCavityCatchWeatherModel_Distributions(model,
				model.getToothache(), model.getCavity(), model.getCatch(),
				model.getWeather());
	}

	@Test
	public void test_MeningitisStiffNeckModel_Distributions() {
		FullJointDistributionMeningitisStiffNeckModel model = new FullJointDistributionMeningitisStiffNeckModel();

		test_MeningitisStiffNeckModel_Distributions(model,
				model.getMeningitis(), model.getStiffNeck());
	}

	@Test
	public void test_BurglaryAlarmModel_Distributions() {
		FullJointDistributionBurglaryAlarmModel model = new FullJointDistributionBurglaryAlarmModel();

		test_BurglaryAlarmModel_Distributions(model, model.getBurglary(),
				model.getEarthquake(), model.getAlarm(), model.getJohnCalls(),
				model.getMaryCalls());
	}
}
