package com.healthcare.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.app.dto.HealthConditionDTO;
import com.healthcare.app.entity.HealthCondition;
import com.healthcare.app.repository.HealthConditionRepo;

@Service
public class HealthConditionService {
	@Autowired
	HealthConditionRepo repo;

	public List<HealthConditionDTO> findAll() {
		List<HealthCondition> healthConditions = repo.findAll();
		List<HealthConditionDTO> healthConditionDTOs = new ArrayList<>();
		for (HealthCondition healthCondition : healthConditions) {
			healthConditionDTOs.add(healthCondition.toDto(healthCondition));
		}
		return healthConditionDTOs;

	}

	public HealthConditionDTO saveHealthCondition(HealthConditionDTO healthConditionDTO) {
		HealthCondition healthCondition = new HealthCondition();
		healthCondition = repo.save(healthCondition.toEntity(healthConditionDTO));
		return healthCondition.toDto(healthCondition);
	}

	public HealthConditionDTO findHealthConditionById(Long id) {
		Optional<HealthCondition> healthCondition = repo.findById(id);
		if (healthCondition.isPresent()) {
			return healthCondition.get().toDto(healthCondition.get());
		}
		return new HealthConditionDTO();
	}

	public void deleteHealthCondition(Long id) {
		Optional<HealthCondition> healthCondition = repo.findById(id);
		if (healthCondition.isPresent()) {
			repo.deleteById(id);
		}
	}

	public HealthConditionDTO updateHealthCondition(HealthConditionDTO healthConditionDTO) {
		HealthCondition healthCondition = new HealthCondition();
		healthCondition = repo.save(healthCondition.toEntity(healthConditionDTO));
		return healthCondition.toDto(healthCondition);
	}



}
