package com.example.Lab2.networks

import com.example.Lab2.models.ToolRequest
import retrofit2.Response

interface INetworkSource {
    suspend fun getTools(): Response<List<ToolRequest>>
}