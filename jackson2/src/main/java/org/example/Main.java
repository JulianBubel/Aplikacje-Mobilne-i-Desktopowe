package org.example;
import javax.swing.SwingUtilities;

//Dlaczego format JSON jest lepszy od zwykłego pliku tekstowego .txt przy zapisywaniu obiektów? ponieważ jest bardziej uniwersalny, latwiej się go manipuluje, jest łatwiejszy do oczytania dla ludzi lub maszyn
//Co się stanie, jeśli w klasie Student zabraknie pustego konstruktora podczas próby deserializacji przez bibliotekę Jackson? jackson nie będzie mógł utworzyć obiektu i pojawi się error
//Do czego służy słowo kluczowe transient w kontekście serializacji? (Podpowiedź: sprawdź w dokumentacji). transient oznacza pole które nie powinno być zapisywane w czasie serializacji obiektu
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}