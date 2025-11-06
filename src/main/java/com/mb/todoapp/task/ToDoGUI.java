package com.mb.todoapp.task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Benutzeroberfläche für die einfache ToDo-Liste.
 * <p>
 * Diese Klasse erstellt ein GUI mit Eingabefeld, Aufgabenliste und Steuerelementen
 * zum Hinzufügen, Umschalten und Löschen von Aufgaben. Die Checkboxen in der Liste
 * sind interaktiv: ein Klick auf die Checkbox ändert den Erledigt-Status.
 */
public class ToDoGUI {

    /**
     * Steuert die Aufgabenlogik (Hinzufügen, Löschen, Status ändern).
     */
    private final ToDoController controller;

    /**
     * Anzeige der Aufgaben in einer Liste.
     */
    private JList<Task> taskList;

    /**
     * Erstellt eine neue GUI-Instanz mit dem angegebenen {@link ToDoController}.
     *
     * @param controller die Controller-Instanz, welche die Aufgabenverwaltung übernimmt
     */
    public ToDoGUI(ToDoController controller) {
        this.controller = controller;
    }

    /**
     * Erstellt und zeigt das Hauptfenster der ToDo-App.
     * <p>
     * Enthält:
     * <ul>
     *   <li>Eingabefeld und Button zum Hinzufügen neuer Aufgaben</li>
     *   <li>Liste mit allen Aufgaben</li>
     *   <li>Buttons zum Umschalten des Status und zum Löschen</li>
     * </ul>
     */
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Simple ToDo-Liste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 520);

        JTextField inputField = new JTextField();
        JButton addBtn = new JButton("Hinzufügen");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addBtn, BorderLayout.EAST);

        taskList = new JList<>(controller.getListModel());
        taskList.setCellRenderer(new TaskCellRenderer());
        taskList.setFixedCellHeight(30); // fixierte Höhe für bessere Darstellung
        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton toggleBtn = new JButton("Erledigt/Unerledigt");
        JButton deleteBtn = new JButton("Löschen");
        buttons.add(toggleBtn);
        buttons.add(deleteBtn);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);

        // === Aktionen ===
        addBtn.addActionListener(e -> {
            controller.addTask(inputField.getText());
            inputField.setText("");
        });

        inputField.addActionListener(e -> {
            controller.addTask(inputField.getText());
            inputField.setText("");
        });

        toggleBtn.addActionListener(e -> controller.toggleTask(taskList.getSelectedIndex()));
        deleteBtn.addActionListener(e -> controller.deleteTask(taskList.getSelectedIndex()));

        // Interaktive Checkboxen + Doppelklick auf Zelle
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = taskList.locationToIndex(e.getPoint());
                if (index >= 0) {
                    Rectangle cellBounds = taskList.getCellBounds(index, index);
                    Task t = controller.getListModel().get(index);

                    // Klick links in den Bereich der Checkbox (~20px)
                    int relativeX = e.getX() - cellBounds.x;
                    if (relativeX <= 20 || e.getClickCount() == 2) {
                        controller.toggleTask(index);
                        taskList.repaint(cellBounds); // GUI aktualisieren
                    }
                }
            }
        });

        // Fenster positionieren und anzeigen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
