/*
 * PercentageStatsOverlap.java
 */
package com.triptheone.bjcp.overlap;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.triptheone.bjcp.Style;

/**
 * PercentageStatsOverlap
 * @author Eric Martin
 */
public class PercentageStatsOverlap implements OverlapPredicate 
{
    /**
     * {@inheritDoc}
     */
    public boolean apply(final Style style, final Style alternate) 
    {
        if (minPercentOverlap(style.getIbuRange(), alternate.getIbuRange(), 0.5f) && 
            minPercentOverlap(style.getOgRange(), alternate.getOgRange(), 0.5f) &&
            minPercentOverlap(style.getFgRange(), alternate.getFgRange(), 0.5f) &&
            minPercentOverlap(style.getSrmRange(), alternate.getSrmRange(), 0.5f) &&
            minPercentOverlap(style.getAbvRange(), alternate.getAbvRange(), 0.5f))
        {
            return true;
        }
       
        return false;
    }
    
    /**
     * TODO
     * @param styleStat TODO
     * @param alternateStat TODO
     * @return TODO
     */
    private boolean minPercentOverlap(final Range<Float> styleStat, final Range<Float> alternateStat, final float minPercent)
    {
        Preconditions.checkArgument(styleStat.isConnected(alternateStat));
        
        Range<Float> intersection = styleStat.intersection(alternateStat);
        
        float originalRangeSize = styleStat.upperEndpoint() - styleStat.lowerEndpoint();
        float intersectionSize = intersection.upperEndpoint() - intersection.lowerEndpoint();

        return minPercent <= (intersectionSize / originalRangeSize);
    }
}
