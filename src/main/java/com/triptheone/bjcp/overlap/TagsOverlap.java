/*
 * TagsOverlap.java
 */
package com.triptheone.bjcp.overlap;

import java.util.Set;

import com.google.common.collect.Sets;
import com.triptheone.bjcp.Style;

/**
 * TagsOverlap
 * @author Eric Martin
 */
public class TagsOverlap implements OverlapPredicate 
{
    /**
     * {@inheritDoc}
     */
    public boolean apply(final Style style, final Style alternate) 
    {
        Set<String> tagsIntersection = Sets.intersection(style.getTags(), alternate.getTags());
        
        return 0.5f <= ((float) tagsIntersection.size() / style.getTags().size());
    }
}
