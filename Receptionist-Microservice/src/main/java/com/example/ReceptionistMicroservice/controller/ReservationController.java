package com.example.ReceptionistMicroservice.controller;

import com.example.ReceptionistMicroservice.entity.Reservation; 
import com.example.ReceptionistMicroservice.exception.ResourceNotFoundException;
import com.example.ReceptionistMicroservice.payload.response.MessageResponse;
import com.example.ReceptionistMicroservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;


    @PostMapping("/reservation/save")
    public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation){

        if (reservationRepository.existsByroomNo(reservation.getRoomNo())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" room is already Reserved!"));
        }
        Reservation rooms=new Reservation(reservation.getId(),reservation.getRoomNo(),reservation.getAdults(),reservation.getChildren(),reservation.getCheckindate(),reservation.getCheckoutdate());

        return ResponseEntity.ok().body(this.reservationRepository.save(rooms));
    }

    @GetMapping("reservation/list")
    public List<Reservation> getReservation(){
        return this.reservationRepository.findAll();
    }


    @GetMapping("reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(value="id") int reservationId)throws ResourceNotFoundException{
        Reservation reservation=reservationRepository.findById(reservationId)
                .orElseThrow(()->new ResourceNotFoundException("Reservation  not found:: "+reservationId));
        return ResponseEntity.ok().body(reservation);
    }


    @PutMapping("reservation/edit/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") int  reservationId,
                                                   @Validated @RequestBody Reservation reservationDetails  )
            throws ResourceNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found for this id :: " +reservationId ));
        reservation.setRoomNo(reservationDetails.getRoomNo());
        reservation.setChildren(reservationDetails.getChildren());
        reservation.setAdults(reservationDetails.getAdults());
        reservation.setCheckindate(reservationDetails.getCheckindate());
        reservation.setCheckoutdate(reservationDetails.getCheckoutdate());

        return ResponseEntity.ok(this.reservationRepository.save(reservation));
    }

    //Delete Reservation

    @DeleteMapping("reservation/delete/{id}")
    public Map<String,Boolean> deletereservation(@PathVariable(value = "id") int  reservationId)throws ResourceNotFoundException {
        Reservation reservation=reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("reservation not found for this id :: " +reservationId ));

        this.reservationRepository.delete(reservation);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }


}
