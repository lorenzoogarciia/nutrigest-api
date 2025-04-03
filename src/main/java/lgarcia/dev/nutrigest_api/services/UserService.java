package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.AddressesModel;
import lgarcia.dev.nutrigest_api.models.DTOs.Users.GET.AllUsersDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Users.GET.GetUserDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Users.GET.MeasuresDTO;
import lgarcia.dev.nutrigest_api.models.UserModel;
import lgarcia.dev.nutrigest_api.models.UserPhoneModel;
import lgarcia.dev.nutrigest_api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    private SupabaseAuthService supabaseAuthService;

    // Función para obtener todos los usuarios
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public ArrayList<AllUsersDTO> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        List<AllUsersDTO> usersDTO = users.stream().map(user -> {
            AllUsersDTO userDTO = new AllUsersDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTO.setGender(user.getGender());
            userDTO.setBirthDate(user.getBirthDate());
            userDTO.setTargetWeight(user.getTargetWeight());
            userDTO.setActivity(user.getActivity());
            userDTO.setPhotoUrl(user.getPhotoUrl());
            userDTO.setCreatedAt(user.getCreatedAt());
            userDTO.setNutritionistId(user.getNutritionist().getId());

            if(user.getPhone() != null) {
                userDTO.setPhone(user.getPhone().stream()
                        .map(UserPhoneModel::getPhone)
                        .collect(Collectors.toList()));
            }

            if(user.getAddress() != null) {
                userDTO.setAddress(user.getAddress().stream()
                        .map(AddressesModel::getAddress)
                        .collect(Collectors.toList()));
            }

            return userDTO;
        }).collect(Collectors.toList());

        return (ArrayList<AllUsersDTO>) usersDTO;
    }
    // Función para obtener un usuario por su id DTO
    public GetUserDTO getUserById(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);
        GetUserDTO userDTO = new GetUserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setTargetWeight(user.getTargetWeight());
        userDTO.setActivity(user.getActivity());
        userDTO.setPhotoUrl(user.getPhotoUrl());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setNutritionistId(user.getNutritionist().getId());

        if(user.getPhone() != null) {
            userDTO.setPhone(user.getPhone().stream()
                    .map(UserPhoneModel::getPhone)
                    .collect(Collectors.toList()));
        }

        if(user.getAddress() != null) {
            userDTO.setAddress(user.getAddress().stream()
                    .map(AddressesModel::getAddress)
                    .collect(Collectors.toList()));
        }

        if(user.getMeasures() != null) {
            userDTO.setMeasures(user.getMeasures().stream().map(measure -> {
                MeasuresDTO measureDTO = new MeasuresDTO();
                measureDTO.setWeight(measure.getWeight());
                measureDTO.setHeight(measure.getHeight());
                measureDTO.setCreatedAt(measure.getCreatedAt());
                return measureDTO;
            }).collect(Collectors.toList()));
        }

        return userDTO;
    }

    // Funcion para obtener teléfonos de un usuario
    public List<String> getPhonesByUserId(Long id) {
        UserModel phones = userRepository.findById(id).orElse(null);
        if(phones.getPhone() != null) {
            return phones.getPhone().stream()
                    .map(UserPhoneModel::getPhone)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    // Función para almacenar un usuario
    public UserModel storeUser(UserModel user, String password)
    {
        if(user.getAddress() !=null) {
            user.getAddress().forEach(address -> address.setUser(user));
        }


        if(user.getPhone() !=null) {
            user.getPhone().forEach(phone -> phone.setUser(user));
        }

        supabaseAuthService.createSupabaseUser(user.getEmail(), password);

        return userRepository.save(user);
    }

    //Función para agregar un teléfono a un usuario
    public UserModel addPhone(UserModel user, Long id) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            if(user.getPhone() !=null) {
                user.getPhone().forEach(phone -> phone.setUser(userToUpdate));
                userToUpdate.getPhone().addAll(user.getPhone());
            }
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    //Función para agregar una dirección a un usuario
    public UserModel addAddress(UserModel user, Long id) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            if(user.getAddress() !=null) {
                user.getAddress().forEach(address -> address.setUser(userToUpdate));
                userToUpdate.getAddress().addAll(user.getAddress());
            }
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    //Función para agregar una medida a un usuario
    public UserModel addMeasure(UserModel user, Long id) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            if(user.getMeasures() !=null) {
                user.getMeasures().forEach(measure -> measure.setUser(userToUpdate));
                userToUpdate.getMeasures().addAll(user.getMeasures());
            }
            return userRepository.save(userToUpdate);
        }
        return null;
    }


    //Función para actualizar un usuario
    public UserModel updateUser(UserModel user, Long id) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            if (user.getName() != null) {
                userToUpdate.setName(user.getName());
            }

            if (user.getLastName() != null) {
                userToUpdate.setLastName(user.getLastName());
            }

            if (user.getEmail() != null) {
                userToUpdate.setEmail(user.getEmail());
            }

            if (user.getGender() != null) {
                userToUpdate.setGender(user.getGender());
            }

            if (user.getTargetWeight() != 0) {
                userToUpdate.setTargetWeight(user.getTargetWeight());
            }

            if (user.getNutritionist() != null) {
                userToUpdate.setNutritionist(user.getNutritionist());
            }

            if (user.getBirthDate() != null) {
                userToUpdate.setBirthDate(user.getBirthDate());
            }

            if(user.getActivity() != null) {
                userToUpdate.setActivity(user.getActivity());
            }

            if(user.getPhotoUrl() != null) {
                userToUpdate.setPhotoUrl(user.getPhotoUrl());
            }

            if(user.getNutritionist() != null) {
                userToUpdate.setNutritionist(user.getNutritionist());
            }

            if(user.getAddress() != null && !user.getAddress().isEmpty()) {
                userToUpdate.getAddress().clear();
                user.getAddress().forEach(address -> address.setUser(userToUpdate));
                userToUpdate.getAddress().addAll(user.getAddress());
            }

            if(user.getPhone() !=null && !user.getPhone().isEmpty()) {
                userToUpdate.getPhone().clear();
                user.getPhone().forEach(phone -> phone.setUser(userToUpdate));
                userToUpdate.getPhone().addAll(user.getPhone());
            }

            return userRepository.save(userToUpdate);
        }
        return null;
    }

    // Función para eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
