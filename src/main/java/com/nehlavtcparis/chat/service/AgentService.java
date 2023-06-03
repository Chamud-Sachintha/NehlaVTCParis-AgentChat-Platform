package com.nehlavtcparis.chat.service;

import com.nehlavtcparis.chat.models.Agent;
import com.nehlavtcparis.chat.models.ConnectedAgent;
import com.nehlavtcparis.chat.models.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {

    public List<ConnectedAgent> agentList = new ArrayList<>();

    public Agent validateAgentDetails(Agent agentDetails) {

        if (agentDetails.getUserName().equalsIgnoreCase("test_agent") && agentDetails.getPassword().equalsIgnoreCase("123")) {
            return  agentDetails;
        } else {
            return null;
        }
    }

    public boolean storeConnectedAgents(ConnectedAgent agentDetails) {

        boolean response = false;

        try {

            if ((!this.validateUsernameExist(agentDetails)) && agentDetails != null) {
                this.agentList.add(agentDetails);
            }

            response = true;
        } catch (Exception e) {
            response = false;
        }

        return response;
    }

    private boolean validateUsernameExist(ConnectedAgent agentDetails) {

        boolean isExist = false;

        for (ConnectedAgent connectedAgent : this.agentList) {

            if (connectedAgent.getAgentName().equalsIgnoreCase(agentDetails.getAgentName())) {
                isExist = true;
                break;
            }
        }

        return isExist;
    }

    public Response handleUserReponseEntity(int statusCode, String message, Object ...data) {
        Response responseHandleRequest = new Response();

        responseHandleRequest.setStatusCode(statusCode);
        responseHandleRequest.setMessage(message);
        responseHandleRequest.setData(data);

        return responseHandleRequest;
    }
}
