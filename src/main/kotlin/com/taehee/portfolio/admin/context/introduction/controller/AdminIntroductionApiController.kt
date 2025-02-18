package com.taehee.portfolio.admin.context.introduction.controller

import com.taehee.portfolio.admin.context.introduction.form.IntroductionForm
import com.taehee.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.taehee.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {

    @PostMapping
    fun post (@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id: Long, @RequestBody form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)

        return ApiResponse.successUpdate()
    }
}