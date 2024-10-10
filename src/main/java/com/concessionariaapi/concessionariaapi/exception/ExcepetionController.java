package com.concessionariaapi.concessionariaapi.exception;



import com.concessionariaapi.concessionariaapi.dto.ExceptionDto;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice(annotations = RestController.class)
public class ExcepetionController{

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(CreateCarException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(CarsNotFound.class)
    public ResponseEntity<?> notFound(CarsNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.Conflict.class)
    public ResponseEntity<?> conflict(HttpClientErrorException.Conflict ex) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }





}
