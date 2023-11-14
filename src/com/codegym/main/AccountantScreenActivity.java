package com.codegym.main;

public class AccountantScreenActivity extends ScreenActivity{
    @Override
    public MainFunction createScreen() {
        return new AccountantFunction();
    }
}
