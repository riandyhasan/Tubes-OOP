package com.monstersaku.view;

public class Help implements GameView {
    public static Help INSTANCE = new Help();

    private Help() {};

    @Override
    public void showMessage(){
        System.out.println() ;
        System.out.println("====================== MONSTER SAKU ======================") ;
        System.out.println("  Selama datang di permainan Monster Saku!  ");
        System.out.println("  Permainan ini adalah permaianan sabung monster");
        System.out.println("  Kalian dan satu teman kalian akan bermain");
        System.out.println("  Setiap pemain akan diberikan modal 6 monster");
        System.out.println("  Pemain akan menyabung monster sampai salah satu pemain");
        System.out.println("  tidak memiliki monster tersisa atau bangkrut ");
        System.out.println("  Pemain bergantian melakukan turn.");
        System.out.println("====================== GAME MENU ========================");
        System.out.println("1. MOVE");
        System.out.println("Pemain menyuruh monster sabungan yang saat itu dipakai");
        System.out.println("untuk menggunakan jurusnya. Setiap turn hanya boleh");
        System.out.println("memakai satu move (Jangan maruk).");
        System.out.println("2. SWITCH");
        System.out.println("Pemain mengganti monster sabungannya untuk disabung dengan");
        System.out.println("pemain lain saat itu, pemain hanya boleh mengganti monster");
        System.out.println("yang ia miliki (Jangan nyuri). Setiap turn hanya boleh");
        System.out.println("memakai satu move (Jangan maruk).");
        System.out.println("3. MONSTER INFO");
        System.out.println("Mengeluarkan informasi spek dari monster yang dipunyai pemain");
        System.out.println("3. MONSTER INFO");
        System.out.println("Mengeluarkan informasi spek dari monster yang dipunyai pemain");
        System.out.println("4. GAME INFO");
        System.out.println("Mengeluarkan informasi permainan saat ini");
        System.out.println("5. HELP");
        System.out.println("Mengeluarkan pesan ini");
        System.out.println("6. EXIT");
        System.out.println("Keluar dari game (TOBAT)");
        System.out.println() ;
    }
}
