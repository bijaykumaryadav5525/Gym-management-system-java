/*abstract class name as gymmember
  **all attributes (variable)having different data types stored in gymmember
*/
public abstract class GymMember{
    
     protected int  id;
     protected String  name;
     protected String  location;
     protected String  phone;
     protected String  email;
     protected String  gender;
     protected String  DOB;
     protected String  membershipstartdate;
     protected int  attendance;
     protected double  loyaltyPoints;
     protected boolean  activeStatus;
     
     //constructor
     public   GymMember(int id, String name, String location, String phone,String email, String gender, String DOB, String membershipstartdate){
       //call instance varibles as used "this" keyword
       this.id=id;
       this.name=name;
       this.location=location;
       this.phone=phone;
       this.email=email;
       this.gender=gender;
       this.DOB=DOB;
       this.membershipstartdate=membershipstartdate;
       this.attendance=0;
       this.loyaltyPoints=0;
       this.activeStatus=false;
       
       
       
    }
    
    // accessor method. and getter method
    
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getlocation(){
        return location;
    }
    public String getphone(){
        return phone;
    }
    public String getemail(){
        return email;
    }
    public String getgender(){
        return gender;
    }
    public String getDOB(){
        return DOB;
    }
    public String getmembershipstartdate(){
        return membershipstartdate;
    }
    public int getattendance(){
        return attendance;
    }
    public double getloyaltyPoints(){
        return loyaltyPoints;
    }
    public boolean getactiveStatus(){
        return activeStatus;
    }
    
    //create a abstract method name markAttendance.
    public abstract void markAttendance();
    //create a method activemembership .
    public void activateMembership(){
        if(!activeStatus){
            activeStatus=true;
            System.out.println("Membership to be activated" +id);
            
        }
        else{
            System.out.println("Membership to be renewed");
        }
    }
    //create a method deactivatemembership.
    public void deactivateMembership(){
        if(activeStatus){
            activeStatus=false;
            System.out.println("Membership to be deactivated" +id);
            
        }
        else{
            System.out.println("Membership to be paused");
        }
    }
    //create a method resetmember.
    public void resetMember(){
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0;
        
    }
    //Display method should output.
    public String display(){
        return "ID:" + id+
               "\nName:"+name+
               "\nPhone:" + phone+
               "\nEmail:" + email+
               "\nDate of Birth:" +DOB+
               "\nMemberShipStartDate:"+membershipstartdate+
               "\nAttendance:"+ attendance+
               "\nLoyalty Points:" +loyaltyPoints+
               "\nMembership Status:" + (activeStatus ? "Active" : "Inactive");
               
               
    
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
     
     
     
     
     
    
    
