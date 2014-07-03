package com.deppon.fssc.module.quartz.server.exception;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 
* @ClassName: QuartzModelException 
* @Description: TODO(异常实体类) 
* @author 谢玉良 xieyuliang@deppon.com 
* @date 2013-2-27 下午4:53:00 
*
 */
@SuppressWarnings("serial")
public class QuartzModelException extends BusinessException {

	private static final String IS_NULL_ERROR_CODE = "error.module.quartz.QuartzModelIsNullException";

	private static final String ID_NULL_ERROR_CODE = "error.module.quartz.QuartzModelIdNullException";


	public QuartzModelException(QuartzModelExceptionType errorType) {
		super();
		if (errorType.equals(QuartzModelExceptionType.IsNull)) {
			this.errCode = IS_NULL_ERROR_CODE;
		}
		if (errorType.equals(QuartzModelExceptionType.IdNull)) {
			this.errCode = ID_NULL_ERROR_CODE;
		}
	}

}
