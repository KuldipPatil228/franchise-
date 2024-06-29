package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.FranchiseDto;
import com.example.franchise.Entitiy.Franchise;
import com.example.franchise.Entitiy.User;
import com.example.franchise.Enums.MessageType;
import com.example.franchise.Enums.UserType;
import com.example.franchise.Exception.ApiException;
import com.example.franchise.Repository.FranchiseRepository;
import com.example.franchise.Repository.UserRepository;
import com.example.franchise.Util.ApiUtil;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.FranchiseService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class FranchiseServiceImpl implements FranchiseService {

    private static final Logger log = Logger.getLogger(FranchiseServiceImpl.class.getName());

    private final FranchiseRepository franchiseRepository;
    private final UserRepository userRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, UserRepository userRepository) {
        this.franchiseRepository = franchiseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public FranchiseDto create(FranchiseDto franchiseDto) {
        User user = fetchUser(franchiseDto.ownerId());
        Franchise franchise = ConverterUtil.franchiseConverter().toEntity(franchiseDto);
        franchise.setFuId(ApiUtil.generateUUID());
        franchise.setOwner(user);
        franchise.setOpen(true);
        return ConverterUtil.franchiseConverter().toDto(franchiseRepository.save(franchise));
    }


    /**
     * private Methods
     */
    public User fetchUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ApiException(MessageType.NOT_FOUND_USER, "User not found for ID: " + id));

        if (user.getUserType() != UserType.FRANCHISE_OWNER) {
            throw new ApiException(MessageType.UNAUTHORIZED_ACCESS, "Invalid access: " + user.getUserType());
        }
        return user;
    }

}
