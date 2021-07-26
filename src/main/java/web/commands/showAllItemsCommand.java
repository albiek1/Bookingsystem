package web.commands;

import business.entities.Item;
import business.exceptions.ItemException;
import business.services.ItemFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class showAllItemsCommand extends CommandProtectedPage{

    ItemFacade itemFacade;

    public showAllItemsCommand(String pageToShow, String role){
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ItemException {
        List<Item> items = itemFacade.getAllItems();
        request.setAttribute("items", items);
        return pageToShow;
    }
}
