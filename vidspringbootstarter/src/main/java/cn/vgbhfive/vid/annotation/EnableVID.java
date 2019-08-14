package cn.vgbhfive.vid.annotation;

import cn.vgbhfive.vid.config.VIDAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @time: 2019/08/14
 * @author: Vgbh
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({VIDAutoConfigure.class})
public @interface EnableVID {
}
