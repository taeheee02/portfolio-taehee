package com.taehee.portfolio.domain.repository

import com.taehee.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByisActive(isActive: Boolean): List<Experience>
}