package com.bluebird.DreamEducation.actuator;

import com.bluebird.DreamEducation.services.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HttpTraceActuatorConfiguration {
    @Autowired
    TraceService traceService;
    @Bean
    public HttpTraceRepository httpTraceRepository() {


        return new HttpTraceRepository() {
            @Override
            public List<HttpTrace> findAll() {
                return null;
            }

            @Override
            public void add(HttpTrace trace) {
                if (!trace.getRequest().getUri().getPath().contains("actuator")) {
                    String getPrincipalName = trace.getPrincipal() == null ? null : trace.getPrincipal().getName();
                    String getSessionName = trace.getSession() == null ? null : trace.getSession().getId();
                    traceService.add(
                            trace.getRequest().getMethod(),
                            trace.getResponse().getStatus(),
                            (trace.getRequest().getUri().getAuthority() + trace.getRequest().getUri().getPath()),
                            trace.getTimestamp(),
                            trace.getTimeTaken(),
                            getPrincipalName,
                            getSessionName,
                            trace.getRequest().getHeaders().toString(),
                            trace.getResponse().getHeaders().toString(),
                            trace.getRequest().getRemoteAddress(),
                            (byte) 1
                    );
                }
            }
        };
    }
}
