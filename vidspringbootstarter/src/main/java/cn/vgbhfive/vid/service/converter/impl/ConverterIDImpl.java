package cn.vgbhfive.vid.service.converter.impl;

import cn.vgbhfive.vid.service.converter.Converter;
import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 由Populator 填充器填充ID ，再由Converter 转换ID 为Long 类型数据
 * 或者根据Long 类型数据转换成ID
 *
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
public class ConverterIDImpl implements Converter {

    private static final Logger logger = LoggerFactory.getLogger(ConverterIDImpl.class);

    private IDMeta idMeta;

    public ConverterIDImpl() {
    }

    public ConverterIDImpl(IDMeta idMeta) {
        this.idMeta = idMeta;
    }

    /**
     * ID -> Long
     * @param id
     * @return Long
     */
    public long convert(ID id) {
        return doConvert(id, this.idMeta);
    }

    /**
     * 负责具体由ID 转换为Long
     * @param id
     * @param idMeta
     * @return Long
     */
    public long doConvert(ID id, IDMeta idMeta) {
        long result = 0;

        result |= id.getMachine();
        result |= id.getSeq() << idMeta.getSeqBitsStartPos();
        result |= id.getTime() << idMeta.getTimeBitsStartPos();
        result |= id.getGenMethod() << idMeta.getGenMethodBitsStartPos();
        result |= id.getType() << idMeta.getTypeBitsStartPos();
        result |= id.getVersion() << idMeta.getVersionBitsStartPos();

        if (logger.isDebugEnabled()) {
            logger.debug(" ID ---> Long  return:" + result);
        }

        return result;
    }

    /**
     * Long -> ID
     * @param id
     * @return ID
     */
    public ID convert(long id) {
        return doConvert(id, this.idMeta);
    }

    /**
     * 负责具体由Long 转换为ID
     * @param id
     * @param idMeta
     * @return ID
     */
    public ID doConvert(long id, IDMeta idMeta) {
        ID result = new ID();

        result.setMachine(id & idMeta.getMachineBitsMask());
        result.setSeq((id >>> idMeta.getSeqBitsStartPos()) & idMeta.getSeqBitsMask());
        result.setTime((id >>> idMeta.getTimeBitsStartPos()) & idMeta.getTimeBitsMask());
        result.setGenMethod((id >>> idMeta.getGenMethodBitsStartPos()) & idMeta.getGenMethodBitsMask());
        result.setType((id >>> idMeta.getTypeBitsStartPos()) & idMeta.getTypeBitsMask());
        result.setVersion((id >>> idMeta.getVersionBitsStartPos()) & idMeta.getVersionBitsMask());

        if (logger.isDebugEnabled()) {
            logger.debug(" Long ---> ID  return:" + result.toString());
        }

        return result;
    }
}
