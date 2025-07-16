package org.alilopez.dto;

import java.util.ArrayList;
import java.util.List;

public class StatsDTO {
    List<String> labels;
    List<Float> data;

    public StatsDTO(List<String> labels, List<Float> data) {
        this.labels = labels;
        this.data = data;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }
}
