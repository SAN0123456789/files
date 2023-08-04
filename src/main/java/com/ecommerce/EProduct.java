package com.ecommerce;


import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(name ="EProduct.findAllWherePriceIs1000", query="SELECT p from EProduct p where p.price=1000")
@Entity
@Table(name="eproduct")
public class EProduct {
        
		@Id
		@Column(name="Aadhar_id")
		private long ID;
				
        private String name;
        private BigDecimal price;
        

        public EProduct() {                
        }
        
        public long getID() {return this.ID; }
        public String getName() { return this.name;}
        public BigDecimal getPrice() { return this.price;}
        //public Date getDateAdded() { return this.dateAdded;}
        
        public void setID(long id) { this.ID = id;}
        public void setName(String name) { this.name = name;}
        public void setPrice(BigDecimal price) { this.price = price;}
        //public void setDateAdded(Date date) { this.dateAdded = date;}        
}