/*
 * ConnectedStatsOverlap.java
 */
package com.triptheone.bjcp.overlap;

import com.google.common.base.Preconditions;
import com.triptheone.bjcp.Style;

/**
 * ConnectedStatsOverlap
 * @author Eric Martin
 */
public class ConnectedStatsOverlap implements OverlapPredicate 
{
    /**
     * {@inheritDoc}
     */
    public boolean apply(final Style style, final Style alternate) 
    {
        Preconditions.checkNotNull(style);
        Preconditions.checkNotNull(alternate);
        
        if (style.getIbuRange().isConnected(alternate.getIbuRange()) &&
            style.getOgRange().isConnected(alternate.getOgRange()) &&
            style.getFgRange().isConnected(alternate.getFgRange()) &&
            style.getSrmRange().isConnected(alternate.getSrmRange()) &&
            style.getAbvRange().isConnected(alternate.getAbvRange()))
        {
            return true;
        }
        
        return false;
    }    
}
