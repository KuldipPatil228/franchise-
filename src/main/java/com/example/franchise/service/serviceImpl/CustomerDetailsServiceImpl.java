package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.CustomerDetails;
import com.example.franchise.Entitiy.User;
import com.example.franchise.Enums.MessageType;
import com.example.franchise.Exception.ApiException;
import com.example.franchise.Repository.CustomerDetailsRepository;
import com.example.franchise.Repository.UserRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.CustomerDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;
    private final UserRepository userRepository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository, UserRepository userRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CustomerDetailsDTO getCustomerDetailsById(Long id) {
        CustomerDetails customerDetails = fetchCustomerDetails(id);
        return ConverterUtil.customerDetailsConverter().toDto(customerDetails);
    }

    @Override
    public CustomerDetailsDTO createCustomerDetails(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails customerDetails = ConverterUtil.customerDetailsConverter().toEntity(customerDetailsDTO);
        Optional<User> user = fetchUser(customerDetailsDTO.user().getId());
        customerDetails.setUser(user.get());
        CustomerDetails savedCustomerDetails = customerDetailsRepository.save(customerDetails);
        return ConverterUtil.customerDetailsConverter().toDto(savedCustomerDetails);
    }

    @Override
    public CustomerDetailsDTO updateCustomerDetails(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(customerDetailsDTO.id())
                .orElseThrow(() -> new ApiException(MessageType.NOT_FOUND_USER, "CustomerDetails not found"));
        return ConverterUtil.customerDetailsConverter().toDto(customerDetailsRepository.save(ConverterUtil.customerDetailsConverter().updateEntity(customerDetailsDTO, customerDetails)));
    }

    @Override
    public String deleteCustomerDetails(Long id) {
        CustomerDetails customerDetails = fetchCustomerDetails(id);
        customerDetailsRepository.delete(customerDetails);
        return "deleted :" + id;
    }

    private CustomerDetails fetchCustomerDetails(Long id) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepository.findById(id);
        if (customerDetails.isPresent()) {
            return customerDetails.get();
        } else {
            throw new ApiException(MessageType.NOT_FOUND_USER, "CustomerDetails not found for id: " + id);
        }
    }

    private Optional<User> fetchUser(Long userId) {
        if (userId == null || userId <= 0) {
            return Optional.empty();
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ApiException(MessageType.NOT_FOUND_USER, "User not found for ID: " + userId);
        }
        return userOptional;
    }

}

