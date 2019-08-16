package cn.vgbhfive.vid.config;

import cn.vgbhfive.vid.client.VID;
import cn.vgbhfive.vid.properties.IDProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @time: 2019/08/14
 * @author: Vgbh
 */
@Configuration
@EnableConfigurationProperties(IDProperties.class)
@ComponentScan("cn.vgbhfive.vid")
public class VIDAutoConfigure {

    private static final Logger logger = LoggerFactory.getLogger(VIDAutoConfigure.class);

    @Bean
    public VID vid(IDProperties idProperties) {
        logger.info("  ----- VIDAutoConfigure Executed! -----  ");
        return new VID(idProperties);
    }

}
