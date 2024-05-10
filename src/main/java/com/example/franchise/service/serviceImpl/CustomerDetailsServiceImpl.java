package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.CustomerDetails;
import com.example.franchise.Repository.CustomerDetailsRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.CustomerDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public CustomerDetailsDTO getCustomerDetailsById(Long id) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerDetails not found"));
        return ConverterUtil.customerDetailsConverter().toDto(customerDetails);
    }

    @Override
    public CustomerDetailsDTO createCustomerDetails(CustomerDetails customerDetails) {
        CustomerDetails savedCustomerDetails = customerDetailsRepository.save(customerDetails);
        return ConverterUtil.customerDetailsConverter().toDto(savedCustomerDetails);
    }

    @Override
    public CustomerDetailsDTO updateCustomerDetails(Long id, CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerDetails not found"));
        return ConverterUtil.customerDetailsConverter().toDto(customerDetailsRepository.save(ConverterUtil.customerDetailsConverter().updateEntity(customerDetailsDTO, customerDetails)));
    }

    @Override
    public void deleteCustomerDetails(Long id) {
        CustomerDetails customerDetails = fetchCustomerDetails(id);
        customerDetailsRepository.delete(customerDetails);
    }

    private CustomerDetails fetchCustomerDetails(Long id) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepository.findById(id);
        if (customerDetails.isPresent()) {
            return customerDetails.get();
        } else {
            throw new IllegalArgumentException("CustomerDetails not found for id: " + id);
        }
    }

}

