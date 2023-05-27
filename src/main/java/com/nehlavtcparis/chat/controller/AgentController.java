package com.nehlavtcparis.chat.controller;

import com.nehlavtcparis.chat.models.Agent;
import com.nehlavtcparis.chat.models.Response;
import com.nehlavtcparis.chat.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
