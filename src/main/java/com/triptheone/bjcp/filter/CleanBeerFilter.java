/*
 * CleanBeerFilter.java
 */
package com.triptheone.bjcp.filter;

import com.google.common.base.Preconditions;
import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlSubcategory;

/**
 * CleanBeerFilter
 * @author Eric Martin
 */
public class CleanBeerFilter implements FilterPredicate 
{
    /**
     * {@inheritDoc}
     */
    public boolean apply(final XmlClass xmlClass, final XmlCategory xmlCategory, final XmlSubcategory xmlSubcategory) 
    {
        Preconditions.checkNotNull(xmlClass);
        Preconditions.checkNotNull(xmlCategory);
        Preconditions.checkNotNull(xmlSubcategory);

        if (xmlClass.getType().equalsIgnoreCase("beer"))
        {
            if ((!xmlCategory.getId().equalsIgnoreCase("23")) && 
                (!xmlSubcategory.getId().equalsIgnoreCase("27A")) &&
                (!xmlSubcategory.getId().equalsIgnoreCase("27C")) &&
                (!xmlCategory.getId().equalsIgnoreCase("28")))
            {
                return true;
            }
        }
        
        return false;
    }
}
