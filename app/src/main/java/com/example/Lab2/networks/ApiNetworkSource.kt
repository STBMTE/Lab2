package com.example.Lab2.networks

import com.example.Lab2.models.ToolRequest
import com.example.Lab2.repository.RetrofitBuilder
import retrofit2.Response

class ApiNetworkSource: INetworkSource {

    override suspend fun getTools(): Response<List<ToolRequest>> {
        return RetrofitBuilder.toolsApi.getTools()
    }
}