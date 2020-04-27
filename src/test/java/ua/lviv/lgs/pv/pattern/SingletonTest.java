package ua.lviv.lgs.pv.pattern;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class SingletonTest {

    @Test
    void testSingleton() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        assertSame(singleton, singleton2);
    }

}