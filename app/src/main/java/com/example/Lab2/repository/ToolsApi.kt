package com.example.Lab2.repository

import com.example.Lab2.models.ToolRequest
import retrofit2.Response
import retrofit2.http.GET

interface ToolsApi {
    @GET("new_text.json")
    suspend fun getTools(): Response<List<ToolRequest>>
}