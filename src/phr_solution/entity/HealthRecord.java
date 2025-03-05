package phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthRecord {
	private Long id;
	private Long patientId; // 해당 환자의 고유 번호
	private String dateOfVisit; // 방문날자
	private String diagnosis; // 진단
	private String treatment; // 처방
}
