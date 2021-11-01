package com.cm.php

import com.intellij.openapi.vfs.*

class CMPhpVirtualFileAdapter : VirtualFileListener {

    override fun fileCreated(event: VirtualFileEvent) {
        println("file created")
        super.fileCreated(event)
    }

    override fun fileDeleted(event: VirtualFileEvent) {
        println("file deleted")
        super.fileDeleted(event)
    }

    override fun fileMoved(event: VirtualFileMoveEvent) {
        println("file moved")
        super.fileMoved(event)
    }

    override fun fileCopied(event: VirtualFileCopyEvent) {
        println("file copied")
        super.fileCopied(event)
    }

    override fun propertyChanged(event: VirtualFilePropertyEvent) {
        println("property changed")
        super.propertyChanged(event)
    }

    override fun contentsChanged(event: VirtualFileEvent) {
        println("contents changed")
        super.contentsChanged(event)
    }
}