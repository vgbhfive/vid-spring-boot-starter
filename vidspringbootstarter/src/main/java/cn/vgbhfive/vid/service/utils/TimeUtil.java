package cn.vgbhfive.vid.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2019/08/15
 * @author: Vgbh
 */
public class TimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    public static final long EPOCH = 1420041600000L;

    public static long genTime() {
        return (System.currentTimeMillis() - EPOCH) / 1000;
    }

    public static void validateTimestamp(long lastTimeStamp, long timeStamp) {
        if (timeStamp < lastTimeStamp) {
            if (logger.isErrorEnabled())
                logger.error(String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                                lastTimeStamp - timeStamp));

            throw new IllegalStateException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                            lastTimeStamp - timeStamp));
        }
    }

    public static long tillNextTimeUnit(long lastTimeStamp) {
        long timeStamp = 0;

        if (logger.isInfoEnabled()) {
            logger.error(String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                    lastTimeStamp));
            timeStamp = TimeUtil.genTime();
            while (timeStamp <= lastTimeStamp) {
                timeStamp = TimeUtil.genTime();
            }
        }

        if (logger.isInfoEnabled()) {
            logger.error(String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                    timeStamp));
        }
        return timeStamp;
    }

}
