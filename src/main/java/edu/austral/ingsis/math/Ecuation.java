package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class Ecuation implements Function {
  List<Function> functions;

  @Override
  public double evaluate() {
    double res = 0;
    for (Function function : functions) {
      res += function.evaluate();
    }
    return res;
  }

  @Override
  public List<String> getVariables() {
    List<String> res = new ArrayList<>();
    for (Function function : functions) {
      res.addAll(function.getVariables());
    }
    return res;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    for (Function function : functions) {
      res.append(function.toString());
    }
    return res.toString();
  }
}
