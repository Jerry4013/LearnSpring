package com.frankmoley.landon.data.webservice;

import com.frankmoley.landon.data.entity.Room;
import com.frankmoley.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    List<Room> findAll(@RequestParam(required = false) String roomNumber){
        ArrayList<Room> rooms = new ArrayList<>();
        if (roomNumber == null){
            Iterable<Room> results = this.repository.findAll();
            results.forEach(room -> {rooms.add(room);});
        }else {
            Room room = this.repository.findByNumber(roomNumber);
            if (room != null) {
                rooms.add(room);
            }
        }
        return rooms;
    }
}
