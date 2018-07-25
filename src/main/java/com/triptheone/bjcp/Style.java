/*
 * Style.java
 */
package com.triptheone.bjcp;

import java.util.Set;

import com.google.common.collect.Range;

import lombok.Builder;
import lombok.Data;

/**
 * Style
 * @author Eric Martin
 */
@Data
@Builder
public class Style 
{
    private final String id;
    
    private final String name;
    
    private final Set<String> tags;
    
    private final Range<Float> ibuRange;

    private final Range<Float> ogRange;

    private final Range<Float> fgRange;

    private final Range<Float> srmRange;

    private final Range<Float> abvRange;
    
    public String toShortString()
    {
        return id + " " + name;
    }
}
