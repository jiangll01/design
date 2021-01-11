package com.dream.design.chain.chain2;

/**
 * @author jiangll01
 * @Date: 2020/7/27 9:57
 * @Description: 责任链上下文
 */

public class ProcessContext {
    // 标识责任链的code
    private String code;
    // 存储上下文的真正载体
    private Model model;
    // 责任链中断的标识
    private Boolean needBreak = false;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Boolean getNeedBreak() {
        return needBreak;
    }

    public void setNeedBreak(Boolean needBreak) {
        this.needBreak = needBreak;

    }


}

