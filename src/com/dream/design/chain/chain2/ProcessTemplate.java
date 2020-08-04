package com.dream.design.chain.chain2;

import java.util.List;

/**
 * @author jiangll01
 * @Date: 2020/7/27 9:59
 * @Description: 业务执行模板（把责任链的逻辑串起来）
 */
public class ProcessTemplate {
    private List<BusinessProcess> processList;
    public List<BusinessProcess> getProcessList() {
        return processList;
    }
    public void setProcessList(List<BusinessProcess> processList) {
        this.processList = processList;
    }
}
