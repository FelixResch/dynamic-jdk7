package org.xjs.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Felix Resch on 29-Apr-16.
 */
public class PluggableTest {

    @Test
    public void testObject() throws Exception {
        TestObject testObject = new TestObject();
        Object object = new Object();
        PluggableAccessor.add(testObject, object);
        assertEquals(object, PluggableAccessor.getFirst(testObject, Object.class).get());
    }
}