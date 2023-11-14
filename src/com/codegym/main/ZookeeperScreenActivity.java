package com.codegym.main;

public class ZookeeperScreenActivity extends ScreenActivity{
    @Override
    public MainFunction createScreen() {
        return new ZookeeperFunction();
    }
}
