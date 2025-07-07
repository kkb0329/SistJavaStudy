package data.thyme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class ShopDto {

	private int num;
	private String sangpum;
	private int su;
	private int dan;
	private String color;
	
}
