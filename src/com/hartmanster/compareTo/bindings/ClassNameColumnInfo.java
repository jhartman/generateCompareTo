package com.hartmanster.compareTo.bindings;

import com.hartmanster.compareTo.PsiFieldWithSortOrder;
import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.util.ui.ColumnInfo;
import org.jetbrains.annotations.Nullable;

/**
 * ColumnInfo for rendering the class name
 */
public class ClassNameColumnInfo extends ColumnInfo<PsiFieldWithSortOrder, String> {
  private final DefaultPsiElementCellRenderer psiFieldWithSortOrderCellRenderer
      = new DefaultPsiElementCellRenderer();

  public ClassNameColumnInfo(String name) {
    super(name);
  }

  @Nullable
  @Override
  public String valueOf(PsiFieldWithSortOrder psiFieldWithSortOrder) {
    return psiFieldWithSortOrder.getPsiField().getName();
  }
}
