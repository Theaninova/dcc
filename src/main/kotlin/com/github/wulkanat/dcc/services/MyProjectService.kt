package com.github.wulkanat.dcc.services

import com.intellij.openapi.project.Project
import com.github.wulkanat.dcc.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
