package org.xjs.dynamic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Felix Resch on 29-Apr-16.
 */
public class TestObject implements Pluggable<TestObject> {

    private List<Object> children;

    @Override
    public Collection<Object> __children() {
        if(children == null) {
            children = new ArrayList<>();
        }
        return children;
    }
}
