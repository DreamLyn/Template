package com.lyn.modules.common.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
	// http 状态码
	private int code;
	// 返回信息
	private String msg;
	// 返回的数据
	private Object data;
}
