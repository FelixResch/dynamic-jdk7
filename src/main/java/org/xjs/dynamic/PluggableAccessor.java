package org.xjs.dynamic;

import io.femo.support.jdk7.DefaultOptional;
import io.femo.support.jdk7.Optional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by felix on 7/11/16.
 */
public final class PluggableAccessor {

    public static <T, J extends Pluggable<? extends J>> Optional<T> getFirst(J pluggable, Class<T> type) {
        Collection<Object> children = pluggable.__children();
        for(Object child : children) {
            if(type.isAssignableFrom(child.getClass())) {
                return new DefaultOptional<>(type.cast(child));
            }
        }
        return new DefaultOptional<>();
    }

    public static <T, J extends Pluggable<? extends J>> List<T> get(J pluggable, Class<T> type) {
        Collection<Object> children = pluggable.__children();
        ArrayList<T> list = new ArrayList<>();
        for(Object child : children) {
            if(type.isAssignableFrom(child.getClass())) {
                list.add(type.cast(child));
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static <T, J extends Pluggable<? extends J>> J removeAll(J pluggable, Class<T> type) {
        Iterator iterator = pluggable.__children().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if(type.isAssignableFrom(object.getClass())) {
                iterator.remove();
            }
        }
        return pluggable;
    }

    @SuppressWarnings("unchecked")
    public static <J extends Pluggable<? extends J>> J reset(J pluggable) {
        pluggable.__children().clear();
        return pluggable;
    }

    @SuppressWarnings("unchecked")
    public static  <T, J extends Pluggable<? extends J>> J add(J pluggable, T object) {
        pluggable.__children().add(object);
        return pluggable;
    }
}
