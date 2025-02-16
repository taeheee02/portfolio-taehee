package com.taehee.portfolio.presentation.dto

import com.taehee.portfolio.domain.entity.Project
import com.taehee.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDTO(
    val content: String,
    val url: String?
) {
    constructor(projectDetail: ProjectDetail) : this(
        content = projectDetail.content,
        url = projectDetail.url
    )
}