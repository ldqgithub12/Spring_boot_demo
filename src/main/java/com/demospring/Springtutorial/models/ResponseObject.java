package com.demospring.Springtutorial.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
