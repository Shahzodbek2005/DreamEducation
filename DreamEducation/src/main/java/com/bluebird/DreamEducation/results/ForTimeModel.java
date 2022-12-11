package com.bluebird.DreamEducation.results;

import java.util.List;

public class ForTimeModel {

    String title;
    List<StatusResult> counts;
    List<StatusResult> lastCounts;

    public List<StatusResult> getLastCounts() {
        return lastCounts;
    }

    public void setLastCounts(List<StatusResult> lastCounts) {
        this.lastCounts = lastCounts;
    }

    public List<StatusResult> getCounts() {
        return counts;
    }

    public void setCounts(List<StatusResult> counts) {
        this.counts = counts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
