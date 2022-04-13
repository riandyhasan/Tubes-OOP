package com.monstersaku.view;

public class TurnMenu implements GameView {
    public static TurnMenu INSTANCE = new TurnMenu();
    
    public TurnMenu() {};
    
    @Override
    public void showMessage(){
        System.out.println("GAME MENU");
        System.out.println("1. MOVE");
        System.out.println("2. SWITCH");
        System.out.println("3. MONSTER INFO");
        System.out.println("4. GAME INFO");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
        System.out.printf("Command : ");
    }
}
