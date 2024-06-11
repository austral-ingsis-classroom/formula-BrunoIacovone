package edu.austral.ingsis.math.values;

import java.util.List;

public class Val implements Value{
    int value;

    public Val(int value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
