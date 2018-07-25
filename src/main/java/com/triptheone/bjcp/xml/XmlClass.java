/*
 * XmlClass.java
 */
package com.triptheone.bjcp.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.ToString;

/**
 * XmlClass
 * @author Eric Martin
 */
@Getter
@ToString
public class XmlClass 
{
    @XmlAttribute(name = "type")
    private String type;

    @XmlElement(name = "category")
    private List<XmlCategory> categories;
}
