/*
 * FilterPredicate.java
 */
package com.triptheone.bjcp.filter;

import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlSubcategory;

/**
 * FilterPredicate
 * @author Eric Martin
 */
public interface FilterPredicate 
{
    /**
     * TODO
     * @param xmlClass TODO
     * @param xmlCategory TODO
     * @param xmlSubcategory TODO
     * @return TODO
     */
    boolean apply(final XmlClass xmlClass, final XmlCategory xmlCategory, final XmlSubcategory xmlSubcategory); 
}
