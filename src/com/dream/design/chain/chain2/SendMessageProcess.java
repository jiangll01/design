package com.dream.design.chain.chain2;

/**
 * @author jiangll01
 * @Date: 2020/7/27 10:02
 * @Description:
 */
public class SendMessageProcess implements BusinessProcess {
    @Override
    public void process(ProcessContext context) {
        Model user =  context.getModel();
        System.out.println("给"+ "发消息");
    }
}
