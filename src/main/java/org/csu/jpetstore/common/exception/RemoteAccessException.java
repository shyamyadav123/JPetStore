package org.csu.jpetstore.common.exception;

import org.csu.jpetstore.common.result.ResultCode;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public class RemoteAccessException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public RemoteAccessException() {
        super();
    }

    public RemoteAccessException(Object data) {
        super();
        super.data = data;
    }

    public RemoteAccessException(ResultCode resultCode) {
        super(resultCode);
    }

    public RemoteAccessException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public RemoteAccessException(String msg) {
        super(msg);
    }

    public RemoteAccessException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}
