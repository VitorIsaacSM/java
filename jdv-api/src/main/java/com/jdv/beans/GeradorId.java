package com.jdv.beans;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Remote
@Singleton
public class GeradorId {
	ArrayList<classeId> listaIds = new ArrayList<classeId>();
	
	public classeId geraId(classeId user) {
		
		String oldId = user.id;
		String oldSession = user.session;
		String newId = oldId;
		
		if(!listaIds.isEmpty()) {
			for(int i = 0; i < listaIds.size(); i++) {
				classeId whatever = listaIds.get(i);
				if(whatever.session.equals(oldSession)) {
					newId = whatever.id;
				}
			}
		}
		
		if(oldId.equals(newId)) {
			user.id = Integer.toString(listaIds.size() + 1);
			listaIds.add(user);
		}
		else {
			user.id = newId;
		}
		
		System.out.println("usuario logado : Id = " + user.id + " Session = " + oldSession);
		
		return user;
	}
	
	public boolean validaId(String id) {
		return listaIds.contains(id);
	}
	
	
}
