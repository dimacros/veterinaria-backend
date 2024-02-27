package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoNegocio implements IProductoNegocio {

    // Inyectamos una interface del Repositorio para acceder a la DB
    @Autowired
    IProductoRepositorio iProductoRepositorio;

    @Override
    public Producto registrar(Producto producto) {
        return iProductoRepositorio.save(producto); // insert into
    }

    @Override
    public Producto buscar(Long codigo) throws Exception {
        // where id =
        return iProductoRepositorio.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontro el producto con codigo: " + codigo));
    }

    @Override
    public List<Producto> listado() {
        return iProductoRepositorio.findAll(); // select * from tbl_producto;
    }

    @Override
    public Producto actualizar(Producto producto) throws Exception {
        buscar(producto.getCodigo()); // no requiere asignar a una var
        return iProductoRepositorio.save(producto);
    }

    @Override
    public double calcularIGV(Producto producto) {
//        double igv = 0;
        if (producto != null) {
            return 0.18 * producto.getPrecio();
        }
        return 0;
    }

    @Override
    public double calcularDescuento(Producto producto) {
        double descuento = 0;
        if (producto != null) {
            if (producto.getStock() >= 20) {
                descuento = 0.10 * producto.getPrecio();
            }
        }
        return descuento;
    }

    @Override
    public double calcularPrecioVenta(Producto producto) {
        return producto.getPrecio() + calcularIGV(producto)
                - calcularDescuento(producto);
    }

    @Override
    public double calcularPrecioVenta(Long codigo) throws Exception {
        return calcularPrecioVenta(buscar(codigo));
    }

    @Override
    public List<Producto> listadoProductosPorDescripcion(String prefijo) {
        return iProductoRepositorio.obtenerReportePorDescripcion(prefijo);
    }

    @Override
    public List<Producto> listadoTotal() {
        List<Producto> listado = iProductoRepositorio.findAll();
        for ( Producto producto:listado) {
            producto.setTotal(calcularPrecioVenta(producto));
        }
        return listado;
    }
}
