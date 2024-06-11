package edu.austral.ingsis.math.values;

import java.util.List;

public class Var implements Value{
    int value;
    String name;

    public Var(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public List<String> getVariables() {
        return List.of(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
