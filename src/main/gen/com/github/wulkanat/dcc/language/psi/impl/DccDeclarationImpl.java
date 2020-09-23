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

public class DccDeclarationImpl extends ASTWrapperPsiElement implements DccDeclaration {

  public DccDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DccVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DccVisitor) accept((DccVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DccHeapValDeclaration getHeapValDeclaration() {
    return findChildByClass(DccHeapValDeclaration.class);
  }

  @Override
  @Nullable
  public DccHeapVarDeclaration getHeapVarDeclaration() {
    return findChildByClass(DccHeapVarDeclaration.class);
  }

  @Override
  @Nullable
  public DccValDeclaration getValDeclaration() {
    return findChildByClass(DccValDeclaration.class);
  }

  @Override
  @Nullable
  public DccVarDeclaration getVarDeclaration() {
    return findChildByClass(DccVarDeclaration.class);
  }

}
