package com.titxu.core.convert;



import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.pojo.entity.Dict;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DictConvert {
    Dict toDict(ExcelDictDTO dto);
    List<Dict> toDicts(List<ExcelDictDTO> dto);
}
