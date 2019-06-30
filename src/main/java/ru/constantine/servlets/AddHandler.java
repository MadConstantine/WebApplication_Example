package ru.constantine.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.constantine.entities.*;
import ru.constantine.entities.Parcel.ParcelType;
import ru.constantine.model.Model;

public class AddHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddHandler() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/add.jsp");
		dispatcher.forward(request, response);
	    		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParcelType type = ParcelType.valueOf(request.getParameter("type").toUpperCase());
		String receiverIndex = request.getParameter("recv_index");
		String receiverAdr = request.getParameter("recv_adr");
		String receiverName = request.getParameter("recv_name");
		// prepare parcel, id will be set inside model.add()
		Parcel parcel = new Parcel(type, receiverIndex, receiverAdr, receiverName);
		
		Model model = Model.getInstance();
		model.add(parcel);
		
		request.setAttribute("parcelinfo", parcel.toString());
		doGet(request, response);
	}

}
