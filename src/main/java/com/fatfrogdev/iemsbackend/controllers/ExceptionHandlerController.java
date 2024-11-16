package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.ErrorObjectDto;
import com.fatfrogdev.iemsbackend.exceptions.brand.BrandAlreadyExistsException;
import com.fatfrogdev.iemsbackend.exceptions.brand.BrandAlreadyHasProductsException;
import com.fatfrogdev.iemsbackend.exceptions.brand.BrandNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileHasNotValidExtensionException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileSizeNotValidException;
import com.fatfrogdev.iemsbackend.exceptions.file.UploadFileException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.ErrorSavingLeaderboardException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.LeaderboardDetailsNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.leaderboard.LeaderboardNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductAlreadyExistsException;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductAlreadyHasReviewsException;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.review.ReviewAlreadyExistsException;
import com.fatfrogdev.iemsbackend.exceptions.review.ReviewNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserAlreadyExistsException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserIsActiveException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.user.UserIsInactiveException;
import jakarta.validation.ConstraintViolation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {

    private static final DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm");
    private static final String date = LocalDateTime.now().format(format);

    // Brand Exceptions

    @ExceptionHandler({BrandAlreadyExistsException.class})
    public ResponseEntity<ErrorObjectDto> handleBrandAlreadyExistsException(BrandAlreadyExistsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST,e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({BrandAlreadyHasProductsException.class})
    public ResponseEntity<ErrorObjectDto> handleBrandAlreadyHasProductsException(BrandAlreadyHasProductsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({BrandNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleBrandNotFoundException(BrandNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    // File Exceptions

    @ExceptionHandler({FileNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleFileNotFoundException(FileNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler({FileHasNotValidExtensionException.class})
    public ResponseEntity<ErrorObjectDto> handleFileHasNotValidExtensionException(FileHasNotValidExtensionException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({FileSizeNotValidException.class})
    public ResponseEntity<ErrorObjectDto> handleFileSizeNotValidException(FileSizeNotValidException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({UploadFileException.class})
    public ResponseEntity<ErrorObjectDto> handleUploadFileException(UploadFileException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.INTERNAL_SERVER_ERROR, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    // Leaderboard Exceptions

    @ExceptionHandler({LeaderboardNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleLeaderboardNotFoundException(LeaderboardNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler({LeaderboardDetailsNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleLeaderboardDetailsNotFoundException(LeaderboardDetailsNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler({ErrorSavingLeaderboardException.class})
    public ResponseEntity<ErrorObjectDto> handleErrorSavingLeaderboardException(ErrorSavingLeaderboardException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.INTERNAL_SERVER_ERROR, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    //  Product Exceptions

    @ExceptionHandler({ProductAlreadyExistsException.class})
    public ResponseEntity<ErrorObjectDto> handleProductAlreadyExistsException(ProductAlreadyExistsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleProductNotFoundException(ProductNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler({ProductAlreadyHasReviewsException.class})
    public ResponseEntity<ErrorObjectDto> handleProductAlreadyHasReviewsException(ProductAlreadyHasReviewsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    // Review Exceptions

    @ExceptionHandler({ReviewNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleReviewNotFoundException(ReviewNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler({ReviewAlreadyExistsException.class})
    public ResponseEntity<ErrorObjectDto> handleReviewAlreadyExistsException(ReviewAlreadyExistsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    // User Exceptions

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorObjectDto> handleUserNotFoundException(UserNotFoundException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }


    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<ErrorObjectDto> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({UserIsActiveException.class})
    public ResponseEntity<ErrorObjectDto> handleUserIsAlreadyActiveException(UserIsActiveException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler({UserIsInactiveException.class})
    public ResponseEntity<ErrorObjectDto> handleUserWasAlreadyDeactivatedException(UserIsInactiveException e){
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST, e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    // Validation exceptions

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(jakarta.validation.ConstraintViolationException ex) {
        // Gets all the constraint violations
        Set<ConstraintViolation<?>> validationErrors = ex.getConstraintViolations();

        // Converts the violations to a map
        Map<String, String> mapErrors = validationErrors.stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage
                ));
        return new ResponseEntity<>(mapErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<ErrorObjectDto> handleConstraintViolationException(org.hibernate.exception.ConstraintViolationException ex) {
        ErrorObjectDto errorObject = new ErrorObjectDto(date, HttpStatus.BAD_REQUEST,ex.getClass().getSimpleName(), this.formatSQLConstraintViolation(ex.getErrorMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    /**
     * Formats the SQL Constraint Violation Exception. Replaces the "Detail:" string and removes the brackets.
     * Used to format the error message of the ConstraintViolationException and avoid showing explicit SQL errors.
     * @param errorString
     * @return String
     * */
    private String formatSQLConstraintViolation(String errorString){
        return errorString.split("Detail:", 2)[1]
                .trim()
                .replaceAll("[\\[\\]()]", "");
    };
}