package com.taehee.portfolio.presentation.controller

import com.taehee.portfolio.domain.constant.SkillType
import com.taehee.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }


    @GetMapping("/")
    fun home(model: Model): String {
        // home 페이지에서 사용할 데이터들을 모두 모델에 담습니다.
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)

        val resume = presentationService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())

        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/home"
    }

}
