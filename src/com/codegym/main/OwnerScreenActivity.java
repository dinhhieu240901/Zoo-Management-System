package com.codegym.main;

public class OwnerScreenActivity extends ScreenActivity{
    @Override
    public MainFunction createScreen() {
     
        return new OwnerFunction();

    }
}
