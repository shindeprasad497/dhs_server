package com.healthcare.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.app.dto.AppointmentDTO;
import com.healthcare.app.service.AppointmentService;


@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/{id}")
	public AppointmentDTO getAppointmentById(@PathVariable Long id)
	{
		return appointmentService.getAppointmentById(id);
	}
	
	
	
	@PostMapping(value="/book")
	public AppointmentDTO bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		return appointmentService.bookAppointment(appointmentDTO);
	}
	@GetMapping(value="/patientid/{petientId}")
	public List<AppointmentDTO> getAppointmentByPetientId(@PathVariable Long petientId)
	{
		return appointmentService.getAppointmentByPetientId(petientId);
	}
}
