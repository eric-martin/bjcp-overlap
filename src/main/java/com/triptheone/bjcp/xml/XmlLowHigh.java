/*
 * XmlLowHigh.java
 */
package com.triptheone.bjcp.xml;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.ToString;

/**
 * XmlLowHigh
 * @author Eric Martin
 */
@Getter
@ToString
public class XmlLowHigh 
{
    @XmlElement(name = "low")
    private Float low;

    @XmlElement(name = "high")
    private Float high;
}
