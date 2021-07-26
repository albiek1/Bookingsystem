package business.entities;

public class Item {

    private int id;
    private String ItemID;
    private String name;
    private String ItemType;
    private int RoomID;
    private String RoomName;
    private String Status;

    public Item(String ItemID, String name, String ItemType, int RoomID, String RoomName, String Status){
        this.ItemID = ItemID;
        this.name = name;
        this.ItemType = ItemType;
        this.RoomID = RoomID;
        this.RoomName = RoomName;
        this.Status = Status;
    }

    public Item(int id, String itemID, String itemName, String itemType, int roomID, String roomName, String status){
        this.id = id;
        this.ItemID = itemID;
        this.name = itemName;
        this.ItemType = itemType;
        this.RoomID = roomID;
        this.RoomName = roomName;
        this.Status = status;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
