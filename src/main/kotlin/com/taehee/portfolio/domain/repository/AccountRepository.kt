package com.taehee.portfolio.domain.repository

import com.taehee.portfolio.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountRepository: JpaRepository<Account, Long> {

    fun findByLoginId(loginId: String): Optional<Account>
}