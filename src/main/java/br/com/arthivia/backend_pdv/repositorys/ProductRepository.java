package br.com.arthivia.backend_pdv.repositorys;

import br.com.arthivia.backend_pdv.models.entitys.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByBarCode(String barCode);
}
