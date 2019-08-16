package cn.vgbhfive.vid.service.populator.impl;

import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import cn.vgbhfive.vid.service.populator.Populator;
import cn.vgbhfive.vid.service.utils.TimeUtil;
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
        Variant varOld, varNew;
        long timestamp, sequence;

        while (true) {
            varOld = atomic.get();

            timestamp = TimeUtil.genTime();
            TimeUtil.validateTimestamp(varOld.lastTimeStamp, timestamp);

            sequence = varOld.sequence;

            if (timestamp == varOld.lastTimeStamp) {
                sequence++;
                sequence &= idMeta.getSeqBitsMask();
                if (sequence == 0) {
                    timestamp = TimeUtil.tillNextTimeUnit(varOld.lastTimeStamp);
                }
            } else {
                sequence = 0;
            }

            varNew = new Variant();
            varNew.sequence = sequence;
            varNew.lastTimeStamp = timestamp;

            if (atomic.compareAndSet(varOld, varNew)) {
                id.setSeq(sequence);
                id.setTime(timestamp);

                break;
            }

        }
    }

    /**
     * 重置原子定位
     */
    public void reset() {
        atomic = new AtomicReference<Variant>(new Variant());
    }
}
