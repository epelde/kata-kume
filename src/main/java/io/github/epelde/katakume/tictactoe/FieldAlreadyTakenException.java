package io.github.epelde.katakume.tictactoe;

public class FieldAlreadyTakenException extends Exception {

    public FieldAlreadyTakenException(String message) {
        super(message);
    }
}
