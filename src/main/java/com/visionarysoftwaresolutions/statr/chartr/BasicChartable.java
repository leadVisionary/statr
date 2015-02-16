package com.visionarysoftwaresolutions.statr.chartr;

import lombok.NonNull;

final class BasicChartable implements Chartable {
    private final String name;
    private final Dataset d;


    BasicChartable(@NonNull final String name, @NonNull final Dataset dataset) {
        this.name = name;
        d = dataset;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Dataset getDataset() {
        return d;
    }
}
