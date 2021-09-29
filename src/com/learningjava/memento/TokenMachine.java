package com.learningjava.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        return addToken(new Token(value));
    }

    public Memento addToken(Token token) {
        // todo (yes, please do both overloads :)
        tokens.add(token);
        Memento m = new Memento();
        m.tokens = tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
        return m;
    }

    public void revert(Memento m) {
        tokens = m.tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
    }
}
