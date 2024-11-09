package com.tyut.design.E15_responsibilityChain;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 请假条类
 */
@SuppressWarnings("all")
public class LeaveRequest {
    // 姓名
    private String name;
    // 请假天数
    private int num;
    // 请假原因
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
