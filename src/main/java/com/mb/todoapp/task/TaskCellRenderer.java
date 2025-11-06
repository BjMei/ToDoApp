package com.mb.todoapp.task;

import javax.swing.*;
import java.awt.*;

/**
 * Renderer für die Darstellung von {@link Task}-Objekten in einer {@link JList}.
 * <p>
 * Zeigt jede Aufgabe mit einer Checkbox und einem Label an. Der Status der Checkbox
 * entspricht dem Erledigt-Status der Aufgabe. Die Checkbox ist visuell und wird
 * über die {@link ToDoGUI} interaktiv behandelt (MouseListener).
 */
public class TaskCellRenderer extends JPanel implements ListCellRenderer<Task> {

    /** Label zur Anzeige des Aufgabentextes. */
    private final JLabel label = new JLabel();

    /** Checkbox, die den Erledigt-Status der Aufgabe anzeigt. */
    private final JCheckBox box = new JCheckBox();

    /**
     * Erstellt einen neuen Renderer mit BorderLayout.
     * Checkbox links, Label rechts.
     */
    public TaskCellRenderer() {
        super(new BorderLayout(5, 5));
        setOpaque(true);
        add(box, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
    }

    /**
     * Bereitet die Anzeige einer einzelnen Aufgabe in der Liste vor.
     *
     * @param list die JList, die das Element rendert
     * @param value das {@link Task}-Objekt, das dargestellt wird
     * @param index der Index des Elements in der Liste
     * @param isSelected ob das Element aktuell ausgewählt ist
     * @param cellHasFocus ob die Zelle den Fokus hat
     * @return das konfigurierte {@link Component}-Objekt für die Darstellung
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Task> list, Task value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        box.setSelected(value.isDone());
        String text = value.getName();
        label.setText(value.isDone() ? "<html><strike>" + text + "</strike></html>" : text);

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }
}
