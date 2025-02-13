package com.taehee.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServerletRequest: HttpServletRequest) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServerletRequest.cookies
        ?.map { "${it.name}:${it.value}" }
        ?.toString()

    var referer: String? = httpServerletRequest.getHeader("referer")

    var localAddr: String? = httpServerletRequest.localAddr

    var remoteAddr: String? = httpServerletRequest.remoteAddr

    var remoteHost: String? = httpServerletRequest.remoteHost

    var requestUri: String? = httpServerletRequest.requestURI

    var userAgent: String? = httpServerletRequest.getHeader("user-Agent")
}