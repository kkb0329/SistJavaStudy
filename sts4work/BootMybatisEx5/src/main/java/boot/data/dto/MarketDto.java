package boot.data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("mdto")
public class MarketDto {

	private String num;
	private String sangpum;
	private int price;
	private String photoname;
	private Timestamp ipgoday;
	
}
