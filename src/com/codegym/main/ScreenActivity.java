package com.codegym.main;

public abstract class ScreenActivity {
    public void renderWindow() {

        MainFunction mainFunction = createScreen();
        mainFunction.show();
    }

    public abstract MainFunction createScreen();

}
