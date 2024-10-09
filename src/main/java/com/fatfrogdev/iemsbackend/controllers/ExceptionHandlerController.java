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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}