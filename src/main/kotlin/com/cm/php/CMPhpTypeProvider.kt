package com.cm.php

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.util.SmartList
import com.jetbrains.php.lang.psi.PhpFile
import com.jetbrains.php.lang.psi.elements.AssignmentExpression
import com.jetbrains.php.lang.psi.elements.PhpNamedElement
import com.jetbrains.php.lang.psi.elements.PhpPsiElement
import com.jetbrains.php.lang.psi.elements.Variable
import com.jetbrains.php.lang.psi.resolve.types.PhpType
import com.jetbrains.php.lang.psi.resolve.types.PhpTypeProvider4
import java.io.File


open class CMPhpTypeProvider : CompletionContributor(), PhpTypeProvider4 {

    override fun getKey(): Char {
        return 'S'
    }

    override fun getType(p0: PsiElement?): PhpType? {
        return null
    }

    override fun complete(p0: String?, p1: Project?): PhpType? {
        TODO("Not yet implemented")
    }

    override fun getBySignature(
        p0: String?,
        p1: MutableSet<String>?,
        p2: Int,
        p3: Project?
    ): MutableCollection<out PhpNamedElement>? {
        TODO("Not yet implemented")
    }


    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        super.fillCompletionVariants(parameters, result)
    }


    private fun getMetaFile(project: Project): PsiFile? {
        //return FilenameIndex.getFilesByName(project, ".phpstorm.meta.php", GlobalSearchScope.allScope(project));
        val metaFile = LocalFileSystem.getInstance()
            .findFileByPath(project.basePath + File.separatorChar.toString() + ".phpstorm.meta.php")
        return if (metaFile != null) PsiManager.getInstance(project).findFile(metaFile) else null
    }

    private fun getVariables(project: Project, key: String): Collection<Variable>? {
        val file = getMetaFile(project)
        val result: MutableCollection<Variable> = SmartList<Variable>()
        (file as? PhpFile)?.accept(object : CMPhpElementVisitor() {
            override fun visitPhpAssignmentExpression(assignmentExpression: AssignmentExpression) {
                val variable: PhpPsiElement? = assignmentExpression.getVariable()
                if (variable is Variable) {
                    if ((variable as Variable).getNameCS().equals(key)) {
                        result.add(variable as Variable)
                    }
                }
            }
        })
        return result
    }
}