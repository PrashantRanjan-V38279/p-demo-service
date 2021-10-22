package com.aflac.eib.demo.exception;

import java.text.MessageFormat;

public enum ExceptionCode {

    SELECTIONCRITERIAINVALIDJSON("751", "service.p-account-cmdqry.invalidjson.selectioncriteria");
	
	private final String id;
	private final String msg;

	ExceptionCode(String id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	public String getId() {
		return this.id;
	}

	public String getMsg() {
		return this.msg;
	}
	
	public String getMessage(Object... args) {
        return MessageFormat.format(msg, args);
   }
	
}
