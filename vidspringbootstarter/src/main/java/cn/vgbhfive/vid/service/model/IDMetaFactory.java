package cn.vgbhfive.vid.service.model;

import org.springframework.stereotype.Component;

/**
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
public class IDMetaFactory {

    // TODO 先固定长度后续再根据传入参数可变化
    private static final IDMeta ID_META = new IDMeta((byte)10, (byte)20, (byte)30, (byte)2, (byte)1, (byte)1);

    public static IDMeta getIDMeta() {
        return ID_META;
    }

}
