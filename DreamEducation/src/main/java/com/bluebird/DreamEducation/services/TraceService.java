package com.bluebird.DreamEducation.services;

import com.bluebird.DreamEducation.entities.TraceModel;
import com.bluebird.DreamEducation.repositories.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TraceService {
    @Autowired
    TraceRepository traceRepository;

    public List<TraceModel> getAll(){
      return traceRepository.findAll();

    }

    public void add(String method, Integer statusCode, String url, Instant timeStamp, Long timeTaken, String principal, String session, String requestHeaders, String responseHeaders, String remoteAddress, Byte count){
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
