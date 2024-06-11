package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.Val;
import edu.austral.ingsis.math.values.Var;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Function function = new Sum(new Val(1), new Var("x", 3));
    final Double result = function.evaluate();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Function function = new Division(new Val(12), new Var("div", 4));
    final Double result = function.evaluate();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Function function =
        new Multiplication(new Division(new Val(9), new Var("x", 3)), new Var("y", 4));
    final Double result = function.evaluate();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Function function =
        new Power(new Division(new Val(27), new Var("a", 9)), new Var("b", 3));
    final Double result = function.evaluate();
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Function function = new Power(new Var("z", 36), new Division(new Val(1), new Val(2)));
    final Double result = function.evaluate();
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Function function = new Substract(new Abs(new Var("value", 8)), new Val(8));
    final Double result = function.evaluate();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Function function = new Substract(new Abs(new Var("value", 8)), new Val(8));
    final Double result = function.evaluate();
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Function function =
        new Multiplication(new Substract(new Val(5), new Var("i", 2)), new Val(8));
    final Double result = function.evaluate();
    assertThat(result, equalTo(24d));
  }
}
