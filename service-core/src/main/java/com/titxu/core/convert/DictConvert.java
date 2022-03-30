package com.titxu.core.convert;



import com.titxu.core.pojo.dto.DictDTO;
import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.pojo.entity.Dict;
import com.titxu.core.pojo.vo.DictVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DictConvert {
    Dict toDict(ExcelDictDTO dto);
    @Mapping(target = "children", ignore = true)
    List<DictDTO> toDTOs(List<Dict> entity);
    List<ExcelDictDTO> toDictDTO(List<Dict> dto);
    List<Dict> toEntity(List<ExcelDictDTO> dto);
    List<DictVo> toVo(List<DictDTO> dto);


    DictDTO toDTO(Dict entity);
}
