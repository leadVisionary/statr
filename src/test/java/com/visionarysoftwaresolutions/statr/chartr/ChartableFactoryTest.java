package com.visionarysoftwaresolutions.statr.chartr;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChartableFactoryTest {
    ChartableFactory toTest;
    String name;


    enum UnitsSoldPerGenre implements IndependentVariable {
        OTHER(1500),
        SHOOTER(3500),
        ACTION(6000),
        STRATEGY(11500),
        SPORT(27500);

        final int units;

        UnitsSoldPerGenre(int number) {
            units = number;
        }

        @Override
        public String getName() { return this.name(); }

        Number getUnits() { return units; }
    }

    @Before
    public void setup() {
        name = "Units Sold Per Genre";
        toTest = new ChartableFactory();
    }

    @Test
    public void canMakeAChartableFromNameAndEnum() {
        final Map<String , Number> sold = Maps.newHashMap();
        for(UnitsSoldPerGenre g : UnitsSoldPerGenre.values()) {
            sold.put(g.getName(), g.getUnits());
        }
        final Chartable result = toTest.create(name, sold);
        assertEquals(name, result.getName());
    }
}
