package com.mb.todoapp.main;

import com.mb.todoapp.task.ToDoController;
import com.mb.todoapp.task.ToDoGUI;

import javax.swing.*;

// ToDo: Listen speichern in einer Datei (CSV)
// ToDo: Mehrere Listen erstellen Können (Liste 1, Liste 2)
// ToDo: Zusätzlich eine Prio angeben zum Text (1-5)
// ToDo: Filterung der Prio (Absteigend)
// ToDo: Prio farblich hinterlegen (rot, gelb, grün...)

/**
 * Einstiegspunkt der ToDo-Anwendung.
 * <p>
 * Startet die grafische Benutzeroberfläche (Swing) über den {@link ToDoController}.
 */
public class Main {

    /**
     * Hauptmethode, die das Programm startet.
     * <p>
     * Die GUI wird im Event-Dispatch-Thread von Swing gestartet,
     * um Thread-Sicherheit sicherzustellen.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ToDoGUI(new ToDoController()).createAndShowGUI()
        );
    }
}
