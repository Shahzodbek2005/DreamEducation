package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.TraceModel;
import com.bluebird.DreamEducation.repositories.TraceRepository;
import com.bluebird.DreamEducation.results.ForTimeModel;
import com.bluebird.DreamEducation.results.StatusResult;
import com.bluebird.DreamEducation.results.TopRankModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TraceService {
    @Autowired
    TraceRepository traceRepository;

    public ForTimeModel getAllStats(String type) {
        ForTimeModel timeModel = new ForTimeModel();
        List<List<Object>> thisTimeUpdated = new ArrayList<>();
        List<List<Object>> lastTimeUpdated = new ArrayList<>();
        String title = "";
        switch (type) {
            case "w":
                title = "Weekly";
                thisTimeUpdated = traceRepository.getStatusCodes(7, 0);
                lastTimeUpdated = traceRepository.getStatusCodes(14, 7);
                break;
            case "m":
                title = "Monthly";
                thisTimeUpdated = traceRepository.getStatusCodes(30, 0);
                lastTimeUpdated = traceRepository.getStatusCodes(60, 30);
                break;
            case "y":
                title = "Yearly";
                thisTimeUpdated = traceRepository.getStatusCodes(365, 0);
                lastTimeUpdated = traceRepository.getStatusCodes(730, 365);
                break;
        }
        // shu vaqt malumotlari
        List<StatusResult> data = new ArrayList<>();
        StatusResult data200 = new StatusResult();
        StatusResult data400 = new StatusResult();
        StatusResult data404 = new StatusResult();
        StatusResult data500 = new StatusResult();
        // o'tgan vaqt malumotlari
        List<StatusResult> lastData = new ArrayList<>();
        StatusResult lastData200 = new StatusResult();
        StatusResult lastData400 = new StatusResult();
        StatusResult lastData404 = new StatusResult();
        StatusResult lastData500 = new StatusResult();

        int count200 = 0;
        int count500 = 0;
        int count400 = 0;
        int count404 = 0;

        int lastCount200 = 0;
        int lastCount400 = 0;
        int lastCount500 = 0;
        int lastCount404 = 0;

        String updated200 = "0";
        String updated400 = "0";
        String updated404 = "0";
        String updated500 = "0";

        String lastUpdated200 = "0";
        String lastUpdated400 = "0";
        String lastUpdated404 = "0";
        String lastUpdated500 = "0";

        final String s = "[[1, 2022-11-27 09:57:19.233, 200]]";

        if (!(thisTimeUpdated.isEmpty() && lastTimeUpdated.isEmpty())) {
            for (List<Object> item : thisTimeUpdated) {
                if (((int) item.get(2)) == 200) {
                    count200 = ((BigInteger) item.get(0)).intValue();
                    updated200 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 400) {
                    count400 = ((BigInteger) item.get(0)).intValue();
                    updated400 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 404) {
                    count404 = ((BigInteger) item.get(0)).intValue();
                    updated404 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 2500) {
                    count500 = ((BigInteger) item.get(0)).intValue();
                    updated500 = ((Timestamp) item.get(1)).toInstant().toString();
                }
            }

            for (List<Object> item : lastTimeUpdated) {
                if (((int) item.get(2)) == 200) {
                    lastCount200 = ((BigInteger) item.get(0)).intValue();
                    lastUpdated200 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 400) {
                    lastCount400 = ((BigInteger) item.get(0)).intValue();
                    lastUpdated400 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 404) {
                    lastCount404 = ((BigInteger) item.get(0)).intValue();
                    lastUpdated404 = ((Timestamp) item.get(1)).toInstant().toString();
                } else if (((int) item.get(2)) == 2500) {
                    lastCount500 = ((BigInteger) item.get(0)).intValue();
                    lastUpdated500 = ((Timestamp) item.get(1)).toInstant().toString();
                }
            }
        }


        // shu hafta ma'lumotlarini modellarga joylash
        data200.setStatusCode(200);
        data200.setCount(count200);
        data200.setUpdated(updated200);

        data400.setStatusCode(400);
        data400.setCount(count400);
        data400.setUpdated(updated400);

        data404.setStatusCode(404);
        data404.setCount(count404);
        data404.setUpdated(updated404);

        data500.setStatusCode(500);
        data500.setCount(count500);
        data500.setUpdated(updated500);

        data.add(data200);
        data.add(data400);
        data.add(data404);
        data.add(data500);

        // o'tgan hafta ma'lumotlarini modellarga joylash
        lastData200.setStatusCode(200);
        lastData200.setCount(lastCount200);
        lastData200.setUpdated(lastUpdated200);

        lastData400.setStatusCode(400);
        lastData400.setCount(lastCount400);
        lastData400.setUpdated(lastUpdated400);

        lastData404.setStatusCode(404);
        lastData404.setCount(lastCount404);
        lastData404.setUpdated(lastUpdated404);

        lastData500.setStatusCode(500);
        lastData500.setCount(lastCount500);
        lastData500.setUpdated(lastUpdated500);

        lastData.add(lastData200);
        lastData.add(lastData400);
        lastData.add(lastData404);
        lastData.add(lastData500);

        // umumiy ma'lumotlarni modelga joylash
        timeModel.setTitle(title);
        timeModel.setCounts(data);
        timeModel.setLastCounts(lastData);

        return timeModel;
    }

    public List<TraceModel> getTraces(String type) {
        switch (type) {
            case "w":
                return traceRepository.findByDate(7, 0);
            case "m":
                return traceRepository.findByDate(30, 0);
            case "y":
                return traceRepository.findByDate(365, 0);
            default:
                return null;
        }
    }

    public List<TopRankModel> topRank(String type) {
        List<List<Object>> topRankThisWeek = new ArrayList<>();
        List<TopRankModel> topRankModelList = new ArrayList<>();
        switch (type) {
            case "w":
                topRankThisWeek = traceRepository.topRank(7, 0);
                break;
            case "m":
                topRankThisWeek = traceRepository.topRank(30, 0);
                break;
            case "y":
                topRankThisWeek = traceRepository.topRank(365, 0);
                break;
        }
        if (!topRankThisWeek.isEmpty()) {
            for (List<Object> objects : topRankThisWeek) {
                TopRankModel topRankModel = new TopRankModel();
                topRankModel.setCount(((BigInteger) objects.get(0)).intValue());
                topRankModel.setUrl((String) objects.get(1));
                topRankModel.setCountOk(Integer.valueOf(((String) objects.get(2))));
                topRankModel.setStat("N/A");
                topRankModelList.add(topRankModel);
            }
        }

        return topRankModelList;
    }

    public void add(String method, Integer statusCode, String url, Instant timeStamp, Long timeTaken, String principal, String session, String requestHeaders, String responseHeaders, String remoteAddress, Byte count) {
    TraceModel traceModel = new TraceModel();
        traceModel.setMethod(method);
        traceModel.setStatusCode(statusCode);
        traceModel.setUrl(url);
        traceModel.setTimestamp(timeStamp);
        traceModel.setTimeTaken(timeTaken);
        traceModel.setPrincipal(principal);
        traceModel.setSession(session);
        traceModel.setRequestHeaders(requestHeaders);
        traceModel.setResponseHeaders(responseHeaders);
        traceModel.setRemoteAddress(remoteAddress);
        traceModel.setCount(count);
        traceRepository.save(traceModel);
    }

}
