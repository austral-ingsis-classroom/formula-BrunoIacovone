package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.Val;
import edu.austral.ingsis.math.values.Var;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.List;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Function function = new Sum(new Val(1), new Val(6));
    final List<String> result = function.getVariables();
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Function function = new Division(new Val(12), new Var("div", 1));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Function function = new Multiplication(new Division(new Val(9), new Var("x", 1)), new Var("y", 1));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Function function = new Power(new Division(new Val(27), new Var("a", 1)), new Var("b", 1));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Function function = new Power(new Var("z", 1), new Division(new Val(1), new Val(2)));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Function function = new Substract(new Abs(new Var("value", 1)), new Val(8));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Function function = new Substract(new Abs(new Var("value", 1)), new Val(8));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Function function = new Multiplication(new Substract(new Val(5), new Var("i", 1)), new Val(8));
    final List<String> result = function.getVariables();
    assertThat(result, containsInAnyOrder("i"));
  }
}
