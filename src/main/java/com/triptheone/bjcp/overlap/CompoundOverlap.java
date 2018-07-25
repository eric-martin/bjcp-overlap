/*
 * CompoundOverlap.java
 */
package com.triptheone.bjcp.overlap;

import java.util.List;

import com.google.common.base.Preconditions;
import com.triptheone.bjcp.Style;

/**
 * CompoundOverlap
 * @author Eric Martin
 */
public class CompoundOverlap implements OverlapPredicate 
{
    private final List<OverlapPredicate> predicates;
    
    public CompoundOverlap(final List<OverlapPredicate> predicates)
    {
        Preconditions.checkNotNull(predicates);
        
        this.predicates = predicates;
    }

    /**
     * {@inheritDoc}
     */
    public boolean apply(final Style style, final Style alternate) 
    {
        for (OverlapPredicate predicate : predicates)
        {
            if (!predicate.apply(style, alternate))
            {
                return false;
            }
        }
        
        return true;
    }

}
