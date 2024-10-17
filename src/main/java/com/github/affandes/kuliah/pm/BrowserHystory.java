package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;

public class BrowserHistory {
    
    private LinkedList<String> history;

    public BrowserHistory() {
        history = new LinkedList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history.");
        } else {
            System.out.println("History browser (terbaru ke terlama):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Browsing: " + website);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada website yang bisa dikembalikan.");
        } else {
            String lastWebsite = history.removeLast();
            System.out.println("Kembali ke halaman sebelumnya. Menghapus: " + lastWebsite);
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        System.out.println("Simulasi History Browser: ");
        do {
            System.out.println("\nMasukkan perintah (view, browse, back, exit): ");
            command = scanner.nextLine();
            
            switch (command) {
                case "view":
                    browser.view();
                    break;
                case "browse":
                    System.out.println("Masukkan URL website yang ingin dikunjungi: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;
                case "back":
                    browser.back();
                    break;
                case "exit":
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenal.");
            }
        } while (!command.equals("exit"));
        
        scanner.close();
    }
}
