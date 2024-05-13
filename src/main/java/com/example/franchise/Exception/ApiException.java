package com.example.franchise.Exception;



import com.example.franchise.DTO.MessageDTO;
import com.example.franchise.Enums.MessageType;

import java.util.List;

public class ApiException extends RuntimeException {
    private final transient MessageDTO messageDTO;
    private final transient List<String> details;

    public ApiException(MessageType messageType) {
        messageDTO = new MessageDTO(messageType, null);
        details = null;
    }

    public ApiException(MessageType messageType, Object... args) {
        messageDTO = new MessageDTO(messageType, args);
        details = null;
    }

    public ApiException(MessageType messageType, List<String> details) {
        messageDTO = new MessageDTO(messageType, null);
        this.details = details;
    }

    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

    public List<String> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Message Code=");
        sb.append(messageDTO.messageType().getCode());
        if (messageDTO.args() != null && messageDTO.args().length > 0) {
            sb.append(", args=");
            for (Object arg : messageDTO.args()) {
                if (arg != null)
                    sb.append("{").append(arg).append("}");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}

