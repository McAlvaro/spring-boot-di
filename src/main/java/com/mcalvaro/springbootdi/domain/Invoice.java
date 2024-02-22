package com.mcalvaro.springbootdi.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
 
    private String description;

    @Autowired
    private Client client;

    @Autowired
    private List<ItemInvoice> items;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ItemInvoice> getItems() {
		return items;
	}

	public void setItems(List<ItemInvoice> items) {
		this.items = items;
	}
}
