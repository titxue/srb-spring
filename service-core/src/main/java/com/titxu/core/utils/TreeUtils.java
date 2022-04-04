package com.titxu.core.utils;

import com.titxu.core.convert.DictConvert;
import com.titxu.core.pojo.dto.DictDTO;
import com.titxu.core.pojo.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lxue
 */
@Component
public class TreeUtils {
    /**
     * 根节点CODE
     */
    private static final Long TREE_ROOT = 1L;
    private DictConvert convert;

    /**
     * lambda表达式版
     */
    public List<DictDTO> getTreeEX(List<Dict> record){
        return record.stream().filter(entity -> TREE_ROOT.equals(entity.getParentId())).map(entity -> {
            DictDTO dto = convert.toDTO(entity);
            dto.setChildren(getChildEX(entity.getParentId(),record));
            return dto;
        }).collect(Collectors.toList());
    }


    private List<DictDTO> getChildEX(Long pid,List<Dict> record){
        return record.stream().filter(entity -> pid.equals(entity.getParentId())).map(entity -> {
            DictDTO dto = convert.toDTO(entity);
            dto.setChildren(getChildEX(entity.getId(),record));
            return dto;
        }).collect(Collectors.toList());
    }

    @Autowired
    public void setConvert(DictConvert convert) {
        this.convert = convert;
    }
}

