package com.mb.todoapp.task;

/**
 * Repräsentiert eine einzelne Aufgabe in der ToDo-Liste.
 * <p>
 * Eine Aufgabe besitzt nur einen Namen und den Status, ob sie erledigt ist.
 */
public class Task {

    /**
     * Der Name bzw. die Beschreibung der Aufgabe.
     */
    private final String name;

    /**
     * Gibt an, ob die Aufgabe erledigt ist.
     */
    private boolean done;

    /**
     * Erstellt eine neue Aufgabe mit dem angegebenen Namen.
     * Der Erledigt-Status ist initial {@code false}.
     *
     * @param name der Name der Aufgabe
     */
    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    /**
     * Gibt den Namen der Aufgabe zurück.
     *
     * @return Name der Aufgabe
     */
    public String getName() {
        return name;
    }

    /**
     * Prüft, ob die Aufgabe erledigt ist.
     *
     * @return {@code true}, wenn erledigt; sonst {@code false}
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Wechselt den Status zwischen erledigt und unerledigt.
     */
    public void toggleDone() {
        done = !done;
    }

    /**
     * Gibt den Aufgabennamen als Textdarstellung zurück.
     *
     * @return der Name der Aufgabe
     */
    @Override
    public String toString() {
        return name;
    }
}
