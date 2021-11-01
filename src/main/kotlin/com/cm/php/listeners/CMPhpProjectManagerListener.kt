package com.cm.php.listeners

import com.cm.php.CMPhpVirtualFileAdapter
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.openapi.vfs.VirtualFileManager

internal class CMPhpProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        println("project opened!")
        VirtualFileManager.getInstance().addVirtualFileListener(CMPhpVirtualFileAdapter())
    }
}
