package dao.interfaces;

public interface AdminDao{

    public void addUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public void addRoom(String type,int seatingCapacity);
    public void modifyRoom(int roomId, String roomType, int seatingCapacity);
    public void importUser();
}
