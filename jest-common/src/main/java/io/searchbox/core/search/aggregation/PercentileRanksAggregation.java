package io.searchbox.core.search.aggregation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import static io.searchbox.core.search.aggregation.AggregationField.VALUES;

/**
 * @author cfstout
 */
public class PercentileRanksAggregation extends Aggregation<PercentileRanksAggregation> {

    public static final String TYPE = "percentile_ranks";

    private Map<String, Double> percentileRanks;

    public PercentileRanksAggregation(String name, JsonObject percentilesAggregation) {
        super(name, percentilesAggregation);
        percentileRanks = new HashMap<String, Double>();
        JsonObject values = percentilesAggregation.getAsJsonObject(String.valueOf(VALUES));
        for (Map.Entry<String, JsonElement> entry : values.entrySet()) {
            if (!(Double.isNaN(entry.getValue().getAsDouble()))) {
                percentileRanks.put(entry.getKey(), entry.getValue().getAsDouble());
            }
        }
    }

    public Map<String, Double> getPercentileRanks() {
        return percentileRanks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PercentileRanksAggregation that = (PercentileRanksAggregation) o;

        if (!percentileRanks.equals(that.percentileRanks)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return percentileRanks.hashCode();
    }
}
