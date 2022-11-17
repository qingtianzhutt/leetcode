package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("返回结果")
public class SwaggerResultMessage<T> implements Serializable {
    private static final SerializerFeature[] JSON_SERIALIZER_FEATURES;
    private static final String SUCCESS = "0";
    private static final String FAIL_MSG = "操作失败";
    private static final String FAIL = "1";
    @ApiModelProperty("是否成功")
    private boolean success = true;
    @ApiModelProperty("结果编码")
    private String code = "0";
    @ApiModelProperty("错误消息")
    private String errMsg = "";
    @ApiModelProperty("返回数据")
    private T data;

    static {
        JSON_SERIALIZER_FEATURES = new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect};
    }

    public SwaggerResultMessage() {
    }

    public String toJSONString() {
        return JSON.toJSONString(this, JSON_SERIALIZER_FEATURES);
    }

    public String toJSONStringWithDateFormat(String dateFormat) {
        return JSON.toJSONStringWithDateFormat(this, dateFormat, JSON_SERIALIZER_FEATURES);
    }

    public SwaggerResultMessage(T data) {
        this.data = (T) data;
    }

    /**
     * 勿删，否则可能会影响反序列化
     */
    public SwaggerResultMessage(boolean success, T data) {
        this.success = success;
        this.data = (T) data;
        this.code = success ? "0" : "1";
        this.data = data;
    }

    /**
     * 勿删，否则可能会影响反序列化
     */
    public SwaggerResultMessage(boolean success, String errMsg) {
        this.success = success;
        this.errMsg = errMsg;
        this.code = success ? "0" : "1";
    }

    /**
     * 勿删，否则可能会影响反序列化
     */
    public SwaggerResultMessage(boolean success, String errMsg, T data) {
        this.success = success;
        this.errMsg = errMsg;
        this.data = (T) data;
    }

    /**
     * 勿删，否则可能会影响反序列化
     */
    public SwaggerResultMessage(boolean success, String code, String errMsg, T data) {
        this.success = success;
        this.code = code;
        this.errMsg = errMsg;
        this.data = (T) data;
    }

}
