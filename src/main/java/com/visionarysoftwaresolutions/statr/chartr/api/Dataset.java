package com.visionarysoftwaresolutions.statr.chartr.api;

import java.util.Set;

/**
 * Created by Master on 2/14/2015.
 */
public interface Dataset {
    Set<? extends IndependentVariable> getIndependentVariables();
    <D extends Data> D getValuesFor(IndependentVariable x);
    void accept(DatasetVisitor v);
}
