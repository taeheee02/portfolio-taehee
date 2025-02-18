package com.taehee.portfolio.admin.context.skill.controller

import com.taehee.portfolio.admin.context.skill.form.SkillForm
import com.taehee.portfolio.admin.context.skill.service.AdminSkillService
import com.taehee.portfolio.admin.data.ApiResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
@RequestMapping("/admin/api/skills")
class AdminSkilllApiController(
    private val adminSkillService: AdminSkillService
) {

    @PostMapping
    fun post (@RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putSkill(@PathVariable id: Long, @RequestBody form: SkillForm): ResponseEntity<Any> {
        adminSkillService.update(id, form)

        return ApiResponse.successUpdate()
    }
}