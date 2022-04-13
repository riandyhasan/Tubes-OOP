package com.monstersaku.view;

public class MainMenu implements GameView {
    public static MainMenu INSTANCE = new MainMenu();
    
    public MainMenu() {};

    @Override
    public void showMessage(){
        System.out.println("GAME MENU");
        System.out.println("1. START");
        System.out.println("2. HELP");
        System.out.println("3. EXIT");
        System.out.printf("Command : ");
    }
}
