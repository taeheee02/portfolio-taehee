package com.taehee.portfolio.admin.context.project.controller

import com.taehee.portfolio.admin.context.project.form.ProjectForm
import com.taehee.portfolio.admin.context.project.form.ProjectSkillForm
import com.taehee.portfolio.admin.context.project.service.AdminProjectService
import com.taehee.portfolio.admin.context.project.service.AdminProjectSkillService
import com.taehee.portfolio.admin.data.ApiResponse
import com.taehee.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSKillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {

    @PostMapping
    fun postProjectSKill (@RequestBody @Validated form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSKill (@PathVariable id: Long): ResponseEntity<Any> {
        adminProjectSkillService.delete(id)

        return ApiResponse.successDelete()
    }
}