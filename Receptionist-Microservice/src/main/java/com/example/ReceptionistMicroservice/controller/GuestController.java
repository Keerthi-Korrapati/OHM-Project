package com.example.ReceptionistMicroservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReceptionistMicroservice.entity.Guest;
import com.example.ReceptionistMicroservice.exception.ResourceNotFoundException;
import com.example.ReceptionistMicroservice.repository.GuestRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;
    private static final Logger logger = LoggerFactory.getLogger(GuestController.class);

    @PostMapping("/guest/save")
    public Guest createGuest( @Valid @RequestBody Guest guest){
        logger.info("It is the guestposting method");
        return this.guestRepository.save(guest);
    }

    @GetMapping("/guest/list")

    public List<Guest> getguestlist(){
        return this.guestRepository.findAll();
    }
    @GetMapping("guest/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable(value="id") int guestId)throws ResourceNotFoundException {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(()->new ResourceNotFoundException("guest  not found:: "+guestId));
        return ResponseEntity.ok().body(guest);
    }
    @PutMapping("guest/edit/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable(value = "id") int  guestId,
                                                 @Validated @RequestBody Guest guestDetails  )
            throws ResourceNotFoundException {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("guest not found for this id :: " +guestId ));
       guest.setRoomNo(guestDetails.getRoomNo());
       guest.setName(guestDetails.getName());
       guest.setPhoneNo(guestDetails.getPhoneNo());
       guest.setEmail(guestDetails.getEmail());
       guest.setGender(guestDetails.getGender());
       guest.setAddress(guestDetails.getAddress());

        return ResponseEntity.ok(this.guestRepository.save(guest));
    }

    @DeleteMapping("guest/delete/{id}")
    public Map<String,Boolean> deleteGuest(@PathVariable(value = "id") int  guestId)throws ResourceNotFoundException {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("guest not found for this id :: " +guestId ));

        this.guestRepository.delete(guest);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }
}
