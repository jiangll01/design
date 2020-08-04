package com.dream.design.chain.chain2;

/**
 * @author jiangll01
 * @Date: 2020/7/27 10:01
 * @Description:
 */
public class WhiteListProcess implements BusinessProcess {
    @Override
    public void process(ProcessContext context) {
        Model user =  context.getModel();
        if ("3y".equals(user)) {
            context.setNeedBreak(true);
        }
    }
}
