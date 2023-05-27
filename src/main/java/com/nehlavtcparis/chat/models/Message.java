package com.nehlavtcparis.chat.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private String senderName;
    private String recieverName;
    private String message;
    private String date;
    private String status;
}
