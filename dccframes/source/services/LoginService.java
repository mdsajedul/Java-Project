package services;
import repositories.*;
public class LoginService{
    UserRepository userRepository=new UserRepository();
    public boolean adminValidation(String userText,String passwordText){
        return userRepository.getAdminValidity(userText,passwordText);
    }
    public boolean doctorValidation(String userText,String passwordText){
        return userRepository.getDoctorValidity(userText,passwordText);
    }
   
}