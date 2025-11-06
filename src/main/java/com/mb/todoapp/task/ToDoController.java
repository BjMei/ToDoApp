package com.mb.todoapp.task;

import javax.swing.*;

/**
 * Controller-Klasse für die ToDo-Anwendung.
 * <p>
 * Diese Klasse verwaltet die Logik für das Hinzufügen, Umschalten (erledigt/unerledigt)
 * und Löschen von Aufgaben. Sie hält ein {@link DefaultListModel}, das die
 * Aufgabenliste repräsentiert und von der GUI verwendet wird.
 */
public class ToDoController {

    /** Modell, das alle Aufgaben enthält. */
    private final DefaultListModel<Task> listModel = new DefaultListModel<>();

    /**
     * Gibt das Aufgabenmodell zurück.
     *
     * @return das {@link DefaultListModel} mit allen Aufgaben
     */
    public DefaultListModel<Task> getListModel() {
        return listModel;
    }

    /**
     * Fügt eine neue Aufgabe hinzu, sofern der Name nicht leer ist.
     *
     * @param name Name der neuen Aufgabe
     */
    public void addTask(String name) {
        if (name != null && !name.trim().isEmpty()) {
            listModel.addElement(new Task(name.trim()));
        }
    }

    /**
     * Wechselt den Erledigt-Status einer Aufgabe an der angegebenen Position.
     *
     * @param index Index der Aufgabe in der Liste
     */
    public void toggleTask(int index) {
        if (index >= 0 && index < listModel.size()) {
            Task t = listModel.get(index);
            t.toggleDone();
            listModel.setElementAt(t, index);
        }
    }

    /**
     * Löscht die Aufgabe an der angegebenen Position.
     *
     * @param index Index der Aufgabe in der Liste
     */
    public void deleteTask(int index) {
        if (index >= 0 && index < listModel.size()) {
            listModel.remove(index);
        }
    }
}
