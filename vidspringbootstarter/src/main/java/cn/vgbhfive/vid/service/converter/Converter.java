package cn.vgbhfive.vid.service.converter;

import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import org.springframework.stereotype.Component;

/**
 * 转换器接口
 *
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
public interface Converter {

    long convert(ID id);

    long doConvert(ID id, IDMeta idMeta);

    ID convert(long id);

    ID doConvert(long id, IDMeta idMeta);

}
