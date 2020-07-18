package com.md.it.framework.config.swagger2;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description 自定义swagger2配置
 * @Author TuMinglong
 * @Date 2019/6/1 17:13
 */
@Data
@ConfigurationProperties(prefix = "hdw.swagger2")
public class HdwSwaggerProperties {

    /**
     * 是否启用swagger,生产环境建议关闭
     */
    private boolean enabled;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档描述
     */
    private String description;

    /**
     * 版本
     */
    private String version;
    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 客户端密钥
     */
    private String clientSecret;
    /**
     * 客户端授权范围
     */
    private String scope;
    /**
     * 获取token
     */
    private String accessTokenUri;
    /**
     * 认证地址
     */
    private String userAuthorizationUri;

    private List<String> ignores = Lists.newArrayList();
}
