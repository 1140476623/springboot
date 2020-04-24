package cn.gdj.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootdemo.bean.Events;
import springbootdemo.bean.States;

@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @RequestMapping("/testMachine")
    public void testMachine() {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
