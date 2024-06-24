package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Passenger;
import com.example.service.PassengerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passenger")
    public String listPassenger(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("passengers", passengerService.getAllPassengers());
        model.addAttribute("passenger", new Passenger());
        return "passengerManagement";
    }

    @PostMapping("/passengers")
    public String addPassenger(@ModelAttribute Passenger passenger, @RequestParam(value = "mailingList", required = false) String mailingList, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        passenger.setMailingList(mailingList != null && mailingList.equals("true"));
        passengerService.addPassenger(passenger);
        return "redirect:/passenger";
    }

    @PostMapping("/passengers/delete/{id}")
    public String deletePassenger(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        passengerService.deletePassenger(id);
        return "redirect:/passenger";
    }

    @GetMapping("/passengers/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Passenger passenger = passengerService.getPassengerById(id);
        return "editPassenger";
    }

    @PostMapping("/passenger/update")
    public String updatePassenger(@ModelAttribute Passenger passenger, @RequestParam(value = "mailingList", required = false) String mailingList, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        passenger.setMailingList(mailingList != null && mailingList.equals("true"));
        passengerService.updatePassenger(passenger);
        return "redirect:/passenger";
    }
}
