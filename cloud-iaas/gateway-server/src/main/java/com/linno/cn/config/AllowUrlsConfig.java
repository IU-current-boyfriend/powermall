package com.linno.cn.config;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "gateway.white")
@Component
@RefreshScope // 当配置文件发生变化时，则重新配置文件属性
public class AllowUrlsConfig {
    private List<String> allowUrls;
}
