package org.xjs.dynamic;


import java.util.Collection;

/**
 * Created by Felix Resch on 29-Apr-16.
 */
public interface Pluggable<J extends Pluggable> {

    Collection<Object> __children();

}
