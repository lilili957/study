package com.lilili.proxy;

/**
 * @Author LiYuan
 * @Date 2021/12/9
 **/
public class StudentServiceImpl implements StudentService{

    @Override
    public void info() {
        System.out.println("正在查询信息...");
    }
}
