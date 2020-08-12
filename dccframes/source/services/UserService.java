package services;
import repositories.*;
public class UserService{
    UserRepository userRepository=new UserRepository();
    public boolean addNewPrisoner(String firstNameText,String prisonIdText,String ageText,String parentText,String dobText,String sexText,String addressText,String crimeText,String entryText){
        return userRepository.insertPrisonerIntoDB(firstNameText,prisonIdText,ageText,parentText,dobText,sexText,addressText,crimeText,entryText);
    }
    public boolean searchPrisoner(String searchPrisonerText){
        return userRepository.searchPrisonerIntoDB(searchPrisonerText);
    }
    public boolean addNewGuard(String firstNameText,String guardIdText,String ageText,String parentText,String dobText,String sexText,String addressText,String startText,String phoneText){
        return userRepository.insertGuardIntoDB(firstNameText,guardIdText,ageText,parentText,dobText,sexText,addressText,startText,phoneText);
    }
    public boolean addNewDoctor(String firstNameText,String doctorIdText,String ageText,String emailText,String dobText,String sexText,String addressText,String entryText,String passwordText){
        return userRepository.insertDoctorIntoDB(firstNameText,doctorIdText,ageText,emailText,dobText,sexText,addressText,entryText,passwordText);
    }
    public boolean addNewStuff(String firstNameText,String stuffsIdText,String ageText,String dobText,String sexText,String workTypeText,String addressText,String entryText){
        return userRepository.insertStuffIntoDB(firstNameText,stuffsIdText,ageText,dobText,sexText,workTypeText,addressText,entryText);
    }

    public boolean addHealth(String searchPrisonerText,String pHealthn){
        return userRepository.addHealthToDB(searchPrisonerText,pHealthn);
    }

}