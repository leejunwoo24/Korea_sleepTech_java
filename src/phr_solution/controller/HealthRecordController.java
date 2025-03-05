package phr_solution.controller;

import java.util.List;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.RecordResponseDto;
import phr_solution.service.HealthRecordService;
import phr_solution.service.implement.HealthRecordServiceimpl;

public class HealthRecordController {
	private HealthRecordService service;
	
	public HealthRecordController() {
		this.service = new HealthRecordServiceimpl();
	}
	
	public void createRecord(RecordRequestDto dto) {
		service.createRecord(dto);
	}
	
	public List<RecordResponseDto> getAllRecords(){
		return service.getAllRecords();
	}
	
	public List<RecordResponseDto> filterRecordByDiagnosis(String diagnosis){
		return service.filterRecordsByDiagnosis(diagnosis);
	}
	
	public void deleteRecord(long id) {
		service.deleteRecord(id);
	}
}
