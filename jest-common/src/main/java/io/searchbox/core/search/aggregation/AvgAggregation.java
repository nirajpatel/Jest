package io.searchbox.core.search.aggregation;

import com.google.gson.JsonObject;

import static io.searchbox.core.search.aggregation.AggregationField.VALUE;

/**
 * @author cfstout
 */
public class AvgAggregation extends SingleValueAggregation<AvgAggregation> {

    public static final String TYPE = "avg";

    public <T extends Aggregation> AvgAggregation(String name, JsonObject avgAggregation) {
        super(name, avgAggregation);
    }

    /**
     * @return Average if it was found and not null, null otherwise
     */
    public Double getAvg() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvgAggregation)) {
            return false;
        }
        return super.equals(o);
    }
}
