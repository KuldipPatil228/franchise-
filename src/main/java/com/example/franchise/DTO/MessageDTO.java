package com.example.franchise.DTO;

import com.example.franchise.Enums.MessageType;

import java.util.Arrays;
import java.util.List;

public record MessageDTO(
        MessageType messageType,
        Object[] args
) {
    public boolean hasArgs() {
        return args != null && args.length > 0;
    }

    public List<Object> argsAsList() {
        return hasArgs() ? Arrays.stream(args()).toList() : null;
    }
}
