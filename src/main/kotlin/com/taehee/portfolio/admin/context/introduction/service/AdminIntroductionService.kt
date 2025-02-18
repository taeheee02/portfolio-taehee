package com.taehee.portfolio.admin.context.introduction.service

import com.taehee.portfolio.admin.data.TableDTO
import com.taehee.portfolio.domain.entity.Introduction
import com.taehee.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable() : TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}