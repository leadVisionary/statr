package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Maps;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Master on 2/14/2015.
 */
public class PieChartTest {
    PieChart toTest;
    Chartable data;
    Map<String,Number> variables;

    @Before
    public void setup() {
        variables = Maps.newHashMap();
        variables.put("Action",6000);
        variables.put("Strategy", 11500);
        variables.put("Sport",27500);
        variables.put("Shooter", 3500);
        variables.put("Other",1500);
        data = new BasicChartable("Units Sold Per Genre", new NumericDataset(variables));
        toTest = new PieChart(data);
    }

    @Test
    public void canSliceAppropriately() {
        SmallCircle s = new SmallCircle((short)100);
        PieChart.Pie pie = toTest.create(s);
        final Set<? extends IndependentVariable> vars = data.getDataset().getIndependentVariables();
        final Set<PieChart.Pie.Slice> slices = pie.getSlices();
        assertEquals(vars.size(), slices.size());
        for (final IndependentVariable v : vars) {
            Number proportion = slices.stream()
                                .filter(x-> x.getLabel().equalsIgnoreCase(v.getName()))
                                .findAny().get().getProportionOfPie();
            final double expectedSum = variables.values().parallelStream().collect(Collectors.summingDouble(x -> x.doubleValue()));
            final double currentValueProp = variables.get(v.getName()).doubleValue() / expectedSum;
            assertEquals(currentValueProp * s.area().doubleValue(), proportion.doubleValue(), .001);
        }



    }
}
