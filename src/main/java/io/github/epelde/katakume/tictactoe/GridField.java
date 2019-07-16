package io.github.epelde.katakume.tictactoe;

public class GridField {

    private Player taken = null;

    public boolean isTaken() {
        return taken != null;
    }

    public void take(Player player) throws FieldAlreadyTakenException {
        if (isTaken()) throw new FieldAlreadyTakenException("Field already taken by " + taken);
        this.taken = player;
    }
}
