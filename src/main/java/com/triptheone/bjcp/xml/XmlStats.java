/*
 * XmlStats.java
 */
package com.triptheone.bjcp.xml;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.ToString;

/**
 * XmlStats
 * @author Eric Martin
 */
@Getter
@ToString
public class XmlStats 
{
    @XmlElement(name = "ibu")
    private XmlLowHigh ibu;
        
    @XmlElement(name = "og")
    private XmlLowHigh og;
    
    @XmlElement(name = "fg")
    private XmlLowHigh fg;
    
    @XmlElement(name = "srm")
    private XmlLowHigh srm;

    @XmlElement(name = "abv")
    private XmlLowHigh abv;
}
