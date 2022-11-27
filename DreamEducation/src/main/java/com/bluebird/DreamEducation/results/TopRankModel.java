package com.bluebird.DreamEducation.results;

public class TopRankModel {
    Integer count;
    Integer countOk = 0;
    String url;
    String stat;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountOk() {
        return countOk;
    }

    public void setCountOk(Integer countOk) {
        this.countOk = countOk;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
