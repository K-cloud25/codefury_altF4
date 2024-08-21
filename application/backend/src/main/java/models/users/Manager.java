package models.users;

public class Manager extends Employee{

    private int credits;

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Manager(int empID, String empName, String email, String phone, int empType, String passwd, int credits) {
        super(empID, empName, email, phone, empType, passwd);
        this.credits = credits;
    }


    public Manager() {
    }


    @Override
    public int getEmployeeType() {
        return 2;
    }

//----------------------------------------------------------------------------------------------------------------------
    //Functions to be implemented for the Manager :
    //1. Book Meeting Rooms with specification like amenities
         //(a).Push these details to the meeting Table of the DB.
         //Inputs needed for the function :
              //managerID, RoomID,meetingID,startTime,EndTime,Hashmap<String,int>Amenities, //name-count
             //  costOfMeeting- calculated from the amenities list
         //(b). Update the credits of the current Manager (managerID)-call UpdateCreditFunc
//----------------------------------------------------------------------------------------------------------------------

    //2. Update credit Functions :
        //Push the details in the credit Table of the DB (managerID,credit)
         //Inputs needed for this
             //managerID,calculatedCurrentCredits

    //3. Fetch the fresh Details OR update the current state of the current manager from the list of managers :
           //Query the DB credit and update
}
