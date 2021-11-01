package com.cm.php

import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor


open class CMPhpElementVisitor : PhpElementVisitor() {


    override fun visitElement(element: PsiElement) {
        var child = element.firstChild
        while (child != null) {
            child.accept(this)
            child = child.nextSibling
        }
    }

}