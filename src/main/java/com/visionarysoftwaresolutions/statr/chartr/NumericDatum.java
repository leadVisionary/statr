package com.visionarysoftwaresolutions.statr.chartr;

import com.visionarysoftwaresolutions.statr.chartr.api.Datum;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

/**
 * Created by Master on 2/14/2015.
 */
@RequiredArgsConstructor
public class NumericDatum extends Number implements Datum {
    @Delegate @NonNull private final Number number;
}
