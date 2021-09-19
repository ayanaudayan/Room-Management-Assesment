package com.inxldigital.roomManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inxldigital.roomManagement.model.Room;
import com.inxldigital.roomManagement.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/addform")
	public String showAddForm(Room room,Model model)
	{
        room= new Room();
		 model.addAttribute("room",room);
		return "add";
	}
	
	@PostMapping("/create")
    public String addRoom(@ModelAttribute Room room) {
        
		roomService.save(room);
        return "redirect:/index";
    }
	
	@GetMapping("/index")
	public String showRoomList(Model model) {
	    model.addAttribute("rooms", roomService.findAll());
	    return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    Room room = roomService.findById(id);
	    model.addAttribute("room", room);
	    return "update-room";
	}
	
	@PostMapping("/update")
	public String updateRoom( Room room) {
 
		roomService.save(room);
	    return "redirect:/index";
	}
}
