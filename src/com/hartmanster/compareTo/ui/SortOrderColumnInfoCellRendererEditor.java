package com.hartmanster.compareTo.ui;

import com.hartmanster.compareTo.ui.MyTable;
import com.intellij.util.ui.AbstractTableCellEditor;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortOrderColumnInfoCellRendererEditor extends AbstractTableCellEditor implements
    TableCellRenderer {

    private final JRadioButton ascendingOrderButton;
    private final JRadioButton descendingOrderButton;
    private final JPanel buttonPanel;

    public SortOrderColumnInfoCellRendererEditor() {
      this.ascendingOrderButton = new JRadioButton("asc");
      ascendingOrderButton.setSelected(true);

      descendingOrderButton = new JRadioButton("desc");
      descendingOrderButton.setSelected(false);

      ButtonGroup buttonGroup = new ButtonGroup();
      buttonGroup.add(ascendingOrderButton);
      buttonGroup.add(descendingOrderButton);

      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

      buttonPanel.add(ascendingOrderButton);
      buttonPanel.add(descendingOrderButton);

      ascendingOrderButton.addActionListener(new StopTableEditingActionListener(buttonPanel));
      descendingOrderButton.addActionListener(new StopTableEditingActionListener(buttonPanel));

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean cellHasFocus, int row, int col) {
      if (!getCellEditorValue().equals(value)) {
        ascendingOrderButton.setSelected(Boolean.TRUE.equals(value));
        descendingOrderButton.setSelected(Boolean.FALSE.equals(value));
      }
      return buttonPanel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jTable, Object value, boolean b, int i, int i2) {
      if (!getCellEditorValue().equals(value)) {
        ascendingOrderButton.setSelected(Boolean.TRUE.equals(value));
        descendingOrderButton.setSelected(Boolean.FALSE.equals(value));
      }
      return buttonPanel;
    }

    @Override
    public Object getCellEditorValue() {
      return ascendingOrderButton.isSelected();
    }

    private static class StopTableEditingActionListener implements ActionListener {
      private final JPanel buttonPanel;

      private StopTableEditingActionListener(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
      }

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        MyTable parentTable = (MyTable) buttonPanel.getParent();
        TableCellEditor editor = parentTable.getCellEditor();
        if (editor != null) {
          editor.stopCellEditing();
        }
      }
    }
  }
