package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.Val;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Function function = new Sum(new Val(1), new Val(6));
    final Double result = function.evaluate();
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Function function = new Division(new Val(12), new Val(2));
    final Double result = function.evaluate();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Function function = new Multiplication(new Division(new Val(9), new Val(2)), new Val(3));
    final Double result = function.evaluate();
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Function function = new Power(new Division(new Val(27), new Val(6)), new Val(2));
    final Double result = function.evaluate();
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Function function = new Power(new Val(36), new Division(new Val(1), new Val(2)));
    final Double result = function.evaluate();
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Function function = new Abs(new Val(136));
    final Double result = function.evaluate();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Function function = new Abs(new Val(-136));
    final Double result = function.evaluate();
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Function function = new Multiplication(new Substract(new Val(5), new Val(5)), new Val(8));
    final Double result = function.evaluate();
    assertThat(result, equalTo(0d));
  }
}
