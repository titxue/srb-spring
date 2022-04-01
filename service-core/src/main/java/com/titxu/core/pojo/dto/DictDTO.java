package com.titxu.core.pojo.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "上级id")
    private Long parentId;
    @ApiModelProperty(value = "子节点")
    private List<DictDTO> children;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "值")
    private Integer value;

    @ApiModelProperty(value = "编码")
    private String dictCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
