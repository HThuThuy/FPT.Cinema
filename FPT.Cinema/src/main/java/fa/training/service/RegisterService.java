//package fa.training.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import fa.training.DTO.RegisterDTO;
//import fa.training.model.Customer;
//import fa.training.model.Users;
//
//@Service
//public class RegisterService {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private CustomerService customerService;
//
//	public void registerUser(RegisterDTO registerDTO) {
//		Users user = new Users();
//		user.setAccount(registerDTO.getAccount());
//		user.setPassword(registerDTO.getPassword());
//
//		Customer customer = customerService.findById(registerDTO.getCccd());
//		System.out.println("abc" + customer);
//		user.setCustomer(customer);
//
//		userService.save(user);
//	}
//}
