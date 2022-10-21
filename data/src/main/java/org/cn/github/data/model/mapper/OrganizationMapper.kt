package org.cn.github.data.model.mapper

import org.cn.github.data.model.OrganizationListEntity
import org.cn.github.domain.model.OrganizationList

class OrganizationMapper : Mapper<ArrayList<OrganizationListEntity>, ArrayList<OrganizationList>> {

    override fun map(input: ArrayList<OrganizationListEntity>): ArrayList<OrganizationList> {
        return with(input) {
            getOrganizationList(this)
        }
    }

    private fun getOrganizationList(results: ArrayList<OrganizationListEntity>): ArrayList<OrganizationList> {
        val list = ArrayList<OrganizationList>()
        list.add(OrganizationList())
        results.map { data ->
            list.add(
                OrganizationList(
                    avatarUrl = data.avatarUrl ?: "",
                    description = data.description ?: "",
                    eventsUrl = data.eventsUrl ?: "",
                    hooksUrl = data.hooksUrl ?: "",
                    id = data.id ?: 0,
                    issuesUrl = data.issuesUrl ?: "",
                    login = data.login ?: "",
                    membersUrl = data.membersUrl ?: "",
                    nodeId = data.nodeId ?: "",
                    publicMembersUrl = data.publicMembersUrl ?: "",
                    reposUrl = data.reposUrl ?: "",
                    url = data.url ?: ""
                )
            )
        }
        return list
    }
}