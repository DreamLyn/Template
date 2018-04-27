package com.lyn.template.common.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseBean {
	// http 状态码
	private int code;
	// 返回信息
	private String msg;
	// 返回的数据
	private Object data;
}
