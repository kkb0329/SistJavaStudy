package boot.jpa.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boot.jpa.dto.ShopDto;
import boot.jpa.repository.*;

@Repository
public class ShopDao {

    @Autowired
    ShopInter shopInter;

    // insert
    public void insertShop(ShopDto dto) {
        shopInter.save(dto);
    }

    // 전체 출력
    public List<ShopDto> getAllDatas() {
        return shopInter.findAll();
    }

    // 단일 DTO 반환
    public ShopDto getData(int num) {
        return shopInter.findById(num).orElse(null);
    }

    // update (save는 PK 있으면 update)
    public void updateShop(ShopDto dto) {
        shopInter.save(dto);
    }

    // delete
    public void deleteShop(int num) {
        shopInter.deleteById(num);
    }
}
