/*
 * StatsFilter.java
 */
package com.triptheone.bjcp.filter;

import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlLowHigh;
import com.triptheone.bjcp.xml.XmlStats;
import com.triptheone.bjcp.xml.XmlSubcategory;

/**
 * StatsFilter
 * @author Eric Martin
 */
public class StatsFilter implements FilterPredicate 
{
    public boolean apply(final XmlClass xmlClass, final XmlCategory xmlCategory, final XmlSubcategory xmlSubcategory) 
    {
        XmlStats stats = xmlSubcategory.getStats();
        
        if (stats != null)
        {
            if (lowAndHighNotNull(stats.getIbu()) &&
                lowAndHighNotNull(stats.getOg()) &&
                lowAndHighNotNull(stats.getFg()) &&
                lowAndHighNotNull(stats.getSrm()) &&
                lowAndHighNotNull(stats.getAbv()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean lowAndHighNotNull(final XmlLowHigh lowHigh)
    {
        return (lowHigh != null) && (lowHigh.getLow() != null) && (lowHigh.getHigh() != null);
    }
}
