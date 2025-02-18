package com.taehee.portfolio.admin.context.link.service

import com.taehee.portfolio.admin.data.TableDTO
import com.taehee.portfolio.domain.entity.Introduction
import com.taehee.portfolio.domain.entity.Link
import com.taehee.portfolio.domain.repository.IntroductionRepository
import com.taehee.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    fun getLinkTable() : TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}