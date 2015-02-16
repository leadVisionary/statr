package com.visionarysoftwaresolutions.statr.chartr;

import com.visionarysoftwaresolutions.statr.chartr.api.Chartable;
import com.visionarysoftwaresolutions.statr.chartr.api.Dataset;
import lombok.NonNull;

import java.util.Map;

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
