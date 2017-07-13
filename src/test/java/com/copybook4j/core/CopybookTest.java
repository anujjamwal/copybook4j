package com.copybook4j.core;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anujjamwal on 12/07/17.
 */
public class CopybookTest {
    @Test
    public void shouldParseToGenerateCopybook() throws IOException {
        Copybook copybook = Copybook.fromContent("    01     Employee.\n        05   Name  PIC XXXXXXXXXXXXX");

        assertThat(copybook.level(), is(1));
        assertThat(copybook.name(), is("Employee"));
    }
}