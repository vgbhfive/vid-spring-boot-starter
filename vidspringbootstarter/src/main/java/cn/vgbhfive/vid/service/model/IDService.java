package cn.vgbhfive.vid.service.model;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 对VID 提供实现生成ID 和解析ID 的接口
 *
 * @time: 2019/08/14
 * @author: Vgbh
 */
//@Component
public interface IDService {

    /**
     * 生成唯一ID
     * @return ID
     */
    Long genId();

    /**
     * 解析ID
     * @param id
     * @return Map
     */
    Map<String, String> expId(Long id);

}
