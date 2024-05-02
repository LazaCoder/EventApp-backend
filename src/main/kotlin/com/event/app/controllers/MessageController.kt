import com.event.app.models.Message
import com.event.app.repository.MessageRepository
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired

@Controller
class MessageController @Autowired constructor(private val messageRepository: MessageRepository) {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    fun processMessage(message: Message): Message {
        // Save the incoming message to the database
        val savedMessage = messageRepository.save(message)

        // Return the saved message to update all clients via WebSocket
        return savedMessage
    }
}