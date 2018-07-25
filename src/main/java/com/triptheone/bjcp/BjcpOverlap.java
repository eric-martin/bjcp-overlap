/*
 * BjcpOverlap.java
 */
package com.triptheone.bjcp;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.triptheone.bjcp.filter.CleanBeerFilter;
import com.triptheone.bjcp.filter.CompoundFilter;
import com.triptheone.bjcp.filter.FilterPredicate;
import com.triptheone.bjcp.filter.StatsFilter;
import com.triptheone.bjcp.overlap.CompoundOverlap;
import com.triptheone.bjcp.overlap.ConnectedStatsOverlap;
import com.triptheone.bjcp.overlap.OverlapPredicate;
import com.triptheone.bjcp.overlap.PercentageStatsOverlap;
import com.triptheone.bjcp.overlap.TagsOverlap;
import com.triptheone.bjcp.xml.XmlCategory;
import com.triptheone.bjcp.xml.XmlClass;
import com.triptheone.bjcp.xml.XmlStyleguide;
import com.triptheone.bjcp.xml.XmlSubcategory;

import lombok.extern.slf4j.Slf4j;

/**
 * BjcpOverlap
 * @author Eric Martin
 */
@Slf4j
public class BjcpOverlap 
{
    public static void main(final String[] args) throws Exception 
    {
        // get the styleguide file
        
        ClassLoader classLoader = BjcpOverlap.class.getClassLoader();
        File xmlFile = new File(classLoader.getResource("2015_styleguide.xml").getFile());

        // read the file into our xml objects
        
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlStyleguide.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        XmlStyleguide styleguide = (XmlStyleguide) jaxbUnmarshaller.unmarshal(xmlFile);

        // flatten the xml into a list of styles we are interested in
        
        List<Style> styles = Lists.newArrayList();
        
        FilterPredicate predicate = new CompoundFilter(Lists.newArrayList(new CleanBeerFilter(), 
                                                                          new StatsFilter()));
        
        for (XmlClass xmlClass : styleguide.getClasses())
        {
            for (XmlCategory xmlCategory : xmlClass.getCategories())
            {
                for (XmlSubcategory xmlSubcategory : xmlCategory.getSubcategories())
                {
                    if (predicate.apply(xmlClass, xmlCategory, xmlSubcategory))
                    {
                        Style style = StyleAdapter.fromXml(xmlClass, xmlCategory, xmlSubcategory);
                        
                        log.debug(style.toString());
                        
                        styles.add(style);
                    }
                }               
            }
        }
        
        // determine overlapping styles
        
        OverlapPredicate strategy = new CompoundOverlap(Lists.newArrayList(new ConnectedStatsOverlap(), 
                                                                           new PercentageStatsOverlap(),
                                                                           new TagsOverlap()));
        
        for (Style style : styles)
        {
            List<Style> overlaps = Lists.newArrayList();
            
            for (Style alternate : styles)
            {
                if (!style.equals(alternate))
                {
                    if (strategy.apply(style, alternate))
                    {
                        overlaps.add(alternate);
                    }
                }
            }
            
            // output results
            
            System.out.print(style.toShortString());
            System.out.print(": ");
            
            if (!overlaps.isEmpty())
            {
                List<String> names = Lists.newArrayList();
                
                for (Style overlap : overlaps)
                {
                    names.add(overlap.toShortString());
                }
                
                System.out.print(Joiner.on(", ").join(names));
            }
            else
            {
                System.out.print("N/A");
            }
                        
            System.out.println();
        }
        
        // done
        
        return;
    }
}
