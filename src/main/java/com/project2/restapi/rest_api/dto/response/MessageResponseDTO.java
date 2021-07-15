package com.project2.restapi.rest_api.dto.response;

import lombok.Builder;
import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

@Data
@Builder
public class MessageResponseDTO {
    
    private String message;
}
