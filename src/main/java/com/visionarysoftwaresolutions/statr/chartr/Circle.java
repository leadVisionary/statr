package com.visionarysoftwaresolutions.statr.chartr;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by Master on 2/14/2015.
 */
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public abstract class Circle {
    @NonNull private final Number radius;

    public Number getRadius() { return radius; }
    public Number diameter() { return getRadius().doubleValue() * 2; };
    public Number circumference() { return Math.PI * diameter().doubleValue(); };
    public Number area() { return Math.PI * Math.pow(getRadius().doubleValue(), 2);}
}
