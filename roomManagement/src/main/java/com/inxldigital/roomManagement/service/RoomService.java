package com.inxldigital.roomManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inxldigital.roomManagement.model.Room;
import com.inxldigital.roomManagement.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepository;
	
	public void save(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
	}

	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	public Room findById(long id) {
		// TODO Auto-generated method stub
		return roomRepository.getById(id);
	}

}
