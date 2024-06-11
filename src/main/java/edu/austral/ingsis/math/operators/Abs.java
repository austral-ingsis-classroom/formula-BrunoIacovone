package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;

import java.util.List;

public class Abs implements Operator{
    private final Function function;

    public Abs(Function function) {
        this.function = function;
    }

    @Override
    public double evaluate() {
        return Math.abs(function.evaluate());
    }

    @Override
    public List<String> getVariables() {
        return function.getVariables();
    }

    @Override
    public String toString() {
        return "|"+function.toString()+"|";
    }
}
