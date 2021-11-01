package com.cm.php

import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class MyPluginTest : BasePlatformTestCase() {

    fun testXMLFile() {
//        myFixture.addFileToProject("src/test/testData/rename/foo.xml","Hello World")

//        myFixture.openFileInEditor()
    }

    override fun getTestDataPath() = "src/test/testData/rename"

    fun testRename() {
        myFixture.testRename("foo.xml", "foo_after.xml", "a2")
    }
}
