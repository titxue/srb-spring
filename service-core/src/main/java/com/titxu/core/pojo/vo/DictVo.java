package com.titxu.core.pojo.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DictVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "上级id")
    private Long parentId;

    @ApiModelProperty(value = "子节点")
    private List<DictVo> children;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "值")
    private Integer value;

    @ApiModelProperty(value = "编码")
    private String dictCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
