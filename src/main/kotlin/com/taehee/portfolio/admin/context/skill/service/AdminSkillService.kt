package com.taehee.portfolio.admin.context.skill.service

import com.taehee.portfolio.admin.data.TableDTO
import com.taehee.portfolio.domain.entity.Introduction
import com.taehee.portfolio.domain.entity.Skill
import com.taehee.portfolio.domain.repository.IntroductionRepository
import com.taehee.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable() : TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}