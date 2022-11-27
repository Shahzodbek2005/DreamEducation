package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.TraceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceRepository extends JpaRepository<TraceModel, Long> {

    @Query(value = "select * from http_trace where url = :url and dayofyear(timestamp) between dayofyear(now()) - :first and dayofyear(now()) - :last", nativeQuery = true)
    List<TraceModel> findByUrl(@Param("url") String url, @Param("first") Integer first, @Param("last") Integer last);


    @Query(value = "select * from http_trace where dayofyear(timestamp) between dayofyear(now()) - :first and dayofyear(now()) - :last", nativeQuery = true)
    List<TraceModel> findByDate(@Param("first") Integer first, @Param("last") Integer last);

    @Query(value = "select  count(count) as count, max(timestamp), status_code from http_trace where dayofyear(timestamp) between dayofyear(now()) - :first and dayofyear(now()) - :last group by status_code order by count desc", nativeQuery = true)
    List<List<Object>> getStatusCodes(@Param("first") Integer first, @Param("last") Integer last);

    @Query(value = "select count as jami, url1 as url,  coalesce(soni200, \"0\") as jami200 from (select count(count) as count, url as url1 from http_trace where dayofyear(timestamp) between dayofyear(now()) - :first and dayofyear(now()) - :last group by url order  by count desc) as T1 left join (select  url as url2 , count(count) soni200 from http_trace where status_code = 200 and dayofyear(timestamp) between dayofyear(now()) - :first and dayofyear(now()) - :last group by url) as T2 on T1.url1 = T2.url2 order by count desc limit 5", nativeQuery = true)
    List<List<Object>> topRank(@Param("first") Integer first, @Param("last") Integer last);
}
