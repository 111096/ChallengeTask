/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.challenge.controller;

import net.challenge.entity.Tick;
import net.challenge.entity.Statistics;
import net.challenge.service.TickService;
import net.challenge.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

/**
 * @author moust
 */
@RestController
@RequestMapping("/api")
public class ChallengeController {

    @Autowired
    TickService tickService;

    @Autowired
    StatisticService statisticService;

    @PostMapping("/tick")
    public String createNewTick(@RequestBody Tick tick) {
        System.out.println(System.currentTimeMillis());
        return tickService.createNewTick(tick);
    }

    @GetMapping("/statistics")
    public Statistics getStatistics() {
        return statisticService.getStatistics();
    }

    @GetMapping("/{instrument}")
    public Tick getStatistics(@PathVariable("instrument") String instrument) {
        return tickService.findInstrumentById(instrument);
    }

    @GetMapping("fourth")
    public Hashtable<String, Tick> fourth() {
        return tickService.readFile();
    }

}
