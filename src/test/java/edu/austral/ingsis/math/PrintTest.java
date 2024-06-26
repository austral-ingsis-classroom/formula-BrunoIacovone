package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.Val;
import edu.austral.ingsis.math.values.Var;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final Function function = new Sum(new Val(1), new Val(6));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final Function function = new Division(new Val(12), new Val(2));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final Function function = new Multiplication(new Division(new Val(9), new Val(2)), new Val(3));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final Function function = new Power(new Division(new Val(27), new Val(6)), new Val(2));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final Function function = new Substract(new Abs(new Var("value", 1)), new Val(8));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final Function function = new Substract(new Abs(new Var("value", 1)), new Val(8));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final Function function =
        new Multiplication(new Substract(new Val(5), new Var("i", 1)), new Val(8));
    final String result = function.toString();
    assertThat(result, equalTo(expected));
  }
}
