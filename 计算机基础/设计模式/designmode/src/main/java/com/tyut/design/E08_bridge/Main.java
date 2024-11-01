package com.tyut.design.E08_bridge;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote Main方法
 */
public class Main {
    public static void main(String[] args) {
        // 操作系统是一个维度  不同的视频文件是一个维度  多维度适合用桥接模式
        // 操作系统为抽象化角色 不同的文件格式为实现化角色
        // Windows平台下的avi文件
        OperatingSystem os = new Windows(new AVIFile());
        os.play("战狼3");

        // Linux平台下的rmvb文件
        Linux linux = new Linux(new RMVBFile());
        linux.play("战狼2");
    }
}
