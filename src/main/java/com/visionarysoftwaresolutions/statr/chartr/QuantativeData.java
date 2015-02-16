package com.visionarysoftwaresolutions.statr.chartr;

import com.visionarysoftwaresolutions.statr.chartr.api.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Master on 2/14/2015.
 */
@RequiredArgsConstructor
public class QuantativeData implements Data<NumericDatum> {
    @Delegate @NonNull private final Collection<NumericDatum> data;

    public Number sum() {
        return data.parallelStream().collect(Collectors.summingDouble(x -> x.doubleValue()));
    }
}
