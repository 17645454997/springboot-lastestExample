package com.xingjiahe.www.infrastructure.util.validator;

import java.util.List;

public class ValidationResult {
 
	//校验结果是否有错
	private boolean hasErrors;
	
	//校验错误信息
	private List<String> errorMsg;
 
	public boolean isHasErrors() {
		return hasErrors;
	}
 
	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
	public String toString() {
		return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg="
				+ errorMsg + "]";
	}
 
}
