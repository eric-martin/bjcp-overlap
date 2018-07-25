/*
 * StyleAdapter.java
 */
package com.triptheone.bjcp;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlStats;
import com.triptheone.bjcp.xml.XmlSubcategory;

import lombok.experimental.UtilityClass;

/**
 * StyleAdapter
 * @author Eric Martin
 */
@UtilityClass
public class StyleAdapter 
{
    /**
     * TODO
     * @param xmlClass TODO
     * @param xmlCategory TODO
     * @param xmlSubcategory TODO
     * @return TODO
     */
    public Style fromXml(final XmlClass xmlClass, final XmlCategory xmlCategory, final XmlSubcategory xmlSubcategory)
    {
        Preconditions.checkNotNull(xmlClass);
        Preconditions.checkNotNull(xmlCategory);
        Preconditions.checkNotNull(xmlSubcategory);
        Preconditions.checkNotNull(xmlSubcategory.getStats());
        
        Style.StyleBuilder builder = Style.builder();
        
        builder.id(xmlSubcategory.getId());
        builder.name(xmlSubcategory.getName());
        
        Iterable<String> tags = Splitter.on(",").trimResults().omitEmptyStrings().split(xmlSubcategory.getTags());
        builder.tags(Sets.newHashSet(tags));
                
        XmlStats stats = xmlSubcategory.getStats();
        
        builder.ibuRange(Range.closed(stats.getIbu().getLow(), stats.getIbu().getHigh()));
        builder.ogRange(Range.closed(stats.getOg().getLow(), stats.getOg().getHigh()));
        builder.fgRange(Range.closed(stats.getFg().getLow(), stats.getFg().getHigh()));
        builder.srmRange(Range.closed(stats.getSrm().getLow(), stats.getSrm().getHigh()));
        builder.abvRange(Range.closed(stats.getAbv().getLow(), stats.getAbv().getHigh()));
                        
        return builder.build();
    }
}
