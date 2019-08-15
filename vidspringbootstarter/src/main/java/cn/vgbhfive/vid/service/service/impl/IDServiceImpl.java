package cn.vgbhfive.vid.service.service.impl;

import cn.vgbhfive.vid.service.model.ID;
import cn.vgbhfive.vid.service.model.IDMeta;
import cn.vgbhfive.vid.service.populator.Populator;
import cn.vgbhfive.vid.service.service.AbstractIDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 继承IDService 实现填充ID
 *
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Component
public class IDServiceImpl extends AbstractIDService {

    private static final Logger logger = LoggerFactory.getLogger(IDServiceImpl.class);

    @Autowired
    @Qualifier("atomic")
    private Populator populator;

    public IDServiceImpl(IDMeta idMeta) {
        super(idMeta);
    }

    /**
     * 回调函数，负责填充ID
     * @param id
     */
    protected void populateId(ID id) {
        populator.populatorID(id, this.idMeta);
    }
}
