package com.titxu.common.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author lxue
 * @data 2022/3/22 22:26
 * @param <T> 泛型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private Integer code;
    private String msg;
    private T data;


    /**
     * 成功返回结果
     * @param <T>  返回结果类型
     * @return 成功结果
     */
    public static <T> R<T> ok() {
        R<T> result = new R<>();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMsg(ResponseEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 失败返回结果
     *
     * @param <T> 返回结果类型
     * @return 失败结果
     */
    public static <T> R<T> error() {
        R<T> result = new R<>();
        result.setCode(ResponseEnum.ERROR.getCode());
        result.setMsg(ResponseEnum.ERROR.getMsg());
        return result;
    }

    /**
     * 设置指定的错误码和错误信息
     * @param responseEnum 错误枚举类
     * @param <T> 返回结果类型
     * @return R
     */
    public static <T> R<T> setResult(ResponseEnum responseEnum) {
        R<T> result = new R<>();
        result.setCode(responseEnum.getCode());
        result.setMsg(responseEnum.getMsg());
        return result;
    }

    /**
     * 设置指定的数据体
     * @param data 数据体
     * @return R
     */
    public <V> R<V> data(V data) {
        // Todo: 优化为this,不要每次都new. 但是不知道怎么使用泛型,所以暂时这样,
        //  强行使用this使用时候泛型推断为Object,idea会报黄色警告
        // this.setData(data);
        R<V> result = new R<>();
        result.setCode(this.getCode());
        result.setMsg(this.getMsg());
        result.setData(data);
        return result;
    }

    /**u
     * 设置指定的错误信息
     * @param msg 错误信息
     * @return R
     */
    public R<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * 设置指定的错误码
     * @param code 错误码
     * @return R
     */
    public R<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
