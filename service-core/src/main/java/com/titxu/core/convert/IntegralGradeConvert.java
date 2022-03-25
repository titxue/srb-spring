package com.titxu.core.convert;

import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.entity.IntegralGrade;
import com.titxu.core.pojo.vo.IntegralGradeVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IntegralGradeConvert {
    IntegralGradeVO toVO(IntegralGradeDTO dto);
    IntegralGradeDTO toDTO(IntegralGrade entity);

    List<IntegralGradeVO> toVOs(List<IntegralGradeDTO> dto);
    List<IntegralGradeDTO> toDTOs(List<IntegralGrade> entity);
}
