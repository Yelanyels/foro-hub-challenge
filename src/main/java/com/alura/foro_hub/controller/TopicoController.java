package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        // Regla de negocio: No permitir duplicados (mismo título y mensaje)
        var existe = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (existe) {
            throw new RuntimeException("Este tópico ya existe en el foro.");
        }

        repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListadoTopico> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        // 1. Verificar si existe (usando Optional como sugiere la cartilla)
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 2. Cargar el tópico y actualizar
        var topico = topicoOptional.get();
        topico.actualizarDatos(datos);

        // 3. Retornar los datos actualizados
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        // La cartilla sugiere verificar si el tópico existe antes de borrar
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si el ID no es correcto
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content como buena práctica REST
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

}