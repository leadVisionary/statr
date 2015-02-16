package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Sets;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Master on 2/14/2015.
 */
public class ChartableFactory {
    public Chartable create(@NonNull final String name,
                            @NonNull final Map<String, Number> variables) {
        final Dataset d = new NumericDataset(variables);
        return new BasicChartable(name, d);
    }
}
