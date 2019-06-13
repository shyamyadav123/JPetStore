package org.csu.jpetstore.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数无效项
 * @author: sun
 * @date: 2019/6/13
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParameterInvalidItem {

    /**
     * 无效字段的名称
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String message;

}
