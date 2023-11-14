package com.codegym.main;

public class VisitorScreenActivity extends ScreenActivity{
    @Override
    public MainFunction createScreen() {
        return new VisitorFunction();
    }
}
