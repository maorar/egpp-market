package com.egpp.egppmarket.persistence.crud;

import com.egpp.egppmarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //@Query(value="SELECT * FROM productos WHERE id_categoria = ?",nativeQuery=true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int Categoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}