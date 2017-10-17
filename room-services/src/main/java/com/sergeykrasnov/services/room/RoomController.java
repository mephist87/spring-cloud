package com.sergeykrasnov.services.room;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
@Api(value = "rooms", description = "Data service operations on rooms", tags = "rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @ApiOperation(value = "Get all rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    @RequestMapping(method = RequestMethod.GET)
    public List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNotEmpty(roomNumber)) {
            return Collections.singletonList(roomRepository.findRoomByRoomNumber(roomNumber));
        }
        return (List<Room>) roomRepository.findAll();
    }

}
