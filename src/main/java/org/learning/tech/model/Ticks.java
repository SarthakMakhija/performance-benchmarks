package org.learning.tech.model;

import org.learning.tech.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ticks extends ArrayList<Tick> {

    public Ticks(List<Tick> elements) {
        super(elements);
    }

    public Ticks cleanUsing(Validator validator) {
        return new Ticks(
                this.stream().filter(tick -> validator.isValid(tick.signature())).collect(Collectors.toList())
        );
    }
}