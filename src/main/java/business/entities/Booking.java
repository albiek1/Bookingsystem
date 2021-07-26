package business.entities;


import java.sql.Date;

public class Booking {

    private int BookingID;
    private int ItemID;
    private String ItemName;
    private String ItemType;
    private Date bookingStart;
    private int length;
    private int StudentID;
    private Date bookingEnd;
    private String status;

    public Booking(int ItemID, Date bookingStart, int length, int StudentID){
        this.ItemID = ItemID;
        this.bookingStart = bookingStart;
        this.length = length;
        this.StudentID = StudentID;
    }

    public Booking(int bookingID, Date bookingStart, int length, int StudentID, int itemID, String status){
        this.BookingID = bookingID;
        this.bookingStart = bookingStart;
        this.length = length;
        this.StudentID = StudentID;
        this.ItemID = itemID;
        this.status = status;
    }

    public Booking(int BookingID, String ItemName, String ItemType, Date bookingStart, int length, int StudentID){
        this.BookingID = BookingID;
        this.ItemName = ItemName;
        this.ItemType = ItemType;
        this.bookingStart = bookingStart;
        this.length = length;
        this.StudentID = StudentID;
    }

    public Booking(int BookingID, int itemID, String itemType, String itemName, Date bookingStart, int length, Date bookingEnd, String status){
        this.BookingID = BookingID;
        this.ItemID = itemID;
        this.ItemType = itemType;
        this.ItemName = itemName;
        this.bookingStart = bookingStart;
        this.length = length;
        this.bookingEnd = bookingEnd;
        this.status = status;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public Date getDate() {
        return bookingStart;
    }

    public void setDate(Date date) {
        this.bookingStart = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public Date getBookingEnd(){
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd){
        this.bookingEnd = bookingEnd;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
