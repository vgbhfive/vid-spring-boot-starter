package cn.vgbhfive.vid.service.service;

import cn.vgbhfive.vid.properties.IDProperties;
import cn.vgbhfive.vid.service.converter.Converter;
import cn.vgbhfive.vid.service.converter.impl.ConverterIDImpl;
import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import cn.vgbhfive.vid.service.model.IDMetaFactory;
import cn.vgbhfive.vid.service.model.IDService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象IDService 实现类，负责聚合填充器和转换器
 *
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Data
@Component
public abstract class AbstractIDService implements IDService {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractIDService.class);

    protected IDMeta idMeta;

    protected Long machine;
    protected Long genMethod;
    protected Long type;
    protected Long version;

    @Autowired
    protected Converter converter;

    @Autowired
    private IDProperties idProperties;

    public AbstractIDService() {
        this.idMeta = IDMetaFactory.getIDMeta();
    }

    /**
     * 生成或解析ID 之前初始化
     */
    public void init() {
        // 初始化参数
        this.machine = idProperties.getMachine();
        this.genMethod = idProperties.getGenMethod();
        this.type = idProperties.getType();
        this.version = idProperties.getVersion();

        // 参数校验
        if (this.machine < 0) {
            logger.error("The machine ID must bigger than ZERO.");
            throw new IllegalStateException("The machine ID must bigger than ZERO.");
        }

        // 构造 ID 模式类
        if (null == idMeta) {
            idMeta = IDMetaFactory.getIDMeta();
        }

        // 构建 ID/Long 转换类
        setConverter(new ConverterIDImpl(this.idMeta));
    }

    //模板回调函数，调用Populator 填充器
    protected abstract void populateId(ID id);

    /**
     * 生成唯一ID
     * @return
     */
    public Long genId() {
        init();
        ID id = new ID();
        id.setMachine(this.machine);
        id.setGenMethod(this.genMethod);
        id.setType(this.type);
        id.setVersion(this.version);
        populateId(id);

        Long result = converter.convert(id);
        if (logger.isDebugEnabled()) {
            logger.debug("ID :" + id + " -> " + result);
        }
        return result;
    }

    /**
     * 解析ID
     * @param id
     * @return
     */
    public Map<String, String> expId(Long id) {
        ID result = converter.convert(id);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Machine", result.getMachine().toString());
        map.put("GenMethod", result.getGenMethod().toString());
        map.put("Seq", result.getSeq().toString());
        map.put("Time", result.getTime().toString());
        map.put("Type", result.getType().toString());
        map.put("Version", result.getVersion().toString());

        if (logger.isDebugEnabled()) {
            logger.debug("Long :" + id + " -> " + map.toString());
        }
        return map;
    }

}
