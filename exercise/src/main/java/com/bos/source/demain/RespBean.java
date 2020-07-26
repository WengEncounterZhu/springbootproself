package com.bos.source.demain;

public class RespBean<T> {
    private  Integer code;
    private  String msg;
    private   T   data;




    public static RespBean ok(Integer code ) {
            RespBean respBean = new RespBean();
            respBean.setCode(code);
            return  respBean;
    }

    public  static <T> RespBean ok(Integer code , T data) {

        RespBean respBean = new RespBean();
        respBean.setCode(code);
        respBean.setMsg("sucess");
        respBean.setData(data);
        return  respBean;
    }






    public Integer getCode() {
        return code;
    }

    public RespBean(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RespBean() {
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
