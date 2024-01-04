/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.lab2;

/**
 *
 * @author Tai NGguyen
 * Student Number: 041086103
 * validation class is a custom exception class used to indicate that data
 * does not meet the required validation criteria
 */
public class ValidationException extends Exception{
    /**
     *  Constructs a new `ValidationException` with a default error message.
     */
    public ValidationException(){
        super("Data not in valid format");
    }
    /**
     * Constructs a new `ValidationException` with a custom error message.
     * @param message The custom error message describing the validation failure.
     */
    public ValidationException(String message){
        super(message);
    }
    /**
     * Constructs a new `ValidationException` with a custom error message and a cause.
     * @param message The custom error message describing the validation failure.
     * @param throwable The cause of the exception.
     */
    public ValidationException(String message, Throwable throwable){
        super(message, throwable);
    }
    /**
     * Constructs a new `ValidationException` with a cause.
     * @param throwable The cause of the exception.
     */
    public ValidationException(Throwable throwable){
        super(throwable);
    }
    
}
