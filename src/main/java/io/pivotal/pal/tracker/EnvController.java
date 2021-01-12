package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    String cfInstanceIndex;

    String port;

    String memoryLimit;

    String cfInstanceAddr;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                          @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr){
        this.cfInstanceIndex = cfInstanceIndex;
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceAddr = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT", this.port);
        envMap.put("MEMORY_LIMIT", this.memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", this.cfInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR", this.cfInstanceAddr);

        return  envMap;
    }
}
