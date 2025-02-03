package com.progresa.demo.controllers;


import com.progresa.demo.models.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @GetMapping
    public String getProductos(Model model){
        List<Producto> listaProductos = new ArrayList<>();


        model.addAttribute("productos");
        return "listadoProductos";
    }

    @GetMapping("/{id}")
    public String getProductoById(@PathVariable("id") long id){
        return "detalleProducto";
    }

    @PostMapping
    public String nuevoProducto(@RequestBody Producto producto){
        return "nuevoProducto";
    }

    @PutMapping("/{id}")
    public String actualizarProducto(@PathVariable("id") long id, @RequestParam String nuevoNombre){
        return "actualizarProducto";
    }

   @RequestMapping(value="/save", method = {RequestMethod.POST, RequestMethod.GET})
    public String saveProducto(Model model, @ModelAttribute("productoform") Producto producto) {
        return "saveProducto";
    }

}
