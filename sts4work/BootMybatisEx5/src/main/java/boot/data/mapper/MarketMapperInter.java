package boot.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MarketDto;

@Mapper
public interface MarketMapperInter {

	public int getTotalCount();
	public void insertMarket(MarketDto dto);
}
