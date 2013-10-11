package com.hartmanster.compareTo;

import com.intellij.psi.PsiField;

/**
 * Tuple describing the PsiField and whether or not the field should be sorted in ascending or descending order
 */
public class PsiFieldWithSortOrder {
  private final PsiField psiField;
  private boolean ascending;

  public PsiFieldWithSortOrder(PsiField psiField, boolean ascending) {
    this.psiField = psiField;
    this.ascending = ascending;
  }

  public PsiField getPsiField() {
    return psiField;
  }

  public boolean isAscending() {
    return ascending;
  }

  public void setAscending(boolean ascending) {
    this.ascending = ascending;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PsiFieldWithSortOrder that = (PsiFieldWithSortOrder) o;

    if (ascending != that.ascending) return false;
    if (!psiField.equals(that.psiField)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = psiField.hashCode();
    result = 31 * result + (ascending ? 1 : 0);
    return result;
  }
}

