package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Master on 2/15/2015.
 */
class NumericDataset implements Dataset {
    final Map<IndependentVariable, QuantativeData> data;

    NumericDataset(final Map<String, Number> variableNames)
    {
        data = Maps.newHashMap();
        for (final Map.Entry<String,Number> e : variableNames.entrySet()) {
            final NumericDatum datum = new NumericDatum(e.getValue());
            final QuantativeData qd = new QuantativeData(Lists.newArrayList(datum));
            data.put(new IndependentVariable() {
                @Override
                public String getName() {
                    return e.getKey();
                }
            }, qd);
        }
    }
    @Override
    public Set<? extends IndependentVariable> getIndependentVariables() {
        return data.keySet();
    }

    @Override
    public void accept(DatasetVisitor v) {
        v.visit(this);
    }

    @Override
    public QuantativeData getValuesFor(IndependentVariable x) {
        return data.get(x);
    }
}
