/*
 * $Id: ChatStringToString.java 19250 2010-08-30 16:53:14Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.hello;

import java.util.Collection;

import org.mule.api.transformer.TransformerException;
import org.mule.management.stats.AllStatistics;
import org.mule.management.stats.FlowConstructStatistics;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

/**
 * <code>NameStringToChatString</code> is a dummy transformer used in the hello world
 * application to transform the ChatString object into a string.
 */
public class AppendStatsToChatString extends AbstractTransformer
{
    public AppendStatsToChatString()
    {
        super();
        this.registerSourceType(DataTypeFactory.create(ChatString.class));
        this.setReturnDataType(DataTypeFactory.create(ChatString.class));
    }

    @Override
    public Object doTransform(Object src, String encoding) throws TransformerException
    {
        ChatString chatString = (ChatString)src;
        
        AllStatistics stats = muleContext.getStatistics();
        Collection<FlowConstructStatistics> flowStats = stats.getServiceStatistics();
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n");
        for (FlowConstructStatistics flowStat : flowStats) {
        	String name = flowStat.getName();
        	long numEvents = flowStat.getTotalEventsReceived();
        	long totalProcessingTime = flowStat.getTotalProcessingTime();
        
        	sb.append("Flow \"").append(name).append("\"\n");
        	sb.append("\tNumber of events: ").append(numEvents).append("\n");
        	sb.append("\tTotal Processing Time: ").append(totalProcessingTime).append("\n");
        	sb.append("\n");
        }
        
        chatString.append(sb.toString());
        return chatString;
    }
}
