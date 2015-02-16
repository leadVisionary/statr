package com.visionarysoftwaresolutions.statr.chartr;

import lombok.NonNull;

/**
 * Created by Master on 2/15/2015.
 */
public class NumericDatasetSumVisitor implements DatasetVisitor {
    private Number sum = 0;

    @Override
    public void visit(@NonNull final Dataset d) {
        for(IndependentVariable v : d.getIndependentVariables()) {
            final QuantativeData qd = d.getValuesFor(v);
            sum = sum.doubleValue() + qd.sum().doubleValue();
        }
    }

    public Number getSum() {
        return sum;
    }
}
