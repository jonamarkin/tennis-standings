package com.ato.tennis_standings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerResponse {
    private String code;
    private String message;
    private Object data;
}
