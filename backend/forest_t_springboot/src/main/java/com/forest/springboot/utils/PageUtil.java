package com.forest.springboot.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: dwh
 **/
public class PageUtil {
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value = "检索对象")
    public static class Query {

        @ApiModelProperty(value = "排序字段")
        private String orderField = "";

        @ApiModelProperty(value = "排序顺序 1升序 2降序")
        private String orderOrient = "";

        @ApiModelProperty(value = "检索参数")
        private List<IndexArrayVo> indexArray = null;

        @ApiModelProperty(value = "检索字段之间的关系 1并且 2或者 默认并且")
        private String indexRelation = "";

        @ApiModelProperty(value = "页码")
        private Integer pageNum = 1;

        @ApiModelProperty(value = "每页数量")
        private Integer pageSize = 10;

        @Data
        @EqualsAndHashCode(callSuper = false)
        @Accessors(chain = true)
        @ApiModel(value = "indexArray对象参数")
        public static class IndexArrayVo {

            @ApiModelProperty(value = "字段名")
            private String colName = "";

            @ApiModelProperty(value = "检索值")
            private String value = "";

            @ApiModelProperty(value = "检索类别 1 等于 2不等于 3大于 4大于等于 5小于 6小于等于 7包含 8不包含")
            private String indexType = "";
        }
    }

    public static <T> QueryWrapper<T> Wrapper(QueryWrapper<T> Wrapper, Query query) {
        if (null != query.indexArray) {
            for (int i = 0; i < query.indexArray.size(); i++) {
                Query.IndexArrayVo index = query.indexArray.get(i);
                switch (index.getIndexType()) {
                    case "1":
                        Wrapper.eq(index.getColName(), index.getValue());
                        break;
                    case "2":
                        Wrapper.ne(index.getColName(), index.getValue());
                        break;
                    case "3":
                        Wrapper.gt(index.getColName(), index.getValue());
                        break;
                    case "4":
                        Wrapper.ge(index.getColName(), index.getValue());
                        break;
                    case "5":
                        Wrapper.lt(index.getColName(), index.getValue());
                        break;
                    case "6":
                        Wrapper.le(index.getColName(), index.getValue());
                        break;
                    case "7":
                        Wrapper.like(index.getColName(), index.getValue());
                        break;
                    case "8":
                        Wrapper.notLike(index.getColName(), index.getValue());
                        break;
                }
                //设置字段间关系
                if ("2".equals(query.getIndexRelation()) && i + 1 < query.indexArray.size()) {
                    Wrapper.or();
                }
            }
        }

        //设置排序
        if ("1".equals(query.getOrderOrient())) {
            Wrapper.orderByAsc(query.getOrderField());
        } else if ("2".equals(query.getOrderOrient())) {
            Wrapper.orderByDesc(query.getOrderField());
        }
        return Wrapper;
    }
}
