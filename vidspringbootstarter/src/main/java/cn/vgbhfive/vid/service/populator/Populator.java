package cn.vgbhfive.vid.service.populator;

import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import org.springframework.stereotype.Component;

/**
 * 填充器接口
 *
 * @time: 2019/8/15
 * @author: Vgbh
 */
@Component
public interface Populator {

    void populatorID(ID id, IDMeta idMeta);

    void reset();

}
