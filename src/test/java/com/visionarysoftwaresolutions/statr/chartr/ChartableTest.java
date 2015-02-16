package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Maps;
import com.visionarysoftwaresolutions.statr.chartr.api.Chartable;
import com.visionarysoftwaresolutions.statr.chartr.api.Dataset;
import com.visionarysoftwaresolutions.statr.chartr.api.IndependentVariable;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChartableTest {
    Chartable toTest;

    @Test
    public void canGetName() {
        final String chartName = "Units Sold per Genre";
        final Map<String, Number> labels = Maps.newHashMap();
        toTest = new BasicChartable(chartName, new NumericDataset(labels));
        assertEquals(chartName, toTest.getName());
    }

    @Test
    public void canGetIndependentVariables() {
        final Map<String,Number> variables = Maps.newHashMap();
        variables.put("Action",0);
        variables.put("Strategy", 0);
        variables.put("Sport",0);
        variables.put("Shooter", 0);
        variables.put("Other",0);
        toTest = new BasicChartable("", new NumericDataset(variables));
        for (IndependentVariable x : toTest.getDataset().getIndependentVariables()) {
            assertTrue(variables.keySet().contains(x.getName()));
        }
    }

    @Test
    public void canGetValuesForIndependentVariables() {
        final Map<String,Number> variables = Maps.newHashMap();
        variables.put("Action",6000);
        variables.put("Strategy", 11500);
        variables.put("Sport",27500);
        variables.put("Shooter", 3500);
        variables.put("Other",1500);
        toTest = new BasicChartable("", new NumericDataset(variables));
        final Dataset s = toTest.getDataset();
        for (IndependentVariable x : s.getIndependentVariables()) {
            QuantativeData qd = s.getValuesFor(x);
            assertEquals(variables.get(x.getName()).doubleValue(), qd.sum().doubleValue(), .001);
        }
    }

}
