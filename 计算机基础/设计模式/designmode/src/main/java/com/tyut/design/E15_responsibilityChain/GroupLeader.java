package com.tyut.design.E15_responsibilityChain;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 小组长 -》 具体处理者角色
 */
public class GroupLeader extends Handler {
    public GroupLeader() {
        //小组长处理1-3天的请假
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天," + leaveRequest.getContent() + "。");
        System.out.println("小组长审批：同意。");
    }
}
