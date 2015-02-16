package com.visionarysoftwaresolutions.statr.chartr;


import com.google.common.collect.Sets;
import com.visionarysoftwaresolutions.statr.chartr.api.Chartable;
import com.visionarysoftwaresolutions.statr.chartr.api.Dataset;
import com.visionarysoftwaresolutions.statr.chartr.api.IndependentVariable;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Master on 2/14/2015.
 */
public class PieChart {
    final Chartable data;
    public PieChart(@NonNull final Chartable data) {
        this.data = data;
    }

    public Pie create(@NonNull final Circle circle){
        return new Pie(circle, data);
    }

    public class Pie {
        private final Circle c;
        private final Chartable d;
        private final Set<Slice> slices;

        public class Slice {
            private final String label;
            private final Number proportionOfPie;

            private Slice(final String name, final Number prop){
                label = name;
                proportionOfPie = prop;
            }

            public String getLabel() { return label; }
            public Number getProportionOfPie() { return proportionOfPie; }
        }

        private Pie(final Circle circle, final Chartable data) {
            c = circle;
            d = data;
            final Dataset s = d.getDataset();
            slices = Sets.newHashSetWithExpectedSize(s.getIndependentVariables().size());
            for (final IndependentVariable x : s.getIndependentVariables()) {
                slices.add(new Slice(x.getName(), proportionOfWhole(x)));
            }
        }

        public Set<Slice> getSlices() {
            return Sets.newHashSet(slices);
        }

        private Number proportionOfWhole(final IndependentVariable x) {
            // x / area = value for x / sum
            final Dataset s = d.getDataset();
            final NumericDatasetSumVisitor summer = new NumericDatasetSumVisitor();
            summer.visit(s);
            final Number sum = summer.getSum();
            final QuantativeData qd = s.getValuesFor(x);
            final BigDecimal dividedBySum = BigDecimal.valueOf(qd.sum().doubleValue())
                                            .divide(BigDecimal.valueOf(sum.doubleValue()));
            return dividedBySum.multiply(BigDecimal.valueOf(c.area().doubleValue()));
        }
    }
}
