package cn.vgbhfive.vid.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置参数类
 *
 * @time: 2019/08/14
 * @author: Vgbh
 */
@Data
@ConfigurationProperties("spring.vid") // 配置参数前缀
public class IDProperties {

    private Long machine;

    private Long genMethod;

    private Long type;

    private Long version;

}
