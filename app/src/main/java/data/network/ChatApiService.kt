package data.network

import com.example.myapplication.data.network.dto.MessageDto
import com.example.myapplication.data.network.dto.NewMessageDto

interface ChatApiService {
    @GET("messages")
    suspend fun getMessages(
        @Query("sortBy") sortBy: String = "createdAt",
        @Query("order") order: String = "desc"
    ): List<MessageDto>

    @POST("messages")
    suspend fun sendMessage(
        @Body message: NewMessageDto
    ): MessageDto
}