package com.liushuai.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 默认规则是轮询，定义为随机规则，负载均衡算法有七种
        // 注意不要放在被@ComponentScan注解扫描的包或子包中
        return new RandomRule();
    }
}
