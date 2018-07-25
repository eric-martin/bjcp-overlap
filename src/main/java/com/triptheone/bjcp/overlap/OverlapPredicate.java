/*
 * OverlapPredicate.java
 */
package com.triptheone.bjcp.overlap;

import com.triptheone.bjcp.Style;

/**
 * OverlapPredicate
 * @author Eric Martin
 */
public interface OverlapPredicate 
{
    /**
     * TODO
     * @param style TODO
     * @param alternate TODO
     * @return TODO
     */
    boolean apply(final Style style, final Style alternate);
}
