package com.hartmanster.compareTo.ui;

import com.intellij.util.ui.ListTableModel;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 * A JTable that hooks into the rendering/editing system provided by intellij classes
 */
public class MyTable extends JTable {
  public MyTable(ListTableModel<?> myFields) {
    super(myFields);
  }

  @Override
  public TableCellRenderer getCellRenderer(int row, int col) {
    TableModel tableModel = getModel();
    ListTableModel<?> listTableModel = (ListTableModel<?>) tableModel;

    TableCellRenderer renderer = listTableModel.getColumnInfos()[col].getRenderer(listTableModel.getItem(row));
    if (renderer != null) {
      return renderer;
    } else {
      return super.getCellRenderer(row, col);
    }
  }

  @Override
  public TableCellEditor getCellEditor(int row, int col) {
    TableModel tableModel = getModel();
    ListTableModel<?> listTableModel = (ListTableModel<?>) tableModel;

    TableCellEditor editor = listTableModel.getColumnInfos()[col].getEditor(listTableModel.getItem(row));
    if (editor != null) {
      return editor;
    } else {
      return super.getCellEditor(row, col);
    }
  }
}
