package com.tyut.design.E08_bridge;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 抽象操作系统 - 抽象化角色
 */
public abstract class OperatingSystem {
    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
