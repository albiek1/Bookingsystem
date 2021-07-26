package business.services;

import business.entities.Item;
import business.exceptions.ItemException;
import business.persistence.Database;
import business.persistence.ItemMapper;

import java.util.List;

public class ItemFacade {
    ItemMapper itemMapper;

    public ItemFacade(Database database){itemMapper = new ItemMapper(database);}

    public Item createItem(String itemID, String name, String itemType, int roomID, String roomName, String Status) throws ItemException
    {
        Item item = new Item(itemID, name, itemType, roomID, roomName, Status);
        itemMapper.createItem(item);
        return item;
    }

    public List<Item> getAllItems() throws ItemException {
        List<Item> items;
        items = itemMapper.getAllItems();
        return items;
    }

    public Item getItemByID(int id) throws ItemException {
        return itemMapper.getItemByID(id);
    }

    public int getItemBySID(String id) throws ItemException {
        return itemMapper.getItemBySID(id);
    }

    public void updateItemStatus(int id, String status) throws ItemException {
        itemMapper.updateItemStatus(id, status);
    }
}
