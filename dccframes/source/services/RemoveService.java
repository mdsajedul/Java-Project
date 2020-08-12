package services;
import repositories.*;
public class RemoveService{
    UserRepository userRepository=new UserRepository();
    public boolean doctorRemove(String searchDoctorText){
        return userRepository.getDoctorRemove(searchDoctorText);
    }

    public boolean prisonerRemove(String searchPrisonerText){
        return userRepository.getPrisonerRemove(searchPrisonerText);
    }

    public boolean guardRemove(String searchGuardText){
        return userRepository.getGuardRemove(searchGuardText);
    }

    public boolean stuffRemove(String searchStuffsText){
        return userRepository.getStuffRemove(searchStuffsText);
    }




}