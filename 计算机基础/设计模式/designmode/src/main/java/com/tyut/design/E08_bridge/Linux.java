package com.tyut.design.E08_bridge;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote Linux操作系统
 */
public class Linux extends OperatingSystem {
    public Linux(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Linux平台");
        videoFile.decode(fileName);
    }
}
