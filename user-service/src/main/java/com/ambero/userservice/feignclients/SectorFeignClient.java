package com.ambero.userservice.feignclients;

import com.ambero.userservice.model.Sector;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "sector-service", url = "http://sector-service")
public interface SectorFeignClient {

    @RequestMapping(method = RequestMethod.GET, value ="/sector")
    List<Sector> readAll();

}
