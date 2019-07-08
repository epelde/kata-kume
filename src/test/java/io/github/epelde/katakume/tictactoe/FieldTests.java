package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTests {

    @Test
    public void Two_Fields_With_Different_Coordinates_Are_Different() {
        Field f1 = new Field(1, 1);
        Field f2 = new Field(1, 2);
        assertNotEquals(f1, f2);
    }

    @Test
    public void Two_Fields_With_Same_Coordinates_Are_Equals() {
        Field f1 = new Field(1, 1);
        Field f2 = new Field(1, 1);
        assertEquals(f1, f2);
    }

}
