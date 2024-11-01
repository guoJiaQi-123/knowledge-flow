package com.tyut.design.E08_bridge;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote RMVB视频文件 - 具体实现化
 */
public class RMVBFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("RMVB文件解码：" + fileName);
    }
}
