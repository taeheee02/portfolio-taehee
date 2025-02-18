package com.taehee.portfolio.admin.context.skill.service

import com.taehee.portfolio.admin.context.skill.form.SkillForm
import com.taehee.portfolio.admin.data.TableDTO
import com.taehee.portfolio.admin.exception.AdminBadRequestException
import com.taehee.portfolio.domain.constant.SkillType
import com.taehee.portfolio.domain.entity.Skill
import com.taehee.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable() : TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: SkillForm) {
        val skillType = SkillType.valueOf(form.type)
        skillRepository.findByNameIgnoreCaseAndType(form.name, skillType)
            .ifPresent { throw AdminBadRequestException("중복된 데이터입니다.")}
        val skill = form.toEntity()
        skillRepository.save(skill)
    }
    @Transactional
    fun update(id: Long, form: SkillForm) {
        val skill = form.toEntity(id)
        skillRepository.save(skill)
    }
}