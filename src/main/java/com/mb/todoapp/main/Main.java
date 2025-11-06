package com.mb.todoapp.main;

import com.mb.todoapp.task.ToDoController;
import com.mb.todoapp.task.ToDoGUI;

import javax.swing.*;

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
