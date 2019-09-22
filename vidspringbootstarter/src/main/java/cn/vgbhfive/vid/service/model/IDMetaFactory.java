package cn.vgbhfive.vid.service.model;

import org.springframework.stereotype.Component;

/**
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
public class IDMetaFactory {

	/**
	 * 最大峰值型
	 */
    private static final IDMeta ID_META_MAX_PEAK = new IDMeta((byte)10, (byte)20, (byte)30, (byte)2, (byte)1, (byte)1);

	/**
	 * 最小粒度型
	 */
	private static final IDMeta ID_META_MIN_GRANULARITY = new IDMeta((byte)10, (byte)30, (byte)20, (byte)2, (byte)1, (byte)1);

    public static IDMeta getIDMeta(Long type) {
    	if (type == 1) {
			return ID_META_MAX_PEAK;
		} else if (type == 0) {
    		return ID_META_MIN_GRANULARITY;
		} else {
			return ID_META_MAX_PEAK;
		}
    }

}
