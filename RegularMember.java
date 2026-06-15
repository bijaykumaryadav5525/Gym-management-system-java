/*create a class regularmember extends with gymmember abstract class name as gymmember
 **all attributes (variable)having different data types stored in gymmember
 */
public class RegularMember extends GymMember{
    //all variables 
    private int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    //constructor
    public RegularMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipstartDate,String refferralSource){

        super(id,name,location,phone,email,gender,DOB,membershipstartDate);
        this.isEligibleForUpgrade=false;
        this.attendanceLimit=30;
        this.plan="basic";
        this.price=6500;
        this.removalReason="";

        //accessor method or getters

       
    }

    public int getattendanceLimit(){
        return attendanceLimit;

    }

    public boolean getisEligibleForUpgrade(){
        return isEligibleForUpgrade;

    }

    public String getremovalReason(){
        return removalReason;

    }

    public String getreferralSource(){
        return referralSource;

    }

    public String getplan(){
        return plan;

    }

    public double getprice(){
        return price;

    }

    @Override
    public void markAttendance(){
        this.attendance++;
        this.loyaltyPoints+=5;

        //note part, >= comditions
        if(getattendance()>=attendanceLimit){
            isEligibleForUpgrade=true;
            System.out.println("Enter a iseligibleforupgrade:" + id);

        }

    }
    //create a method named as getPlanPrice.
    public double getPlanPrice(){
        switch(plan){
            case "basic":
                return 6500;

            case "standard":
                return 12500;

            case "delux":
                return 18500;

            default:
                System.out.println("Invalid plan by passes.");
                return -1;

            
        }
    }
    // create a method named as upgradePlan with return type string
    /*public String upgradePlan(){
    if(!isEligibleForUpgrade){
    return "upgrade not allowed:";

    }
    plan=plan;
    price=price;
    return "Updated successfully."+plan;

            
    }*/
    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) {
            return "Not eligible for upgrade yet.";
        }

        double newPrice = getPlanPrice(newPlan);

        if (newPrice < 0) {
            return "Invalid plan selected: " + newPlan;
        }

        this.plan = newPlan;
        this.price = newPrice;
        this.isEligibleForUpgrade = false; // Reset eligibility after upgrade
        return String.format("Plan upgraded successfully to: %s\nNew Price: $%.2f", newPlan, newPrice);
    }

    private double getPlanPrice(String planName) {
        // Define your plan prices here
        switch(planName.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "delux":
                return 18500;

            default:
                return -1; // indicates invalid plan
        }
    }
    //create a method named as revertRegularMember.
    public void revertRegularMember(){
        this.removalReason=removalReason;
        //calling a superclass name as restMember.
        super.resetMember();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        System.out.println(id +"Removal Rasson:" + removalReason );

    }
    //display
    @Override
    public String display(){
        //calling super class name as display
        return super.display() +
        "\nReferral Source: " + referralSource +
        "\nPlan: " + plan +
        "\nPrice: " + price +
        "\nEligible for Upgrade: " + (isEligibleForUpgrade ? "Yes" : "No");

    }
        
}
    
    
