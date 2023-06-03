package com.nehlavtcparis.chat.controller;

import com.nehlavtcparis.chat.models.Agent;
import com.nehlavtcparis.chat.models.ConnectedAgent;
import com.nehlavtcparis.chat.models.Response;
import com.nehlavtcparis.chat.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/validate")
    public Response validateAgentLoginDetails(@RequestBody Agent agentDetails) {
        Response userResponse = null;
        Agent agentData = this.agentService.validateAgentDetails(agentDetails);

        if (agentData != null) {
            agentDetails.setAgentName("Test Agent");
            userResponse = this.agentService.handleUserReponseEntity(1, "Operation Complete", agentDetails);
        } else {
            userResponse = this.agentService.handleUserReponseEntity(0, "Invalid Data.");
        }

        return userResponse;
    }

    @PostMapping("/connectedAgents")
    public Response getConnectedAgentList(@RequestBody ConnectedAgent agentDetails) {
        Response userResponse = null;
        boolean result = false;

        if (agentDetails != null) {
            result = this.agentService.storeConnectedAgents(agentDetails);

            if (result) {
                userResponse = this.agentService.handleUserReponseEntity(1, "Operation Complete");
            } else {
                userResponse = this.agentService.handleUserReponseEntity(1, "Operation In Complete");
            }
        } else {
            userResponse = this.agentService.handleUserReponseEntity(0, "Invalid Data.");
        }

        return  userResponse;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/getAgentList")
    public Response getConnectedAgentList() {
        Response userResponse = null;

        List<ConnectedAgent> connectedAgents = this.agentService.agentList;
        userResponse = this.agentService.handleUserReponseEntity(1, "Operation Complete", connectedAgents);

        return userResponse;
    }
}
