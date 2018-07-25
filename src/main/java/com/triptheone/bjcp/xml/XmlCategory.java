/*
 * XmlCategory.java
 */
package com.triptheone.bjcp.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.ToString;

/**
 * XmlCategory
 * @author Eric Martin
 */
@Getter
@ToString
public class XmlCategory 
{
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "subcategory")
    private List<XmlSubcategory> subcategories;
}
