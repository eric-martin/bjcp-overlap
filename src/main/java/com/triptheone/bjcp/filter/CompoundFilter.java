/*
 * CompoundFilter.java
 */
package com.triptheone.bjcp.filter;

import java.util.List;

import com.google.common.base.Preconditions;
import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlSubcategory;

/**
 * CompoundFilter
 * @author Eric Martin
 */
public class CompoundFilter implements FilterPredicate 
{
    private final List<FilterPredicate> predicates;
    
    public CompoundFilter(final List<FilterPredicate> predicates)
    {
        Preconditions.checkNotNull(predicates);
        
        this.predicates = predicates;
    }

    public boolean apply(final XmlClass xmlClass, final XmlCategory xmlCategory, final XmlSubcategory xmlSubcategory) 
    {
        for (FilterPredicate predicate : predicates)
        {
            if (!predicate.apply(xmlClass, xmlCategory, xmlSubcategory))
            {
                return false;
            }
        }
        
        return true;
    }
}
