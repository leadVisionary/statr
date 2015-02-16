package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class NumericDatasetSumVisitorTest {
    Dataset toVisit;
    NumericDatasetSumVisitor toTest;
    Map<String,Number> variables;

    @Before
    public void setup() {
        variables = Maps.newHashMap();
        variables.put("Action",6000);
        variables.put("Strategy", 11500);
        variables.put("Sport",27500);
        variables.put("Shooter", 3500);
        variables.put("Other",1500);
        toVisit = new NumericDataset(variables);
        toTest = new NumericDatasetSumVisitor();
    }

    @Test
    public void canCalculateSum() {
        toTest.visit(toVisit);
        final Number sum = toTest.getSum();
        assertEquals(
                variables.values().stream().collect(Collectors.summingDouble(x -> x.doubleValue())),
                sum);

    }

}
