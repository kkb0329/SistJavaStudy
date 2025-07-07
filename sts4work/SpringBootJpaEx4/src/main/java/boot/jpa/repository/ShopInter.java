package boot.jpa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import boot.jpa.dto.ShopDto;

public interface ShopInter extends JpaRepository<ShopDto, Integer> {
    // 기본 CRUD 자동 제공
}
