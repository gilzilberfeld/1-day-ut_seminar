package testingil.unittesting.examples.e11.bdd;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testingil.unittesting.examples.e11.bdd.Calculator;
public class Steps {
	Calculator calc;
	
	@Given("I have a calculator")
	public void setup() {
		calc = new Calculator();
	}
	
	@When("I type in {int}, {string}, {int}")
	public void i_type_in(int val1, String op, int val2) {
		calc.press(Integer.toString(val1));
		calc.press(op);
		calc.press(Integer.toString(val2));
	}

	@Then("The result is {string}")
	public void the_result_is(String expected) {
		calc.press("=");
		assertEquals(expected, calc.getDisplay());
	}

	@When("I type in {int} plus {int}")
	public void i_type_in_plus(Integer val1, Integer val2) {
		i_type_in(val1, "+", val2);
	}
}
