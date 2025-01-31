package com.example.loginauthapi.service;

import com.example.loginauthapi.model.Guest;
import com.example.loginauthapi.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public String addGuest(String name, String description, String dayOfWeek) {
        // Verifica se já existe um convidado para o dia
        Optional<Guest> existingGuest = guestRepository.findByDayOfWeek(dayOfWeek);
        if (existingGuest.isPresent()) {
            return "Já existe um convidado para " + dayOfWeek;
        }

        Guest newGuest = new Guest(name, description, dayOfWeek);
        guestRepository.save(newGuest);
        return "Convidado cadastrado com sucesso!";
    }

    public void updateGuest(String id, String name, String description, String dayOfWeek) {
        Optional<Guest> guestOptional = guestRepository.findById(id);

        if (guestOptional.isPresent()) {
            Guest guest = guestOptional.get();

            // Verifica se está alterando para um dia já ocupado
            if (!guest.getDayOfWeek().equals(dayOfWeek) && guestRepository.findByDayOfWeek(dayOfWeek).isPresent()) {
                throw new RuntimeException("Já existe um convidado para " + dayOfWeek);
            }

            guest.setName(name);
            guest.setDescription(description);
            guest.setDayOfWeek(dayOfWeek);
            guestRepository.save(guest);
        }
    }

    public void deleteGuest(String id) {
        guestRepository.deleteById(id);
    }
}