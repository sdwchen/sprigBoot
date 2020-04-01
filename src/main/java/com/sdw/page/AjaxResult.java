package com.sdw.page;


public class AjaxResult {
    private boolean success;
    private String msg;

    public AjaxResult() {
    }

    public AjaxResult(String msg) {

        this.setMsg(msg);
    }

    public AjaxResult(Boolean success) {

        this.setSuccess(success);
    }

    public AjaxResult(boolean success, String msg) {

        this.setSuccess(success);
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AjaxResult [success=" + success + ", msg=" + msg + "]";
    }

}
