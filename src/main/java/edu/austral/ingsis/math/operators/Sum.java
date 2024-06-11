package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class Sum implements Operator {

  private final Function left;
  private final Function right;

  public Sum(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double evaluate() {
    return left.evaluate() + right.evaluate();
  }

  @Override
  public List<String> getVariables() {
    List<String> res = new ArrayList<>(left.getVariables());
    res.addAll(right.getVariables());
    return res;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    if (left instanceof Operator && !(left instanceof Abs)) {
      res.append("(");
      res.append(left.toString());
      res.append(")");
    } else {
      res.append(left.toString());
    }
    res.append(" + ");
    if (right instanceof Operator && !(right instanceof Abs)) {
      res.append("(");
      res.append(right.toString());
      res.append(")");
    } else {
      res.append(right.toString());
    }
    return res.toString();
  }
}
