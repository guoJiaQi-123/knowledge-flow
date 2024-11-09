package com.tyut.design.E15_responsibilityChain;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 抽象处理者（Handler）角色
 */
public abstract class Handler {

    public static final int NUM_ONE = 1;
    public static final int NUM_THREE = 3;
    public static final int NUM_SEVEN = 7;

    //该领导处理的请假天数区间
    private int numStart;
    private int numEnd;
    //领导上面还有领导
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    //设置请假天数范围
    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    //设置上级领导
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }


    //提交请假条
    protected void submit(LeaveRequest leaveRequest) {
        if (0 == this.numStart) {
            return;
        }
        //如果请假天数达到该领导者的处理要求
        if (leaveRequest.getNum() >= this.numStart) {
            this.handleLeave(leaveRequest);

            //如果还有上级 并且请假天数超过了当前领导的处理范围
            if (null != this.nextHandler && leaveRequest.getNum() > numEnd) {
                this.nextHandler.submit(leaveRequest);//继续提交
            } else {
                System.out.println("流程结束");
            }
        }
    }

    //各级领导处理请假条方法
    protected abstract void handleLeave(LeaveRequest leaveRequest);
}
