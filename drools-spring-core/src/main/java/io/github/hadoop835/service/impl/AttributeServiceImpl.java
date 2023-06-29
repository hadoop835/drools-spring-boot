package io.github.hadoop835.service.impl;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.hadoop835.dao.entity.AttributeEntiry;
import io.github.hadoop835.dao.entity.AttributeItemEntiry;
import io.github.hadoop835.dao.mapper.AttributeItemMapper;
import io.github.hadoop835.dao.mapper.AttributeMapper;
import io.github.hadoop835.dto.AttributeDto;
import io.github.hadoop835.dto.AttributeItemDto;
import io.github.hadoop835.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 属性业务逻辑
 * @author chenzhh
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    private static Logger LOGGER = LoggerFactory.getLogger(AttributeServiceImpl.class);
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private AttributeItemMapper attributeItemMapper;

    @PostConstruct
    private void init(){
        LOGGER.info("开始初始化数据");
//       InputStream inputStream = AttributeServiceImpl.class.getResourceAsStream("/init/attribute.json");
//        if(Objects.nonNull(inputStream)){
//            List<AttributeDto> attributeDtos =   JSON.parseArray(IoUtil.readUtf8(inputStream), AttributeDto.class);
//            for(AttributeDto attributeDto : attributeDtos){
//                AttributeEntiry attributeEntiry = new AttributeEntiry().toAttributeEntiry(attributeDto);
//                attributeMapper.insert(attributeEntiry);
//                List<AttributeItemDto> attributeItemDtos =  attributeDto.getAttributeItemDtos();
//                List<AttributeItemEntiry> attributeItemEntiries = Lists.newArrayList();
//                for(AttributeItemDto attributeItemDto : attributeItemDtos){
//                    AttributeItemEntiry attributeItemEntiry = new AttributeItemEntiry().toAttributeItemEntiry(attributeItemDto);
//                    attributeItemEntiry.setAttributeId(attributeEntiry.getId());
//                    attributeItemEntiries.add(attributeItemEntiry);
//                }
//                if(!CollectionUtils.isEmpty(attributeItemEntiries)){
//                    attributeItemMapper.insertBatch(attributeItemEntiries);
//                }
//            }
//        }

    }
}
