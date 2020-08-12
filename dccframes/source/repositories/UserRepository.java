package repositories;
import java.sql.*;
public class UserRepository{
    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    public UserRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Dcc","root","");
            stmt=con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean getAdminValidity(String username,String password){
        try{
            query="SELECT * FROM admin WHERE username='"+username+"' AND password='"+password+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean getDoctorValidity(String username,String password){
        try{
            query="SELECT * FROM doctor WHERE doctorId='"+username+"' AND dPassword='"+password+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean insertPrisonerIntoDB(String firstNameText,String prisonIdText,String ageText,String parentText,String dobText,String sexText,String addressText,String crimeText,String entryText){
        try{
            query="INSERT INTO prisoner(pFirstName,prisonerId,pAge,pParentName,pDob,pSex,pAddress,crime,entryDate) VALUES('"+firstNameText+"','"+prisonIdText+ "','"+ageText+"','"+parentText+"','"+dobText+"','"+sexText+"','"+addressText+"','"+crimeText+"','"+entryText+"')";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }


    public boolean searchPrisonerIntoDB(String searchPrisonerText){
        try{
            query="select * from prisoner where prisonerId='"+searchPrisonerText+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean insertGuardIntoDB(String firstNameText,String guardIdText,String ageText,String parentText,String dobText,String sexText,String addressText,String startText,String phoneText){
        try{
            query="INSERT INTO guard(gFirstName,guardId,gAge,gParentName,gDob,gSex,gAddress,startDate,gPhone) VALUES('"+firstNameText+"','"+guardIdText+ "','"+ageText+"','"+parentText+"','"+dobText+"','"+sexText+"','"+addressText+"','"+startText+"','"+phoneText+"')";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }



    public boolean insertDoctorIntoDB(String firstNameText,String doctorIdText,String ageText,String emailText,String dobText,String sexText,String addressText,String entryText,String passwordText){
        try{
            query="INSERT INTO doctor(dFirstName,doctorId,dAge,email,dDob,dSex,dAddress,dEntry,dPassword) VALUES('"+firstNameText+"','"+doctorIdText+ "','"+ageText+"','"+emailText+"','"+dobText+"','"+sexText+"','"+addressText+"','"+entryText+"','"+passwordText+"')";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean insertStuffIntoDB(String firstNameText,String stuffsIdText,String ageText,String dobText,String sexText,String workTypeText,String addressText,String entryText){
        try{
            query="INSERT INTO stuff(sFirstName,stuffId,sAge,sDob,sSex,sWork,sAddress,sEntry) VALUES('"+firstNameText+"','"+stuffsIdText+ "','"+ageText+"','"+dobText+"','"+sexText+"','"+workTypeText+"','"+addressText+"','"+entryText+"')";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean getDoctorRemove(String searchDoctorText){

        try{
           
            String sql="Delete from doctor where doctorId ='"+searchDoctorText+"'";
          int i=stmt.executeUpdate(sql);
          if(i==1){
              return true;
        }
        else{
            return false;
        }
    }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean getPrisonerRemove(String searchPrisonerText){

        try{
            
            String sql="Delete from prisoner where prisonerId ='"+searchPrisonerText+"'";
          int i=stmt.executeUpdate(sql);
          if(i==1){
              return true;
        }
        else{
            return false;
        }
    }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean getGuardRemove(String searchGuardText){

        try{
            
            String sql="Delete from guard where guardId ='"+searchGuardText+"'";
          int i=stmt.executeUpdate(sql);
          if(i==1){
              return true;
        }
        else{
            return false;
        }
    }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean getStuffRemove(String searchStuffsText){

        try{
           
            String sql="Delete from stuff where stuffId ='"+searchStuffsText+"'";
          int i=stmt.executeUpdate(sql);
          if(i==1){
              return true;
        }
        else{
            return false;
        }
    }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean addHealthToDB(String searchPrisonerText,String pHealthn){
        try{
            query="UPDATE prisoner SET pHealth='"+pHealthn+"' WHERE prisonerId='"+searchPrisonerText+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    
}