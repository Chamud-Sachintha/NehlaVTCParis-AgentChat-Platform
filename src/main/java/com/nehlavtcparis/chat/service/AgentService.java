package com.nehlavtcparis.chat.service;

import com.nehlavtcparis.chat.models.Agent;
import com.nehlavtcparis.chat.models.Response;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    public Agent validateAgentDetails(Agent agentDetails) {

        if (agentDetails.getUserName().equalsIgnoreCase("test_agent") && agentDetails.getPassword().equalsIgnoreCase("123")) {
            return  agentDetails;
        } else {
            return null;
        }
    }

    public Response handleUserReponseEntity(int statusCode, String message, Object ...data) {
        Response responseHandleRequest = new Response();

        responseHandleRequest.setStatusCode(statusCode);
        responseHandleRequest.setMessage(message);
        responseHandleRequest.setData(data);

        return responseHandleRequest;
    }
}
