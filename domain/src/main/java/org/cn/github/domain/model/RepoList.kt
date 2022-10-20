package org.cn.github.domain.model

data class RepoList(
    val name: String = "",
    val description: String = "",
    val html_url: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val pushed_at: String = "",
    val language: String = "",
    val stargazers_count: Int = 0,
    val forks_count: Int = 0,
    val visibility: String = ""
)