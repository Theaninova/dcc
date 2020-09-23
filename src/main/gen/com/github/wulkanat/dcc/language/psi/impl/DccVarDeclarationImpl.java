// This is a generated file. Not intended for manual editing.
package com.github.wulkanat.dcc.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.wulkanat.dcc.language.psi.DccTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.wulkanat.dcc.language.psi.*;

public class DccVarDeclarationImpl extends ASTWrapperPsiElement implements DccVarDeclaration {

  public DccVarDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DccVisitor visitor) {
    visitor.visitVarDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DccVisitor) accept((DccVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DccExpression getExpression() {
    return findNotNullChildByClass(DccExpression.class);
  }

  @Override
  @NotNull
  public DccSeparator getSeparator() {
    return findNotNullChildByClass(DccSeparator.class);
  }

}
