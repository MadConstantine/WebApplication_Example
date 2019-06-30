package ru.constantine.servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.constantine.entities.*;
import ru.constantine.model.Model;

public class ListHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListHandler() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get model
		Model model = Model.getInstance();
		List<Parcel> parcels = model.list();
		
		// prepare lists to send back
		List<Long> idList = new LinkedList<Long>();
		List<String> typeList = new LinkedList<String>();
		List<String> indexList = new LinkedList<String>();
		List<String> adrList = new LinkedList<String>();
		List<String> nameList = new LinkedList<String>();
		for (Parcel p : parcels) {
			if (!parcels.isEmpty()) {
				idList.add(p.getId());
				typeList.add(p.getType().toString());
				indexList.add(p.getReceiverIndex());
				adrList.add(p.getReceiverAdr());
				nameList.add(p.getReceiverName());
			}
		}
		request.setAttribute("idlist", idList);
		request.setAttribute("typelist", typeList);
		request.setAttribute("indexlist", indexList);
		request.setAttribute("adrlist", adrList);
		request.setAttribute("namelist", nameList);
		
		//send it all to list.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
