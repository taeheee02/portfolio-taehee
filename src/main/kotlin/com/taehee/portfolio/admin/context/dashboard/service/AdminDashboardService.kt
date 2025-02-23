package com.taehee.portfolio.admin.context.dashboard.service

import com.taehee.portfolio.admin.data.TableDTO
import com.taehee.portfolio.domain.entity.HttpInterface
import com.taehee.portfolio.domain.repository.HttpInterfaceRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AdminDashboardService(
    private val httpInterfaceRepository: HttpInterfaceRepository
) {

    fun getHttpInterfaceTable(): TableDTO {
        val pageRequest = PageRequest.of(0, 100, Sort.Direction.DESC, "id")

        val classInfo = HttpInterface::class
        val entitiies = httpInterfaceRepository.findAll(pageRequest).content

        return TableDTO.from(classInfo, entitiies)

    }

    fun countVisitorsTotal(): Long {
        return httpInterfaceRepository.count()
    }

    fun countVisitorsWeekly(): Long {
        var today = LocalDate.now()
        var startDay = today.minusDays(6)

        return httpInterfaceRepository.countAllByCreatedDateTimeBetween(startDay.atStartOfDay(), today.atTime(LocalTime.MAX))
    }

    fun countVisitorsToday(): Long {
        var today = LocalDate.now()

        return httpInterfaceRepository.countAllByCreatedDateTimeBetween(today.atStartOfDay(), today.atTime(LocalTime.MAX))
    }
}