package com.example.loginauthapi.controllers;

import com.example.loginauthapi.model.Guest;
import com.example.loginauthapi.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin("*")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @PostMapping
    public String addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest.getName(), guest.getDescription(), guest.getDayOfWeek());
    }

    @PutMapping("/{id}")
    public void updateGuest(@PathVariable String id, @RequestBody Guest guest) {
        guestService.updateGuest(id, guest.getName(), guest.getDescription(), guest.getDayOfWeek());
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable String id) {
        guestService.deleteGuest(id);
    }
}