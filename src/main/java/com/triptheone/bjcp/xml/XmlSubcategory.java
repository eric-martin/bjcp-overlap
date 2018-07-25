/*
 * XmlSubcategory.java
 */
package com.triptheone.bjcp.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.ToString;

/**
 * XmlSubcategory
 * @author Eric Martin
 */
@Getter
@ToString
public class XmlSubcategory 
{
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;
    
    @XmlElement(name = "tags")
    private String tags;
    
    @XmlElement(name = "stats")
    private XmlStats stats;
}
