package cn.vgbhfive.vid.client;

import cn.vgbhfive.vid.properties.IDProperties;
import cn.vgbhfive.vid.service.model.IDService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 对外提供服务类
 *
 * @time: 2019/08/14
 * @author: Vgbh
 */
public class VID {

    @Autowired
    private IDService idService;

    private IDProperties idProperties;

    public VID() {
    }

    public VID(IDProperties idProperties) {
        this.idProperties = idProperties;
    }

    /**
     * 测试函数
     * @return idProperties
     */
    public String test() {
        return idProperties.toString();
    }

    /**
     * 生成唯一ID
     * @return ID
     */
    public Long genId() {
        return idService.genId();
    }

    /**
     * 解析ID
     * @param id
     * @return Map
     */
    public Map<String, String> expId(Long id) {
        return null;
    }
}
