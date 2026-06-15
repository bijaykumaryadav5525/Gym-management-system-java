/*create a class premiummember extends with gymmember abstract class name as gymmember
 **all attributes (variable)having different data types stored in gymmember
 */

public class PremiumMember extends GymMember{
    private double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    //constructor,class name is always same as constructor name
    public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartdate,String personalTrainer){
        //calling super class constructor with eigth parameters
        super(id,name,location,phone,email,gender,DOB,membershipStartdate);

        // set a values attributes
        this.premiumCharge=50000;
        this.paidAmount=0;
        this.isFullPayment=false;
        this.discountAmount=0;
        this.personalTrainer=personalTrainer;
    }
    //getters method
    public double getPrice(){
        return premiumCharge;
    }

    public String getpersonalTrainer(){
        return personalTrainer;
    }

    public boolean getisFullPayment(){
        return isFullPayment;
    }

    public double getpaidAmount(){
        return paidAmount;
    }

    public double getdiscountAmount(){
        return discountAmount;
    }
    //create a method as return type string.
    public String payDueAmount(double amount ){
        //already payment
        if(this.isFullPayment){
            return "Payment is already full.";

        }
        if(paidAmount+amount>premiumCharge){
            return "Enter a valid amount.";

        }
        //add amount
        paidAmount+=amount;

        //remaining amount
        double remainingAmount=premiumCharge-this.paidAmount;

        //total paidamount=premiumcharge
        if(paidAmount==premiumCharge){
            isFullPayment=true;
            return "Payment Successfull" +amount;
        }
        return "payment successful."+amount+"Remaning amount:"+remainingAmount;
    }
    //create a method
    public String calculateDiscount(){
        if(this.isFullPayment){
            //discount 10%
            discountAmount=0.1*premiumCharge;
            return "Discount successfully:"+discountAmount;
        }
        return "No discount is available.";
    }


    //create a method name as revertPremiumMember.
    public void revertPremiumMember(){
        //call superclass name as resetMember
        super.resetMember();
        this.personalTrainer="";
        this.isFullPayment=false;
        this.paidAmount=0;
        this.discountAmount=0;
        System.out.println(id+ "Membership to be revert");
    }   

    @Override
    public void markAttendance(){
        this.attendance++;
        this.loyaltyPoints+=10;

    }

    @Override
    public String display() {
        String info = super.display();
        info+= "\nPersonal Trainer: " + personalTrainer;
        info += "\nPaid Amount: " + paidAmount;
        info += "\nFull Payment Completed: " + (isFullPayment ? "Yes" : "No");
        info += "\nRemaining Amount: " + (premiumCharge - paidAmount);
        if (isFullPayment) {
            info += "\nDiscount Amount: " + discountAmount;
        }
        return info;
    }

}

