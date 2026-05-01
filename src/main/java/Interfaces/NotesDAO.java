/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Alex
 */
public interface NotesDAO {
   void addCustomer(Customer customer);               // Add a new customer
    List<Customer> getAllCustomers();                 // Retrieve all customers
    Customer getCustomerById(int customerId);         // Find customer by ID
    List<Customer> searchCustomers(String keyword);   // Search by name or phone
    void updateCustomer(Customer customer);           // Update customer details
    void deleteCustomer(int customerId);    
}
