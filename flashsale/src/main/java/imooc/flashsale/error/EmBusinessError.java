package imooc.flashsale.error;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/04
 **/

public enum EmBusinessError implements CommonError{

    //Generic error, starts with 10001
    PARAMETER_VALIDATION_ERROR(10001, "Parameter is invalid"),
    UNKNOWN_ERROR(10002, "Unknown error"),

    USER_NOT_EXIST(20001,"User does not exist.")
    ;


    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
