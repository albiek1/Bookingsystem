package business.persistence;

import business.entities.Item;
import business.exceptions.ItemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    private Database database;

    public ItemMapper(Database database){this.database = database;}

    public void createItem(Item item) throws ItemException {
        try(Connection connection = database.connect()){
            String sql = "INSERT INTO items (ItemID, itemName, itemType, RoomID, RoomName, Status) VALUES (?, ?, ?, ?, ?, ?)";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, item.getItemID());
                ps.setString(2, item.getName());
                ps.setString(3, item.getItemType());
                ps.setInt(4, item.getRoomID());
                ps.setString(5, item.getRoomName());
                ps.setString(6, item.getStatus());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                item.setId(id);
            }
            catch (SQLException ex)
            {
                throw new ItemException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new ItemException(ex.getMessage());
        }
    }

    public List<Item> getAllItems() throws ItemException {
        List<Item> items = new ArrayList<>();
        try(Connection connection = database.connect()) {
            String sql = "SELECT * FROM items";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("iditems");
                    String itemID = rs.getString("itemID");
                    String itemName = rs.getString("itemName");
                    String itemType = rs.getString("itemType");
                    int roomID = rs.getInt("roomID");
                    String roomName = rs.getString("roomName");
                    String status = rs.getString("status");
                    Item item = new Item(id, itemID, itemName, itemType, roomID, roomName, status);
                    items.add(item);
                }
            }
        }
        catch (SQLException ex){
            throw new ItemException(ex.getMessage());
        }
        return items;
    }

    public Item getItemByID(int id) throws ItemException {
        Item item = null;
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM items WHERE iditems = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String itemID = rs.getString("itemID");
                    String itemName = rs.getString("itemName");
                    String itemType = rs.getString("itemType");
                    int roomID = rs.getInt("roomID");
                    String roomName = rs.getString("roomName");
                    String status = rs.getString("status");
                    item = new Item(id, itemID, itemName, itemType, roomID, roomName, status);
                }
            }
            catch (SQLException ex){
                throw new ItemException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new ItemException(ex.getMessage());
        }
        return item;
    }

    public int getItemBySID(String itemID) throws ItemException {
        int id = 0;
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM items WHERE itemID = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, itemID);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    id = rs.getInt("iditems");
                }
            }
        }
        catch (SQLException ex){
            throw new ItemException(ex.getMessage());
        }
        return id;
    }

    public void updateItemStatus(int id, String status) throws ItemException{
        try(Connection connection = database.connect()){
            String sql = "UPDATE items SET status = ? WHERE iditems = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, status);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        }catch (SQLException ex){
            throw new ItemException(ex.getMessage());
        }
    }
}
