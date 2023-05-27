package com.nehlavtcparis.chat.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {

    private int statusCode;
    private String message;
    private Object data;
}
