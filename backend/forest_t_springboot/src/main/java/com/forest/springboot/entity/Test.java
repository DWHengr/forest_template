package com.forest.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author forest
 * @since 2022-11-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@TableName("t_test")
@ApiModel(value="Test对象", description="测试表")
public class Test implements Serializable {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "int类型")
      @TableField("int_field")
    private Long intField;

      @ApiModelProperty(value = "字符串类型")
      @TableField("string_field")
    private String stringField;

      @ApiModelProperty(value = "时间类型")
      @TableField("date_field")
    private LocalDateTime dateField;


}
