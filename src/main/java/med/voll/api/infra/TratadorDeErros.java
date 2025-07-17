// src/main/java/med/voll/api/infra/TratadorDeErros.java
package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity tratarErro500(Exception ex) {
        return ResponseEntity.status(500).body("Erro interno: " + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroValidacao(MethodArgumentNotValidException ex) {
           var error = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro -> (FieldError) erro)
                .toList();

        return ResponseEntity.badRequest().body(error.stream().map(DadosError::new).toList());
    }

    private record DadosError(String campo, String mensagem) {
        public DadosError(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}