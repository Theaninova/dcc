// This is a generated file. Not intended for manual editing.
package com.github.wulkanat.dcc.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DccDeclaration extends PsiElement {

  @Nullable
  DccHeapValDeclaration getHeapValDeclaration();

  @Nullable
  DccHeapVarDeclaration getHeapVarDeclaration();

  @Nullable
  DccValDeclaration getValDeclaration();

  @Nullable
  DccVarDeclaration getVarDeclaration();

}
