package ua.lviv.lgs.pv.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

@Test
void getMessage() {
    String expected = "Message";
    String actual = new Service().getMessage();
    assertEquals(expected, actual);
}
}
