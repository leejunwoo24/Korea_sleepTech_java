package phr_solution.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientRequestDto {
	private Long id;
	private int age;
	private String name;
	private String gender;
}
