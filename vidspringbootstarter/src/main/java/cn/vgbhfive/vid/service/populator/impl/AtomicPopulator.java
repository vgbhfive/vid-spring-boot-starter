package cn.vgbhfive.vid.service.populator.impl;

import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import cn.vgbhfive.vid.service.populator.Populator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子填充器
 *
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
@Qualifier("atomic") // 根据名称获取到本实例
public class AtomicPopulator implements Populator {

    private static final Logger logger = LoggerFactory.getLogger(AtomicPopulator.class);

    public AtomicPopulator() {
        super();
    }

    static class Variant {
        private long sequence = 0;
        private long lastTimeStamp = -1;
    }

    private AtomicReference<Variant> atomic = new AtomicReference(new Variant());

    /**
     * 原子填充器的具体实现方法
     * @param id
     * @param idMeta
     */
    public void populatorID(ID id, IDMeta idMeta) {
        //TODO
    }

    /**
     * 重置原子定位
     */
    public void reset() {
        atomic = new AtomicReference<Variant>(new Variant());
    }
}
